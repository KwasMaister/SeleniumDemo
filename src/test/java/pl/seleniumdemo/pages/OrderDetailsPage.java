package pl.seleniumdemo.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

public class OrderDetailsPage {

    private WebDriver driver;

    public OrderDetailsPage(WebDriver driver) {
        PageFactory.initElements(new AjaxElementLocatorFactory(driver, 5), this);
        this.driver = driver;
    }

    @FindBy(xpath = "//div[@class='woocommerce-order']//p")
    private WebElement infoAboutOrderReceived;

    @FindBy(xpath = "//td[contains(@class,'product-name')]")
    private WebElement infoAboutProductName;

    public WebElement getInfoAboutOrderReceived() {
        return infoAboutOrderReceived;
    }

    public WebElement getInfoAboutProductName() {
        return infoAboutProductName;
    }
}
