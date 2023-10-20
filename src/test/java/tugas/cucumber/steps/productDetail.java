package tugas.cucumber.steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import tugas.cucumber.runner.runnerTest;

import java.util.concurrent.TimeUnit;

public class productDetail {
    private WebDriver driver;

    public productDetail() {
        // Menggunakan WebDriver dari Test Runner
        this.driver = runnerTest.getDriver();
    }

    String baseUrl = "https://www.saucedemo.com/";
    @Given("User in login page page")
    public void userInLoginPagePage() {
        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        driver.get(baseUrl);

        WebElement isVisited = driver.findElement(By.id("login-button"));
        isVisited.isDisplayed();
    }

    @And("User fill Username & Password form")
    public void userFillUsernamePasswordForm() {
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
    }

    @And("User click button login")
    public void userClickButtonLogin() {
        driver.findElement(By.id("login-button")).click();
    }

    @Then("User directed to dashboard page")
    public void userDirectedToDashboardPage(){
        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        WebElement element = driver.findElement(By.xpath("//span[@class='title']"));
        element.isDisplayed();
    }

    @And("User click one product")
    public void userClickOneProduct() {
        WebElement productName = driver.findElement(By.xpath("//div[@class='inventory_item_name ']"));
        productName.click();
    }

    @Then("User directed to product detail page")
    public void userDirectedToProductDetailPage() {
        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        WebElement navigator = driver.findElement(By.id("back-to-products"));
        navigator.isDisplayed();
    }
}
