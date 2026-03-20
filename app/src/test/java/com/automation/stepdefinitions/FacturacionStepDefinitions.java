package com.automation.stepdefinitions;

import com.automation.questions.InvoiceSuccessMessageDisplayed;
import com.automation.tasks.InvoiceOrder;
import com.automation.tasks.Login;
import com.automation.tasks.NavigateToCompletedOrders;
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

public class FacturacionStepDefinitions {

    private Actor actor;
    private EnvironmentVariables env;
    private String baseUrl;

    @Before
    public void setTheStage() {
        OnStage.setTheStage(new OnlineCast());
        env = Serenity.environmentVariables();
        baseUrl = EnvironmentSpecificConfiguration.from(env).getProperty("webdriver.base.url");
    }

    @Dado("que el usuario inicia sesión correctamente en la plataforma")
    public void elUsuarioIniciaSessionCorrectamente() {
        actor = OnStage.theActorCalled("Mesero");
        String email    = EnvironmentSpecificConfiguration.from(env).getProperty("test.credentials.valid.email");
        String password = EnvironmentSpecificConfiguration.from(env).getProperty("test.credentials.valid.password");
        actor.attemptsTo(
            Open.url(baseUrl),
            Login.withCredentials(email, password)
        );
    }

    @Dado("accede a la sección de pedidos completados")
    public void accedeALaSeccionDePedidosCompletados() {
        actor.attemptsTo(NavigateToCompletedOrders.section());
    }

    @Cuando("factura uno de los pedidos disponibles")
    public void facturaUnoDeLosPedidosDisponibles() {
        actor.attemptsTo(InvoiceOrder.withIndex("0"));
    }

    @Entonces("debería visualizar un mensaje de factura generada exitosamente")
    public void deberiaVisualizarUnMensajeDeFacturaGeneradaExitosamente() {
        actor.should(
            seeThat("el mensaje de factura exitosa es visible",
                    InvoiceSuccessMessageDisplayed.isVisible(), is(true))
        );
    }
}
