package pl.SeleniumDemo.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class OpenShopPage {

    private WebDriver driver;

    @FindBy(css = "[class='added_to_cart wc-forward']")
    List<WebElement> viewCartButton;

    public OpenShopPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    public ProductPage openProduct(String title) {
        driver.findElement(By.xpath("//h2[text()='" + title + "']")).click();
        return new ProductPage(driver);
    }

    public OpenShopPage addToCart(String title) throws InterruptedException {
        driver.findElement(By.xpath("//a[@aria-label='Add “" + title + "” to your cart']")).click();
        Thread.sleep(1000);
        return this;
    }

    public CartPage viewCart() {
        viewCartButton.get(0).click();
        return new CartPage(driver);
    }

}
