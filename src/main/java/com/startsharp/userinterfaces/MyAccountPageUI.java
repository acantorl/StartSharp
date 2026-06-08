package com.startsharp.userinterfaces;

import net.serenitybdd.screenplay.targets.Target;

public class MyAccountPageUI {

    public static final Target DASHBOARD_MESSAGE = Target.the("mensaje de tablero")
            .locatedBy("//h1[text()='Tablero']");

}
