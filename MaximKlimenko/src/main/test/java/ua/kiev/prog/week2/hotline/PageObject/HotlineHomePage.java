package ua.kiev.prog.week2.hotline.PageObject;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;


public class HotlineHomePage extends BasePage {

    private String homePageLink = "http://hotline.ua/";

    public HotlineHomePage(WebDriver driver) {
        super(driver);
    }

    public HotlineHomePage openUrl(){
        driver.get(homePageLink);
        return this;
    }

    @FindBy(id = "searchbox")
    private WebElement searchField;

    @FindBy(how = How.ID,using = "doSearch")
    private WebElement searchbutton;

    @FindBy(css = ".reg")
    private WebElement registerLink;


    public RegistrationPage clickOnRegisterLink() {
        registerLink.click();

        return new RegistrationPage(driver);
    }

    public SearchResultsPage search(String text) {
        searchField.sendKeys(text);
        searchbutton.click();
        return new SearchResultsPage(driver);
    }




}
