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

    @Then("he should be redirected to the login page")
    public void he_should_be_redirected_to_the_login_page() {

        // 1. Espera anti-asincronía basada en el cambio de URL
        theActorInTheSpotlight().attemptsTo(
                Wait.until(
                        theActor -> TheWebPage.currentUrl().answeredBy(theActor),
                        Matchers.containsString("/Account/Login")
                ).forNoMoreThan(15).seconds()
        );

        // 2. Aserción formal usando tu Question limpia de Screenplay
        theActorInTheSpotlight().should(
                seeThat("El usuario se encuentra en la pantalla de Login",
                        LogInForm.esVisible(),
                        is(true))
        );
    }
}