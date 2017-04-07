package ua.kiev.prog.week2.hotline;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by Zver on 30.03.2017.
 */
public class MainPage extends BasePage {
    private static final String url = "http://hotline.ua/";

    @FindBy(id = "searchbox")
    private WebElement searchField;

    @FindBy(id = "doSearch")
    private WebElement searchButton;

    @FindBy(css = "a.reg")
    private WebElement registerLink;

    public MainPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
        PageFactory.initElements(driver, this);
    }

    //put url to driver
    public MainPage open() {
        driver.get(url);
        return this;
    }

    //put searchString into searchField and click on searchButton
    public SearchResultPage search(String searchString) {
        searchField.sendKeys(searchString, Keys.ENTER);
        return new SearchResultPage(driver);
    }

    public RegisterNewUserPage goToRegisterNewUserPage() {
        wait.until(ExpectedConditions.elementToBeClickable(registerLink));
        registerLink.click();
        return new RegisterNewUserPage(driver, wait);
    }
}
