package ua.kiev.prog.testngexamples;

import org.testng.annotations.DataProvider;

public class Provider {

    @DataProvider(name = "provider")
    public static Object[][] validDataProvider() {
        return new Object[][]{
                {'A', 65}, {'a', 97},
                {'B', 66}, {'b', 98},
                {'C', 67}, {'c', 99},
                {'D', 68}, {'d', 100},
                {'Z', 90}, {'z', 122},
                {'1', 49}, {'9', 57}
        };
    }


}
