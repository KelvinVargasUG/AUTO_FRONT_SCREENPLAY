package com.automation.ui;

import net.serenitybdd.screenplay.targets.Target;

public class LoginPage {

    public static final Target EMAIL_INPUT =
            Target.the("campo correo electrónico de login")
                  .locatedBy("#email");

    public static final Target PASSWORD_INPUT =
            Target.the("campo contraseña de login")
                  .locatedBy("#password");

    public static final Target LOGIN_BUTTON =
            Target.the("botón de login")
                  .locatedBy("[data-testid='login-button']");
}
