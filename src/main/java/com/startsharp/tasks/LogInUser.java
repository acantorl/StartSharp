package com.startsharp.tasks;

import com.startsharp.userinterfaces.HomePageUI;
import net.serenitybdd.annotations.Step;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static net.serenitybdd.screenplay.Tasks.instrumented;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;


public class LogInUser implements Task {

    private final String usuario;
    private final String password;

    public LogInUser(String usuario, String password){
        this.usuario = usuario;
        this.password = password;
}

public static LogInUser conCredenciales(String usuario, String password) {
    return instrumented(LogInUser.class, usuario, password);

}


    @Override
    @Step("{0} inicia sesión con usuario #usuario")
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                WaitUntil.the(HomePageUI.USER_NAME_INPUT, isVisible()).forNoMoreThan(15).seconds(),
                Enter.theValue(usuario).into(HomePageUI.USER_NAME_INPUT),
                Enter.theValue(password).into(HomePageUI.USER_PASSWORD_INPUT),
                Click.on(HomePageUI.LOGIN_BUTTON)
                );








    }
}
