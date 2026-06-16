package com.startsharp.stepdefinitions;

import com.startsharp2.tasks.LogOutUser;
import com.startsharp2.userinterfaces.HomePageUI;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.matchers.WebElementStateMatchers;
import net.serenitybdd.screenplay.questions.WebElementQuestion;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

public class LogOutUserStepDefinitions {

    @When("he logs out")
    public void he_logs_out() {
        OnStage.theActorInTheSpotlight().attemptsTo(
                LogOutUser.asUser()
        );
    }

    @Then("he should see a header message logo related to {string}")
    public void he_should_see_a_header_message_logo_related_to(String expectedMessage) {

        // Estructura Screenplay recomendada: Valida de manera fluida y espera el elemento automáticamente
        theActorInTheSpotlight().should(
                seeThat("El mensaje visible en el login tras cerrar sesión",
                        WebElementQuestion.the(HomePageUI.LBL_LOGIN_TITLE),
                        WebElementStateMatchers.containsText(expectedMessage))
        );
    }
}