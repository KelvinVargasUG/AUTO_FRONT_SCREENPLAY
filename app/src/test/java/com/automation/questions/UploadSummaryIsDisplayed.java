package com.automation.questions;

import com.automation.ui.BulkUploadPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

import java.time.Duration;

public class UploadSummaryIsDisplayed implements Question<Boolean> {

    public static UploadSummaryIsDisplayed isVisible() {
        return new UploadSummaryIsDisplayed();
    }

    @Override
    public Boolean answeredBy(Actor actor) {
        return BulkUploadPage.UPLOAD_SUMMARY_TITLE
                             .waitingForNoMoreThan(Duration.ofSeconds(20))
                             .resolveFor(actor)
                             .waitUntilVisible()
                             .isVisible();
    }
}
