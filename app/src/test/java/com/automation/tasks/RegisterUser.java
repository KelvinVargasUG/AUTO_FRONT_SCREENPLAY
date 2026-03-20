package com.automation.tasks;

import com.automation.models.UserData;
import com.automation.ui.RegisterPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.annotations.Step;

public class RegisterUser implements Task {

    private final UserData userData;

    public RegisterUser(UserData userData) {
        this.userData = userData;
    }

    public static RegisterUser with(UserData userData) {
        return new RegisterUser(userData);
    }

    @Override
    @Step("{0} completa el formulario de registro con email: #userData.email")
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
            Enter.theValue(userData.getName()).into(RegisterPage.NAME_INPUT),
            Enter.theValue(userData.getEmail()).into(RegisterPage.EMAIL_INPUT),
            Enter.theValue(userData.getPassword()).into(RegisterPage.PASSWORD_INPUT),
            Click.on(RegisterPage.SUBMIT_BUTTON)
        );
    }
}
