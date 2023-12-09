package pl.seleniumdemo.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoggedUserPage {

    private WebDriver driver;

    public LoggedUserPage (WebDriver driver){
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    @FindBy (className = "woocommerce-MyAccount-content")
    private WebElement welcomeText;

    public WebElement getWelcomeText() {
        return welcomeText;
    }

}
