package runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
@CucumberOptions(
		tags="",
        features = "src/test/resources/features",
        glue = {"stepdefinitions", "hooks"},
        plugin = {"pretty", "html:target/cucumber-reports/cucumber.html", "json:target/cucumber-reports/cucumber.json"}
)
public class TestRunner extends AbstractTestNGCucumberTests {
}
