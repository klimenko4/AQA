package ua.kiev.prog.week2.hotline;

import org.testng.annotations.DataProvider;

/**
 * Created by Zver on 08.04.2017.
 */
public class NewUserPositiveDataProvider {
    @DataProvider(name = "getPositiveNewUserData")
    public static Object[][] getData() {
        return new Object[][]{
                {"oon@i.ua", "o", "ionp"},
                {"oractor@yandex.ru", "or", "Tra12"},
                {"ooneyspoon@gmail.com", "ooneyhunter", "HUNTER789"},
                {"oho@uy.uyt", "ouyuytr5654er43wertytr54e32we", "jkuiyhgtfredfcd"},
                {"oapswoty@f.op", "o876765456trfghbvc5434321qwawe", "yuyikjuytgfdresw"}
        };
    }
}
