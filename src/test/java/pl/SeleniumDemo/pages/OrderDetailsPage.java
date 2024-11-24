package pl.SeleniumDemo.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import pl.SeleniumDemo.utils.SeleniumHelper;

import java.util.List;
import java.util.stream.Collectors;

public class OrderDetailsPage {

    private WebDriver driver;

    public OrderDetailsPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    @FindBy(css = "[class='woocommerce-notice woocommerce-notice--success woocommerce-thankyou-order-received']")
    WebElement headerOrders;

    @FindBy(xpath = "//td[@class='woocommerce-table__product-name product-name']/a")
    List<WebElement> productsList;

    public WebElement getHeader() {
        SeleniumHelper.waitForWebElementToExist(driver, headerOrders);
        return headerOrders;
    }

    public List<String> getProductsName() {
        List<String> productsName = productsList.stream()
                .map(el -> el.getText())
                .collect(Collectors.toList());
        return productsName;
    }


}
