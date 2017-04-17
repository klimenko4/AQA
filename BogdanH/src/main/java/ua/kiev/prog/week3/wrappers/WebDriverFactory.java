package ua.kiev.prog.week3.wrappers;

import io.github.bonigarcia.wdm.ChromeDriverManager;
import io.github.bonigarcia.wdm.FirefoxDriverManager;
import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import ua.kiev.prog.week3.utils.ConfigLoader;

import static ua.kiev.prog.week3.utils.CoreConstants.CHROME;
import static ua.kiev.prog.week3.utils.CoreConstants.FIREFOX;

public class WebDriverFactory {

    public static WebDriver getDriver() {
        final String browser = ConfigLoader.getProperty("browser");
        System.getProperty("browser");

        if (StringUtils.isEmpty(browser)) {
            throw new IllegalStateException("'browser' property is missing!");
        }

        switch (browser) {
            case CHROME:
                ChromeDriverManager.getInstance().setup();
                return new ChromeDriver();
            case FIREFOX:
                FirefoxDriverManager.getInstance().setup();
                return new FirefoxDriver();
            default:
                throw new IllegalArgumentException(browser + " browser is not supported!");
        }
    }

    public static WebDriver getDriverUsingIf(DesiredCapabilities desiredCapabilities) {
        if (desiredCapabilities == null) {
            throw new IllegalStateException("DesiredCapabilities are missing!");
        }

        final String browser = desiredCapabilities.getBrowserName();

        if (CHROME.equalsIgnoreCase(browser)) {
            return new ChromeDriver(desiredCapabilities);
        } else if (FIREFOX.equalsIgnoreCase(browser)) {
            return new FirefoxDriver(desiredCapabilities);
        } else if (browser.isEmpty()) {
            throw new IllegalStateException("'browser' capability is missing!");
        }

        throw new IllegalArgumentException(desiredCapabilities.getBrowserName() + " browser is not supported!");
    }
}
