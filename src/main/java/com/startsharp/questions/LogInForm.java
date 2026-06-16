package com.startsharp.questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.page.TheWebPage;

public class LogInForm implements Question<Boolean> {

    @Override
    public Boolean answeredBy(Actor actor) {
        // Obtiene la URL actual del navegador a través de Serenity
        String currentUrl = TheWebPage.currentUrl().answeredBy(actor);
        // Retorna verdadero si el usuario fue redirigido a la ruta de Login
        return currentUrl.contains("/Account/Login");
    }

    public static LogInForm esVisible() {
        return new LogInForm();
    }
}