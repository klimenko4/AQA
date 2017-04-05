package ua.kiev.prog.week3.wrappers;

import org.openqa.selenium.WebDriver;

import static java.util.Optional.ofNullable;

public abstract class WebDriverProvider {

    private static final ThreadLocal<WebDriver> DRIVER_CONTAINER = new ThreadLocal<>();

    public static WebDriver getDriver() {
        return DRIVER_CONTAINER.get();
    }

    protected void setupDriver() {
        WebDriver driver = WebDriverFactory.getDriver();
        driver.manage().window().maximize();
        DRIVER_CONTAINER.set(driver);
    }

    protected void cleanUp() {
        ofNullable(getDriver()).ifPresent(WebDriver::quit);
        DRIVER_CONTAINER.remove();
    }
}

