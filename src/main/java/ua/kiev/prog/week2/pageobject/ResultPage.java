package ua.kiev.prog.week2.pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ResultPage {

    private WebDriver driver;

    public ResultPage(WebDriver driver) {
        this.driver = driver;
    }

    public String getHeaderMessage() {
        return driver.findElement(By.cssSelector("#results > header > h1")).
                getText();
    }

}

