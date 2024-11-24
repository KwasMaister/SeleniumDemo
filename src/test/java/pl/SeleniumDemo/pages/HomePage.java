package pl.SeleniumDemo.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {

    WebDriver driver;

    public HomePage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    @FindBy(id = "menu-item-20")
    WebElement cartButton;

    @FindBy(id = "menu-item-21")
    WebElement shopButton;

    @FindBy(id = "menu-item-22")
    WebElement myAccountButton;

    public MyAccountPage myAccount() {
        myAccountButton.click();
        return new MyAccountPage(driver);
    }

    public OpenShopPage openShopPage() {
        shopButton.click();
        return new OpenShopPage(driver);
    }
}
