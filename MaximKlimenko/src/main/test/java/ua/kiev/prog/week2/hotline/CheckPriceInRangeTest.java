package ua.kiev.prog.week2.hotline;

import io.github.bonigarcia.wdm.ChromeDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.HashMap;


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

    PriceRanges range = PriceRanges.range_2500_3500;

    @Test
    public void itemPriceInRange() {
        SearchResultsPage searchResultsPage = hotlineHomePage.openUrl().search("iphone")
                .closeStatistic()
                .selectPriceFilter(range);
        HashMap<Integer,Integer> prices = searchResultsPage.getAllpricesFromPage();
        searchResultsPage.checkPrices(prices, range);


    }

    @After
    public void tearDown() {
        driver.quit();

    }
}
