package stepdefinitions;

import com.qa.util.DependencyInjection;
import io.cucumber.java.en.Then;
import org.testng.Assert;

public class SummaryPageSteps {

    private DependencyInjection dependencyInjection;

    public SummaryPageSteps (DependencyInjection dependencyInjection) {
        this.dependencyInjection = dependencyInjection;
    }

    @Then("verify total count is {int}")
    public void verify_total_count(int expectedProductCount) {
        int actualProductCount = dependencyInjection.summaryPage.getProductsCountOnSummary();
        Assert.assertEquals(actualProductCount, expectedProductCount);
    }
}
