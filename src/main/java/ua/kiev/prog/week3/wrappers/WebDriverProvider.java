package ua.kiev.prog.week3.wrappers;

import org.openqa.selenium.WebDriver;

import static java.util.Optional.ofNullable;
import static ua.kiev.prog.week3.utils.ScreenshotUtils.takeScreenshot;

public abstract class WebDriverProvider {

    private static final ThreadLocal<WebDriver> DRIVER_CONTAINER = new ThreadLocal<>();

    public static WebDriver getDriver() {
        return DRIVER_CONTAINER.get();
    }

    public static void setupDriver() {
        WebDriver driver = WebDriverFactory.getDriver();
        driver.manage().window().maximize();
        DRIVER_CONTAINER.set(driver);
    }

    public static void cleanUp() {
        ofNullable(getDriver()).ifPresent(driver -> {
            takeScreenshot(driver);
            driver.quit();
        });
        DRIVER_CONTAINER.remove();
    }
}

