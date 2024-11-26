package steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.testng.Assert;
import pageObjects.MainPage;

import java.time.Duration;

public class Steps_MainPage extends Steps {
    private MainPage mainPage = new MainPage();

    @Given("I go to the main page")
    public void iGoToTheMainPage() {
        driver.get(mainPage.getUrl());
    }

    @When("I enter the username {}")
    public void iEnterTheUsernameUsername(String username) {
        driver.findElement(By.id("user-name")).sendKeys(username);
    }

    @And("I enter the password {}")
    public void iEnterThePasswordPassword(String password) {
        driver.findElement(By.id("password")).sendKeys(password);
    }

    @And("I click in Login button")
    public void iClickInLoginButton() {
        driver.findElement(By.id("login-button")).click();
    }

    @Then("I should be redirected to inventory page")
    public void iShouldBeRedirectedToInventoryPage() {
        Assert.assertEquals(driver.getCurrentUrl(), "https://www.saucedemo.com/inventory.html");
    }

    @Then("An error button should be displayed")
    public void anErrorButtonShouldBeDisplayed() {
        Assert.assertTrue(driver.findElement(mainPage.getErrorButtonLocator()).isDisplayed());
    }

    @Then("I wait {int} seconds")
    public void andThenIWaitXSeconds(Integer seconds){
        try {
            Thread.sleep(Duration.ofSeconds(seconds));
        } catch (InterruptedException e) {
            System.out.println("Couldn't wait " + seconds + " seconds.");
            throw new RuntimeException(e);
        }
    }
}
