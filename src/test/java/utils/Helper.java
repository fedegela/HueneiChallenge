package utils;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;
import java.util.Date;

public class Helper {

    private static Helper helper;

    public static Helper getInstance() {
        if (helper == null) {
            helper = new Helper();
        }
        return helper;
    }

    public void getScreenshot(WebDriver driver) {
        File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(screenshot, new File(".\\screenshots\\screenshot" + new Date().getTime() + ".png"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
