package pl.seleniumdemo.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

public class ProductListPage {

    private WebDriver driver;

    public ProductListPage(WebDriver driver) {
        PageFactory.initElements(new AjaxElementLocatorFactory(driver, 5), this);
        this.driver = driver;
    }

    @FindBy(className = "icn-shoppingcart")
    private WebElement shoppingCartUsingIcon;

    @FindBy(xpath = "//a[@class='button wc-forward']")
    private WebElement viewCartUsingIcon;

    public ProductPage openProduct(String title) {
        driver.findElement(By.xpath("//h2[text()='" + title + "']")).click();
        return new ProductPage(driver);
    }

    public ProductListPage addToCart(String title) throws InterruptedException {
        driver.findElement(By.xpath("//a[@aria-label='Add “" + title + "” to your cart']")).click();
        Thread.sleep(1000);
        return this;
    }

    public CartPage openCartPage() {
        Actions actions = new Actions(driver);
        actions.moveToElement(shoppingCartUsingIcon).perform();

        viewCartUsingIcon.click();
        return new CartPage(driver);
    }

}
