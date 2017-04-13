package ua.kiev.prog.week2.hotline;


import org.testng.annotations.Test;
import ua.kiev.prog.week2.hotline.PageObject.SearchResultsPage;
import java.util.HashMap;


public class CheckPriceInRangeTest extends BaseTest {


    PriceRanges range = PriceRanges.RANGE_2500_3500;

    @Test
    public void itemPriceInRange() {

        SearchResultsPage searchResultsPage = hotlineHomePage.search("iphone")
                .closeStatistic()
                .selectPriceFilter(range);
        HashMap<Integer,Integer> prices = searchResultsPage.getAllpricesFromPage();
        searchResultsPage.checkPrices(prices, range);
    }

}
