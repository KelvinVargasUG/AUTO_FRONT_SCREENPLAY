package com.automation.questions;

import com.automation.ui.RegisterPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

public class RegistrationWasNotCompleted implements Question<Boolean> {

    public static RegistrationWasNotCompleted check() {
        return new RegistrationWasNotCompleted();
    }

    @Override
    public Boolean answeredBy(Actor actor) {
        try {
            return RegisterPage.ERROR_MESSAGE
                    .resolveFor(actor)
                    .isPresent();
        } catch (Exception e) {
            return false;
        }
    }
}
