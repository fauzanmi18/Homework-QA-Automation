package tugas.cucumber.steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import tugas.cucumber.runner.runnerTest;

import java.util.concurrent.TimeUnit;

public class stepsLogin {
    private WebDriver driver;

    public stepsLogin() {
        // Menggunakan WebDriver dari Test Runner
        this.driver = runnerTest.getDriver();
    }
    String baseUrl = "https://www.saucedemo.com/";
    @Given("User on login page")
    public void user_on_login_page(){
        //driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        driver.get(baseUrl);

        WebElement isVisited = driver.findElement(By.id("login-button"));
        isVisited.isDisplayed();
    }

    @And("User input username")
    public void userInputUsername(){
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
    }

    @And("User input password")
    public void userInputPassword(){
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
    }

    @When("User click login")
    public void userClickLogin(){
        driver.findElement(By.id("login-button")).click();
    }

    @Then("User should redirected to dashboard")
    public void userShouldRedirectedToDashboard() {
        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        String isVisited = driver.findElement(By.xpath("//span[@class='title']")).getText();
        Assert.assertEquals(isVisited, "Products");
    }

    @And("User input invalid password")
    public void userInputInvalidPassword() {
        driver.findElement(By.id("password")).sendKeys("failed");
    }

    @Then("User should have alert message")
    public void userShouldHaveAlertMessage() {
        String actualAlert = "Epic sadface: Username and password do not match any user in this service";
        String verifyAlert = driver.findElement(By.xpath("//h3[contains(@data-test,'error')]")).getText();
        Assert.assertEquals(verifyAlert, actualAlert);
    }
}
