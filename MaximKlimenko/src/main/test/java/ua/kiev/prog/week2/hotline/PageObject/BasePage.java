package ua.kiev.prog.week2.hotline.PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by Maxim Klimenko on 06.04.2017.
 */
public class BasePage {

    protected WebDriver driver;
    protected WebDriverWait wait;
    private String homePageLink = "http://hotline.ua/";


    public BasePage(WebDriver driver) {
        this.wait = new WebDriverWait(driver, 10);
        this.driver = driver;
        driver.manage().window().maximize();
        PageFactory.initElements(driver, this);
    }
}
