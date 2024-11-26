package steps;

import org.openqa.selenium.remote.RemoteWebDriver;
import utils.DriverManager;

public abstract class Steps {
    protected RemoteWebDriver driver = DriverManager.getInstance().getDriver();

}
