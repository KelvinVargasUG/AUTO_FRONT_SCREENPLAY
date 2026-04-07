package com.automation.tasks;

import com.automation.ui.BulkUploadPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.annotations.Step;

public class NavigateToBulkUpload implements Task {

    public static NavigateToBulkUpload section() {
        return new NavigateToBulkUpload();
    }

    @Override
    @Step("{0} navega a la sección de Carga Masiva")
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
            Click.on(BulkUploadPage.NAV_BULK_UPLOAD_LINK)
        );
        BulkUploadPage.DROP_ZONE.resolveFor(actor).waitUntilVisible();
    }
}
