package com.automation.tasks;

import com.automation.ui.AdminPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.annotations.Step;

public class ToggleProductStatus implements Task {

    public static ToggleProductStatus ofFirstProduct() {
        return new ToggleProductStatus();
    }

    @Override
    @Step("{0} cambia el estado (activo/inactivo) del primer producto")
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
            Click.on(AdminPage.FIRST_DEACTIVATE_BUTTON)
        );
    }
}
