package ua.kiev.prog;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import ua.kiev.prog.week2.hotline.ConfirmSuccessRegistrationPage;
import ua.kiev.prog.week2.hotline.MainPage;
import ua.kiev.prog.week2.hotline.NewUserNegativeDataProvider;
import ua.kiev.prog.week2.hotline.NewUserPositiveDataProvider;

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
        System.setProperty("webdriver.chrome.driver", "C:/Users/Zver/IdeaProjects/AQA/drivers/chromedriver.exe");
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
        Assert.assertEquals(title, ConfirmSuccessRegistrationPage.TITLE);
    }

    @Test(dataProvider = "getNegativeNewUserData", dataProviderClass = NewUserNegativeDataProvider.class)
    public static void registerNewUserNegative(String email, String nick, String password) {
        String title = mainPage.open()
                .goToRegisterNewUserPage()
                .fillAndSubmitRegistrationForm(email, nick, password)
                .getTitle();
        Assert.assertNotEquals(title, ConfirmSuccessRegistrationPage.TITLE);
    }
}
