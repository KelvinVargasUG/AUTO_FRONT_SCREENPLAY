package com.automation.stepdefinitions;

import com.automation.models.UserData;
import com.automation.questions.RegistrationErrorMessageDisplayed;
import com.automation.questions.RegistrationSuccessMessageDisplayed;
import com.automation.questions.RegistrationWasNotCompleted;
import com.automation.tasks.OpenRegistrationPage;
import com.automation.tasks.RegisterUser;
import io.cucumber.java.Before;
import io.cucumber.java.es.Cuando;
import io.cucumber.java.es.Dado;
import io.cucumber.java.es.Entonces;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import net.serenitybdd.core.Serenity;
import net.thucydides.model.util.EnvironmentVariables;
import net.serenitybdd.model.environment.EnvironmentSpecificConfiguration;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static org.hamcrest.Matchers.is;

public class RegistrationStepDefinitions {

    private Actor actor;
    private UserData newUser;
    private UserData existingUser;
    private String baseUrl;
    private EnvironmentVariables env;

    @Before
    public void setTheStage() {
        OnStage.setTheStage(new OnlineCast());
        env = Serenity.environmentVariables();
        baseUrl = EnvironmentSpecificConfiguration.from(env).getProperty("webdriver.base.url");
    }

    @Dado("que el usuario se encuentra en la pantalla de registro")
    public void elUsuarioEstaEnLaPantallaDeRegistro() {
        actor = OnStage.theActorCalled("Usuario");
        actor.attemptsTo(OpenRegistrationPage.at(baseUrl));
    }

    @Dado("existe previamente una cuenta registrada con ese correo")
    public void existePreviamenteUnaCuentaRegistradaConEseCorreo() {
        existingUser = UserData.builder()
                               .name("existing" + System.currentTimeMillis())
                               .email(EnvironmentSpecificConfiguration.from(env).getProperty("test.credentials.existing.email"))
                               .password(EnvironmentSpecificConfiguration.from(env).getProperty("test.credentials.existing.password"))
                               .build();
    }

    @Cuando("completa el formulario con datos válidos y únicos")
    public void completaElFormularioConDatosValidosYUnicos() {
        long ts = System.currentTimeMillis();
        newUser = UserData.builder()
                          .name("kelvin" + ts)
                          .email("testuser+" + ts + "@foodtech.com")
                          .password("Test1234!")
                          .build();
        actor.attemptsTo(RegisterUser.with(newUser));
    }

    @Cuando("completa el formulario con un correo ya registrado")
    public void completaElFormularioConUnCorreoYaRegistrado() {
        actor.attemptsTo(RegisterUser.with(existingUser));
    }

    @Entonces("debería visualizar un mensaje de registro exitoso")
    public void deberiaVisualizarUnMensajeDeRegistroExitoso() {
        actor.should(
            seeThat("el mensaje de éxito es visible",
                    RegistrationSuccessMessageDisplayed.isVisible(), is(true))
        );
    }

    @Entonces("debería visualizar un mensaje indicando que el correo ya existe")
    public void deberiaVisualizarUnMensajeDeErrorDeCorreoExistente() {
        actor.should(
            seeThat("el mensaje de error es visible",
                    RegistrationErrorMessageDisplayed.isVisible(), is(true))
        );
    }

    @Entonces("no debería completarse el registro")
    public void noDeberiaCompletarseElRegistro() {
        actor.should(
            seeThat("el registro no fue completado",
                    RegistrationWasNotCompleted.check(), is(true))
        );
    }
}
