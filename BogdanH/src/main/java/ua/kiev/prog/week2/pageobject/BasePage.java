package ua.kiev.prog.week2.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public abstract class BasePage {

    protected WebDriver driver;
    protected String URL;


    public BasePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public String getURL() {
        return URL;
    }

    public void openPage() {
        driver.get(URL);
    }

}
