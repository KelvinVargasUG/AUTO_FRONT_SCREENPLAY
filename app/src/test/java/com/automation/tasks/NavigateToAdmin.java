package com.automation.tasks;

import com.automation.ui.AdminPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.annotations.Step;

public class NavigateToAdmin implements Task {

    public static NavigateToAdmin section() {
        return new NavigateToAdmin();
    }

    @Override
    @Step("{0} navega al catálogo de administrador")
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
            Click.on(AdminPage.NAV_ADMIN_LINK)
        );
    }
}
