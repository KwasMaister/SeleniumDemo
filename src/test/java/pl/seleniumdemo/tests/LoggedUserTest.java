package pl.seleniumdemo.tests;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import pl.seleniumdemo.pages.HomePage;
import pl.seleniumdemo.pages.LoggedUserPage;

import java.util.List;

public class LoggedUserTest extends BaseTest {

    /*
    Baza czysci sie co 24h, dlatego przy kazdym tescie tworze/rejestruje nowe konto
    Aby test dzialal kazdego dnia bez koniecznosci recznego rejestrowania i ustawiania statycznych danych
     */

    private LoggedUserPage registerAndLogIn() {
        int randomNumber = (int) (Math.random() * 1000);
        String email = "testEmail" + randomNumber + "@com.pl";

        LoggedUserPage register = new HomePage(driver).openMyAccountPage()
                .registerUserValidDate(email, "3123123!@#!@HaszTaQ32")
                .logoutButton()
                .loginUserValidDate(email, "3123123!@#!@HaszTaQ32");

        return new LoggedUserPage(driver);
    }

    @Test
    public void loginUserTest() {

        int randomNumber = (int) (Math.random() * 1000);
        String email = "testEmail" + randomNumber + "@com.pl";
        WebElement registerLogoutAndLogIn = new HomePage(driver).openMyAccountPage()
                .registerUserValidDate(email, "3123123!@#!@CAB")
                .logoutButton()
                .loginUserValidDate(email, "3123123!@#!@CAB")
                .getWelcomeText();

        String welcomeText = registerLogoutAndLogIn.getText();
        Assert.assertTrue(welcomeText.contains("testEmail" + randomNumber));
    }

    @Test
    public void accountDetailsSaveChangesWitoutFirstNameAndLastName() {

        List<String> errors = registerAndLogIn()
                .accountDetails()
                .saveChanges()
                .getAccountDetailsErrorsButton();

        String firstError = errors.get(0);
        String secondError = errors.get(1);

        Assert.assertEquals("First name is a required field.", firstError);
        Assert.assertEquals("Last name is a required field.", secondError);
    }

    @Test
    public void accountDetailsSaveFirstNameAndLastName() {

        String info = registerAndLogIn()
                .accountDetails()
                .firstName("Jacob")
                .lastName("Kowalczyk")
                .saveChanges()
                .getSuccessfullInfo()
                .getText();

        Assert.assertEquals("Account details changed successfully.", info);
    }

    @Test
    public void accountDetailsChangeDisplayName() {

        String welcomeText = registerAndLogIn()
                .accountDetails()
                .firstName("Jan")
                .lastName("Kowalski")
                .displayName("Display name test")
                .saveChanges()
                .getWelcomeText()
                .getText();

        Assert.assertTrue(welcomeText.contains("Hello Display name test"));
    }
}
