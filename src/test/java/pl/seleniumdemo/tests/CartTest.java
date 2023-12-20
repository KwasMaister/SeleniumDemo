package pl.seleniumdemo.tests;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import pl.seleniumdemo.pages.HomePage;
import pl.seleniumdemo.pages.ProductPage;

import java.util.List;

public class CartTest extends BaseTest {

    @Test
    public void addProductToCart() {

        String title = "Java Selenium WebDriver";

        WebElement addProductToCart = new HomePage(driver)
                .openShop()
                .openProduct(title)
                .addProductToCart()
                .infoProductAddToCart()

        String alert = addProductToCart.getText();
        Assert.assertTrue(alert.contains(title));

        List<String> nameProducts = new ProductPage(driver)
                .viewCart()
                .getProductsName();

        String onlyOneProduct = nameProducts.get(0);
        Assert.assertEquals(title, onlyOneProduct);
    }
}
