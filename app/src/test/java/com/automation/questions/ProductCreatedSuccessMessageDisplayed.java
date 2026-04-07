package com.automation.questions;

import com.automation.ui.AdminPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

public class ProductCreatedSuccessMessageDisplayed implements Question<Boolean> {

    public static ProductCreatedSuccessMessageDisplayed isVisible() {
        return new ProductCreatedSuccessMessageDisplayed();
    }

    @Override
    public Boolean answeredBy(Actor actor) {
        return AdminPage.PRODUCT_LIST
                        .resolveFor(actor)
                        .waitUntilVisible()
                        .isVisible();
    }
}
