package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPageHelper extends PageBase{
    @FindBy(id = "password")
    WebElement passwordField;

    @FindBy(id = "login")
    WebElement loginButton;

    @FindBy(id = "user")
    WebElement loginField;

    @FindBy(id = "error")
    WebElement errorMessage;

    @FindBy(id = "login-error")
    WebElement errorMessageAttl;

    @FindBy(xpath = "//input[@value='Log in with Atlassian']")
    WebElement loginButtonAttl;

    @FindBy(id = "login-submit")
    WebElement loginSubmitButton;

    public LoginPageHelper(WebDriver driver){
        super(driver);
        this.driver = driver;
    }

    public void loginAsAttlassian(String login, String password) {
        enterLoginAsAttlassian(login);
        submitAsAttlassian();
        enterPasswordAsAttlassian(password);
    }

    public void waitUntilPageIsLoaded() {
        waitUntilElementIsClickable(passwordField,15);
        waitUntilElementIsClickable(loginButton,10);
        waitUntilElementIsClickable(loginField,15);
    }

    public String getErrorMessage(){
        waitUntilElementIsVisible(errorMessage, 15);
        return errorMessage.getText();
    }

    public String getAttlassianErrorMessage(){
        waitUntilElementIsVisible(errorMessageAttl, 15);
        return errorMessageAttl.getText();
    }

    public void pressLoginButton() {
        waitUntilElementIsClickable(loginButton,10);
        loginButton.click();
    }

    public void enterNotAttlassianPassword(String password) {
        //WebElement passwordField = driver.findElement(By.id("password"));
        passwordField.click();
        passwordField.clear();
        passwordField.sendKeys(password);
    }

    public void enterNotAttlassianLogin(String login) {
        //WebElement loginField = driver.findElement(By.id("user"));
        loginField.click();
        loginField.clear();
        loginField.sendKeys(login);
    }

    public void enterLoginAsAttlassian(String login) {
        //WebElement loginField = driver.findElement(By.id("user"));
        loginField.click();
        loginField.clear();
        loginField.sendKeys(login);
    }
    public void submitAsAttlassian() {
        waitUntilElementIsClickable(loginButtonAttl,10);
        //WebElement loginAttlButton = driver.findElement(By.xpath("//input[@value='Log in with Atlassian']"));
        loginButtonAttl.click();
        waitUntilElementIsClickable(passwordField,20);
    }
    public void enterPasswordAsAttlassian(String password) {
        //WebElement passwordAttlField = driver.findElement(By.id("password"));
        passwordField.click();
        passwordField.clear();
        passwordField.sendKeys(password);
        loginSubmitButton.click();
    }
    public void loginNotAttlassian(String login, String password) {
        enterNotAttlassianLogin(login);
        enterNotAttlassianPassword(password);
        pressLoginButton();
    }



}
