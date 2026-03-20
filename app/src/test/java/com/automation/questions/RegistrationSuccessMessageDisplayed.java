package com.automation.questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;

public class RegistrationSuccessMessageDisplayed implements Question<Boolean> {

    public static RegistrationSuccessMessageDisplayed isVisible() {
        return new RegistrationSuccessMessageDisplayed();
    }

    @Override
    public Boolean answeredBy(Actor actor) {
        String currentUrl = BrowseTheWeb.as(actor).getDriver().getCurrentUrl();
        return !currentUrl.contains("register");
    }
}
