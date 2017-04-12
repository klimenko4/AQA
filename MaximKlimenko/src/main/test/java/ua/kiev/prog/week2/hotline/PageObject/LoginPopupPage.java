package ua.kiev.prog.week2.hotline.PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ua.kiev.prog.week2.hotline.PageObject.BasePage;

/**
 * Created by Maxim Klimenko on 10.04.2017.
 */
public class LoginPopupPage extends BasePage {

    @FindBy(name = "login")
    private WebElement emailField;

    @FindBy(name = "password")
    private WebElement passwordField;

    @FindBy(css = ".cell.but-box.but-blue")
    private WebElement submitButton;

    @FindBy(css = ".link-reg-pop")
    private WebElement registrationLink;


    public LoginPopupPage(WebDriver driver) {
        super(driver);
    }
}
