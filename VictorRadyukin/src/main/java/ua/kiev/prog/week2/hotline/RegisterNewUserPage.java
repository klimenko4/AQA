package ua.kiev.prog.week2.hotline;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;

/**
 * Created by Zver on 07.04.2017.
 */
public class RegisterNewUserPage extends BasePage {

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

    public RegisterNewUserPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
        PageFactory.initElements(driver, this);
    }

    public ConfirmSuccessRegistrationPage fillAndSubmitRegistrationForm(String newUserEmail, String newUserNick, String newUserPassword) {
        wait.until(ExpectedConditions.visibilityOf(registerForm));
        email.sendKeys(newUserEmail);
        nick.sendKeys(newUserNick);
        password.sendKeys(newUserPassword);
        submitButton.click();
        return new ConfirmSuccessRegistrationPage(driver, wait);
    }
}
