package pl.seleniumdemo.pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.ui.Select;
import pl.seleniumdemo.models.Customer;

public class BillingDetailsPage {

    WebDriver driver;

    public BillingDetailsPage(WebDriver driver) {
        PageFactory.initElements(new AjaxElementLocatorFactory(driver, 5), this);
        this.driver = driver;
    }

    @FindBy (id = "billing_first_name")
    private WebElement firstNameInput;

    @FindBy (id = "billing_last_name")
    private WebElement lastNameInput;

    @FindBy (id = "billing_company")
    private WebElement companyNameInput;

    @FindBy (id = "billing_country")
    private WebElement countrySelect;

    @FindBy (id = "billing_address_1")
    private WebElement streetAddressHouseNumberInput;

    @FindBy (id = "billing_address_2")
    private WebElement streetAddresApartmentInput;

    @FindBy (id = "billing_postcode")
    private WebElement postcodeZipInput;

    @FindBy (id = "billing_city")
    private WebElement cityInput;

    @FindBy (id = "billing_phone")
    private WebElement phoneInput;

    @FindBy (id = "billing_email")
    private WebElement emailAddressInput;

    @FindBy (id = "place_order")
    private WebElement placeOrderButton;

    @FindBy (id = "order_comments")
    private WebElement commentsInput;

    public OrderDetailsPage fillAddressDetails (Customer customer, String comments) {
        firstNameInput.sendKeys(customer.getFirstName());
        lastNameInput.sendKeys(customer.getLastName());
        companyNameInput.sendKeys(customer.getCompanyName());
        Select select = new Select(countrySelect);
        select.selectByVisibleText(customer.getCountry());
        streetAddressHouseNumberInput.sendKeys(String.format("%s %s", customer.getStreet(), customer.getFlatNumber()));
        postcodeZipInput.sendKeys(customer.getZipCode());
        cityInput.sendKeys(customer.getCity());
        phoneInput.sendKeys(customer.getPhone());
        emailAddressInput.sendKeys(customer.getEmail());
        commentsInput.sendKeys(comments);

        //placeOrderButton.click();
        JavascriptExecutor javascriptExecutor = (JavascriptExecutor) driver;
        javascriptExecutor.executeScript("arguments[0].click();", placeOrderButton);
        return new OrderDetailsPage(driver);
    }
}
