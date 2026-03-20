package com.automation.tasks;

import com.automation.ui.InvoicePage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.ensure.Ensure;
import net.serenitybdd.annotations.Step;

public class InvoiceOrder implements Task {

    private final String index;

    public InvoiceOrder(String index) {
        this.index = index;
    }

    public static InvoiceOrder withIndex(String index) {
        return new InvoiceOrder(index);
    }

    @Override
    @Step("{0} factura el pedido #{index}")
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
            Ensure.that(InvoicePage.NO_ORDERS_MESSAGE).isNotDisplayed(),
            Click.on(InvoicePage.invoiceButton(index))
        );
    }
}
