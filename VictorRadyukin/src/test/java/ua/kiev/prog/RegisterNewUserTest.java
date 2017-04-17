package ua.kiev.prog;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import ua.kiev.prog.week2.hotline.MainPage;
import ua.kiev.prog.week2.hotline.NewUserNegativeDataProvider;
import ua.kiev.prog.week2.hotline.NewUserPositiveDataProvider;
import ua.kiev.prog.week2.hotline.RegisterNewUserPage;

import java.util.List;

/**
 * Created by Zver on 08.04.2017.
 */
public class RegisterNewUserTest {

    private static WebDriver driver;
    private static WebDriverWait wait;
    private static MainPage mainPage;

    @BeforeClass
    public static void setUp() {
        // path to ChromeDriver binary file
        System.setProperty("webdriver.chrome.driver", "/Users/mac/IdeaProjects/AQA/drivers/chromedriver");
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, 60);
        mainPage = new MainPage(driver,wait);
    }

    @Test(dataProvider = "getPositiveNewUserData", dataProviderClass = NewUserPositiveDataProvider.class)
    public static void registerNewUser(String email, String nick, String password) {
        String title = mainPage.open()
                .goToRegisterNewUserPage()
                .fillAndSubmitRegistrationForm(email, nick, password)
                .getTitle();
        Assert.assertEquals(title, RegisterNewUserPage.TITLE_SUCCESS_REGISTRATION);
    }

    @Test(dataProvider = "getNegativeNewUserData", dataProviderClass = NewUserNegativeDataProvider.class)
    public static void registerNewUserNegative(String email, String nick, String password, List<String> expectedValidationMessages) {
        RegisterNewUserPage registerNewUserPage = mainPage.open()
                                                          .goToRegisterNewUserPage()
                                                          .fillAndSubmitRegistrationForm(email, nick, password);

        List<String> actualValidationMessages = registerNewUserPage.getValidationMessages();

        Assert.assertEquals(expectedValidationMessages,actualValidationMessages);

//        if (!emailErrorMessage.isEmpty()) {
//            wait.until(ExpectedConditions.visibilityOf(registerNewUserPage.emailErrorElement));
//            Assert.assertEquals(registerNewUserPage.emailErrorElement.getText(), emailErrorMessage);
//        }
//        if (!nickErrorMessage.isEmpty()) {
//            Assert.assertEquals(registerNewUserPage.nickErrorElement.getText(), nickErrorMessage);
//        }
//        if (!passwordErrorMessage.isEmpty()) {
//            Assert.assertEquals(registerNewUserPage.passwordErrorElement.getText(), passwordErrorMessage);
//        }
    }
}
