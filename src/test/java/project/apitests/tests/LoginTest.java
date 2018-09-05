package project.apitests.tests;

import org.junit.Test;
import project.apitests.dto.JsonConvertible;
import project.apitests.dto.LoginRequest;
import project.apitests.pages.LoginPage;
import project.apitests.utils.Setup;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsEqual.equalTo;


public class LoginTest extends Setup {

    private LoginRequest user = new LoginRequest();
    private LoginPage loginPage = new LoginPage();

    @Test
    public void postLoginTest() throws Exception {
        JsonConvertible actualRequestResponse = loginPage.login(user);
        assertThat("Actual response does not match expected response", actualRequestResponse, equalTo(loginPage.getExpectedResponse()));
    }
}
