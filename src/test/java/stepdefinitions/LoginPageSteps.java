package stepdefinitions;

import com.qa.factory.DriverFactory;
import com.qa.util.DependencyInjection;
import com.saucedemo.pageobjects.LoginPage;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

import java.util.List;
import java.util.Map;

public class LoginPageSteps {

    private String actualTitle;

    private  DependencyInjection dependencyInjection;
    private LoginPage loginPage;

    public LoginPageSteps (DependencyInjection dependencyInjection) {
        this.dependencyInjection = dependencyInjection;
        this.loginPage = dependencyInjection.pageObjectManager.getLoginPage();
    }

    @Given("User is already logged in with below credentials")
    public void user_is_already_logged_in_with_below_credentials(DataTable dataTable) {
        DriverFactory.getDriver().get("https://www.saucedemo.com");
        List<Map<String, String>> cred = dataTable.asMaps(String.class, String.class);
        String username = cred.get(0).get("username");
        String password = cred.get(0).get("password");
        dependencyInjection.productsPage = loginPage.doLogin(username, password);
    }

    @Given("user is on login page")
    public void user_is_on_login_page() {
        DriverFactory.getDriver().get("https://www.saucedemo.com");
    }

    @When("user gets the title of the page")
    public void user_gets_the_title_of_the_page() {
        actualTitle = loginPage.getPageTitle();
        System.out.println("Login page title is " + actualTitle);
    }

    @Then("title should be {string}")
    public void title_should_be(String expectedTitle) {
        Assert.assertEquals(expectedTitle, actualTitle);
    }

    @When("user enter {string} in username field")
    public void user_enter_in_username_field(String username) {
        loginPage.enterUsername(username);
    }

    @When("user enter {string} in password field")
    public void user_enter_in_password_field(String password) {
        loginPage.enterPassword(password);
    }

    @When("click on login button")
    public void click_on_login_button() {
        dependencyInjection.productsPage = loginPage.clickOnLoginBtn();
    }

    @Then("user get {string} error")
    public void user_get_error(String expectedErrorMsg) {
        String actualErrorMsg = loginPage.getErrorMsg();
        Assert.assertEquals(expectedErrorMsg, actualErrorMsg);
    }




}
