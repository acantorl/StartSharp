package com.startsharp.stepdefinitions;


import com.startsharp2.questions.ValidarLogin;
import com.startsharp2.questions.ValidarLogout;
import com.startsharp2.tasks.LogOutUser;
import com.startsharp2.userinterfaces.HomePageUI;
import com.startsharp2.userinterfaces.MyAccountPageUI;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.matchers.WebElementStateMatchers;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static org.hamcrest.Matchers.equalTo;

public class LogOutUserStepDefinitions {


    @When("he logs out")
    public void he_logs_out() {
        OnStage.theActorInTheSpotlight().attemptsTo(
                LogOutUser.asUser()
        );


    }

    @Then("he should see a header message logo related to {string}")
    public void he_should_see_a_header_message_logo_related_to(String expectedMessage) {
        theActorInTheSpotlight().attemptsTo(
                WaitUntil.the(HomePageUI.LBL_LOGIN_TITLE, WebElementStateMatchers.containsText(expectedMessage))
                        .forNoMoreThan(15).seconds()
        );

        theActorInTheSpotlight().should(
                seeThat("El mensaje visible en el Home",
                        ValidarLogout.elMensajeDelHomePage(), equalTo(expectedMessage))
        );
    }


}
