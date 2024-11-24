package pl.SeleniumDemo.pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import pl.SeleniumDemo.models.Customer;
import pl.SeleniumDemo.utils.SeleniumHelper;

public class OrdersPage {

    private WebDriver driver;

    public OrdersPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    @FindBy(id = "billing_first_name")
    WebElement firstNameInput;

    @FindBy(id = "billing_last_name")
    WebElement lastNameInput;

    @FindBy(id = "billing_company")
    WebElement companyNameInput;

    @FindBy(id = "billing_country")
    WebElement countrySelect;

    @FindBy(id = "billing_address_1")
    WebElement streetAddressHouseNumberInput;

    @FindBy(id = "billing_address_2")
    WebElement streetAddressApartmentInput;

    @FindBy(id = "billing_postcode")
    WebElement postcodeInput;

    @FindBy(id = "billing_city")
    WebElement cityInput;

    @FindBy(id = "billing_phone")
    WebElement phoneInput;

    @FindBy(id = "billing_email")
    WebElement emailAddressInput;

    @FindBy(id = "order_comments")
    WebElement orderNotesInput;

    @FindBy(id = "place_order")
    WebElement placeOrderButton;

    public OrderDetailsPage fillUserData(Customer customer) {
        firstNameInput.sendKeys(customer.getFirstName());
        lastNameInput.sendKeys(customer.getLastName());
        companyNameInput.sendKeys(customer.getCompanyName());
        streetAddressHouseNumberInput.sendKeys(String.format("%s %s", customer.getStreet(), customer.getFlatNumber()));
        postcodeInput.sendKeys(customer.getPostcode());
        cityInput.sendKeys(customer.getCity());
        phoneInput.sendKeys(customer.getPhoneNumber());
        emailAddressInput.sendKeys(customer.getEmailAddres());
        orderNotesInput.sendKeys("Random Comments");

        Select select = new Select(countrySelect);
        select.selectByVisibleText(customer.getCountry());

        JavascriptExecutor javascriptExecutor = (JavascriptExecutor) driver;
        javascriptExecutor.executeScript("arguments[0].click();", placeOrderButton);

        return new OrderDetailsPage(driver);
    }

}
