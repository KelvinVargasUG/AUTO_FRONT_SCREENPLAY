package com.automation.stepdefinitions;

import com.automation.models.ProductData;
import com.automation.questions.ProductCreatedSuccessMessageDisplayed;
import com.automation.questions.ProductListedInCatalog;
import com.automation.tasks.Login;
import com.automation.tasks.NavigateToAdmin;
import com.automation.tasks.CreateProduct;
import com.automation.tasks.EditProduct;
import com.automation.tasks.ToggleProductStatus;
import com.automation.ui.AdminPage;
import io.cucumber.java.Before;
import io.cucumber.java.es.Cuando;
import io.cucumber.java.es.Dado;
import io.cucumber.java.es.Entonces;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.actions.Open;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import net.serenitybdd.core.Serenity;
import net.thucydides.model.util.EnvironmentVariables;
import net.serenitybdd.model.environment.EnvironmentSpecificConfiguration;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static org.hamcrest.Matchers.is;

public class CatalogoStepDefinitions {

    private Actor actor;
    private EnvironmentVariables env;
    private String baseUrl;

    @Before
    public void setTheStage() {
        OnStage.setTheStage(new OnlineCast());
        env     = Serenity.environmentVariables();
        baseUrl = EnvironmentSpecificConfiguration.from(env).getProperty("webdriver.base.url");
    }

    @Dado("que el administrador ha iniciado sesión y navega al catálogo")
    public void elAdministradorHaIniciadoSesionYNavegaAlCatalogo() {
        actor = OnStage.theActorCalled("Administrador");
        String email    = EnvironmentSpecificConfiguration.from(env).getProperty("test.credentials.valid.email");
        String password = EnvironmentSpecificConfiguration.from(env).getProperty("test.credentials.valid.password");
        actor.attemptsTo(
            Open.url(baseUrl),
            Login.withCredentials(email, password),
            NavigateToAdmin.section()
        );
    }

    @Cuando("completa el formulario con datos válidos del producto")
    public void completaElFormularioConDatosValidosDelProducto() {
        long ts = System.currentTimeMillis();
        ProductData product = ProductData.builder()
                .name("Producto Test " + ts)
                .type("HOT_DISH")
                .category("Prueba Automatizada")
                .price("1500")
                .build();
        actor.attemptsTo(CreateProduct.with(product));
    }

    @Entonces("debería visualizar el mensaje de producto creado exitosamente")
    public void deberiaVisualizarElMensajeDeProductoCreadoExitosamente() {
        actor.should(
            seeThat("el mensaje de creación exitosa es visible",
                    ProductCreatedSuccessMessageDisplayed.isVisible(), is(true))
        );
    }

    @Cuando("el catálogo tiene productos registrados")
    public void elCatalogoTieneProductosRegistrados() {

    }

    @Entonces("debería visualizar los productos listados con sus botones de acción")
    public void deberiaVisualizarLosProductosListadosConSusBotonesDeAccion() {
        actor.should(
            seeThat("los productos están listados en el catálogo",
                    ProductListedInCatalog.isVisible(), is(true))
        );
    }

    @Cuando("hace clic en editar el primer producto y modifica el nombre")
    public void haceClicEnEditarElPrimerProductoYModificaElNombre() {
        long ts = System.currentTimeMillis();
        actor.attemptsTo(EditProduct.withNewName("Producto Editado " + ts));
    }

    @Entonces("debería visualizar el producto actualizado en el catálogo")
    public void deberiaVisualizarElProductoActualizadoEnElCatalogo() {
        actor.should(
            seeThat("el catálogo sigue mostrando productos tras la edición",
                    ProductListedInCatalog.isVisible(), is(true))
        );
    }

    @Cuando("hace clic en desactivar el primer producto")
    public void haceClicEnDesactivarElPrimerProducto() {
        actor.attemptsTo(ToggleProductStatus.ofFirstProduct());
    }

    @Entonces("el producto debería seguir listado como inactivo en el catálogo")
    public void elProductoDeberiaSeguirListadoComoInactivoEnElCatalogo() {
        actor.should(
            seeThat("el contenedor de productos sigue visible tras la desactivación",
                    ProductListedInCatalog.isVisible(), is(true))
        );
    }

    @Cuando("intenta crear un producto sin completar el nombre")
    public void intentaCrearUnProductoSinCompletarElNombre() {
        ProductData product = ProductData.builder()
                .name("")
                .type("HOT_DISH")
                .category("Prueba")
                .price("1000")
                .build();
        actor.attemptsTo(CreateProduct.with(product));
    }

    @Entonces("debería visualizar un mensaje de validación indicando el campo requerido")
    public void deberiaVisualizarUnMensajeDeValidacionIndicandoElCampoRequerido() {
        actor.should(
            seeThat("el mensaje de validación es visible",
                    a -> AdminPage.VALIDATION_ERROR_MESSAGE.resolveFor(a).waitUntilVisible().isVisible(),
                    is(true))
        );
    }

    @Cuando("intenta guardar la edición borrando el nombre del producto")
    public void intentaGuardarLaEdicionBorrandoElNombreDelProducto() {
        actor.attemptsTo(EditProduct.withNewName(""));
    }

    @Entonces("el producto desactivado no debería aparecer en el catálogo del cliente")
    public void elProductoDesactivadoNoDeberiaAparecerEnElCatalogoDelCliente() {
        actor.attemptsTo(Open.url(baseUrl));
        actor.should(
            seeThat("ningún producto inactivo es visible en el catálogo público",
                    a -> !AdminPage.INACTIVE_PRODUCT_BADGE.resolveFor(a).isPresent(),
                    is(true))
        );
    }

}
