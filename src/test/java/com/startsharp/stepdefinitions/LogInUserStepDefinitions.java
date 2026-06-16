package com.startsharp.stepdefinitions;

import com.startsharp.tasks.LogInUser;
import com.startsharp.userinterfaces.MyAccountPageUI;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.actions.Open;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import net.serenitybdd.screenplay.questions.Text;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static org.hamcrest.Matchers.anyOf;
import static org.hamcrest.Matchers.containsString;

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
        // Text.of() extrae el String real renderizado en el navegador de manera segura
        theActorInTheSpotlight().should(
                seeThat("El mensaje visible en el Dashboard (Soporte Bilingüe)",
                        Text.of(MyAccountPageUI.DASHBOARD_MESSAGE),
                        anyOf(containsString("Tablero"), containsString("Dashboard")))
        );
    }
}