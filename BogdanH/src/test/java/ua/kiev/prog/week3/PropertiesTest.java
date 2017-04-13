package ua.kiev.prog.week3;


import org.testng.annotations.Test;
import ua.kiev.prog.week3.utils.ConfigLoader;

public class PropertiesTest {

    @Test
    public void testProperties() {
        System.out.println(ConfigLoader.getProperty("env.name"));
    }

    @Test(groups = "mytest")
    public void testProperties2() {
        System.out.println(ConfigLoader.getProperty("env.name"));
    }
}
