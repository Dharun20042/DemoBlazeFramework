package tests;

import base.BaseTest;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class CartTest extends BaseTest {

    @Test
    public void cartOperationsTest() {

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

        Assert.assertTrue(alert.getText().contains("Product added"));

        alert.accept();

        driver.findElement(By.id("cartur")).click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//td[text()='Samsung galaxy s6']")));

        Assert.assertTrue(
                driver.getPageSource().contains("Samsung galaxy s6"));

        driver.findElement(By.linkText("Delete")).click();

        wait.until(ExpectedConditions.invisibilityOfElementLocated(
                By.xpath("//td[text()='Samsung galaxy s6']")));
    }
}