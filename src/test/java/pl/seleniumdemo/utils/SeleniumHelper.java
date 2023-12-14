package pl.seleniumdemo.utils;

import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.MediaEntityModelProvider;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;

public class SeleniumHelper {

    public static MediaEntityModelProvider getScreenshot(WebDriver driver) throws IOException {
        String path = getScreenshotPath(driver);
        return MediaEntityBuilder.createScreenCaptureFromPath(path).build();
    }

    public static String getScreenshotPath(WebDriver driver) throws IOException {
        String dateName = new SimpleDateFormat("yyyy-MM-dd-hh-mm").format(new Date());
        int randomNumber = (int) (Math.random() * 1000);
        TakesScreenshot screenshot = (TakesScreenshot) driver;
        File file = screenshot.getScreenshotAs(OutputType.FILE);
        String path = "src/test/java/pl/seleniumdemo/utils/screenshots/screenshots" + dateName + "-random" + randomNumber + ".png";
        FileUtils.copyFile(file, new File(path));
        return path;
    }

}
