package pl.seleniumdemo.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import pl.seleniumdemo.utils.SeleniumHelper;

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

    @FindBy(xpath = "//a[@class='search-toggle_btn icn-search czr-overlay-toggle_btn']")
    private WebElement searchButton;

    public MyAccountPage openMyAccountPage() {
        myAccount.click();
        return new MyAccountPage(driver);
    }

    public ProductListPage openShop() {
        shop.click();
        return new ProductListPage(driver);
    }

    public SearchPage usingSearch() {
        String searchLocator = "//a[@class='search-toggle_btn icn-search czr-overlay-toggle_btn']";
        SeleniumHelper.waitForElementToBeClickable(driver, By.xpath(searchLocator));
        driver.findElement(By.xpath(searchLocator)).click();
        return new SearchPage(driver);
    }
}
