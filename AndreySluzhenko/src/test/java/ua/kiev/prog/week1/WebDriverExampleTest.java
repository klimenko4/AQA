package ua.kiev.prog.week1;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

@SuppressWarnings("ALL")
public class WebDriverExampleTest {

    static WebDriver driver;
    static WebDriverWait wait;

    @BeforeClass
    public static void beforeAll() {
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
        //System.setProperty("webdriver.gecko.driver", "driver/geckodriver.exe");

        driver = new ChromeDriver();

        driver.manage().window().maximize();
        //driver.manage().window().setSize(new Dimension(1024, 768));
        wait = new WebDriverWait(driver, 4);

    }

//    private HotLineMainPage mainPage = new Hot (driver);

    @Test
    public void testHotLine() {

        driver.get("https://hotl.com");
        WebElement q = driver.findElement(By.name("q"));
        q.sendKeys("selenide");
        q.sendKeys(Keys.ENTER);
        String text = driver.findElement(By.linkText("codeborne/selenide")).getText();

        Assert.assertTrue("codeborne/selenide".equals(text));
    }


    @Test
    public void testGitHub() {

        driver.get("https://github.com");
        WebElement q = driver.findElement(By.name("q"));
        q.sendKeys("selenide");
        q.sendKeys(Keys.ENTER);
        String text = driver.findElement(By.linkText("codeborne/selenide")).getText();

        Assert.assertTrue("codeborne/selenide".equals(text));
    }


    @Test
    public void searchSmartphoneOnAmazon() throws InterruptedException {

        driver.get("http://amazon.com");
        WebElement searchField = driver.findElement(By.id("twotabsearchtextbox"));
        searchField.sendKeys("iPhone 7");
        WebElement firstSuggestion = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("issDiv0")));
        String firstSuggestionText = firstSuggestion.getText();

        Assert.assertEquals("iphone 7 plus case", firstSuggestionText);

        firstSuggestion.click();

    }

    @Test
    public void showSmartphoneModels() throws InterruptedException {

        driver.get("http://amazon.com");
        WebElement searchField = driver.findElement(By.id("twotabsearchtextbox"));
        searchField.sendKeys("iphone", Keys.ENTER);
        List<WebElement> smartphones = driver.findElements(By.cssSelector("#s-results-list-atf li h2"));
        smartphones.stream().map(WebElement::getText).forEach(System.out::println);
    }


    @Test
    public void testTableFilter() {

        driver.navigate().to("https://the-internet.herokuapp.com/tables");
        List<WebElement> persons = driver.findElements(By.cssSelector("#table1 > tbody tr:nth-child(2n)"));
        persons.stream().map(WebElement::getText).forEach(System.out::println);

        String smith = driver.findElement(By.xpath(".//table[@id ='table1']//tbody//*[contains(text(),'Smith')]/..")).getText();
        System.out.println(smith);

    }


    @Test
    public void fillForm() throws Exception {
        driver.get("http://derp-bear.herokuapp.com/forms/basic_form_example");

        driver.findElement(By.cssSelector("#first_name")).sendKeys("James");
        driver.findElement(By.cssSelector("#last_name")).sendKeys("James");
        driver.findElement(By.cssSelector("#email")).sendKeys("email@gmail.com");
        driver.findElement(By.cssSelector("#website_url")).sendKeys("site.com");

/*
        Select pets = new Select(driver.findElement(By.cssSelector("select#pet_select")));
        pets.selectByValue("23");
*/

        driver.findElement(By.cssSelector("button#pet_select")).click();
        new Actions(driver).moveToElement(driver.findElement(By.cssSelector("li[rel='2']"))).click().perform();
        driver.findElement(By.cssSelector("input#date_of_birth")).sendKeys("10221991");
        driver.findElement(By.cssSelector("label[for='female']")).click();
        driver.findElement(By.cssSelector("label[for='car']")).click();
        driver.findElement(By.cssSelector("#hi_im_hidden")).sendKeys("fdsfds");

        ((JavascriptExecutor) driver).executeScript(
                "arguments[0].removeAttribute('readonly','readonly')", driver.findElement(By.cssSelector("#read_only_text_area")));
    }


/*    @After
    public void tearDown() throws Exception {
        driver.quit();
    }*/
}

