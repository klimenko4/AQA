package ua.kiev.prog.week2.pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

import static org.openqa.selenium.By.cssSelector;
import static org.openqa.selenium.By.id;

public class FormPageWithBys {


    private static final String URL = "http://derp-bear.herokuapp.com/forms/basic_form_example";
    private WebDriver driver;

    private final By byName = By.id("first_name");
    private final By byLastName = By.id("last_name");
    private final By byEmail = By.id("email");

    public FormPageWithBys(WebDriver driver) {
        this.driver = driver;
    }

    public FormPageWithBys open() {
        driver.get(URL);
        return this;
    }


    public FormPageWithBys enterFirstName(String name) {
        driver.findElement(byName).sendKeys(name);
        return this;
    }


    public FormPageWithBys enterLastName(String lastName) {

        driver.findElement(byLastName).sendKeys(lastName);
        return this;
    }


    public FormPageWithBys enterEmail(String email) {
        driver.findElement(byEmail).sendKeys(email);
        return this;
    }


    public FormPageWithBys enterWebsiteUrl(String url) {
        driver.findElement(cssSelector("#website_url")).sendKeys(url);
        return this;
    }


    public FormPageWithBys selectPet(Pets pet) {
        driver.findElement(cssSelector("button#pet_select")).click();

        new Actions(driver).
                moveToElement(driver.findElement(cssSelector(String.format("li[rel='%d']", pet.ordinal())))).
                click().
                perform();

        return this;
    }

    public FormPageWithBys enterBirthDate(String date) {
        driver.findElement(cssSelector("input#date_of_birth")).sendKeys(date);
        return this;
    }


    public FormPageWithBys selectSex(String sex) {
        driver.findElement(cssSelector(String.format("label[for='%s']", sex))).click();
        return this;
    }

    public FormPageWithBys selectCommutingType(CommutingType type) {
        driver.findElement(cssSelector(String.format("label[for='%s']", type.name().toLowerCase()))).click();
        return this;
    }

    public ResultPage submit() {
        driver.findElement(id("submit_button")).click();
        return new ResultPage(driver);
    }
}
