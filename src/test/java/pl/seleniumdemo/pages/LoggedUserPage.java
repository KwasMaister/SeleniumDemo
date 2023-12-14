package pl.seleniumdemo.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

import java.util.List;
import java.util.stream.Collectors;

public class LoggedUserPage {

    private WebDriver driver;

    public LoggedUserPage(WebDriver driver) {
        PageFactory.initElements(new AjaxElementLocatorFactory(driver, 5), this);
        this.driver = driver;
    }

    @FindBy(className = "woocommerce-MyAccount-content")
    private WebElement welcomeText;

    @FindBy(linkText = "Logout")
    private WebElement logoutButton;

    @FindBy(linkText = "Account details")
    private WebElement accountDetailsButton;

    @FindBy(name = "save_account_details")
    private WebElement accountDetailsSaveChangesButton;

    @FindBy(xpath = "//ul[@class='woocommerce-error']//li")
    private List<WebElement> accountDetailsErrorsButton;

    @FindBy(id = "account_first_name")
    private WebElement firstNameInput;

    @FindBy(id = "account_last_name")
    private WebElement lastNameInput;

    @FindBy(className = "woocommerce-message")
    private WebElement accountDetailsChangedSuccessfullyInfo;

    @FindBy(id = "account_display_name")
    private WebElement displayNameInput;

    public WebElement getWelcomeText() {
        return welcomeText;
    }

    public MyAccountPage logoutButton() {
        logoutButton.click();
        return new MyAccountPage(driver);
    }

    public LoggedUserPage accountDetails() {
        accountDetailsButton.click();
        return this;
    }

    public LoggedUserPage saveChanges() {
        accountDetailsSaveChangesButton.click();
        return this;
    }

    public List<String> getAccountDetailsErrorsButton() {
        return accountDetailsErrorsButton.stream()
                .map(WebElement::getText)
                .collect(Collectors.toList());
    }

    public LoggedUserPage firstName(String firstName) {
        firstNameInput.sendKeys(firstName);
        return this;
    }

    public LoggedUserPage lastName(String lastName) {
        lastNameInput.sendKeys(lastName);
        return this;
    }

    public WebElement getSuccessfullInfo() {
        return accountDetailsChangedSuccessfullyInfo;
    }

    public LoggedUserPage displayName(String displayName) {
        displayNameInput.clear();
        displayNameInput.sendKeys(displayName);
        return this;
    }
}
