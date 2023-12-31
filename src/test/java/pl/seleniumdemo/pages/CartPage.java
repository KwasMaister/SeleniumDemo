package pl.seleniumdemo.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

import java.util.List;
import java.util.stream.Collectors;

public class CartPage {

    private WebDriver driver;

    public CartPage(WebDriver driver) {
        PageFactory.initElements(new AjaxElementLocatorFactory(driver, 5), this);
        this.driver = driver;
    }

    @FindBy(xpath = "//td[@class='product-name']")
    private List<WebElement> productsName;

    @FindBy(xpath = "//a[@class='checkout-button button alt wc-forward']")
    private WebElement proceedToCheckoutButton;

    @FindBy(className = "remove")
    private WebElement deleteProductFromCartButton;

    @FindBy(className = "cart-empty")
    private WebElement infoAboutEmptyCart;

    @FindBy(xpath = "//tr[@class='order-total']//span[@class='woocommerce-Price-amount amount']")
    private WebElement infoAboutTotalPrice;


    public List<String> getProductsName() {
        return productsName.stream()
                .map(WebElement::getText)
                .collect(Collectors.toList());
    }

    public BillingDetailsPage checkout() {
        proceedToCheckoutButton.click();
        return new BillingDetailsPage(driver);
    }

    public CartPage deleteProductFromCart() {
        deleteProductFromCartButton.click();
        return this;
    }

    public WebElement getInfoAboutTotalPrice() {
        return infoAboutTotalPrice;
    }

    public WebElement infoAboutEmptyCartAfterDeleteProduct() {
        return infoAboutEmptyCart;
    }

}
