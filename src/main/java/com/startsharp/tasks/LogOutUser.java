package com.startsharp.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static com.startsharp.userinterfaces.MyAccountPageUI.CLOSE_SESSION_MENU_BUTTON;
import static com.startsharp.userinterfaces.MyAccountPageUI.USER_PROFILE_MENU_BUTTON;
import static net.serenitybdd.screenplay.Tasks.instrumented;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isPresent;

public class LogOutUser implements Task {

    public static LogOutUser asUser() {
        return instrumented(LogOutUser.class);

    }


    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                WaitUntil.the(USER_PROFILE_MENU_BUTTON, isPresent()).forNoMoreThan(20).seconds(),
                Click.on(USER_PROFILE_MENU_BUTTON),
                WaitUntil.the(CLOSE_SESSION_MENU_BUTTON, isPresent()).forNoMoreThan(20).seconds(),
                Click.on(CLOSE_SESSION_MENU_BUTTON)

        );

    }
}
