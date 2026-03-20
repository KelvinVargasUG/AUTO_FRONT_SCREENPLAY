package com.automation.ui;

import net.serenitybdd.screenplay.targets.Target;

public class InvoicePage {

    public static final Target COMPLETED_ORDERS_BUTTON =
            Target.the("botón de pedidos completados")
                  .locatedBy("[data-testid='completed-orders-btn']");

    public static final Target NO_ORDERS_MESSAGE =
            Target.the("mensaje de no hay pedidos disponibles")
                  .locatedBy("[data-testid='no-orders-message']");

    public static final Target INVOICE_TOAST =
            Target.the("mensaje de factura generada exitosamente")
                  .locatedBy("[data-testid='invoice-toast']");

    public static Target invoiceButton(String index) {
        return Target.the("botón de facturar pedido #" + index)
                     .locatedBy(String.format("[data-testid='invoice-btn-%s']", index));
    }
}
