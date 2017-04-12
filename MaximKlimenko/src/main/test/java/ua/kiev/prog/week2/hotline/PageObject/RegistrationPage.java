package ua.kiev.prog.week2.hotline.PageObject;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.Objects;


public class RegistrationPage extends BasePage {

    public RegistrationPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(name = "email")
    private WebElement emailRegField;

    @FindBy(name = "nick")
    private WebElement nicknameRegField;

    @FindBy(name = "password")
    private WebElement passRegField;

    @FindBy(id = "submit-button")
    private WebElement regSubmitButton;

    @FindBy(id = "error_email")
    private WebElement emailError;

    public RegistrationPage fillInEmail(String text) {
        emailRegField.sendKeys(text);
        return this;
    }

    public RegistrationPage fillInNickname(String name) {
        nicknameRegField.sendKeys(name);
        return this;
    }

    public RegistrationPage fillInPassword(String registrationPassword) {
        passRegField.sendKeys(registrationPassword);
        return this;
    }

    public RegistrationPage clickOnRegSubmitButton() {
        regSubmitButton.click();
        return this;
    }

    public void assertEmailErrorContaign(String errorText) {
        System.out.println(errorText + " from provider");
        System.out.println(emailError.getText() +" from element");
        Assert.assertTrue(Objects.equals(errorText, emailError.getText()));

    }
}
