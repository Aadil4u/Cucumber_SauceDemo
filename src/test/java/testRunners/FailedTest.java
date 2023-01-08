package testRunners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features = {"@target/failedRerun.txt"},
        glue = {"stepdefinitions", "AppHooks"},
        plugin = {"pretty","com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"})
public class FailedTest extends AbstractTestNGCucumberTests {
}
