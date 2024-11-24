package pl.SeleniumDemo.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;
import java.util.stream.Collectors;

public class CartPage {

    WebDriver driver;

    public CartPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    @FindBy(className = "entry-header")
    WebElement headerCart;

    @FindBy(xpath = "//td[@class='product-name']")
    List<WebElement> productsList;

    @FindBy(xpath = "//div[@class='wc-proceed-to-checkout']/a")
    WebElement proccedToCheckoutButton;

    public WebElement getHeaderCart() {
        return headerCart;
    }

    public WebElement checkout() {
        return checkout();
    }

    public List<String> getProductsName() {
        return productsList.stream()
                .map(el -> el.getText())
                .collect(Collectors.toList());
    }

    public OrdersPage proccedToCheckout() {
        proccedToCheckoutButton.click();
        return new OrdersPage(driver);
    }


}
