package project.apitests.utils;

import io.restassured.RestAssured;
import org.junit.BeforeClass;

public class Setup {

    @BeforeClass
    public static void setup() {
        SettingsManager settingsManager = new SettingsManager();
        settingsManager.initialization();
        RestAssured.baseURI = settingsManager.getUrl();
    }
}
