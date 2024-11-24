package pl.SeleniumDemo.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import pl.SeleniumDemo.utils.SeleniumHelper;

public class LoggedUserPage {

    private WebDriver driver;

    public LoggedUserPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    @FindBy(xpath = "//div[@class='woocommerce-MyAccount-content']/p[contains(text(),'Hello')]")
    WebElement welcomeText;

    @FindBy(xpath = "//nav[@class='woocommerce-MyAccount-navigation']//a[text()='Logout']")
    WebElement logoutButton;

    @FindBy(linkText = "Dashboard")
    WebElement dashboardLink;

    public WebElement getWelcomeText() {
        SeleniumHelper.waitForWebElementToExist(driver, welcomeText);
        return welcomeText;
    }

    public MyAccountPage logoutButton() {
        SeleniumHelper.waitForWebElementToExist(driver, logoutButton);
        logoutButton.click();
        return new MyAccountPage(driver);
    }

    public WebElement dashboard() {
        SeleniumHelper.waitForWebElementToExist(driver, dashboardLink);
        return dashboardLink;
    }
}
