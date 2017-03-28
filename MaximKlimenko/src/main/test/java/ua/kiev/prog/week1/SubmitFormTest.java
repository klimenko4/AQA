package java.ua.kiev.prog.week1;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class SubmitFormTest {

    static WebDriver driver;


    @BeforeClass
    public static void beforeAll() {
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
    }

    @Test
    public void name() throws Exception {

    }
}
