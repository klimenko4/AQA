package ua.kiev.prog.week2.hotline;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by Maxim Klimenko on 09.04.2017.
 */
public class SearchResultsPage{

    private WebDriver driver;
    private WebDriverWait wait;


    SearchResultsPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, 60);
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = "cell group-gr-185 full-list")
    private WebElement priceFilter;
}
