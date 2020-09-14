package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class TrelloTests {
    public static final String LOGIN = "marinaqatest2019@gmail.com";
    public static final String PASSWORD = "marinaqa";

    @Test
    public void loginNegativeLoginEmpty() throws InterruptedException {
        // Driver initialization. Open Trello application
        //ChromeOptions options = new ChromeOptions();
       //options.addArguments("--lang=" + "rus");
        WebDriver driver = new ChromeDriver(/*options*/);
        driver.get("https://trello.com/");
        Thread.sleep(10000);
        //Open login window
        WebElement loginIcon = driver.findElement(By
                .xpath("//*[@class='btn btn-sm btn-link text-white']"));
        loginIcon.click();
        Thread.sleep(10000);
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
        driver.quit();
    }
    @Test
    public void loginNegativeLoginIncorrect() throws InterruptedException {
        WebDriver driver = new ChromeDriver(/*options*/);
        driver.get("https://trello.com/");
        Thread.sleep(10000);

        //Open login window
        WebElement loginIcon = driver.findElement(By
                .xpath("//*[@class='btn btn-sm btn-link text-white']"));
        loginIcon.click();
        Thread.sleep(10000);

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
        driver.quit();
    }

    @Test
    public void loginNegativePasswordIncorrect() throws InterruptedException {
        // Driver initialization. Open Trello application
        WebDriver driver = new ChromeDriver();
        driver.get("https://trello.com/");
        Thread.sleep(10000);
        //Open login window
        WebElement loginIcon = driver.findElement(By
                .xpath("//*[@class='btn btn-sm btn-link text-white']"));
        loginIcon.click();
        Thread.sleep(10000);
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
        driver.quit();
    }

    @Test
    public void loginPositive() throws InterruptedException {
        // Driver initialization. Open Trello application
        WebDriver driver = new ChromeDriver();
        driver.get("https://trello.com/");
        Thread.sleep(10000);
        //Open login window
        WebElement loginIcon = driver.findElement(By
                .xpath("//*[@class='btn btn-sm btn-link text-white']"));
        loginIcon.click();
        Thread.sleep(10000);
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
        driver.quit();
    }

    @Test
    public void CreateListPositive() throws InterruptedException {
        // Driver initialization. Open Trello application
        WebDriver driver = new ChromeDriver();
        driver.get("https://trello.com/");
        Thread.sleep(10000);
        //Open login window
        WebElement loginIcon = driver.findElement(By
                .xpath("//*[@class='btn btn-sm btn-link text-white']"));
        loginIcon.click();
        Thread.sleep(10000);
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
        //Open QA7Haifa board
        WebElement qa7HaifaBoard = driver.findElement(By
                .xpath("//li[@class='boards-page-board-section-list-item'][.//div[@title ='QA Haifa7']]"));
        qa7HaifaBoard.click();
        Thread.sleep(3000);
        //Press 'Add list' or 'Add another list'
        WebElement addListButton = driver.findElement(By.xpath("//span[@class='placeholder']"));
        addListButton.click();
        //Fill the name of new list and submit it
        WebElement addNamelistField = driver.findElement(By.xpath("//input[@name='name']"));
        addNamelistField.click();
        addNamelistField.clear();
        addNamelistField.sendKeys("test");
        WebElement submitNewList = driver.findElement(By.xpath("//input[@type='submit']"));
        submitNewList.click();
        //Cancel the new adding list control
        WebElement xButton = driver.findElement(By.cssSelector("a.icon-close.dark-hover"));
        xButton.click();

        driver.quit();
    }

}
