package pl.seleniumdemo.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

public class ProductPage {

    private WebDriver driver;

    public ProductPage(WebDriver driver) {
        PageFactory.initElements(new AjaxElementLocatorFactory(driver, 5), this);
        this.driver = driver;
    }

    @FindBy(name = "add-to-cart")
    private WebElement addToCartButton;

    @FindBy(xpath = "//div[@class='woocommerce-message']")
    private WebElement alertAboutAddProductToCart;

    @FindBy(xpath = "//div[@class='woocommerce-message']//a[text()='View cart']")
    private WebElement viewCartButton;

    @FindBy(className = "icn-shoppingcart")
    private WebElement shoppingCart;

    @FindBy(xpath = "//a[@class='remove remove_from_cart_button']")
    private WebElement deleteProduct;

    @FindBy(className = "woocommerce-mini-cart__empty-message")
    private WebElement infoAfterDeleteProduct;

    public ProductPage addProductToCart() {
        addToCartButton.click();
        return this;
    }

    public WebElement infoProductAddToCart() {
        return alertAboutAddProductToCart;
    }

    public CartPage viewCart() {
        viewCartButton.click();
        return new CartPage(driver);
    }

    public ProductPage shoppingCartIcon() {
        Actions actions = new Actions(driver);
        actions.moveToElement(shoppingCart).perform();
        return this;
    }

    public ProductPage deleteProductFromCartByUsingIcon() {
        deleteProduct.click();
        return this;
    }

    public WebElement getInfoAfterDeleteProductByUsingIcon() {
        return infoAfterDeleteProduct;
    }
}
