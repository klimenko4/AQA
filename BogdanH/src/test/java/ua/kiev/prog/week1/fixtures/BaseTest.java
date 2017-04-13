package ua.kiev.prog.week1.fixtures;

import org.junit.After;
import org.junit.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BaseTest {

    protected static WebDriver driver;
    protected static WebDriverWait wait;

    @BeforeClass
    public static void beforeAll() {
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver");
        //System.setProperty("webdriver.gecko.driver", "driver/geckodriver.exe");

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-fullscreen");
        driver = new ChromeDriver(options);

        //driver.manage().window().maximize();
        wait = new WebDriverWait(driver, 4);
    }


    @After
    public void tearDown() throws Exception {
        driver.quit();
    }
}
