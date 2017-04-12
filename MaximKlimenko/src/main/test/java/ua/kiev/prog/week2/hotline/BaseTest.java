package ua.kiev.prog.week2.hotline;

import io.github.bonigarcia.wdm.ChromeDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import ua.kiev.prog.week2.hotline.PageObject.HotlineHomePage;

public class BaseTest {


    protected WebDriver driver;
    protected WebDriverWait wait;
    protected HotlineHomePage hotlineHomePage;
    @BeforeTest
    public void beforeMethod() {
        ChromeDriverManager.getInstance().setup();
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, 10);
        hotlineHomePage = new HotlineHomePage(driver);
        hotlineHomePage.openUrl();
    }

//    @AfterTest
//    public void afterMethod() {
//        driver.quit();
//    }


}
