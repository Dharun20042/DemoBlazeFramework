package tests;

import base.BaseTest;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;

import java.time.Duration;

public class SignupTest extends BaseTest {

    @Test
    public void signupTest() {

        WebDriverWait wait =
                new WebDriverWait(driver, Duration.ofSeconds(10));

        driver.findElement(By.id("signin2")).click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.id("sign-username")));

        String username = "user" + System.currentTimeMillis();

        driver.findElement(By.id("sign-username"))
                .sendKeys(username);

        driver.findElement(By.id("sign-password"))
                .sendKeys("Test@123");

        driver.findElement(By.xpath("//button[text()='Sign up']"))
                .click();

        wait.until(ExpectedConditions.alertIsPresent());

        Alert alert = driver.switchTo().alert();

        String alertText = alert.getText();

        Assert.assertTrue(alertText.contains("Sign up successful"));

        alert.accept();
    }
}