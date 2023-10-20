package tugas.cucumber.steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import tugas.cucumber.runner.runnerTest;

import java.util.concurrent.TimeUnit;

public class stepsLogout {
    //WebDriver driver;
    private WebDriver driver;

    public stepsLogout() {
        // Menggunakan WebDriver dari Test Runner
        this.driver = runnerTest.getDriver();
    }

    String baseUrl = "https://www.saucedemo.com/";
    @Given("User already in login page")
    public void userAlreadyInLoginPage() {
        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        driver.get(baseUrl);

        WebElement isVisited = driver.findElement(By.id("login-button"));
        isVisited.isDisplayed();
    }

    @And("User fill Username form & Password form")
    public void userFillUsernameFormPasswordForm() {
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
    }

    @Then("User click the login button")
    public void userClickTheLoginButton() {
        driver.findElement(By.id("login-button")).click();
    }

    @And("User is directed to dashboard")
    public void userIsDirectedToDashboard() {
        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        WebElement element = driver.findElement(By.xpath("//span[@class='title']"));
        element.isDisplayed();
    }

    @And("User click hamburger menu")
    public void userClickHamburgerMenu() {
        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        WebElement hamburger = driver.findElement(By.id("react-burger-menu-btn"));
        hamburger.click();
    }

    @When("User click logout")
    public void userClickLogout() {
        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);

        WebElement btnLogout = driver.findElement(By.id("logout_sidebar_link"));
        btnLogout.click();
    }

    @Then("User should directed to login page")
    public void userShouldDirectedToLoginPage() {
        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        WebElement isVisited = driver.findElement(By.id("login-button"));
        isVisited.isDisplayed();
    }
}
