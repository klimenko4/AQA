package ua.kiev.prog;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import ua.kiev.prog.week2.hotline.MainPage;
import ua.kiev.prog.week2.hotline.PriceRange;
import ua.kiev.prog.week2.hotline.SearchResultPage;

import java.lang.*;
import java.util.ArrayList;
import java.util.List;


/**
 * Created by Zver on 30.03.2017.
 */
public class CheckPricesInRange {

    private static WebDriver driver;
    private static MainPage mainPage;
    //ArrayList of all item's prices after applying PriceRange filters
    List<Integer> prices;
    //min price from Set of PriceRange objects (see SearchResultPage class)
    int minFilterPrice;
    //max price from Set of PriceRange objects (see SearchResultPage class)
    int maxFilterPrice;

    @BeforeClass
    public static void setUp() {
        // path to ChromeDriver binary file
        System.setProperty("webdriver.chrome.driver","C:/Users/Zver/IdeaProjects/AQA/drivers/chromedriver.exe");
        //initialize WebDriver
        driver = new ChromeDriver();
        //initialize MainPage object
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
        prices = searchResultPage.getAllPricesInRange();
        //min price from all applied PriceRanges
        minFilterPrice = searchResultPage.getMinPriceFromPriceRangeList();
        //max price from all applied PriceRanges
        maxFilterPrice = searchResultPage.getMaxPriceFromPriceRangeList();

        for(int price: prices) {
            System.out.println(price + ";");
        }

        for(int price: prices) {
            Assert.assertTrue("Price is out of range", (price >= minFilterPrice && price <= maxFilterPrice));
        }
    }
}
