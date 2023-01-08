package com.saucedemo.pageobjects;

import com.qa.util.ElementUtil;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class ProductsPage {
    @FindBy(css = ".title")
    WebElement productHeader;

    @FindAll({@FindBy(css = ".inventory_item")})
    List<WebElement> inventoryItems;

    @FindAll({@FindBy(css = ".inventory_item_name")})
    List<WebElement> productsName;

    @FindBy(css = ".shopping_cart_link")
    WebElement cartBtn;

    @FindAll({
            @FindBy(xpath = "//div[@class='inventory_item_name']/parent::a/parent::div//following-sibling::div //button")})
    List<WebElement> addToCartBtn;

    private WebDriver driver;

    public ProductsPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public String getPageUrl() {
        return driver.getCurrentUrl();
    }

    public String getHeaderText() {
        return productHeader.getText();
    }

    public int getProductsCount() {
        return inventoryItems.size();
    }

    public void addProductToCart(String productName) {
        for (int i = 0; i < productsName.size(); i++) {
            String productText = productsName.get(i).getText();
            if (productText.equals(productName)) {
                ElementUtil.scrollByVisibilityOfElement(driver,addToCartBtn.get(i));
                addToCartBtn.get(i).click();
                break;
            }
        }
    }

    public SummaryPage clickOnShoppingCart() {
        ElementUtil.scrollByVisibilityOfElement(driver, cartBtn);
        cartBtn.click();
        return new SummaryPage(driver);
    }


    public ProductDetailsPage clickOnProduct(String productName) {
        for (int i = 0; i < productsName.size(); i++) {
            String productText = productsName.get(i).getText();
            if (productText.equals(productName)) {
                ElementUtil.scrollByVisibilityOfElement(driver, productsName.get(i));
                productsName.get(i).click();
                break;
            }
        }
        return new ProductDetailsPage(driver);
    }


}
