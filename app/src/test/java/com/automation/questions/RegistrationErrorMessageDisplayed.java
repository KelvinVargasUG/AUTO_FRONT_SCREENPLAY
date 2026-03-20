package com.automation.questions;

import com.automation.ui.RegisterPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

public class RegistrationErrorMessageDisplayed implements Question<Boolean> {

    public static RegistrationErrorMessageDisplayed isVisible() {
        return new RegistrationErrorMessageDisplayed();
    }

    @Override
    public Boolean answeredBy(Actor actor) {
        try {
            return RegisterPage.ERROR_MESSAGE
                    .resolveFor(actor)
                    .waitUntilVisible()
                    .isVisible();
        } catch (Exception e) {
            return false;
        }
    }
}
