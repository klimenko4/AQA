package ua.kiev.prog;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ua.kiev.prog.week2.hotline.MainPage;

/**
 * Created by Zver on 08.04.2017.
 */
public class SignInUserTest {
    private static WebDriver driver;
    private static WebDriverWait wait;
    private static MainPage mainPage;

    @BeforeMethod
    public static void setUp() {
        // path to ChromeDriver binary file
        System.setProperty("webdriver.chrome.driver", "C:/Users/Zver/IdeaProjects/AQA/drivers/chromedriver.exe");
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, 60);
        mainPage = new MainPage(driver,wait);
    }

    @Test
    public static void signInUser () {
        Boolean isSucceedUserSignIn = mainPage.open()
                                                .openSignInPopupWindow()
                                                .fillAndSubmitSignInForm("radyukin@i.ua", "123456")
                                                .isSuccessedUserSignIn("radyukin_victor");
        Assert.assertTrue(isSucceedUserSignIn);
    }

    @Test
    public static void signInUserNegative () {
        Boolean isSucceedUserSignIn = mainPage.open()
                .openSignInPopupWindow()
                .fillAndSubmitSignInForm("radyukin@i.ua", "")
                .isSuccessedUserSignIn("radyukin_victor");
        Assert.assertFalse(isSucceedUserSignIn);
    }
}
