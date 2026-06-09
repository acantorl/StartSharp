package com.startsharp2.questions;

import com.startsharp2.userinterfaces.HomePageUI;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.Text;

public class ValidarLogout implements Question<String> {

    public static ValidarLogout elMensajeDelHomePage() {
        return new ValidarLogout();
    }

    @Override
    public String answeredBy(Actor actor) {
        return Text.of(HomePageUI.LBL_LOGIN_TITLE).answeredBy(actor);

    }
}
