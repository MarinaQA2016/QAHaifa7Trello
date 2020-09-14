package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTests extends TestBase {

    @BeforeMethod
    public void initTests() throws InterruptedException {

        //Open login window
        WebElement loginIcon = driver.findElement(By
                .xpath("//*[@class='btn btn-sm btn-link text-white']"));
        loginIcon.click();
        Thread.sleep(10000);
    }

    @Test
    public void loginNegativeLoginEmpty() throws InterruptedException {
        // Enter empty login and password
        WebElement passwordField = driver.findElement(By.id("password"));
        passwordField.click();
        passwordField.clear();
        passwordField.sendKeys("marinaqa");
        //Press login button
        WebElement loginButton = driver.findElement(By.id("login"));
        loginButton.click();
        Thread.sleep(5000);
        //Print error message
        System.out.println("Error: " + driver
                .findElement(By.id("error")).getText());
    }
    @Test
    public void loginNegativeLoginIncorrect() throws InterruptedException {
        // Enter not existent login
        WebElement loginField = driver.findElement(By.id("user"));
        loginField.click();
        loginField.clear();
        loginField.sendKeys("123");
        Thread.sleep(3000);

        //Enter existent password
        WebElement passwordField = driver.findElement(By.id("password"));
        passwordField.click();
        passwordField.clear();
        passwordField.sendKeys("marinaqa");

        //Press login button
        WebElement loginButton = driver.findElement(By.id("login"));
        loginButton.click();
        Thread.sleep(5000);
        //Print error message
        System.out.println("Error: " + driver
                .findElement(By.id("error")).getText());
    }

    @Test
    public void loginNegativePasswordIncorrect() throws InterruptedException {
        // Enter login field for attlassian
        WebElement loginField = driver.findElement(By.id("user"));
        loginField.click();
        loginField.clear();
        loginField.sendKeys(LOGIN);
        Thread.sleep(3000);
        //Submit login attlassian
        WebElement loginAttlButton = driver.findElement(By.id("login"));
        loginAttlButton.click();
        Thread.sleep(15000);
        //Enter an incorrect password and submit it
        WebElement passwordAttlField = driver.findElement(By.id("password"));
        passwordAttlField.click();
        passwordAttlField.clear();
        passwordAttlField.sendKeys(PASSWORD+"1");
        driver.findElement(By.id("login-submit")).click();
        Thread.sleep(3000);
        System.out.println("Error message: " + driver
                .findElement(By.id("login-error")).getText());
    }

    @Test
    public void loginPositive() throws InterruptedException {
        // Enter login field for attlassian
        WebElement loginField = driver.findElement(By.id("user"));
        loginField.click();
        loginField.clear();
        loginField.sendKeys(LOGIN);
        Thread.sleep(3000);
        //Submit login attlassian
        WebElement loginAttlButton = driver.findElement(By.id("login"));
        loginAttlButton.click();
        Thread.sleep(15000);
        //Enter attlassian password and submit it
        WebElement passwordAttlField = driver.findElement(By.id("password"));
        passwordAttlField.click();
        passwordAttlField.clear();
        passwordAttlField.sendKeys(PASSWORD);
        driver.findElement(By.id("login-submit")).click();
        Thread.sleep(30000);
        System.out.println("Boards button text: " + driver
                .findElement(By.xpath("//button[@data-test-id ='header-boards-menu-button']"))
                .getText());
    }




}
