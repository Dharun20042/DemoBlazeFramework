package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {

    WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    By username = By.id("loginusername");
    By password = By.id("loginpassword");
    By loginButton = By.xpath("//button[text()='Log in']");

    public void login(String user, String pass) {

        driver.findElement(username).sendKeys(user);

        driver.findElement(password).sendKeys(pass);

        driver.findElement(loginButton).click();
    }
}