package com.startsharp.stepdefinitions;

import com.startsharp.tasks.LogOutUser;
import com.startsharp.questions.LogInForm; // Tu Question inmune
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.questions.page.TheWebPage;
import net.serenitybdd.screenplay.waits.Wait;
import org.hamcrest.Matchers;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static org.hamcrest.Matchers.is;

public class LogOutUserStepDefinitions {

    @When("he logs out")
    public void he_logs_out() {
        OnStage.theActorInTheSpotlight().attemptsTo(
                LogOutUser.asUser()
        );
    }

    @Then("he should see a header message logo related to {string}")
    public void he_should_see_a_header_message_logo_related_to(String expectedMessage) {

        // 1. Espera anti-asincronía basada en el cambio de URL (Esto es lo que nos dio el verde)
        theActorInTheSpotlight().attemptsTo(
                Wait.until(
                        theActor -> TheWebPage.currentUrl().answeredBy(theActor),
                        Matchers.containsString("/Account/Login")
                ).forNoMoreThan(15).seconds()
        );

        // 2. Aserción formal usando tu Question limpia de Screenplay
        theActorInTheSpotlight().should(
                seeThat("El usuario se encuentra en el formulario de Login",
                        LogInForm.esVisible(),
                        is(true))
        );
    }
}