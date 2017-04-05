package ua.kiev.prog.week3;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import ua.kiev.prog.week3.enums.PriceRange;
import ua.kiev.prog.week3.pageobject.HotlineMainPage;
import ua.kiev.prog.week3.wrappers.BeforeClassWebDriverProvider;

import java.util.List;

import static org.junit.Assert.assertTrue;

@Listeners(BeforeClassWebDriverProvider.class)
public class HotLineTest {

    private HotlineMainPage mainPage;

    @BeforeMethod
    public void setUp() throws Exception {
        mainPage = new HotlineMainPage();
    }

    @DataProvider
    public Object[][] resultsPerProduct() {
        return new Object[][]
                {{"холодильник", 24},
                        {"смартфон", 25}};
    }


    @Test(enabled = false)
    public void checkIphonePricesWithinTheRange() throws Exception {


        PriceRange range = PriceRange.$2500_3500;

        mainPage.openPage();
        List<Integer> prices = mainPage.
                searchFor("iphone").
                selectPriceRange(range).
                selectAllPrices();

        prices.forEach(price -> assertTrue("Price is out of the range", price >= range.getMinPrice() && price <= range.getMaxPrice()));
    }

    @Test(dataProvider = "resultsPerProduct")
    public void checkNumberOfSearchResultsIsCorrect(String product, int resultsNum) throws Exception {

        mainPage.openPage();
        List<Integer> prices = mainPage.
                searchFor(product).
                selectAllPrices();

        assertTrue(prices.size() == resultsNum);

    }
}
