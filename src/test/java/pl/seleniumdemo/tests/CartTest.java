package pl.seleniumdemo.tests;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import pl.seleniumdemo.pages.HomePage;
import pl.seleniumdemo.pages.ProductPage;

import java.util.List;

public class CartTest extends BaseTest {

    @Test
    public void addOneProductToCart() {

        String title = "Java Selenium WebDriver";

        WebElement addProductToCart = new HomePage(driver)
                .openShop()
                .openProduct(title)
                .addProductToCart()
                .infoProductAddToCart();

        String alert = addProductToCart.getText();
        Assert.assertTrue(alert.contains(title));

        List<String> nameProducts = new ProductPage(driver)
                .viewCart()
                .getProductsName();

        String onlyOneProduct = nameProducts.get(0);
        Assert.assertEquals(title, onlyOneProduct);
    }

    @Test
    public void addTwoDifferentProductToCart() throws InterruptedException {

        String firstTitle = "Java Selenium WebDriver";
        String secondTitle = "GIT basics";

        List<String> nameProducts = new HomePage(driver)
                .openShop()
                .addToCart(firstTitle)
                .addToCart(secondTitle)
                .openCartPage()
                .getProductsName();

        String firstNameOfProduct = nameProducts.get(0);
        String secondNameOfProduct = nameProducts.get(1);

        Assert.assertEquals("Java Selenium WebDriver", firstNameOfProduct);
        Assert.assertEquals("GIT basics", secondNameOfProduct);
    }

    @Test
    public void addTwoTheSameProductToCart() throws InterruptedException {
        String firstTitle = "Java Selenium WebDriver";

        List<String> nameProducts = new HomePage(driver)
                .openShop()
                .addToCart(firstTitle)
                .addToCart(firstTitle)
                .openCartPage()
                .getProductsName();

        String firstNameOfProduct = nameProducts.get(0);

        Assert.assertEquals("Java Selenium WebDriver", firstNameOfProduct);
    }

    @Test
    public void checkPriceWhenAddToProductToCart() throws InterruptedException {
        String firstTitle = "Java Selenium WebDriver";
        String secondTitle = "GIT basics";

        WebElement checkPrice = new HomePage(driver)
                .openShop()
                .addToCart(firstTitle)
                .addToCart(secondTitle)
                .openCartPage()
                .getInfoAboutTotalPrice();

        Assert.assertEquals("2,00 zł", checkPrice.getText());
    }

    @Test
    public void deleteProductFromCart() {

        String title = "Java Selenium WebDriver";

        WebElement deleteProduct = new HomePage(driver)
                .openShop()
                .openProduct(title)
                .addProductToCart()
                .viewCart()
                .deleteProductFromCart()
                .infoAboutEmptyCartAfterDeleteProduct();

        Assert.assertEquals("Your cart is currently empty.", deleteProduct.getText());
    }

    @Test
    public void deleteProductFromCartUsingIcon() {

        String title = "Java Selenium WebDriver";

        WebElement deleteProductFromIcon = new HomePage(driver)
                .openShop()
                .openProduct(title)
                .addProductToCart()
                .shoppingCartIcon()
                .deleteProductFromCartByUsingIcon()
                .shoppingCartIcon()
                .getInfoAfterDeleteProductByUsingIcon();

        Assert.assertEquals("No products in the cart.", deleteProductFromIcon.getText());
    }
}
