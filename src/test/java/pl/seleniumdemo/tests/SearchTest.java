package pl.seleniumdemo.tests;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import pl.seleniumdemo.pages.HomePage;
import pl.seleniumdemo.pages.SearchPage;

public class SearchTest extends BaseTest {

    @Test
    public void nothingFoundProduct() {

        String productName = "Test";

        WebElement infoAboutNothingFound = new HomePage(driver)
                .usingSearch()
                .searchProduct(productName)
                .infoAboutNothingFound();

        SearchPage searchPage = new SearchPage(driver);
        WebElement resultSearch = searchPage.getHeadingTitle();
        String headingTitle = resultSearch.getText();

        Assert.assertEquals("Search Results for : " + productName, headingTitle);
        Assert.assertEquals("Sorry, but nothing matched your search criteria. Please try again with some different keywords.", infoAboutNothingFound.getText());
    }

    @Test
    public void foundtheProduct() {

        String productName = "Selenium";

        WebElement searchingProduct = new HomePage(driver)
                .usingSearch()
                .searchProduct(productName)
                .getProductJavaSeleniumWebDriver();

        Assert.assertEquals("Java Selenium WebDriver", searchingProduct.getText());
    }

}
