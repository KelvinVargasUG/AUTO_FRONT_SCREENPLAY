package com.automation.runners;

import io.cucumber.junit.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
    plugin  = {"pretty"},
    features = {
        "src/test/resources/features/registro_usuarios.feature",
        "src/test/resources/features/facturacion.feature"
    },
    glue    = "com.automation.stepdefinitions"
)
public class CucumberTestSuite {
}
