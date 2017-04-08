package ua.kiev.prog.week2.hotline;

import org.testng.annotations.DataProvider;

/**
 * Created by Zver on 08.04.2017.
 */
public class NewUserNegativeDataProvider {
    @DataProvider(name = "getNegativeNewUserData")
    public static Object[][] getData() {
        return new Object[][]{
                {"entchi@ukr.net", "Deutsche", "ere"},
                {"entcophi@ukr.net", "D34eutsche", ""},
                {"uip@lo.re", "лдролр", "JK\"poi"}
        };
    }
}
