package ua.kiev.prog.week1;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class SubmitFormTest {

    static WebDriver driver;
    static WebDriverWait wait;


    @BeforeClass
    public static void beforeAll() {
        System.setProperty("webdriver.chrome.driver", "D:\\projects\\AQA\\drivers\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, 4);

    }

    @Test
    public void submitForm() {
        driver.get("http://derp-bear.herokuapp.com/forms/basic_form_example");
        driver.findElement(By.id("first_name")).sendKeys("TestName");
        driver.findElement(By.id("last_name")).sendKeys("Test Lastname");
        driver.findElement(By.id("email")).sendKeys("mail@mail.com");
        driver.findElement(By.id("website_url")).sendKeys("http://www.google.com.ua");
        driver.findElement(By.cssSelector(".btn-group.select.btn-md.btn-primary")).click();
        WebElement dropdownMenu = wait.until(ExpectedConditions.visibilityOfElementLocated(By
                .cssSelector(".btn-primary.open ul li:nth-child(2)")));
        dropdownMenu.click();

    }

    @After
    public void tearDown() {
//        driver.quit();

    }
}
