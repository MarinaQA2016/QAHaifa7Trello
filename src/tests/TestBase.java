package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class TestBase {
    public static final String LOGIN = "marinaqatest2019@gmail.com";
    public static final String PASSWORD = "marinaqa";
    WebDriver driver;
    @BeforeMethod
    public void StartAppl() throws InterruptedException {
        // Driver initialization. Open Trello application
        //ChromeOptions options = new ChromeOptions();
        //options.addArguments("--lang=" + "rus");
        driver = new ChromeDriver(/*options*/);
        driver.get("https://trello.com/");

    }
    @AfterMethod
    public void tearDown(){
        driver.quit();
    }



}
