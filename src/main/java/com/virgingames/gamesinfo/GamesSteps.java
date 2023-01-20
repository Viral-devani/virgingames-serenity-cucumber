package com.virgingames.gamesinfo;

import com.virgingames.constants.EndPoints;
import io.restassured.parsing.Parser;
import io.restassured.response.ValidatableResponse;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;

public class GamesSteps {
    @Step("Get information from Bingo lobby info resource ")
    public ValidatableResponse getAllGamesInfo() {
        return SerenityRest.given().log().all()
                .when()
                .get(EndPoints.GET_BINGO_LOBBY_FEED)
                .then()
                .statusCode(200)
                .log().all()
                  //parsing the text into JSON format
                .parser("text/plain;charset=UTF-8", Parser.JSON);


    }

}