package tests;

import base.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;

import java.time.Duration;

public class LoginTest extends BaseTest {

    @Test
    public void validLoginTest() {

        HomePage home = new HomePage(driver);

        home.clickLogin();

        WebDriverWait wait =
                new WebDriverWait(driver, Duration.ofSeconds(10));

        wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.id("loginusername")));

        LoginPage login = new LoginPage(driver);

        login.login("dharun12345", "Test@123");

        wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.id("nameofuser")));

        String welcomeText =
                driver.findElement(By.id("nameofuser")).getText();

        Assert.assertTrue(welcomeText.contains("Welcome"));
    }
}