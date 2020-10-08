package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.BoardsPageHelper;
import pages.CurrentBoardPageHelper;
import pages.HomePageHelper;
import pages.LoginPageHelper;

public class CurrentBoardTests extends TestBase {
    LoginPageHelper loginPage;
    BoardsPageHelper boardsPage;
    CurrentBoardPageHelper qaHafa7currentBoard;
    HomePageHelper homePage;

    @BeforeMethod
    public void initTests()  {
        loginPage = new LoginPageHelper(driver);
        boardsPage = new BoardsPageHelper(driver);
        homePage = new HomePageHelper(driver);
        qaHafa7currentBoard = new CurrentBoardPageHelper(driver,"QA Haifa7");

        homePage.waitUntilPageIsLoaded();
        homePage.openLoginPage();
        loginPage.waitUntilPageIsLoaded();
        loginPage.loginAsAttlassian(LOGIN,PASSWORD);
        boardsPage.waitUntilPageIsLoaded();
        boardsPage.openCurrentBoardPage("QA Haifa7");
        qaHafa7currentBoard.waitUntilPageIsLoaded();
    }


    @Test
    public void isCorrectCurrentBoard(){
        Assert.assertEquals(qaHafa7currentBoard.getCurrentBoardHeader(),"QA Haifa7",
                "The header of the screen is not 'QA Haifa7'");
    }

    @Test
    public void isCorrectCurrentBoard2(){
        Assert.assertTrue(qaHafa7currentBoard.isCorrectCurrentBoard(),
                "The header of the screen is not 'QA Haifa7'");
    }


    @Test
    public void createListPositive()  {
        int listsBeforeAdding = qaHafa7currentBoard.getListsQuantity();
        qaHafa7currentBoard.createNewList();
        int listsAfterAdding = qaHafa7currentBoard.getListsQuantity();
        Assert.assertEquals(listsBeforeAdding +1, listsAfterAdding,
                "The quantity of lists is not equal to expected quantitty");

    }

    @Test
    public void putAnyListToArchive()  {
         if (qaHafa7currentBoard.getNameOfAddListButton().equals("Add a list"))
         {
             qaHafa7currentBoard.createNewList();
         }
         int quantityListsInTheBeginning = qaHafa7currentBoard.getListsQuantity();
         qaHafa7currentBoard.openExtraMenuForFirstList();
         qaHafa7currentBoard.putTheListToArchive();
         int quantityListsAtTheEnd = qaHafa7currentBoard.getListsQuantity();
         Assert.assertEquals(quantityListsAtTheEnd,quantityListsInTheBeginning-1,
                "The quantityListsAtTheEnd is not quantityListsInTheBeginning-1");
    }




}
