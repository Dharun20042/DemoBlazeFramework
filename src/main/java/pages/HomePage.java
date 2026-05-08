package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {

    WebDriver driver;

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    By loginBtn = By.id("login2");

    public void clickLogin() {
        driver.findElement(loginBtn).click();
    }
}