package ua.kiev.prog;

import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import ua.kiev.prog.week2.hotline.MainPage;
import java.lang.*;


/**
 * Created by Zver on 30.03.2017.
 */
public class CheckPricesInRange {

    private static WebDriver driver;
    private static MainPage mainPage;

    @BeforeClass
    public static void initWebDriver() {
        //point path to ChromeDriver binary file
        System.setProperty("webdriver.chrome.driver","C:/Users/Zver/IdeaProjects/AQA/drivers/chromedriver.exe");
        //initialize Driver
        driver = new ChromeDriver();
        //initialize MainPage object
        mainPage = new MainPage(driver);
    }

    @Test
    public void checkItemsPricesInRanges() {
        mainPage.setUp(driver, "http://hotline.ua/")
                .search("iphone")
                .selectFilters()
                .checkPricesInRange();
    }
}
