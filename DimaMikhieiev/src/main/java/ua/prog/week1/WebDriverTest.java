package ua.prog.week1;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebDriverTest {

    private static WebDriver driver;
    private static WebDriverWait wait;

    @BeforeClass
    public static void setUp() throws Exception {
        System.setProperty("webdriver.chrome.driver", "/Users/dmytro-mikhieiev/IdeaProjects/maven_2/drivers/chromedriver");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        // driver.manage().window().setSize(new Dimension(1024,768));
        // wait = new WebDriverWait (driver, 4);
    }

    @Test
    public void firstTest() throws Exception {
        driver.get("http://derp-bear.herokuapp.com/forms/basic_form_example");

        WebElement firstname = driver.findElement(By.id("first_name"));
        firstname.clear();
        firstname.sendKeys("Oleg");

        WebElement lastname = driver.findElement(By.id("last_name"));
        lastname.clear();
        lastname.sendKeys("Family");

        WebElement email = driver.findElement(By.id("email"));
        email.clear();
        email.sendKeys("oleg.family@gmail.com");

        WebElement websiteurl = driver.findElement(By.id("website_url"));
        websiteurl.clear();
        websiteurl.sendKeys("http://olegfamily.com");


        WebElement petselect = driver.findElement(By.cssSelector(".filter-option.pull-left"));
        petselect.click();
        WebElement dog = (new WebDriverWait(driver, 10)).until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Dog")));
        dog.click();


    // ??? using other buttons
        WebElement dateofbirth = driver.findElement(By.id("date_of_birth"));
        dateofbirth.sendKeys("09.02.1991");


        WebElement gender = driver.findElement(By.cssSelector("#sex_information > fieldset > ol > li > div > div > label:nth-child(1)"));
        gender.click();

        WebElement bike = (new WebDriverWait(driver, 10)).until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#transportation_example > fieldset > ol > li > div > div > label:nth-child(1) > span")));
        bike.click();
        WebElement car = driver.findElement(By.cssSelector("#transportation_example > fieldset > ol > li > div > div > label:nth-child(2) > span"));
        car.click();

        WebElement passwordfield = driver.findElement(By.id("password_field"));
        passwordfield.sendKeys("123456");

        WebElement freetextarea = driver.findElement(By.id("free_text_area"));
        freetextarea.sendKeys("Hello World!!!");

        WebElement readonlytextarea = driver.findElement(By.id("read_only_text_area"));
        String readonlytestareaText = readonlytextarea.getText();
        Assert.assertEquals("This text is read only!", readonlytestareaText);


    // ??? Contains some value
        WebElement hiimhidden = driver.findElement(By.id("hi_im_hidden"));
        String script = "return arguments[0].innerText";
        String n = ((JavascriptExecutor) driver).executeScript(script, hiimhidden).toString();
        Assert.assertEquals("", n);



        WebElement submitbutton = driver.findElement(By.id("submit_button"));
        submitbutton.click();

    }

//    @Test
//    public void testAmazon() throws Exception {
//        driver.get("https://www.amazon.com");
//        WebElement searchField = driver.findElement(By.id("twotabsearchtextbox"));
//        searchField.sendKeys("iPhone 7");
//
//        WebElement firstSuggestion = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("issDiv0")));
//        String firstSuggestionText = firstSuggestion.getText();
//
//        System.out.println(firstSuggestionText);
//
//        Assert.assertEquals("iphone 7 plus case", firstSuggestionText);
//        firstSuggestion.click();
//
//    }

    @AfterClass
    public static void tearDown() throws Exception {
        //driver.quit();  - закрывает само окно браузера
        //driver.close(); - закрывает вкладку
    }


}
