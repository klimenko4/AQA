package ua.kiev.prog.week2.hotline;


import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import ua.kiev.prog.week2.hotline.PageObject.RegistrationPage;

public class RegistrationAndSignInTest extends BaseTest {

    @DataProvider(name = "RegistrationErrorProvider")
    public static Object[][] RegistrationErrorProvider() {
        return new Object[][]{
                {"maximklimenko4@gmail.com", "Извините, но такой e-mail уже занят"},
                {"maxim@ddd","Поле не соответствует формату"},
                {"","Заполните это поле"}
        };
    }

    @Test(dataProvider = "RegistrationErrorProvider",groups = "registration")
    public void emailAlreadyExistsErrorTest(String email, String errorText) {
        RegistrationPage registrationPage = hotlineHomePage.clickOnRegisterLink()
                .fillInEmail(email)
                .fillInNickname("nickname")
                .fillInPassword("123456")
                .clickOnRegSubmitButton();
        registrationPage.assertEmailErrorContaign(errorText);
    }
}
