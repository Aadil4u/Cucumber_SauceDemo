package com.saucedemo.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class SummaryPage {

    private WebDriver driver;

    @FindAll({ @FindBy(css = ".inventory_item_name") })
    List<WebElement> productsName;

    public SummaryPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public int getProductsCountOnSummary() {
        return productsName.size();
    }
}
