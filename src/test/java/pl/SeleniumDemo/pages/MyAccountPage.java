package pl.SeleniumDemo.pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import pl.SeleniumDemo.utils.SeleniumHelper;

public class MyAccountPage {

    private WebDriver driver;

    public MyAccountPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    @FindBy(id = "reg_email")
    WebElement emailAddressRegInput;

    @FindBy(id = "reg_password")
    WebElement passwordRegInput;

    @FindBy(id = "username")
    WebElement usernameLogInput;

    @FindBy(id = "password")
    WebElement passwordLogInput;

    @FindBy(name = "login")
    WebElement logInButton;

    @FindBy(xpath = "//a[text()='Lost your password?']")
    WebElement lostYourPasswordButton;

    @FindBy(xpath = "//button[@type='submit' and text()='Register']")
    WebElement registerButton;

    @FindBy(xpath = "//ul[@class='woocommerce-error']//li")
    WebElement error;

    @FindBy(css = "[class='woocommerce-password-strength short']")
    WebElement infoVeryWeakPassword;

    @FindBy(css = "[class='woocommerce-password-strength bad']")
    WebElement infoWeakPassword;

    @FindBy(css = "[class='woocommerce-password-strength good']")
    WebElement infoMediumPassword;

    @FindBy(css = "[class='woocommerce-password-strength strong']")
    WebElement infoStrongPassword;

    // wykrozystanie JavaScriptExecutor'a --> standardowa metoda .click() nie zawsze dziala
    private void registerButtonJavaScript() {
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript("arguments[0].click();", registerButton);
    }

    private void registerUser(String email, String password) {
        emailAddressRegInput.sendKeys(email);
        passwordRegInput.sendKeys(password);
        registerButtonJavaScript();
    }

    public LoggedUserPage registerUserValidDate(String email, String password) {
        registerUser(email, password);
        return new LoggedUserPage(driver);
    }

    public MyAccountPage registerUserInvalidDate(String email, String password) {
        registerUser(email, password);
        registerButtonJavaScript();
        return this;
    }

    public MyAccountPage registerUserWithoutClick(String email, String password) {
        emailAddressRegInput.sendKeys(email);
        passwordRegInput.sendKeys(password);
        return this;
    }

    public WebElement getError() {
        SeleniumHelper.waitForWebElementToExist(driver, error);
        return error;
    }

    public MyAccountPage EmailAddressInput(String email) {
        emailAddressRegInput.sendKeys(email);
        return this;
    }

    public MyAccountPage getPasswordInput(String password) {
        passwordRegInput.sendKeys(password);
        return this;
    }

    public MyAccountPage registerButton() {
        registerButtonJavaScript();
        return this;
    }

    public WebElement getInfoAboutVeryWeakPassword() {
        SeleniumHelper.waitForWebElementToExist(driver, infoVeryWeakPassword);
        return infoVeryWeakPassword;
    }

    public WebElement getInfoAboutWeakPassword() {
        SeleniumHelper.waitForWebElementToExist(driver, infoWeakPassword);
        return infoWeakPassword;
    }

    public WebElement getInfoAboutMediumPassword() {
        SeleniumHelper.waitForWebElementToExist(driver, infoMediumPassword);
        return infoMediumPassword;
    }

    public WebElement getInfoAboutStrongPassword() {
        SeleniumHelper.waitForWebElementToExist(driver, infoStrongPassword);
        return infoStrongPassword;
    }

    private void loginUser(String userName, String password) {
        usernameLogInput.sendKeys(userName);
        passwordLogInput.sendKeys(password);
        logInButton.click();
    }

    public LoggedUserPage loginUserValidDate(String userName, String password) {
        loginUser(userName, password);
        return new LoggedUserPage(driver);
    }

    public MyAccountPage loginUserInvalidDate(String userName, String password) {
        loginUser(userName, password);
        return this;
    }
}
