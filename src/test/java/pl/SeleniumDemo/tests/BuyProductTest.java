package pl.SeleniumDemo.tests;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import pl.SeleniumDemo.pages.HomePage;

import java.util.List;

public class BuyProductTest extends BaseTest {

    @Test
    public void buyProduct() {
        HomePage homePage = new HomePage(driver);
        WebElement javaSeleniumWebDriver = homePage.openShopPage()
                .openProduct("Java Selenium WebDriver")
                .addProductToCart()
                .addedToCart();

        Assert.assertTrue(javaSeleniumWebDriver.getText().contains("“Java Selenium WebDriver” has been added to your cart."));
    }

    @Test
    public void viewCartWithOneProduct() {
        HomePage homePage = new HomePage(driver);
        List<String> productsName = homePage.openShopPage()
                .openProduct("Java Selenium WebDriver")
                .addProductToCart()
                .viewCart()
                .getProductsName();

        Assert.assertEquals(productsName.get(0), "Java Selenium WebDriver");
    }

    @Test
    public void viewCartWithTwoProducts() throws InterruptedException {

        String firstProduct = "GIT basics";
        String secondProduct = "Java Selenium WebDriver";
        HomePage homePage = new HomePage(driver);

        List<String> productsName = homePage.openShopPage()
                .addToCart(firstProduct)
                .addToCart(secondProduct)
                .viewCart()
                .getProductsName();

        Assert.assertEquals(productsName.get(0), firstProduct);
        Assert.assertEquals(productsName.get(1), secondProduct);
    }

}
