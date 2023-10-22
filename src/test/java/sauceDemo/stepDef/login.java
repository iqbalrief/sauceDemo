package sauceDemo.stepDef;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


import java.util.List;
import java.util.concurrent.TimeUnit;

public class login {
    WebDriver driver;
    String baseUrl = "https://www.saucedemo.com/";
    @Given(value = "hangman login sauce")
    public void hangman_login_sauce() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        driver.get(baseUrl);
    }



    @When("Input username")
    public void Input_username() {
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
    }

    @When("Input password")
    public void Input_password() {
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
    }

    @And("Click login button")
    public void clickLoginButton() {
        driver.findElement(By.id("login-button")).click();

    }

    @Then("Use in on dashboard page")
    public void useInOnDashboardPage() {
        driver.findElement(By.xpath("//div[@class='app_logo']"));

        WebElement logoElement = driver.findElement(By.xpath("//div[@class='app_logo']"));
        Assert.assertTrue("Element with class 'app_logo' not found on the dashboard page", logoElement.isDisplayed());
    }


    @And("Input Invalid username")
    public void InputInvalidusername() {
        driver.findElement(By.id("user-name")).sendKeys("Pecret_sauces");
    }

    @And("Input Invalid Password")
    public void InputInvalidPassword() {

        driver.findElement(By.id("password")).sendKeys("Pecret_sauces");
    }



    @Then("User get error message")
    public void userGetErrorMessage() {
        String errorLogin = driver.findElement(By.xpath("//h3[@data-test='error']")).getText();;
        Assert.assertEquals(errorLogin, "Epic sadface: Username and password do not match any user in this service");
    }


}
