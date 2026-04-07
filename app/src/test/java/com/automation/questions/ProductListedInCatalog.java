package com.automation.questions;

import com.automation.ui.AdminPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

public class ProductListedInCatalog implements Question<Boolean> {

    public static ProductListedInCatalog isVisible() {
        return new ProductListedInCatalog();
    }

    @Override
    public Boolean answeredBy(Actor actor) {
        return AdminPage.PRODUCT_LIST
                        .resolveFor(actor)
                        .waitUntilVisible()
                        .isVisible();
    }
}
