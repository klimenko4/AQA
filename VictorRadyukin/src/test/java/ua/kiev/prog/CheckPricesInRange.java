package ua.kiev.prog;

import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import ua.kiev.prog.week2.hotline.MainPage;
import ua.kiev.prog.week2.hotline.PriceRange;
import ua.kiev.prog.week2.hotline.SearchResultPage;

import java.util.List;

import static org.junit.Assert.assertTrue;


/**
 * Created by Zver on 30.03.2017.
 */
public class CheckPricesInRange {

    private static WebDriver driver;
    private static MainPage mainPage;

    @BeforeClass
    public static void setUp() {
        // path to ChromeDriver binary file
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Khandozhynski\\IdeaProjects\\automationprog\\drivers\\chromedriver.exe");
        //initialize WebDriver
        driver = new ChromeDriver();
        //initialize MainPage object
        driver.manage().window().maximize();
        mainPage = new MainPage(driver);
    }

    @Test
    public void checkItemsPricesInRanges() throws Exception {
        SearchResultPage searchResultPage = mainPage.open()
                .search("iphone");
        searchResultPage.hideBottomToolbar()
                .selectPriceFilter(PriceRange.PRICE_RANGE_2500_3500)
                .selectPriceFilter(PriceRange.PRICE_RANGE_3500_5000);
        //ArrayList item's prices
        List<Integer> prices = searchResultPage.getAllPricesInRange();
        //min price from all applied PriceRanges
        int minFilterPrice = searchResultPage.getMinPriceFromPriceRangeList();
        //max price from all applied PriceRanges
        int maxFilterPrice = searchResultPage.getMaxPriceFromPriceRangeList();

//        for (int price : prices) {
//            System.out.println(price + ";");
//        }

//        for (int price : prices) {
//            Assert.assertTrue("Price is out of range", (price >= minFilterPrice && price <= maxFilterPrice));
//        }
        prices.forEach(System.out::println);
        prices.forEach(price -> assertTrue("Price is out of range", price >= minFilterPrice && price <= maxFilterPrice));

    }
}
