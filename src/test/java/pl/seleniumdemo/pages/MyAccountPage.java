package pl.seleniumdemo.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

public class MyAccountPage {

    private WebDriver driver;

    public MyAccountPage(WebDriver driver) {
        PageFactory.initElements(new AjaxElementLocatorFactory(driver, 5), this);
        this.driver = driver;
    }

    @FindBy(id = "reg_email")
    private WebElement regEmailAddress;

    @FindBy(id = "reg_password")
    private WebElement regPassword;

    @FindBy(name = "register")
    private WebElement regButton;

    @FindBy(id = "username")
    private WebElement logUserNameOrEmailAddress;

    @FindBy(id = "password")
    private WebElement logPassword;

    @FindBy(name = "login")
    private WebElement logButton;

    @FindBy(xpath = "//ul[@class='woocommerce-error']//li")
    private WebElement error;

    @FindBy(xpath = "//div[@class='woocommerce-password-strength short']")
    private WebElement passwordErrorVeryWeak;

    @FindBy(xpath = "//div[@class='woocommerce-password-strength bad']")
    private WebElement passwordErrorWeak;

    @FindBy(xpath = "//div[@class='woocommerce-password-strength good']")
    private WebElement passwordMedium;

    @FindBy(xpath = "//div[@class='woocommerce-password-strength strong']")
    private WebElement passwordStrong;

    @FindBy(xpath = "//small[@class='woocommerce-password-hint']")
    private WebElement hintAboutPassword;

    public WebElement getError() {
        return error;
    }

    public LoggedUserPage registerUserValidDate(String email, String password) {
        registerUser(email, password);
        return new LoggedUserPage(driver);
    }

    public MyAccountPage registerUserInvalidDate(String email, String password) {
        registerUser(email, password);
        return this;
    }

    private void registerUser(String email, String password) {
        regEmailAddress.sendKeys(email);
        regPassword.sendKeys(password);
        regButton.click();
    }

    public MyAccountPage checkingPassword(String email, String passowrd) {
        regEmailAddress.sendKeys(email);
        regPassword.sendKeys(passowrd);
        return this;
    }

    public LoggedUserPage loginUserValidDate(String emailOrName, String password) {
        loginUser(emailOrName, password);
        return new LoggedUserPage(driver);
    }

    public MyAccountPage loginUserInvalidDate(String emailOrName, String password) {
        loginUser(emailOrName, password);
        return this;
    }

    private void loginUser(String emailOrName, String password) {
        logUserNameOrEmailAddress.sendKeys(emailOrName);
        logPassword.sendKeys(password);
        logButton.click();
    }

    public WebElement getPasswordErrorVeryWeak() {
        return passwordErrorVeryWeak;
    }

    public WebElement getPasswordErrorWeak() {
        return passwordErrorWeak;
    }

    public WebElement getPasswordMedium() {
        return passwordMedium;
    }

    public WebElement getPasswordStrong() {
        return passwordStrong;
    }

    public WebElement getHintAboutPassword() {
        return hintAboutPassword;
    }


}
