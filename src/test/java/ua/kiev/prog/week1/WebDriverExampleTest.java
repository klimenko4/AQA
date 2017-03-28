package ua.kiev.prog.week1;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import ua.kiev.prog.week1.fixtures.BaseTest;

import java.util.List;

import static java.util.concurrent.TimeUnit.SECONDS;

public class WebDriverExampleTest extends BaseTest {


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

    @Test
    public void rozetkaTest() {


        driver.get("http://rozetka.com.ua/");
        WebElement element = driver.findElement(By.xpath(".//*[contains(text(),'Смартфоны, ТВ и электроника')]/.."));

        Actions action = new Actions(driver);
        action.moveToElement(element).click().doubleClick().clickAndHold().
                build().perform();
        FluentWait wait1 = new FluentWait(driver)
                .withTimeout(30, SECONDS)
                .pollingEvery(5, SECONDS)
                .ignoring(NoSuchElementException.class);

        wait1.until(ExpectedConditions.titleIs("sdfsd"));
        driver.manage().addCookie(new Cookie("key","value"));

    }

    @Test
    public void select() {
        Select select = new Select(driver.findElement(By.id("")));
    }

    //    @After
//    public void tearDown() throws Exception {
//        driver.quit();
//    }
}

