package pl.seleniumdemo.tests;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;
import pl.seleniumdemo.models.Customer;
import pl.seleniumdemo.pages.HomePage;
import pl.seleniumdemo.pages.BillingDetailsPage;

public class CheckoutTest extends BaseTest {

    private BillingDetailsPage checkout () {
        BillingDetailsPage billingDetailsPage = new HomePage(driver)
                .openShop()
                .openProduct("Java Selenium WebDriver")
                .addProductToCart()
                .viewCart()
                .checkout();
        return new BillingDetailsPage(driver);
    }

    @Test
    public void checkoutTest () {

        Customer customer = new Customer();

        String text = checkout()
                .fillAddressDetails(customer , "Randomowy komentarz")
                .getInfoAboutOrderReceived()
                .getText();

        Assert.assertEquals(text, "Thank you. Your order has been received.");
    }

}
