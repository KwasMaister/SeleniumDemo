package pl.seleniumdemo.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import pl.seleniumdemo.utils.SeleniumHelper;

public class SearchPage {

    private WebDriver driver;
    public SearchPage(WebDriver driver) {
        PageFactory.initElements(new AjaxElementLocatorFactory(driver, 5), this);
        this.driver = driver;
    }

    @FindBy (xpath = "//div[@class='entry-content']/p")
    private WebElement nothingFoundInfo;

    @FindBy (id = "s-658c750fde498")
    private WebElement searchInput;

    @FindBy (className = "archive-title")
    private WebElement headingTitle;

    @FindBy (xpath = "//a[@class='czr-title' and text()='Java Selenium WebDriver']")
    private WebElement productJavaSeleniumWebDriver;

    public SearchPage searchProduct (String productName){

        String locator = "s-658fca48bf1b8";
        SeleniumHelper.waitForElementToBeClickable(driver, By.id(locator));
        driver.findElement(By.id(locator)).sendKeys(productName);
        driver.findElement(By.id(locator)).sendKeys(Keys.ENTER);
        return this;
    }

    public WebElement infoAboutNothingFound () {
        return nothingFoundInfo;
    }

    public WebElement getHeadingTitle () {
        return headingTitle;
    }

    public WebElement getProductJavaSeleniumWebDriver () {
        return productJavaSeleniumWebDriver;
    }
}
