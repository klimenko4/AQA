package ua.kiev.prog.week2.hotline;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by Zver on 30.03.2017.
 */
public class SearchResultPage {

    private WebDriver driver;

    private WebDriverWait wait;

    //Set for storing all applied PriceRanges
    private Set<PriceRange> priceRangeList = new HashSet<>();

    //bottom blue toolbar, which hides price filters
    // locator can be simple as css = ".blue-toolbar.bottom-position"
    @FindBy(css = "a.hide")
    private WebElement bottomToolbar;

    //@FindBy (partialLinkText = "2500-3500")
    private WebElement checkbox;

    SearchResultPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, 60);
        PageFactory.initElements(driver, this);
    }

    private Set<PriceRange> getPriceRangeList() {
        return priceRangeList;
    }

    //return min price from priceRangeList
    public int getMinPriceFromPriceRangeList() {
        if (this.priceRangeList.isEmpty()) {
            throw new RuntimeException("Filter's list is empty, add one ore more PriceRanges");
        }
        int minPrice = Integer.MAX_VALUE;
        int currentMin;
        for (PriceRange priceRange : priceRangeList) {
            currentMin = priceRange.getMinPrice();
            if (currentMin < minPrice) {
                minPrice = currentMin;
            }
        }
        return minPrice;
        //if it wasn't a set of enum values , Collections.max() and .min() could be used

        // java 8 - stream API
    //    return priceRangeList.stream().map(PriceRange::getMinPrice).mapToInt(Integer::intValue).min().getAsInt();
    }

    //return min price from priceRangeList
    // in this case better to throw runtime exception , not checked exception
    public int getMaxPriceFromPriceRangeList() {
        if (this.priceRangeList.isEmpty()) {
            throw new RuntimeException("Filter's list is empty, add one ore more PriceRanges");
        }
        int maxPrice = Integer.MIN_VALUE;
        int currentMax;
        for (PriceRange priceRange : priceRangeList) {
            currentMax = priceRange.getMaxPrice();
            if (currentMax > maxPrice) {
                maxPrice = currentMax;
            }
        }
        return maxPrice;

    }

    //hide bottom toolbar
    public SearchResultPage hideBottomToolbar() {
        //closing bottom blue toolbar, which hiding filters
        wait.until(ExpectedConditions.elementToBeClickable(bottomToolbar));
        bottomToolbar.click();
        return this;
    }

    //select priceRange from enum PriceRange obj, add PriceRange obj to priceRangeList
    public SearchResultPage selectPriceFilter(PriceRange priceRange) {
        //adding enum obj to total set of all applied price filters
        priceRangeList.add(priceRange);
        wait.until(ExpectedConditions.elementToBeClickable(By.partialLinkText(priceRange.getRangeString())));
        //choose price range checkbox
        checkbox = driver.findElement(By.partialLinkText(priceRange.getRangeString()));
        //wait.until(ExpectedConditions.elementToBeClickable(checkbox));
        checkbox.click();
        return this;
    }

    //get all item's prices after applying priceRange filters
    public List<Integer> getAllPricesInRange() {
        List<Integer> pricesIntegers = new ArrayList<Integer>();
        List<WebElement> pricesBlocks = driver.findElements(By.xpath("//div[@class='text-14 text-13-480 orng']/b"));
        for (WebElement priceBlock : pricesBlocks) {
            String price = priceBlock.getText();
            int len = price.length();
            pricesIntegers.add(Integer.parseInt(removeWhitespacesFromStr(price.substring(0, len - 3))));
        }
        return pricesIntegers;
    }

    //remove whitespaces
    private String removeWhitespacesFromStr(String inputStr) {
        String resultString = "";
        for (int i = 0; i < inputStr.length(); i++) {
            if (inputStr.charAt(i) != ' ') {
                resultString += inputStr.charAt(i);
            }
        }
        return resultString;
    }
}
