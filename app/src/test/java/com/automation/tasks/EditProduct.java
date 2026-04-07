package com.automation.tasks;

import com.automation.ui.AdminPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.annotations.Step;
import org.openqa.selenium.Keys;

public class EditProduct implements Task {

    private final String newName;

    public EditProduct(String newName) {
        this.newName = newName;
    }

    public static EditProduct withNewName(String newName) {
        return new EditProduct(newName);
    }

    @Override
    @Step("{0} edita el primer producto con el nuevo nombre: #newName")
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
            Click.on(AdminPage.FIRST_EDIT_BUTTON),
            Enter.keyValues(Keys.chord(Keys.CONTROL, "a"), Keys.BACK_SPACE).into(AdminPage.EDIT_NAME_INPUT),
            Enter.theValue(newName).into(AdminPage.EDIT_NAME_INPUT),
            Click.on(AdminPage.EDIT_SAVE_BUTTON)
        );
    }
}
