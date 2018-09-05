package project.apitests.pages;

import project.apitests.dto.JsonConvertible;
import project.apitests.dto.LoginRequest;
import project.apitests.dto.LoginResponse;
import project.apitests.utils.JsonHandler;
import project.apitests.utils.SettingsManager;

import static io.restassured.RestAssured.given;
import static project.apitests.utils.JsonHandler.convertJsonIntoObject;
import static project.apitests.utils.JsonHandler.formatJsonForConversion;

public class LoginPage {

    private JsonHandler jsonHandler;
    private JsonConvertible expectedRequestResponse;

    public LoginPage(){
        jsonHandler = new JsonHandler();
    }

    public JsonConvertible login(LoginRequest user) throws Exception {
        user.setLogin(SettingsManager.getLogin());
        user.setPassword(SettingsManager.getPassword());

        String actualJsonResponseStringRaw = given()
                .contentType("application/json")
                .body(user)
                .when().post("/api/auth/login").jsonPath().prettify();

        String actualJsonResponseString = formatJsonForConversion(actualJsonResponseStringRaw);
        JsonConvertible actualJsonResponse = convertJsonIntoObject(actualJsonResponseString, new LoginResponse());
        return actualJsonResponse;
    }

    public JsonConvertible getExpectedResponse() throws Exception {
        expectedRequestResponse = jsonHandler.convertJsonIntoObject(SettingsManager.getFile(), new LoginResponse());
        return expectedRequestResponse;
    }
}
