package com.automation.tasks;

import com.automation.ui.RegisterPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Open;
import net.serenitybdd.annotations.Step;

public class OpenRegistrationPage implements Task {

    private final String baseUrl;

    public OpenRegistrationPage(String baseUrl) {
        this.baseUrl = baseUrl;
    }

    public static OpenRegistrationPage at(String url) {
        return new OpenRegistrationPage(url);
    }

    @Override
    @Step("{0} abre la página de login y navega al registro")
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
            Open.url(baseUrl),
            Click.on(RegisterPage.REGISTER_LINK)
        );
    }
}
