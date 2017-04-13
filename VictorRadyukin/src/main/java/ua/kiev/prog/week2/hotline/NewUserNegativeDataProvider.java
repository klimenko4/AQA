package ua.kiev.prog.week2.hotline;

import org.testng.annotations.DataProvider;

import java.util.Collections;

import static java.util.Arrays.asList;
import static java.util.Collections.singletonList;

/**
 * Created by Zver on 08.04.2017.
 */
public class NewUserNegativeDataProvider {

    @DataProvider(name = "getNegativeNewUserData")
    public static Object[][] getData() {


        return new Object[][]{
                {"erentchi@ukr.net", "Deutsche", "ere", Collections.singletonList("Длина поля не может быть меньше 4 и больше 16 символов")},
                {"enretcophi@ukr.net", "D34eutsche", "", singletonList("Заполните это поле")},
                {"uipui@lo.re", "лдролр", "JKklpoi", singletonList("Поле не соответствует формату")},
                {"", "gfhagfdhsfgjmhg", "JKklpoklk", singletonList("Заполните это поле")},
                {"jfijsdfhv", "gfhagfdhsfgg", "Jpoklk", singletonList("Поле не соответствует формату")},
                {"", "", "", asList("Заполните это поле", "Заполните это поле", "Заполните это поле")}
        };
    }
}
