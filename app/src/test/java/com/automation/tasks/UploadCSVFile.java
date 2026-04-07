package com.automation.tasks;

import com.automation.ui.BulkUploadPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.annotations.Step;

public class UploadCSVFile implements Task {

    private final String filePath;

    public UploadCSVFile(String filePath) {
        this.filePath = filePath;
    }

    public static UploadCSVFile fromPath(String filePath) {
        return new UploadCSVFile(filePath);
    }

    @Override
    @Step("{0} sube el archivo CSV: #filePath")
    public <T extends Actor> void performAs(T actor) {

        BulkUploadPage.FILE_INPUT
                      .resolveFor(actor)
                      .sendKeys(filePath);
    }
}
