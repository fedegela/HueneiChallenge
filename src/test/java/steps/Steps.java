package steps;
import org.openqa.selenium.WebDriver;
import utils.DriverManager;

public abstract class Steps {
    protected WebDriver driver = DriverManager.getInstance().getDriver();
}
