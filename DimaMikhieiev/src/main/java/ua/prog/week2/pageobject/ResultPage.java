package ua.prog.week2.pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * Created by dmytro-mikhieiev on 30.03.17.
 */
public class ResultPage {

    private WebDriver driver;

    public ResultPage(WebDriver driver) {
        this.driver = driver;
    }

//    public String getHeaderMessage() {
//        return driver.findElement(By.cssSelector("#results > header > h1")).
//                getText();
//    }
}
