package com.automation.stepdefinitions;

import com.automation.questions.UploadSummaryIsDisplayed;
import com.automation.tasks.Login;
import com.automation.tasks.NavigateToBulkUpload;
import com.automation.tasks.UploadCSVFile;
import com.automation.ui.BulkUploadPage;
import io.cucumber.java.Before;
import io.cucumber.java.es.Cuando;
import io.cucumber.java.es.Dado;
import io.cucumber.java.es.Entonces;
import io.cucumber.java.es.Y;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.actions.Open;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import net.serenitybdd.core.Serenity;
import net.thucydides.model.util.EnvironmentVariables;
import net.serenitybdd.model.environment.EnvironmentSpecificConfiguration;

import java.nio.file.Paths;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static org.hamcrest.Matchers.is;

public class CargaMasivaStepDefinitions {

    private Actor actor;
    private EnvironmentVariables env;
    private String baseUrl;

    @Before
    public void setTheStage() {
        OnStage.setTheStage(new OnlineCast());
        env     = Serenity.environmentVariables();
        baseUrl = EnvironmentSpecificConfiguration.from(env).getProperty("webdriver.base.url");
    }

    @Dado("que el administrador ha iniciado sesión y navega a carga masiva")
    public void elAdministradorHaIniciadoSesionYNavegaACargaMasiva() {
        actor = OnStage.theActorCalled("Administrador");
        String email    = EnvironmentSpecificConfiguration.from(env).getProperty("test.credentials.valid.email");
        String password = EnvironmentSpecificConfiguration.from(env).getProperty("test.credentials.valid.password");
        actor.attemptsTo(
            Open.url(baseUrl),
            Login.withCredentials(email, password),
            NavigateToBulkUpload.section()
        );
    }

    @Entonces("debería visualizar la zona de arrastre de archivos CSV")
    public void deberiaVisualizarLaZonaDeArrastreDeArchivosCsv() {
        Question<Boolean> dropZoneVisible = a ->
                BulkUploadPage.DROP_ZONE.resolveFor(a).waitUntilVisible().isVisible();
        actor.should(
            seeThat("el componente de carga masiva es visible", dropZoneVisible, is(true))
        );
    }

    @Y("debería visualizar el enlace para descargar la plantilla CSV")
    public void deberiaVisualizarElEnlaceParaDescargarLaPlantillaCsv() {
        Question<Boolean> templateButtonVisible = a ->
                BulkUploadPage.DOWNLOAD_TEMPLATE_BUTTON.resolveFor(a).waitUntilVisible().isVisible();
        actor.should(
            seeThat("el botón de descarga de plantilla es visible", templateButtonVisible, is(true))
        );
    }

    @Cuando("sube un archivo CSV válido con productos")
    public void subeUnArchivoCsvValidoConProductos() {
        try {

            String csvPath = Paths.get(
                getClass().getClassLoader()
                           .getResource("files/productos_prueba.csv")
                           .toURI()
            ).toString();
            actor.attemptsTo(UploadCSVFile.fromPath(csvPath));
        } catch (Exception e) {
            throw new RuntimeException("No se pudo encontrar el archivo CSV de prueba", e);
        }
    }

    @Entonces("debería visualizar el resumen de la carga con los productos procesados")
    public void deberiaVisualizarElResumenDeLaCargaConLosProductosProcesados() {
        actor.should(
            seeThat("el panel de resumen de carga es visible",
                    UploadSummaryIsDisplayed.isVisible(), is(true))
        );
    }

    @Cuando("sube un archivo CSV con cabeceras incorrectas")
    public void subeUnArchivoCsvConCabecerasIncorrectas() {
        try {
            String csvPath = Paths.get(
                getClass().getClassLoader()
                           .getResource("files/cabeceras_invalidas.csv")
                           .toURI()
            ).toString();
            actor.attemptsTo(UploadCSVFile.fromPath(csvPath));
        } catch (Exception e) {
            throw new RuntimeException("No se pudo encontrar el archivo CSV de cabeceras inválidas", e);
        }
    }

    @Entonces("debería visualizar un mensaje indicando el error en el formato del archivo")
    public void deberiaVisualizarUnMensajeIndicandoElErrorEnElFormatoDelArchivo() {
        actor.should(
            seeThat("el mensaje de error de formato CSV es visible",
                    a -> BulkUploadPage.UPLOAD_ERROR_MESSAGE.resolveFor(a).waitUntilVisible().isVisible(),
                    is(true))
        );
    }

    @Cuando("intenta subir un archivo que supera el tamaño máximo permitido")
    public void intentaSubirUnArchivoQueSupeaElTamanioMaximo() {
        try {
            String csvPath = Paths.get(
                getClass().getClassLoader()
                           .getResource("files/mayor_al_peso_permitido.csv")
                           .toURI()
            ).toString();
            actor.attemptsTo(UploadCSVFile.fromPath(csvPath));
        } catch (Exception e) {
            throw new RuntimeException("No se pudo encontrar el archivo mayor_al_peso_permitido.csv", e);
        }
    }

    @Entonces("debería visualizar un mensaje indicando que el archivo supera el tamaño máximo")
    public void deberiaVisualizarUnMensajeIndicandoQueElArchivoSuperaElTamanioMaximo() {
        actor.should(
            seeThat("el mensaje de límite de tamaño es visible",
                    a -> BulkUploadPage.UPLOAD_SIZE_ERROR.resolveFor(a).waitUntilVisible().isVisible(),
                    is(true))
        );
    }

    @Cuando("sube un archivo CSV con registros inválidos")
    public void subeUnArchivoCsvConRegistrosInvalidos() {
        try {
            String csvPath = Paths.get(
                getClass().getClassLoader()
                           .getResource("files/cabeceras_invalidas.csv")
                           .toURI()
            ).toString();
            actor.attemptsTo(UploadCSVFile.fromPath(csvPath));
        } catch (Exception e) {
            throw new RuntimeException("No se pudo encontrar el archivo CSV de registros inválidos", e);
        }
    }

    @Entonces("debería visualizar el enlace para descargar el reporte de errores")
    public void deberiaVisualizarElEnlaceParaDescargarElReporteDeErrores() {
        actor.should(
            seeThat("el enlace de descarga del reporte de errores es visible",
                    a -> BulkUploadPage.ERROR_REPORT_LINK.resolveFor(a).waitUntilVisible().isVisible(),
                    is(true))
        );
    }
}
