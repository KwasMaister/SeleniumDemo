package pl.seleniumdemo.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pl.seleniumdemo.models.Customer;
import pl.seleniumdemo.pages.BillingDetailsPage;
import pl.seleniumdemo.pages.HomePage;
import pl.seleniumdemo.pages.OrderDetailsPage;

public class CheckoutTest extends BaseTest {

    private BillingDetailsPage checkout() {
        BillingDetailsPage billingDetailsPage = new HomePage(driver)
                .openShop()
                .openProduct("Java Selenium WebDriver")
                .addProductToCart()
                .viewCart()
                .checkout();
        return new BillingDetailsPage(driver);
    }

    @Test
    public void checkoutTest() {

        Customer customer = new Customer();

        OrderDetailsPage orderDetailsPage = checkout()
                .fillAddressDetails(customer, "Randomowy komentarz");

        Assert.assertEquals(orderDetailsPage.getInfoAboutOrderReceived().getText(), "Thank you. Your order has been received.");
        Assert.assertEquals(orderDetailsPage.getInfoAboutProductName().getText(), "Java Selenium WebDriver × 1");
    }

}
