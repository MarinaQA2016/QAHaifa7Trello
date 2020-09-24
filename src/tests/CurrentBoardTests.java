package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class CurrentBoardTests extends TestBase {

    @BeforeMethod
    public void initTests() throws InterruptedException {
        //Open login window
        WebElement loginIcon = driver.findElement(By
                .xpath("//*[@class='btn btn-sm btn-link text-white']"));
        loginIcon.click();
        //Thread.sleep(10000);
        waitUntilElementIsClickable(By.id("user"),15);
        // Enter login field for attlassian
        WebElement loginField = driver.findElement(By.id("user"));
        loginField.click();
        loginField.clear();
        loginField.sendKeys(LOGIN);
        //Thread.sleep(3000);
        waitUntilElementIsClickable(By.xpath("//input[@value='Log in with Atlassian']"),10);
        //Submit login attlassian
        WebElement loginAttlButton = driver.findElement(By.id("login"));
        loginAttlButton.click();
        //Thread.sleep(15000);
        waitUntilElementIsClickable(By.id("password"),20);
        waitUntilElementIsClickable(By.id("login-submit"),10);
        //Enter attlassian password and submit it
        WebElement passwordAttlField = driver.findElement(By.id("password"));
        passwordAttlField.click();
        passwordAttlField.clear();
        passwordAttlField.sendKeys(PASSWORD);
        driver.findElement(By.id("login-submit")).click();
        //Thread.sleep(30000);
        waitUntilElementIsClickable(By.xpath("//button[@data-test-id ='header-boards-menu-button']"),45);
        //Open QA7Haifa board
        WebElement qa7HaifaBoard = driver.findElement(By
                .xpath("//li[@class='boards-page-board-section-list-item'][.//div[@title ='QA Haifa7']]"));
        qa7HaifaBoard.click();
        waitUntilElementIsClickable(By.id("workspaces-preamble-board-header-button"),15);
        waitUntilElementIsPresent(By.tagName("h1"),10);
    }

    @Test
    public void isCorrectCurrentBoard(){
        System.out.println("Header of the current board: " + driver.findElement(By.tagName("h1")).getText());
        Assert.assertEquals(driver.findElement(By.tagName("h1")).getText(),"QA Haifa7",
                "The header of the screen is not 'QA Haifa7'");

    }
    @Test
    public void createListPositive() throws InterruptedException {

        System.out.println("Lists quantity before: " + driver
                .findElements(By.xpath("//div[@class = 'list js-list-content']"))
                .size());
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
        System.out.println("Lists quantity after: " + driver
                .findElements(By.xpath("//div[@class = 'list js-list-content']"))
                .size());

    }
    @Test
    public void putAnyListToArchive() throws InterruptedException {
        //Print the quantity of lists
        /*System.out.println("Lists quantity before: " + driver
                .findElements(By.xpath("//div[@class = 'list js-list-content']"))
                .size());*/
        //If there are no lists create the new list
        WebElement addListButton = driver.findElement(By.cssSelector("a.open-add-list"));
        System.out.println("Text on the button: " + addListButton.getText());
         if (addListButton.getText().equals("Add a list")){
             addListButton.click();
             waitUntilElementIsClickable(By.xpath("//input[@type='submit']"),5);
             //Fill the name of new list and submit it
             WebElement addNamelistField = driver.findElement(By.xpath("//input[@name='name']"));
             addNamelistField.click();
             addNamelistField.clear();
             addNamelistField.sendKeys("test");
             WebElement submitNewList = driver.findElement(By.xpath("//input[@type='submit']"));
             submitNewList.click();
             //Cancel the new adding list control
             waitUntilElementIsClickable(By.cssSelector("a.icon-close.dark-hover"),5);
             WebElement xButton = driver.findElement(By.cssSelector("a.icon-close.dark-hover"));
             xButton.click();
             waitUntilElementIsInvisible(By.cssSelector("a.icon-close.dark-hover"),5);
         }

         waitUntilElementsAreVisible(By.xpath("//div[@class = 'list js-list-content']"),10);

         System.out.println("Lists quantity after adding the new list: " + driver
                .findElements(By.xpath("//div[@class = 'list js-list-content']"))
                .size());
         int quantityListsInTheBeginning = driver
                 .findElements(By.xpath("//div[@class = 'list js-list-content']")).size();
         //Thread.sleep(2000);
         addListButton =driver.findElement(By.cssSelector("a.open-add-list"));
        System.out.println("Text on the button: " + addListButton.getText());
        //Open the extra menu for any list
        WebElement extraMenu = driver.findElement(By.cssSelector("a.list-header-extras-menu"));
        extraMenu.click();
        // Put the list to the archive
        waitUntilElementIsClickable(By.cssSelector("a.js-close-list"),15);
        WebElement closeExtraMenu = driver.findElement(By.cssSelector("a.js-close-list"));
        closeExtraMenu.click();
        waitUntilElementIsInvisible(By.cssSelector("a.js-close-list"),5);
        //Print the quantity of lists
        int quantityListsAtTheEnd = driver
                .findElements(By.xpath("//div[@class = 'list js-list-content']")).size();
        System.out.println("Lists quantity at the end: " + driver
                .findElements(By.xpath("//div[@class = 'list js-list-content']"))
                .size());
        Assert.assertEquals(quantityListsAtTheEnd,quantityListsInTheBeginning-1,
                "The quantityListsAtTheEnd is not quantityListsInTheBeginning-1");

    }




}
