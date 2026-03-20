package com.automation.questions;

import com.automation.ui.InvoicePage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

public class InvoiceSuccessMessageDisplayed implements Question<Boolean> {

    public static InvoiceSuccessMessageDisplayed isVisible() {
        return new InvoiceSuccessMessageDisplayed();
    }

    @Override
    public Boolean answeredBy(Actor actor) {
        return InvoicePage.INVOICE_TOAST
                         .resolveFor(actor)
                         .waitUntilVisible()
                         .isVisible();
    }
}
