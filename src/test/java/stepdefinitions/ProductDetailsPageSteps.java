package stepdefinitions;

import com.qa.util.DependencyInjection;
import io.cucumber.java.en.Then;
import org.testng.Assert;

public class ProductDetailsPageSteps {
    private String actualProductName;

    private DependencyInjection dependencyInjection;

    public ProductDetailsPageSteps (DependencyInjection dependencyInjection) {
        this.dependencyInjection = dependencyInjection;
    }

    @Then("user navigated to product details page and gets product name")
    public void userNavigatedToProductDetailsPageAndGetsProductName() {
        actualProductName = dependencyInjection.productDetailsPage.getProductName();
    }

    @Then("product name is equal to {string}")
    public void productNameIsEqualTo(String expectedProductName) {
        Assert.assertEquals(actualProductName,expectedProductName);
    }

}
