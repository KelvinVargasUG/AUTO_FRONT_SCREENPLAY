package com.automation.ui;

import net.serenitybdd.screenplay.targets.Target;

public class AdminPage {

    public static final String URL = "/admin";

    public static final Target NAV_ADMIN_LINK =
            Target.the("enlace de navegación al catálogo Admin")
                  .locatedBy("[data-testid='nav-admin']");

    public static final Target NAME_INPUT =
            Target.the("campo nombre del producto")
                  .locatedBy("//*[@id=\"name\"]");

    public static final Target TYPE_SELECT =
            Target.the("selector tipo del producto")
                  .locatedBy("//*[@id=\"type\"]");

    public static final Target CATEGORY_INPUT =
            Target.the("campo categoría del producto")
                  .locatedBy("//*[@id=\"category\"]");

    public static final Target PRICE_INPUT =
            Target.the("campo precio del producto")
                  .locatedBy("//*[@id=\"price\"]");

    public static final Target CREATE_BUTTON =
            Target.the("botón Crear Producto")
                  .locatedBy("[data-testid='create-product-button']");

    public static final Target PRODUCT_LIST =
            Target.the("contenedor lista de productos")
                  .locatedBy("[data-testid='product-list']");

    public static final Target FIRST_DEACTIVATE_BUTTON =
            Target.the("primer botón Desactivar de la lista")
                  .locatedBy("[data-testid^='toggle-status-']");

    public static final Target FIRST_EDIT_BUTTON =
            Target.the("primer botón Editar de la lista")
                  .locatedBy("[data-testid^='edit-product-']");

    public static final Target EDIT_NAME_INPUT =
            Target.the("campo nombre al editar producto")
                  .locatedBy("//*[@id=\"edit-name\"]");

    public static final Target EDIT_TYPE_SELECT =
            Target.the("selector tipo al editar producto")
                  .locatedBy("//*[@id=\"edit-type\"]");

    public static final Target EDIT_CATEGORY_INPUT =
            Target.the("campo categoría al editar producto")
                  .locatedBy("//*[@id=\"edit-category\"]");

    public static final Target EDIT_PRICE_INPUT =
            Target.the("campo precio al editar producto")
                  .locatedBy("//*[@id=\"edit-price\"]");

    public static final Target EDIT_STATUS_SELECT =
            Target.the("campo estado al editar producto")
                  .locatedBy("//*[@id=\"edit-status\"]");

    public static final Target EDIT_SAVE_BUTTON =
            Target.the("botón guardar cambios del formulario editar")
                  .locatedBy("//*[@id=\"edit-name\"]/ancestor::form//button[@type='submit']");

    public static final Target VALIDATION_ERROR_MESSAGE =
            Target.the("mensaje de error de validación del formulario")
                  .locatedBy("[data-testid='form-validation-error']");

    public static final Target TOGGLE_ERROR_MESSAGE =
            Target.the("mensaje de error al cambiar estado del producto")
                  .locatedBy("[data-testid='toggle-error-message']");

    public static final Target INACTIVE_PRODUCT_BADGE =
            Target.the("badge de producto inactivo")
                  .locatedBy("[data-testid='product-status-inactive']");
}
