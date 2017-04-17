package ua.kiev.prog.week3.utils;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.Augmenter;

import java.io.File;
import java.io.IOException;

public final class ScreenshotUtils {

    private ScreenshotUtils() {
    }

    public static void takeScreenshot(final WebDriver driver) {
        final WebDriver augmentedDriver = new Augmenter().augment(driver);
        final File screenshot = ((TakesScreenshot) augmentedDriver).
                getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(screenshot, new File("screen" + RandomStringUtils.randomNumeric(3) + ".png"));
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
