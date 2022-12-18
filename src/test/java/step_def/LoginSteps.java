package step_def;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import driver.DriverManager;
import pages.LoginPage;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalToIgnoringCase;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertTrue;

public class LoginSteps extends DriverManager {

    LoginPage loginPage = new LoginPage();

    @Given("the user opens web site for the first time")
    public void the_user_opens_web_site_for_the_first_time() {
        loginPage.goToUrl();
    }

    @Then("login screen with user name and password entries")
    public void login_screen_with_user_name_and_password_entries() {
       assertTrue(loginPage.userNameVisible());
    }

    @And("login button is displayed")
    public void i_click_on_log_in_on_login_page() throws Throwable {
        assertThat(loginPage.loginButtonDisplayed(),is(true));
    }

    @Given("the user provides wrong user name and/or password")
    public void the_user_provides_wrong_user_name_and_or_password() throws Throwable {
        loginPage.enterWrongUserName();
        loginPage.enterPassword();
    }

    @When("sign in button is clicked")
    public void sign_in_button_is_clicked() throws Throwable {
       loginPage.clickLoginInButton();
    }

    @Then("error markers are displayed by user name and/or password entries")
    public void error_marker_are_displayed() throws Throwable {
        assertThat(loginPage.errorMarker(),is(true));
    }

    @Then("the user provided right user name and password")
    public void the_user_provide_right_username_password() {
        loginPage.enterWrongUserName();
        loginPage.correctUserPassword();
    }

    @Then("user is taken to the news page")
    public void user_taken_to_new_page() {
        assertThat(loginPage.errorMarker(),is(true));
    }

    @Given("^the user opens web site next time$")
    public void theUserOpensWebSiteNextTimeWhenPreviouslyLoggedIn() {

    }

    @Then("^user is taken straight to the news page$")
    public void userIsTakenStraightToTheNewsPage() {
    }
}
