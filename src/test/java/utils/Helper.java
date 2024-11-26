package utils;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.io.File;
import java.io.IOException;
import java.util.Date;

public class Helper {

    private static Helper helper;

    public static Helper getInstance(){
        if(helper == null) {
            helper = new Helper();
        }
        return helper;
    }

    public void getScreenshot(RemoteWebDriver driver){
        File screenshot = driver.getScreenshotAs(OutputType.FILE);
        try {
            FileHandler.copy(screenshot, new File("./screenshots/screenshot" + new Date().getTime()  + ".png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
