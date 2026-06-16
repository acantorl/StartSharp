package com.startsharp.stepdefinitions;

import com.startsharp2.questions.ValidarLogin;
import com.startsharp2.tasks.LogInUser;
import com.startsharp2.userinterfaces.MyAccountPageUI;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.GivenWhenThen;
import net.serenitybdd.screenplay.actions.Open;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import net.serenitybdd.screenplay.matchers.WebElementStateMatchers;
import net.serenitybdd.screenplay.questions.WebElementQuestion;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static org.hamcrest.Matchers.equalTo;

public class LogInUserStepDefinitions {

    @Before
    public void setTheStage() {
        OnStage.setTheStage(new OnlineCast());
    }

    @Given("that the user navigates on the StartSharp page")
    public void thatTheUserNavigatesOnTheStartSharpPage() {
        OnStage.theActorCalled("Actor").attemptsTo(Open.url("https://demo.serenity.is/"));


    }

    @When("he logs with credentials {string} and {string}")
    public void heLogsWithCredentialsAnd(String usuario, String password) {
        OnStage.theActorInTheSpotlight().attemptsTo(
                LogInUser.conCredenciales(usuario, password)
        );


    }

    @Then("he should see a message related to {string}")
    public void heShouldSeeAMessageRelatedTo(String expectedMessage) {
        GivenWhenThen.seeThat(
                WebElementQuestion.the(MyAccountPageUI.DASHBOARD_MESSAGE),
                WebElementStateMatchers.containsText("Tablero")


        );


        theActorInTheSpotlight().should(
                seeThat("El mensaje visible en el Dashboard",
                        ValidarLogin.elMensajeDeDashboard(), equalTo(expectedMessage))
        );


    }


}