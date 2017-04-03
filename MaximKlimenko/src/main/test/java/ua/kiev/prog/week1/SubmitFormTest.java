package ua.kiev.prog.week1;

import io.github.bonigarcia.wdm.ChromeDriverManager;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
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
        ChromeDriverManager.getInstance().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, 4);

    }

    @Test
    public void submitForm() throws InterruptedException {
        driver.get("http://derp-bear.herokuapp.com/forms/basic_form_example");
        driver.findElement(By.id("first_name")).sendKeys("TestName");
        driver.findElement(By.id("last_name")).sendKeys("Test Lastname");
        driver.findElement(By.id("email")).sendKeys("mail@mail.com");
        driver.findElement(By.id("website_url")).sendKeys("http://www.google.com.ua");
        driver.findElement(By.cssSelector(".btn-group.select.btn-md.btn-primary")).click();
        WebElement dropdownMenu = wait.until(ExpectedConditions.visibilityOfElementLocated(By
                .cssSelector(".btn-primary.open ul li:nth-child(2)")));
        dropdownMenu.click();
        driver.findElement(By.id("date_of_birth")).sendKeys("02/02/2222");
        WebElement maleRadioButton = driver.findElement(By.cssSelector(".radio.radio-inline:nth-child(1) span"));
        maleRadioButton.click();
        WebElement carCheckbox = driver.findElement(By.cssSelector(".checkbox:nth-child(2) .icons span.fui-checkbox-checked"));
        carCheckbox.click();
        driver.findElement(By.id("password_field")).sendKeys("passwordIsHere");
        driver.findElement(By.id("free_text_area")).sendKeys("someTextHere");
        ((JavascriptExecutor) driver)
                .executeScript("$(\"#read_only_text_area\").attr(\"readonly\", false);");
        WebElement readOnly = wait.until(ExpectedConditions
                .visibilityOfElementLocated(By.id("read_only_text_area")));
        readOnly.sendKeys("Now it is not readonly area");

        //isn`t work
//        ((JavascriptExecutor) driver)
//                .executeScript("document.getElementById(\"hi_im_hidden\").style.visibility = \"visible\";");
//        WebElement hiddenField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("hi_im_hidden")));
//        hiddenField.sendKeys("It isn`t hidden now");


        driver.findElement(By.id("submit_button")).click();
        Assert.assertEquals(driver.findElement(By.cssSelector("#results header h1")).getText(),"Thank you for submitting the form");


    }

    @After
    public void tearDown() {
        driver.quit();

    }
}
