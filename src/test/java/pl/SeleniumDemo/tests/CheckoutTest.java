package pl.SeleniumDemo.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pl.SeleniumDemo.models.Customer;
import pl.SeleniumDemo.pages.HomePage;
import pl.SeleniumDemo.pages.OrderDetailsPage;

public class CheckoutTest extends BaseTest {

    @Test
    public void checkOutTest() {

        Customer customer = new Customer();

        HomePage homePage = new HomePage(driver);
        OrderDetailsPage orderDetails = homePage.openShopPage()
                .openProduct("Java Selenium WebDriver")
                .addProductToCart()
                .viewCart()
                .proccedToCheckout()
                .fillUserData(customer);

        Assert.assertEquals(orderDetails.getHeader().getText(), "Thank you. Your order has been received.");
        Assert.assertEquals(orderDetails.getProductsName().get(0), "Java Selenium WebDriver");
    }
}
