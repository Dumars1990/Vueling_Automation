package testRunner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)

@CucumberOptions(
        features = {"src/test/resources/features"},
        glue = {"StepsDefinitions"},
        plugin = {"pretty",
            "html:test-output/cucumber-reports/cucumber.html",
            "json:test-output/cucumber-reports/cucumber.json"
    }
)

public class TestRunner {
}
