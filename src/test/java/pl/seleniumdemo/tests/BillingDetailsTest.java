package pl.seleniumdemo.tests;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pl.seleniumdemo.pages.BillingDetailsPage;
import pl.seleniumdemo.pages.HomePage;

import java.util.List;

public class BillingDetailsTest extends BaseTest {

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
    public void emptyAllField() {
        List<String> errors = checkout()
                .clickPlaceOrderButtonAndStayOnThisPage()
                .getErrors();

        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(errors.get(0), "Billing First name is a required field.");
        softAssert.assertEquals(errors.get(1), "Billing Last name is a required field.");
        softAssert.assertEquals(errors.get(2), "Billing Street address is a required field.");
        softAssert.assertEquals(errors.get(3), "Billing Town / City is a required field.");
        softAssert.assertEquals(errors.get(4), "Billing Phone is a required field.");
        softAssert.assertEquals(errors.get(5), "Billing Email address is a required field.");
        softAssert.assertEquals(errors.get(6), "Billing Postcode / ZIP is not a valid postcode / ZIP.");
        softAssert.assertAll();
    }

    @Test
    public void couponTest() {
        WebElement couponErrorAlert = checkout()
                .enterYourCoupon()
                .sendCoupon("testing coupon")
                .applyCoupon()
                .getCouponError();

        Assert.assertEquals("Coupon \"testing coupon\" does not exist!", couponErrorAlert.getText());
    }
}
