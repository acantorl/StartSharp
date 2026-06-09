package com.startsharp2.userinterfaces;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class HomePageUI {

    public static final Target USER_NAME_INPUT = Target.the("input nombre de usuario")
            .located(By.id("LoginPanel0_Username"));

    public static final Target USER_PASSWORD_INPUT = Target.the("input contraseña de usuario")
            .located(By.id("LoginPanel0_Password"));


    public static final Target LOGIN_BUTTON = Target.the("botón de login")
            .located(By.id("LoginPanel0_LoginButton"));


    public static final Target LBL_LOGIN_TITLE = Target.the("título del formulario de login")
            .locatedBy("//h5[contains(text(), 'Iniciar sesión en su cuenta')]");


}
