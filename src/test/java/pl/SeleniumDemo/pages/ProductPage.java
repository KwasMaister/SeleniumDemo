package pl.SeleniumDemo.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pl.SeleniumDemo.utils.SeleniumHelper;

import java.time.Duration;

public class ProductPage {

    private WebDriver driver;

    public ProductPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    @FindBy(name = "add-to-cart")
    WebElement addToCartButton;

    @FindBy(className = "woocommerce-message")
    WebElement infoAddedToCart;

    @FindBy(xpath = "//div[@class='woocommerce-message']//a[text()='View cart']")
    WebElement viewCartButton;


    public ProductPage addProductToCart() {
        addToCartButton.click();
        return this;
    }

    public WebElement addedToCart() {
        SeleniumHelper.waitForWebElementToExist(driver, infoAddedToCart);
        return infoAddedToCart;
    }

    public CartPage viewCart() {
        WebElement viewCartButton = driver.findElement(By.xpath("//div[@class='woocommerce-message']//a[text()='View cart']"));
        viewCartButton.click();
        return new CartPage(driver);
    }
}
