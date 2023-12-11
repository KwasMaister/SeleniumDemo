package pl.seleniumdemo.utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DriverFactory {

    private static WebDriver driver;

    public static WebDriver getDriver(){
        if (driver==null) {
            String path = "C:\\Users\\jakub\\Desktop\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe";
            System.setProperty("webdriver.chrome.driver", path);
            driver = new ChromeDriver();
        }
        return driver;
    }
}
