package ua.kiev.prog.week1;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOfElementLocated;

public class JunitImitationExample {

    static WebDriver driver;
    static WebDriverWait wait;


    // Entry point
    public static void main(String[] args) {
        beforeAll();
        test1();
        test2();
        afterAll();
    }

    // Аналог @BeforeClass in JUnit
    private static void beforeAll() {

        // setting path to  chromedriver
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");

        //Setting webdriver which represents a real browser
        driver = new ChromeDriver();
        driver.manage().window().maximize();

        //create a wait webdriver instance which will wait maximum 4seconds
        wait = new WebDriverWait(driver, 4);
    }

    // Аналог @Test in JUnit
    private static void test1() {

        // steps
        driver.get("https://github.com");
        WebElement q = driver.findElement(By.name("q"));
        q.sendKeys("selenide");
        q.sendKeys(Keys.ENTER);
        String text = driver.findElement(By.linkText("codeborne/selenide")).getText();

        // assert(verification) - > used standart Java assert
        assert "codeborne/selenide".equals(text);
    }

    // Аналог @Test in JUnit
    private static void test2() {

        // steps
        driver.get("http://amazon.com");
        WebElement searchField = driver.findElement(By.id("twotabsearchtextbox"));
        searchField.sendKeys("iPhone 7");
        WebElement firstSuggestion = wait.until(visibilityOfElementLocated(By.id("issDiv0")));
        String firstSuggestionText = firstSuggestion.getText();

        // assert(verification) - > used standart Java assert
        assert "iphone 7 plus case".equals(firstSuggestionText);
    }

    // Аналог @AfterClass in JUnit
    private static void afterAll() {
        driver.quit();
    }

}
