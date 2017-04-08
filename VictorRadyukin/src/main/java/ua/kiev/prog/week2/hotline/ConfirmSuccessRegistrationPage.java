package ua.kiev.prog.week2.hotline;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by Zver on 07.04.2017.
 */
public class ConfirmSuccessRegistrationPage extends BasePage {
    public static final String TITLE = "Завершение регистрации";

    public ConfirmSuccessRegistrationPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
        PageFactory.initElements(driver, this);
    }

    public String getTitle() {
        return driver.getTitle();
    }
}
