package ua.kiev.prog.week2.hotline;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Zver on 30.03.2017.
 */
public class SearchResultPage {
    private WebDriver driver;

    //bottom blue toolbar, which hides price filters
    @FindBy (xpath = "//*[@id=\"mm-0\"]/div[3]/div/div[1]/a[3]")
    private WebElement bottomToolbar;

    @FindBy (partialLinkText = "2500-3500")
    private WebElement checkbox_1;

    @FindBy (xpath = "//a[@href='/mobile/mobilnye-telefony-i-smartfony/294245-11857-11858/']")
    private WebElement checkbox_2;

    public SearchResultPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    private String removeWhitespacesFromStr (String inputStr) {
        String resultString = "";
        for(int i = 0; i < inputStr.length(); i++) {
            if (inputStr.charAt(i) != ' ') {
                resultString += inputStr.charAt(i);
            }
        }
        return resultString;
    }
    //choosing first two price filters
    public SearchResultPage selectFilters() {
        WebDriverWait wait = new WebDriverWait(driver, 20);
        //closing bottom blue toolbar, which hiding filters
        bottomToolbar.click();
        //choose price filter 2500-3500
        wait.until(ExpectedConditions.elementToBeClickable(checkbox_1));
        checkbox_1.click();
        //choose price filter 3500-5000
        wait.until(ExpectedConditions.elementToBeClickable(checkbox_2));
        checkbox_2.click();
        return this;
    }

    public void checkPricesInRange() {
        List<Integer> pricesIntegers = new ArrayList<Integer>();
        List<WebElement> pricesBlocks = driver.findElements(By.xpath("//div[@class='text-14 text-13-480 orng']/b"));
        for (WebElement priceBlock: pricesBlocks) {
            String price = priceBlock.getText();
            int len = price.length();
            pricesIntegers.add(Integer.parseInt(removeWhitespacesFromStr(price.substring(0, len - 3))));
        }
        for(int price: pricesIntegers) {
            System.out.println(price);
        }
        for(int price: pricesIntegers) {
            Assert.assertTrue("Item's price is out of range", (price >= 2500 && price <= 5000));
        }
    }
}
