package com.automation.ui;

import net.serenitybdd.screenplay.targets.Target;

public class RegisterPage {

    public static final Target REGISTER_LINK =
            Target.the("enlace para ir a registro")
                  .locatedBy("[data-testid='register-link']");

    public static final Target NAME_INPUT =
            Target.the("campo nombre de usuario")
                  .locatedBy("#username");

    public static final Target EMAIL_INPUT =
            Target.the("campo correo electrónico de registro")
                  .locatedBy("#email");

    public static final Target PASSWORD_INPUT =
            Target.the("campo contraseña de registro")
                  .locatedBy("#password");

    public static final Target SUBMIT_BUTTON =
            Target.the("botón de registro")
                  .locatedBy("[data-testid='login-button']");

    public static final Target SUCCESS_MESSAGE =
            Target.the("mensaje de registro exitoso")
                  .locatedBy("[data-testid='register-success-message']");

    public static final Target ERROR_MESSAGE =
            Target.the("mensaje de error de registro")
                  .locatedBy("[data-testid='error-message']");
}
