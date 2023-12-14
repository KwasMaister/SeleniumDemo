package pl.seleniumdemo.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {

    private WebDriver driver;

    public HomePage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    @FindBy(id = "menu-item-20")
    private WebElement cart;

    @FindBy(id = "menu-item-21")
    private WebElement shop;

    @FindBy(id = "menu-item-22")
    private WebElement myAccount;

    public MyAccountPage openMyAccountPage() {
        myAccount.click();
        return new MyAccountPage(driver);
    }
}
