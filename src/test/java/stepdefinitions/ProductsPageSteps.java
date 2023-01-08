package stepdefinitions;


import com.qa.util.DependencyInjection;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import java.util.List;


public class ProductsPageSteps {


    private int actualProductCount;


    private DependencyInjection dependencyInjection;

    public ProductsPageSteps (DependencyInjection dependencyInjection) {
        this.dependencyInjection = dependencyInjection;
    }

    @Given("user is on products page which has {string} header")
    public void user_is_on_products_page_which_has_header(String expectedPageHeader) {
        String actualPageHeader = dependencyInjection.productsPage.getHeaderText();
        Assert.assertEquals(actualPageHeader, expectedPageHeader);
    }

    @Then("user gets product count")
    public void user_gets_product_count() {
        actualProductCount = dependencyInjection.productsPage.getProductsCount();
    }

    @Then("products count is equal to {int}")
    public void products_count_is_equal_to(Integer expectedProductCount) {
        Assert.assertEquals(actualProductCount, expectedProductCount);
    }

    @When("user click on add to cart button for below products")
    public void user_click_on_add_to_cart_button_for_below_products(DataTable dataTable) {
        List<List<String>> productsList = dataTable.asLists(String.class);
        for (List<String> products : productsList) {
            for (String product : products) {
                dependencyInjection.productsPage.addProductToCart(product);
            }
        }
    }

    @Then("user clicks on cart btn")
    public void user_clicks_on_cart_btn() {
        dependencyInjection.summaryPage = dependencyInjection.productsPage.clickOnShoppingCart();
    }

    @When("user click on {string} product name")
    public void user_click_on_product_name(String productName) {
        dependencyInjection.productDetailsPage = dependencyInjection.productsPage.clickOnProduct(productName);
    }

    @Then("user logged in successfully and lands on {string} products page")
    public void user_logged_in_successfully_and_lands_on_products_page(String expectedUrl) {
        String actualUrl = dependencyInjection.productsPage.getPageUrl();
        Assert.assertEquals(actualUrl, expectedUrl);
    }

    @Then("page header should be {string}")
    public void page_header_should_be(String expectedPageHeader) {
        String actualPageHeader = dependencyInjection.productsPage.getHeaderText();
        Assert.assertEquals(actualPageHeader, expectedPageHeader);
    }
}
