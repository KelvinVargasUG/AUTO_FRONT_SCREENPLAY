package com.automation.tasks;

import com.automation.ui.InvoicePage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.annotations.Step;

public class NavigateToCompletedOrders implements Task {

    public static NavigateToCompletedOrders section() {
        return new NavigateToCompletedOrders();
    }

    @Override
    @Step("{0} accede a la sección de pedidos completados")
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
            Click.on(InvoicePage.COMPLETED_ORDERS_BUTTON)
        );
    }
}
