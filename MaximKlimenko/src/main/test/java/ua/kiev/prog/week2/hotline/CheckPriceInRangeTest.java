package ua.kiev.prog.week2.hotline;

import io.github.bonigarcia.wdm.ChromeDriverManager;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by Maxim Klimenko on 06.04.2017.
 */
public class CheckPriceInRangeTest {

    private static WebDriver driver;
    private static WebDriverWait wait;
    private static HotlineHomePage hotlineHomePage;

    @Before
    public void setUp() {
        ChromeDriverManager.getInstance().setup();
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, 10);
        hotlineHomePage = new HotlineHomePage(driver, wait);
    }

    @Test
    public void itemPriceInRange() {
        SearchResultsPage searchResultsPage = hotlineHomePage.openUrl().search("iphone");

    }

    @After
    public void tearDown()  {
    driver.quit();

    }
}
