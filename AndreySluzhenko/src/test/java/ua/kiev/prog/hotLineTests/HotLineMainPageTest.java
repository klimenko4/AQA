package ua.kiev.prog.hotLineTests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ua.kiev.prog.hotline.HotLineMainPage;
import ua.kiev.prog.hotline.HotlineDataProvider.AlreadyExistedUserDataProvider;
import ua.kiev.prog.hotline.HotlineDataProvider.NewUserPositiveDataProvider;

public class HotLineMainPageTest {
    private WebDriver driver;
    private WebDriverWait wait;
    private HotLineMainPage hotLineMainPage;
    String email = "sluzhman@ukr.net";
    String password = "andriiTest";
    String itemToBeSerched = "Core i7";

    public HotLineMainPageTest() {
    }

    @BeforeMethod
    public void beforeEach() {
        this.hotLineMainPage = new HotLineMainPage(this.driver);
    }

    @BeforeClass
    public void beforeAll() {
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
        this.driver = new ChromeDriver();
        this.driver.manage().window().maximize();
        this.wait = new WebDriverWait(this.driver, 4L);
        this.driver.get("https://hotline.com.ua");
    }

    @Test
    public void navigateToHotlinePageTest() {
        this.hotLineMainPage.searchForSomething(this.itemToBeSerched);
        Assert.assertEquals(this.hotLineMainPage.searchbox.getText(), "Core i7");
    }

    @Test(dataProvider = "getPositiveNewUserData", dataProviderClass = NewUserPositiveDataProvider.class)
    public void createNewUserTest(String emailAddress, String userName, String password) {
        this.hotLineMainPage.createNewUser(emailAddress, userName, password);
        Assert.assertEquals(this.hotLineMainPage.registrationSuccessMessage.getText(), "Поздравляем! Вы успешно зарегистрировались на Hotline");
    }

    @Test(dataProvider = "getAlreadyExistedUserData", dataProviderClass = AlreadyExistedUserDataProvider.class)
    public void createNewUserWithExistedCredentials(String emailAddress, String userName, String password) {
        this.hotLineMainPage.createNewUser(emailAddress, userName, password);
        Assert.assertEquals(this.hotLineMainPage.errorOnExistedEmail.getText(), "Извините, но такой e-mail уже занят");
    }

    @Test
    public void loginWithAlreadyCreatedUser() {
        this.hotLineMainPage.loginForAlreadyCreatedUser(email, password);
        Assert.assertEquals(this.hotLineMainPage.userMenu.getText(), "andriiTest");
    }
}
