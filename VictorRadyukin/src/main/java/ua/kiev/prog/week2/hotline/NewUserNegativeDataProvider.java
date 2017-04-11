package ua.kiev.prog.week2.hotline;

import org.testng.annotations.DataProvider;

/**
 * Created by Zver on 08.04.2017.
 */
public class NewUserNegativeDataProvider {
    @DataProvider(name = "getNegativeNewUserData")
    public static Object[][] getData() {
        return new Object[][]{
                {"erentchi@ukr.net", "Deutsche", "ere", "", "", "Длина поля не может быть меньше 4 и больше 16 символов"},
                {"enretcophi@ukr.net", "D34eutsche", "", "", "", "Заполните это поле"},
                {"uipui@lo.re", "лдролр", "JKklpoi", "", "Поле не соответствует формату", ""},
                {"", "gfhagfdhsfgjmhg", "JKklpoklk", "Заполните это поле", "", ""},
                {"jfijsdfhv", "gfhagfdhsfgg", "Jpoklk", "Поле не соответствует формату", "", ""}
        };
    }
}
