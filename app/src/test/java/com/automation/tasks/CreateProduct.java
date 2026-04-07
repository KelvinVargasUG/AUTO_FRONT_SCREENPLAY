package com.automation.tasks;

import com.automation.models.ProductData;
import com.automation.ui.AdminPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actions.SelectFromOptions;
import net.serenitybdd.annotations.Step;

public class CreateProduct implements Task {

    private final ProductData productData;

    public CreateProduct(ProductData productData) {
        this.productData = productData;
    }

    public static CreateProduct with(ProductData productData) {
        return new CreateProduct(productData);
    }

    @Override
    @Step("{0} crea el producto: #productData.name")
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
            Enter.theValue(productData.getName()).into(AdminPage.NAME_INPUT),
            SelectFromOptions.byValue(productData.getType()).from(AdminPage.TYPE_SELECT),
            Enter.theValue(productData.getCategory()).into(AdminPage.CATEGORY_INPUT),
            Enter.theValue(productData.getPrice()).into(AdminPage.PRICE_INPUT),
            Click.on(AdminPage.CREATE_BUTTON)
        );
    }
}
