package com.virgingames.cucumber.steps;

import com.virgingames.gamesinfo.GamesSteps;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.restassured.response.ValidatableResponse;
import net.thucydides.core.annotations.Steps;
import org.junit.Assert;

import java.util.List;

import static org.hamcrest.CoreMatchers.equalTo;

public class GameStepDef {
    static ValidatableResponse response;
    static List<Object> defaultGameFrequencyList;

    //@Steps to initialise object of GamesSteps class
    @Steps
    GamesSteps gamesSteps;
    @When("^User send a GET request to the Get Bingo Lobby feed end point$")
    public void userSendAGETRequestToTheGetBingoLobbyFeedEndPoint() {
        response = gamesSteps.getAllGamesInfo();
    }

    @Then("^verifies that the non-null game frequency has been set to (\\d+)$")
    public void verifiesThatTheNonNullGameFrequencyHasBeenSetTo(int frequency) {
        //path that extracts all the values from the entire record
        defaultGameFrequencyList = response.extract().path("bingoLobbyInfoResource.streams.defaultGameFrequency");
        System.out.println(defaultGameFrequencyList);

        for (Object defaultGameFrequency : defaultGameFrequencyList) {
            if ((defaultGameFrequency != null) ) {
                Assert.assertThat(defaultGameFrequency, equalTo(frequency));
            }
        }
    }
}
