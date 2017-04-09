package ua.kiev.prog.week2.hotline;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.HashMap;
import java.util.List;


public class SearchResultsPage {

    private WebDriver driver;
    private WebDriverWait wait;


    SearchResultsPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, 10);
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = ".link-turn.hide.g_statistic")
    WebElement hideStatisticButton;

    @FindBy(css = ".text-14.text-13-480.orng")
    WebElement allPrices;

    public SearchResultsPage closeStatistic() {
        hideStatisticButton.click();
        return this;
    }

    public SearchResultsPage selectPriceFilter(PriceRanges range) {

        String rangeFilterLink = ".cell.group-gr-185.full-list .f-item:nth-child(" + range.getIndex() + ") a";

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(rangeFilterLink))).click();
        return this;
    }

    public HashMap<Integer, Integer> getAllpricesFromPage() {
        HashMap<Integer, Integer> prices = new HashMap<>();

        String priceLocator = ".text-14.text-13-480.orng";
        List<WebElement> elementsList = driver.findElements(By.cssSelector(priceLocator));
        int i = 1;
        for (WebElement element : elementsList) {
            String priceTextData = element.getText();
            int price = Integer.parseInt(priceTextData.replaceAll("[\\D]", ""));
            prices.put(i-1, price);
            i++;

            System.out.println(price);
        }

        return prices;
    }

    public void checkPrices(HashMap<Integer, Integer> prices, PriceRanges range) {

        for (int i = 0; i <= prices.size()-1; i++) {
            if (prices.get(i) <= range.getMinPrice() || prices.get(i) >= range.getMaxPrice()) {
                System.out.println("Product in row " + i + " is out of range with price " + prices.get(i));
            }
        }
    }


}
