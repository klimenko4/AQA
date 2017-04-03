package ua.kiev.prog.week2.hotline;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.*;

/**
 * Created by Zver on 30.03.2017.
 */
public class SearchResultPage {

    private WebDriver driver;

    private WebDriverWait wait;

    //Set for storing all applied PriceRanges
    private Set<PriceRange> priceRangeList = new TreeSet<PriceRange>();

    //bottom blue toolbar, which hides price filters
    @FindBy(xpath = "//*[@id=\"mm-0\"]/div[3]/div/div[1]/a[3]")
    private WebElement bottomToolbar;

    //@FindBy (partialLinkText = "2500-3500")
    private WebElement checkbox;

    SearchResultPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, 20);
        PageFactory.initElements(driver, this);
    }

    private Set<PriceRange> getPriceRangeList() {
        return priceRangeList;
    }

    //return min price from priceRangeList
    public int getMinPriceFromPriceRangeList() throws Exception {
        if (this.priceRangeList.isEmpty()) {
            throw new Exception("Filter's list is empty, add one ore more PriceRanges");
        }
        Iterator<PriceRange> iterator = this.getPriceRangeList().iterator();
        int minPrice = iterator.next().getMinPrice();
        while(iterator.hasNext()) {
            PriceRange priceRange = iterator.next();
            int minPriceFromPriceRange = priceRange.getMinPrice();
            if (minPriceFromPriceRange < minPrice) {
                minPrice = minPriceFromPriceRange;
            }
        }
        return minPrice;
    }

    //return min price from priceRangeList
    public int getMaxPriceFromPriceRangeList() throws Exception {
        if (this.priceRangeList.isEmpty()) {
            throw new Exception("Filter's list is empty, add one ore more PriceRanges");
        }
        Iterator<PriceRange> iterator = this.getPriceRangeList().iterator();
        int maxPrice = iterator.next().getMaxPrice();
        while(iterator.hasNext()) {
            PriceRange priceRange = iterator.next();
            int maxPriceFromPriceRange = priceRange.getMaxPrice();
            if (maxPriceFromPriceRange > maxPrice) {
                maxPrice = maxPriceFromPriceRange;
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
        //choose price range checkbox
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        checkbox = driver.findElement(By.partialLinkText(priceRange.getRangeString()));
        wait.until(ExpectedConditions.elementToBeClickable(checkbox));
        checkbox.click();
        return this;
    }

    //get all item's prices after applying priceRange filters
    public List<Integer> getAllPricesInRange() {
        List<Integer> pricesIntegers = new ArrayList<Integer>();
        List<WebElement> pricesBlocks = driver.findElements(By.xpath("//div[@class='text-14 text-13-480 orng']/b"));
        for (WebElement priceBlock: pricesBlocks) {
            String price = priceBlock.getText();
            int len = price.length();
            pricesIntegers.add(Integer.parseInt(removeWhitespacesFromStr(price.substring(0, len - 3))));
        }
        return pricesIntegers;
    }

    //remove whitespaces
    private String removeWhitespacesFromStr (String inputStr) {
        String resultString = "";
        for(int i = 0; i < inputStr.length(); i++) {
            if (inputStr.charAt(i) != ' ') {
                resultString += inputStr.charAt(i);
            }
        }
        return resultString;
    }
}
