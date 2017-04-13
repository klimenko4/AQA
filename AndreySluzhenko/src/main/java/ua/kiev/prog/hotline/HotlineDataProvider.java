package ua.kiev.prog.hotline;

import org.testng.annotations.DataProvider;

public class HotlineDataProvider {

    public static class AlreadyExistedUserDataProvider {
        @DataProvider(name = "getAlreadyExistedUserData")
        public static Object[][] getData() {
            return new Object[][]{
                    {"test@ukr.net", "testUser", "testPassword"},
                    {"test1@ukr.net", "testUser1", "testPassword1"},
                    {"test2@gmail.com", "testUser2", "testPassword2"}
            };
        }
    }

    public static class NewUserPositiveDataProvider {
        @DataProvider(name = "getPositiveNewUserData")
        public static Object[][] getData() {
            return new Object[][]{
                    {"test@ukr.net", "testUser", "testPassword"},
                    {"test1@ukr.net", "testUser1", "testPassword1"},
                    {"test2@gmail.com", "testUser2", "testPassword2"}
            };
        }
    }
}