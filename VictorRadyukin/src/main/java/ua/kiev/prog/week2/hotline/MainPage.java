package ua.kiev.prog.week2.hotline;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * Created by Zver on 30.03.2017.
 */
public class MainPage {
    private WebDriver driver;

    public MainPage(WebDriver driver) {
        this.driver = driver;
    }

    //put url to driver
    public MainPage setUp(WebDriver driver, String hostName) {
        driver.get(hostName);
        return this;
    }

    //put searchString into searchField and click on searchButton
    public SearchResultPage search(String searchString) {
        WebElement searchField = driver.findElement(By.id("searchbox"));
        WebElement searchButton = driver.findElement(By.id("doSearch"));
        searchField.sendKeys(searchString);
        searchButton.click();
        return new SearchResultPage(driver);
    }
}
