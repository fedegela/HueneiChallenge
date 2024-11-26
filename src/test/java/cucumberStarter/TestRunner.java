package cucumberStarter;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import utils.DriverManager;

@CucumberOptions(
        features = "src/test/java/features",
        glue = "steps",
        plugin = {"html:target/cucumber-html-report",
        "json:target/cucumber-json-report.json" }
)

public class TestRunner extends AbstractTestNGCucumberTests {

    @Before
    public void setUp() {
        DriverManager.getInstance().getDriver(DriverManager.Browser.CHROME);
    }

    @After
    public void shutDown(){
        DriverManager.getInstance().shutDownWebDriver();
    }

}
