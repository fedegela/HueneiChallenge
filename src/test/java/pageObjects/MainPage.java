package pageObjects;

import org.openqa.selenium.By;

public class MainPage {

    private final String url = "https://www.saucedemo.com";
    private final By errorButtonLocator = By.cssSelector(".error-button");

    public String getUrl() {
        return url;
    }

    public By getErrorButtonLocator() {
        return errorButtonLocator;
    }
}
