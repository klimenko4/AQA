package ua.kiev.prog.week2.hotline;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by Zver on 30.03.2017.
 */
public class MainPage {
    private WebDriver driver;
    private static final String url = "http://hotline.ua/";

    @FindBy(id = "searchbox")
    private WebElement searchField;

    @FindBy(id = "doSearch")
    private WebElement searchButton;

    public MainPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    //put url to driver
    public MainPage open() {
        driver.get(url);
        return this;
    }

    //put searchString into searchField and click on searchButton
    public SearchResultPage search(String searchString) {
        searchField.sendKeys(searchString, Keys.ENTER);
        return new SearchResultPage(driver);
    }
}
