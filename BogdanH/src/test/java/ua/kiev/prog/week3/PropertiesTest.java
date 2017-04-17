package ua.kiev.prog.week3;


import org.testng.annotations.Test;
import ua.kiev.prog.week3.utils.ConfigLoader;

public class PropertiesTest {

    @Test
    public void testProperties() {


     // System.out.println(System.getProperty("new.my.property"));
      System.out.println(ConfigLoader.getProperty("env.name"));
//        System.out.println(System.getProperty("browser"));
//        System.out.println(System.getProperty("site.url"));
        //System.out.println(ConfigLoader.getProperty("env.name"));
    }

    @Test(groups = "mytest")
    public void testProperties2() {
        System.out.println(ConfigLoader.getProperty("env.name"));
    }
}
