package ua.prog.week2.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by dmytro-mikhieiev on 30.03.17.
 */
public class BasePage {

    protected WebDriver driver;
    protected String URL;

    public BasePage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public String getURL() { return URL; }

    public void openPage() { driver.get(URL); }

}
