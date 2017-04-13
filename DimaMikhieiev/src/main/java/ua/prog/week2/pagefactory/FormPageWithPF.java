package ua.prog.week2.pagefactory;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ua.prog.week2.pageobject.BasePage;

import java.util.List;

import static org.openqa.selenium.By.cssSelector;

/**
 * Created by dmytro-mikhieiev on 30.03.17.
 */
public class FormPageWithPF extends BasePage {

    @FindBy(id = "searchbox")
    private WebElement searchField;

    @FindBy(css = "#filters > div.cell.group-gr-185.full-list > div > div:nth-child(1) > a")
    private WebElement range;

    @FindBy(className = ".cell gd-item flex-block flex-stretch flex-wrap")
    private List<WebElement> webElements;

    public FormPageWithPF(WebDriver driver) {
        super(driver);
        URL="http://hotline.ua/";
    }

    public FormPageWithPF searchField(String searchdata) {
        searchField.sendKeys(searchdata);
        searchField.click();
        return this;
    }

    public FormPageWithPF range() {
        driver.findElement(cssSelector("#filters > div.cell.group-gr-185.full-list > div > div:nth-child(1) > a")).click();
        return this;
    }

    public FormPageWithPF webElements () {
        // List<WebElement> webElements = driver.findElements(By.className("cell gd-item flex-block flex-stretch flex-wrap"));
        Assert.assertEquals(4, webElements.size());
        return this;
    }

//    public ResultPage result() {
//        driver.findElement(id("submit_button")).click();
//        return new ResultPage(driver);
//    }

}
