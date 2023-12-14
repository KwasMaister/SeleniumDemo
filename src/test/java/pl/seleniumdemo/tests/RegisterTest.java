package pl.seleniumdemo.tests;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import pl.seleniumdemo.pages.HomePage;
import pl.seleniumdemo.utils.SeleniumHelper;
import pl.seleniumdemo.utils.TestListener;

import java.io.IOException;

@Listeners(value = {TestListener.class})
public class RegisterTest extends BaseTest {

    @Test
    public void registerValidUserTest() {

        int randomNumber = (int) (Math.random() * 10000);

        String getWelcomeText = new HomePage(driver).openMyAccountPage()
                .registerUserValidDate("nazwa" + randomNumber + "@nazwa.pl", "123DudixPatrzy123!#")
                .getWelcomeText()
                .getText();

        Assert.assertTrue(getWelcomeText.contains("Hello nazwa" + randomNumber));

    }

    @Test
    public void registerUserWithTheSameEmailAddresTest() {
        WebElement getError = new HomePage(driver).openMyAccountPage()
                .registerUserInvalidDate("test123@com.pl", "test123@com.pl")
                .getError();

        Assert.assertEquals("Error: An account is already registered with your email address. Please log in.", getError.getText());

    }

    @Test
    public void registerUserWithInvalidEmailAddress() {
        WebElement getError = new HomePage(driver).openMyAccountPage()
                .registerUserInvalidDate("test123@test", "test123@com.pl")
                .getError();

        Assert.assertEquals("Error: Please provide a valid email address.", getError.getText());
    }

    @Test
    public void registerUserWithVeryWeakPassword() {

        int randomNumber = (int) (Math.random() * 1000);

        String passwordError = new HomePage(driver).openMyAccountPage()
                .checkingPassword("emailtest" + randomNumber + "@com.pl", "123456789")
                .getPasswordErrorVeryWeak()
                .getText();

        Assert.assertEquals(passwordError, "Very weak - Please enter a stronger password.");

    }

    @Test
    public void registerUserWithWeakPassword() {
        int randomNumber = (int) (Math.random() * 1000);

        String passwordError = new HomePage(driver).openMyAccountPage()
                .checkingPassword("emailtest" + randomNumber + "@com.pl", "123!@#")
                .getPasswordErrorWeak()
                .getText();

        Assert.assertEquals(passwordError, "Weak - Please enter a stronger password.");
    }

    @Test
    public void registerUserWithMediumPassword() {
        int randomNumber = (int) (Math.random() * 1000);

        String passwordError = new HomePage(driver).openMyAccountPage()
                .checkingPassword("emailtest" + randomNumber + "@com.pl", "123!@#123")
                .getPasswordMedium()
                .getText();

        Assert.assertEquals(passwordError, "Medium");
    }

    @Test
    public void registerUserWithStrongPassword() {
        int randomNumber = (int) (Math.random() * 1000);

        String passwordError = new HomePage(driver).openMyAccountPage()
                .checkingPassword("emailtest" + randomNumber + "@com.pl", "123!@#ABCabc")
                .getPasswordStrong()
                .getText();

        Assert.assertEquals(passwordError, "Strong");
    }

    @Test
    public void checkingHintAboutPassword() throws IOException {

        ExtentTest test = extentReports.createTest("Checking Hit About Password");
        int randomNumber = (int) (Math.random() * 1000);

        test.log(Status.PASS, "Setting bad Password");
        String hintAboutPassword = new HomePage(driver).openMyAccountPage()
                .checkingPassword("emailtest" + randomNumber + "@com.pl", "123456789")
                .getHintAboutPassword()
                .getText();

        Assert.assertTrue(hintAboutPassword.contains("Hint: The password should be at least twelve characters long."));
    }
}
