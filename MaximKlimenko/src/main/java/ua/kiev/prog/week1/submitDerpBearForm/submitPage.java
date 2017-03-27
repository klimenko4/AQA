package ua.kiev.prog.week1.submitDerpBearForm;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 * Created by Maxim Klimenko on 28.03.2017.
 */
public class submitPage {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.get("http://www.amazon.com");
    }

}
