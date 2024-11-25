package pl.SeleniumDemo.tests;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import pl.SeleniumDemo.pages.HomePage;

public class LoginTest extends BaseTest {

    @Test
    public void loginUserValidDateTest() {

        int randomNumbers = (int) (Math.random() * 1000);
        String randomEmail = "exampleEmail" + randomNumbers + "@email.com.pl";

        HomePage homePage = new HomePage(driver);
        WebElement dashboard = homePage.myAccount()
                .registerUserValidDate(randomEmail, "exampleEmail@email.com.pl")
                .logoutButton()
                .loginUserValidDate(randomEmail, "exampleEmail@email.com.pl")
                .dashboard();

        Assert.assertTrue(dashboard.isDisplayed());
        Assert.assertEquals(dashboard.getText(), "Dashboard");
    }

    @Test
    public void loginUserInvalidDateTest() {

        int randomNumbers = (int) (Math.random() * 1000);
        String randomEmail = "exampleEmail" + randomNumbers + "@email.com.pl";

        HomePage homePage = new HomePage(driver);
        WebElement errorLog = homePage.myAccount()
                .registerUserValidDate(randomEmail, "exampleEmail@email.com.pl")
                .logoutButton()
                .loginUserInvalidDate(randomEmail, "badPassword12!#")
                .getError();

        Assert.assertTrue(errorLog.getText().contains(": Incorrect username or password."));
    }

}
