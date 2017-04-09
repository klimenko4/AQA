package ua.kiev.prog.week2.hotline;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.WebDriverWait;


public class HotlineHomePage extends BasePage {

    private String homePageLink = "http://hotline.ua/";

    public HotlineHomePage(WebDriver driver, WebDriverWait wait) {
        super(driver);
        driver.manage().window().maximize();
    }

    public HotlineHomePage openUrl(){
        driver.get(homePageLink);
        return this;
    }

    @FindBy(id = "searchbox")
    private WebElement searchField;

    @FindBy(how = How.ID,using = "doSearch")
    private WebElement searchbutton;

    public SearchResultsPage search(String text) {
        searchField.sendKeys(text);
        searchbutton.click();
        return new SearchResultsPage(driver);
    }


}
