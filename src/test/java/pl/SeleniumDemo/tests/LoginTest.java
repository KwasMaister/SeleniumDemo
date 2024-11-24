package pl.SeleniumDemo.tests;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import pl.SeleniumDemo.pages.HomePage;
import pl.SeleniumDemo.pages.MyAccountPage;

public class LoginTest extends BaseTest {

    int randomNumbers = (int) (Math.random() * 1000);
    String randomEmail = "exampleEmail" + randomNumbers + "@email.com.pl";

    private MyAccountPage registerAndLogOutUser() {

        HomePage homePage = new HomePage(driver);
        homePage.myAccount()
                .registerUserValidDate(randomEmail, "exampleEmail@email.com.pl")
                .logoutButton();
        return new MyAccountPage(driver);
    }

    @Test
    public void loginUserValidDateTest() {
        WebElement dashboard = registerAndLogOutUser()
                .loginUserValidDate(randomEmail, "exampleEmail@email.com.pl")
                .dashboard();

        Assert.assertTrue(dashboard.isDisplayed());
        Assert.assertEquals(dashboard.getText(), "Dashboard");
    }

    @Test
    public void loginUserInvalidDateTest() {
        WebElement error = registerAndLogOutUser()
                .loginUserInvalidDate(randomEmail + ".pl", "badPassword12!#")
                .getError();

        Assert.assertTrue(error.getText().contains(": Incorrect username or password."));
    }

}
