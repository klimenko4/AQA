package ua.kiev.prog.week2.hotline;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by Maxim Klimenko on 06.04.2017.
 */
public class BasePage {

    protected WebDriver driver;
    private String homePageLink = "http://hotline.ua/";


    public BasePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
}
