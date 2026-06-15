package com.startsharp2.userinterfaces;

import net.serenitybdd.screenplay.targets.Target;

public class MyAccountPageUI {

    public static final Target DASHBOARD_MESSAGE = Target.the("mensaje de tablero")
            .locatedBy("//h1[text()='Tablero']");

    public static final Target USER_PROFILE_MENU_BUTTON = Target.the("Botón de perfil de usuario")
            .locatedBy(".s-user-profile-link");

    public static final Target CLOSE_SESSION_MENU_BUTTON = Target.the("botón de cerrar sesión de usuario")
            .locatedBy("a[href*='/Account/Signout']");


}
