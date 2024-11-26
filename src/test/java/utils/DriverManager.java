package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;

public class DriverManager {

    private final int WAIT_TIME = 10;
    private final String driversPath = "./src/test/java/drivers/";
    private WebDriver driver;
    private static DriverManager driverManager;

    public static DriverManager getInstance() {
        if (driverManager == null) {
            driverManager = new DriverManager();
        }
        return driverManager;
    }

    public WebDriver getDriver() {
        return getDriver(Browser.CHROME);
    }

    public WebDriver getDriver(Browser browserName) {
        if (driver == null) {
            initiateWebDriver(browserName);
        }
        return driver;
    }

    private void initiateWebDriver(Browser browserName) {
        switch (browserName) {
            case Browser.FIREFOX:
                System.setProperty("webdriver.gecko.driver",
                        driversPath + "geckodriver.exe");
                driver = new FirefoxDriver();
                break;

            case Browser.EDGE:
                System.setProperty("webdriver.edge.driver",
                        driversPath + "msedgedriver.exe");
                driver = new EdgeDriver();
                break;
            case Browser.CHROME:
            default:
                System.setProperty("webdriver.chrome.driver",
                        driversPath + "chromedriver.exe");
                ChromeOptions opt = new ChromeOptions();
                opt.addArguments("--headless");
                driver = new ChromeDriver(opt);
                break;
        }
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(WAIT_TIME));
    }

    public void shutDownWebDriver() {
        driver.close();
        driver.quit();
        driver = null;
    }

    public enum Browser {
        CHROME, FIREFOX, EDGE
    }
}
