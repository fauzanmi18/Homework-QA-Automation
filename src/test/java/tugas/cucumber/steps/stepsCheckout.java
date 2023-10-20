package tugas.cucumber.steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import tugas.cucumber.runner.runnerTest;

import java.util.concurrent.TimeUnit;

public class stepsCheckout {
    private WebDriver driver;

    public stepsCheckout() {
        // Menggunakan WebDriver dari Test Runner
        this.driver = runnerTest.getDriver();
    }

    String baseUrl = "https://www.saucedemo.com/";
    @Given("User in login page")
    public void userInLoginPage() {
        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        driver.get(baseUrl);

        WebElement isVisited = driver.findElement(By.id("login-button"));
        isVisited.isDisplayed();
    }

    @And("User fill Username and Password form")
    public void userFillUsernameAndPasswordForm() {
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
    }

    @Then("User click login button")
    public void userClickLoginButton() {
        driver.findElement(By.id("login-button")).click();
    }

    @And("User directed to dashboard")
    public void userDirectedToDashboard(){
        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        WebElement element = driver.findElement(By.xpath("//span[@class='title']"));
        element.isDisplayed();
    }

    @And("User add one product to card")
    public void userAddProductToCard() {
        WebElement addToCart = driver.findElement(By.id("add-to-cart-sauce-labs-bike-light"));
        addToCart.click();
    }

    @And("User click cart icon")
    public void userClickCartIcon() {
        WebElement cart = driver.findElement(By.xpath("//a[@class='shopping_cart_link']"));
        cart.click();
    }

    @And("User verify the product")
    public void userVerifyTheProduct() {
        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        String selectedProduct = "Sauce Labs Bike Light";
        String productOnCart = driver.findElement(By.xpath("//div[@class='inventory_item_name']")).getText();
        Assert.assertEquals(selectedProduct, productOnCart);
    }

    @Then("User click checkout button")
    public void userClickCheckoutButton() {
        WebElement btnCheckout = driver.findElement(By.id("checkout"));
        btnCheckout.click();
    }

    @And("User fill information form")
    public void userFillInformationForm() {
        driver.findElement(By.id("first-name")).sendKeys("abc");
        driver.findElement(By.id("last-name")).sendKeys("abc");
        driver.findElement(By.id("postal-code")).sendKeys("abc");
    }

    @Then("User click continue button")
    public void userClickContinueButton() {
        WebElement continueBtn = driver.findElement(By.id("continue"));
        continueBtn.click();
    }

    @And("User directed to overview page")
    public void userDirectedToOverviewPage() {
        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        String expectedPage = driver.findElement(By.xpath("//span[@class='title']")).getText();
        Assert.assertEquals(expectedPage, "Checkout: Overview");
    }

    @Then("User click finish button")
    public void userClickFinishButton() {
        WebElement finishBtn = driver.findElement(By.id("finish"));
        finishBtn.click();
    }

    @And("User get order complete message")
    public void userGetOrderCompleteMessage() {
        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        String finishAlert = driver.findElement(By.xpath("//h2[@class='complete-header']")).getText();
        Assert.assertEquals(finishAlert, "Thank you for your order!");
    }
}
