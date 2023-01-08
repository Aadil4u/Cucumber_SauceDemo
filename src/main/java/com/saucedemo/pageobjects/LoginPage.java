package com.saucedemo.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

    @FindBy(id = "user-name")
    WebElement username;
    @FindBy(id = "password")
    WebElement password;
    @FindBy(id = "login-button")
    WebElement loginBtn;
    @FindBy(css = ".login_logo")
    WebElement logo;
    @FindBy(css = "h3[data-test='error']")
    WebElement errorMsg;
    private WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public String getPageTitle() {
        return driver.getTitle();
    }

    public void enterUsername(String uname) {
        username.sendKeys(uname);
    }

    public void enterPassword(String pass) {
        password.sendKeys(pass);
    }

    public ProductsPage clickOnLoginBtn() {
        loginBtn.click();
        return new ProductsPage(driver);
    }

    public String getErrorMsg() {
        return errorMsg.getText();
    }

    public ProductsPage doLogin(String uname, String pass) {
        enterUsername(uname);
        enterPassword(pass);
        clickOnLoginBtn();
        return new ProductsPage(driver);
    }

}
