package tests;

import base.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class ProductTest extends BaseTest {

    @Test
    public void verifyCategoriesAndProduct() {

        WebDriverWait wait =
                new WebDriverWait(driver, Duration.ofSeconds(20));

        // Phones Category

        wait.until(ExpectedConditions.elementToBeClickable(
                By.linkText("Phones")));

        driver.findElement(By.linkText("Phones")).click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.linkText("Samsung galaxy s6")));

        Assert.assertTrue(
                driver.getPageSource().contains("Samsung galaxy s6"));

        // Laptops Category

        wait.until(ExpectedConditions.elementToBeClickable(
                By.linkText("Laptops")));

        driver.findElement(By.linkText("Laptops")).click();

        // Wait for products to load

        wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.linkText("MacBook air")));

        Assert.assertTrue(
                driver.getPageSource().contains("MacBook air"));

        // Product Details Page

        driver.findElement(By.linkText("MacBook air")).click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.className("name")));

        String productName =
                driver.findElement(By.className("name")).getText();

        Assert.assertTrue(productName.contains("MacBook air"));
    }
}