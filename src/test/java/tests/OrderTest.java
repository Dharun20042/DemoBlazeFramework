package tests;

import base.BaseTest;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class OrderTest extends BaseTest {

    @Test
    public void placeOrderTest() {

        WebDriverWait wait =
                new WebDriverWait(driver, Duration.ofSeconds(20));

        wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.linkText("Samsung galaxy s6")));

        driver.findElement(By.linkText("Samsung galaxy s6")).click();

        wait.until(ExpectedConditions.elementToBeClickable(
                By.linkText("Add to cart")));

        driver.findElement(By.linkText("Add to cart")).click();

        wait.until(ExpectedConditions.alertIsPresent());

        Alert alert = driver.switchTo().alert();

        alert.accept();

        driver.findElement(By.id("cartur")).click();

        wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//button[text()='Place Order']")));

        driver.findElement(By.xpath("//button[text()='Place Order']"))
                .click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.id("name")));

        driver.findElement(By.id("name"))
                .sendKeys("Dharun");

        driver.findElement(By.id("country"))
                .sendKeys("India");

        driver.findElement(By.id("city"))
                .sendKeys("Madurai");

        driver.findElement(By.id("card"))
                .sendKeys("123456789");

        driver.findElement(By.id("month"))
                .sendKeys("05");

        driver.findElement(By.id("year"))
                .sendKeys("2026");

        driver.findElement(By.xpath("//button[text()='Purchase']"))
                .click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.className("sweet-alert")));

        Assert.assertTrue(
                driver.getPageSource()
                        .contains("Thank you for your purchase"));
    }
}