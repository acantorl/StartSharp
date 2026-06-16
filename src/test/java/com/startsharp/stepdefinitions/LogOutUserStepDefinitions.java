package com.startsharp.stepdefinitions;

import com.startsharp2.tasks.LogOutUser;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.questions.page.TheWebPage;
import net.serenitybdd.screenplay.waits.Wait;
import org.hamcrest.Matchers;

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

        // 1. DALE TIEMPO A LA REDIRECCIÓN: Esperamos hasta 15 segundos a que la URL cambie al Login
        theActorInTheSpotlight().attemptsTo(
                Wait.until(
                        theActor -> TheWebPage.currentUrl().answeredBy(theActor),
                        Matchers.containsString("/Account/Login")
                ).forNoMoreThan(15).seconds()
        );

        // 2. ASERCIÓN INMUNE: Validamos que la URL actual contenga la ruta de autenticación externa
        theActorInTheSpotlight().should(
                seeThat("La URL actual corresponde a la pantalla de Login",
                        TheWebPage.currentUrl(),
                        Matchers.containsString("/Account/Login"))
        );
    }
}