package ua.kiev.prog.week2.hotline;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

import static java.util.stream.Collectors.toList;
import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOf;
import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOfAllElementsLocatedBy;

/**
 * Created by Zver on 07.04.2017.
 */
public class RegisterNewUserPage extends BasePage {
    public static final String TITLE_SUCCESS_REGISTRATION = "Завершение регистрации";

    @FindBy(id = "reg-form")
    private WebElement registerForm;

    @FindBy(xpath = "//input[@name = 'email']")
    private WebElement email;

    @FindBy(xpath = "//input[@name = 'nick']")
    private WebElement nick;

    @FindBy(xpath = "//input[@name = 'password']")
    private WebElement password;

    @FindBy(id = "submit-button")
    private WebElement submitButton;

//    @FindBy(css = "[id^='error_']")
//    private List<WebElement> errorElement;


    public RegisterNewUserPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
        PageFactory.initElements(driver, this);
    }

    public List<String> getValidationMessages() {

        return wait.until(visibilityOfAllElementsLocatedBy
                (By.cssSelector("[id^='error_']")))
                .stream()
                .map(WebElement::getText)
                .collect(toList());
    }

    public String getTitle() {
        return driver.getTitle();
    }

    public RegisterNewUserPage fillAndSubmitRegistrationForm(String newUserEmail, String newUserNick, String newUserPassword) {
        wait.until(visibilityOf(registerForm));
        email.sendKeys(newUserEmail);
        nick.sendKeys(newUserNick);
        password.sendKeys(newUserPassword);
        submitButton.click();
        return this;
    }
}
