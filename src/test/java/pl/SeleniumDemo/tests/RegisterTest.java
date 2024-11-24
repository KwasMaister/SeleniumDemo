package pl.SeleniumDemo.tests;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import pl.SeleniumDemo.pages.HomePage;

public class RegisterTest extends BaseTest {

    private String initialRandomEmail() {
        int randomNumber = (int) (Math.random() * 10000);
        String randomEmail = "emailTest" + randomNumber + "@email.com.pl";
        return randomEmail;
    }

    @Test
    public void registerValidUserTest() {

        HomePage homePage = new HomePage(driver);
        WebElement headerText = homePage.myAccount()
                .registerUserValidDate(initialRandomEmail(), "randomPassword123!#")
                .getWelcomeText();

        Assert.assertTrue(headerText.getText().contains("Hello " + "emailTest"));
    }

    @Test
    public void registerUserWithTheSameEmail() {

        String randomEmail = initialRandomEmail();

        HomePage homePage = new HomePage(driver);
        WebElement errorText = homePage.myAccount()
                .registerUserValidDate(randomEmail, "randomPassword123!#")
                .logoutButton()
                .registerUserInvalidDate(randomEmail, "anotherrandomPassword123!#")
                .getError();

        Assert.assertEquals(errorText.getText(), "Error: An account is already registered with your email address. Please log in.");
    }

    @Test
    public void registerUserEmptyFields() {
        HomePage homePage = new HomePage(driver);
        WebElement errorText = homePage.myAccount()
                .registerButton()
                .getError();

        Assert.assertEquals(errorText.getText(), "Error: Please provide a valid email address.");
    }

    @Test
    public void registerUserOnlyEmail() {
        HomePage homePage = new HomePage(driver);
        WebElement errorText = homePage.myAccount()
                .EmailAddressInput("exampleEmail@email.com.pl")
                .registerButton()
                .getError();

        Assert.assertEquals(errorText.getText(), "Error: Please enter an account password.");
    }

    @Test
    public void registerUserOnlyPassword() {
        HomePage homePage = new HomePage(driver);
        WebElement errorText = homePage.myAccount()
                .getPasswordInput("examplePassword123!#")
                .registerButton()
                .getError();

        Assert.assertEquals(errorText.getText(), "Error: Please provide a valid email address.");
    }

    @Test
    public void veryWeakPassword() {
        HomePage homePage = new HomePage(driver);
        WebElement infoAboutVeryWeakPassword = homePage.myAccount()
                .registerUserInvalidDate(initialRandomEmail(), "123")
                .getInfoAboutVeryWeakPassword();

        Assert.assertEquals(infoAboutVeryWeakPassword.getText(), "Very weak - Please enter a stronger password.");
    }

    @Test
    public void weakPassword() {
        HomePage homePage = new HomePage(driver);
        WebElement infoAboutWeakPassword = homePage.myAccount()
                .registerUserInvalidDate(initialRandomEmail(), "123AB")
                .getInfoAboutWeakPassword();

        Assert.assertEquals(infoAboutWeakPassword.getText(), "Weak - Please enter a stronger password.");
    }

    @Test
    public void mediumPassword() {
        HomePage homePage = new HomePage(driver);
        WebElement infoAboutMediumPassword = homePage.myAccount()
                .registerUserWithoutClick(initialRandomEmail(), "123AB123!@#")
                .getInfoAboutMediumPassword();

        Assert.assertEquals(infoAboutMediumPassword.getText(), "Medium");
    }

    @Test
    public void strongPassword() {
        HomePage homePage = new HomePage(driver);
        WebElement infoAboutStrongPassword = homePage.myAccount()
                .registerUserWithoutClick(initialRandomEmail(), "123AB123!@#123")
                .getInfoAboutStrongPassword();

        Assert.assertEquals(infoAboutStrongPassword.getText(), "Strong");
    }
}
