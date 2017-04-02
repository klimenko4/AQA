package ua.prog.week2.pageobject;

import com.sun.tools.javac.util.List;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import static org.openqa.selenium.By.cssSelector;

/**
 * Created by dmytro-mikhieiev on 30.03.17.
 */
public class FormPage extends BasePage {

    @Override
    public String getURL() {
        return null;
    }

    public FormPage(WebDriver driver) {
        super(driver);
    }

    public FormPage open() {
        driver.get("http://hotline.ua/");
        return this;
    }

    public FormPage searchData (String searchField) {
        driver.findElement(By.id("searchbox")).sendKeys("iphone");
        new Actions(driver).click().perform();
        return this;
    }

    public FormPage clickRange(Ranges range) {
        driver.findElement(cssSelector("#filters > div.cell.group-gr-185.full-list > div > div:nth-child(1) > a")).click();
        return this;
    }

    public FormPage quantity() {
        java.util.List<WebElement> list = driver.findElements(By.className("cell gd-item flex-block flex-stretch flex-wrap"));
        Assert.assertEquals(4, list.size());
        return this;
    }

}
