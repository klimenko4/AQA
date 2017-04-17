package ua.kiev.prog.hotline;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HotLineMainPage {

    private WebDriver driver;
    protected WebDriverWait wait;

    @FindBy(id = "searchbox")
    public WebElement searchbox;

    @FindBy(id = "doSearch")
    public WebElement performSearchingButton;

    @FindBy(css = ".open-lightbox>b")
    public WebElement logInButton;

    @FindBy(css = ".reg")
    public WebElement registrationLink;

    @FindBy(xpath = ".//*[@id='reg-form']/div[2]/div[1]/input")
    public WebElement emailInput;

    @FindBy(xpath = ".//*[@id='reg-form']/div[3]/div[1]/input")
    public WebElement userNameInput;

    @FindBy(xpath = ".//*[@id='passw1']")
    public WebElement passwordInput;

    @FindBy(css = ".title-24.m_b-20")
    public WebElement registrationSuccessMessage;

    @FindBy(id = "error_email")
    public WebElement errorOnExistedEmail;

    @FindBy(id = "submit-button")
    public WebElement submitButton;

    @FindBy(xpath = "//input[@name = 'login']")
    public WebElement loginUserInput;

    @FindBy(xpath = "//input[@name = 'password']")
    public WebElement loginPasswordInput;

    @FindBy(css = ".cell.but-box.but-blue")
    public WebElement loginEnterButton;

    @FindBy(id = "open-user-menu")
    public WebElement userMenu;

    public void createNewUser(String emailAddress, String userName, String password){
        registrationLink.click();
        emailInput.sendKeys(emailAddress);
        userNameInput.sendKeys(userName);
        passwordInput.sendKeys(password);
        submitButton.click();
    }

    public HotLineMainPage(WebDriver webDriver) {
        this.driver = webDriver;
        PageFactory.initElements(driver, this);
    }

    public void searchForSomething(String itemForSearch) {
        searchbox.sendKeys(itemForSearch);
        performSearchingButton.click();
    }

    public void loginForAlreadyCreatedUser(String email, String password) {
        logInButton.click();
        if (driver instanceof JavascriptExecutor) {
            ((JavascriptExecutor) driver)
                    .executeScript("var closeLink = document.querySelector('a.close-x'); console.log(closeLink);" +
                            "closeLink.click();");
        }
//        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//input[@name = 'login']")));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".cf.pop-up-box.pup-login.cell-768")));
        loginUserInput.sendKeys(email);
        loginPasswordInput.sendKeys(password);
        loginEnterButton.click();

    }
}

