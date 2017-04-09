package ua.kiev.prog.week2.hotline;

import org.openqa.selenium.*;
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

    @FindBy(xpath = "//a[@href = '/user/log_in/']")
    private WebElement signInLink;

    @FindBy(xpath = "//input[@name = 'login']")
    private WebElement loginInputField;

    @FindBy(xpath = "//input[@name = 'password']")
    private WebElement passwordInputField;

    @FindBy(xpath = "//input[@value = 'Войти']")
    private WebElement signInButton;

    public MainPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
        PageFactory.initElements(driver, this);
    }

    //put url to driver
    public MainPage open() {
        driver.get(url);
        driver.manage().window().maximize();
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

public MainPage openSignInPopupWindow() {
        wait.until(ExpectedConditions.elementToBeClickable(signInLink));
        signInLink.click();
        return this;
    }

    public MainPage fillAndSubmitSignInForm(String email, String password) {
        if (driver instanceof JavascriptExecutor) {
            ((JavascriptExecutor) driver)
                    .executeScript("var closeLink = document.querySelector('a.close-x'); console.log(closeLink);" +
                            "closeLink.click();");
        }
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div.box_user_log")));
        loginInputField.sendKeys(email);
        passwordInputField.sendKeys(password);
        signInButton.click();
        return this;
    }

    public Boolean isSuccessedUserSignIn(String usernameRegisteredUser) {
        String xpathUsernameElement = "//span[@title = '" + usernameRegisteredUser + "']";
        //return (driver.findElement(By.xpath(xpathUsernameElement)).isDisplayed());
        try {
            wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpathUsernameElement)));
        } catch (RuntimeException exception) {
            return false;
        }
        return true;
    }
}
