package cucumberStarter;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import utils.DriverManager;
import utils.Helper;

import java.time.Duration;

@CucumberOptions(
        features = "src/test/java/features",
        glue = "steps",
        plugin = {"pretty",
                "html:target/cucumber-html-report",
                "json:target/cucumber-json-report.json"}
)

public class TestRunner extends AbstractTestNGCucumberTests {

    @Before
    public void setUp() {
        DriverManager.getInstance().getDriver(DriverManager.Browser.CHROME);
    }

    @After
    public void shutDown() {
        Helper.getInstance().getScreenshot(DriverManager.getInstance().getDriver());
        try {
            Thread.sleep(Duration.ofSeconds(5));
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        DriverManager.getInstance().shutDownWebDriver();
    }

}
