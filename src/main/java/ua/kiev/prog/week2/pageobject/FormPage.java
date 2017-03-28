package ua.kiev.prog.week2.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

import static org.openqa.selenium.By.cssSelector;
import static org.openqa.selenium.By.id;

public class FormPage {


    private WebDriver driver;

    public FormPage(WebDriver driver) {
        this.driver = driver;
    }

    public FormPage open() {
        driver.get("http://derp-bear.herokuapp.com/forms/basic_form_example");
        return this;
    }


    public FormPage enterFirstName(String name) {
        driver.findElement(cssSelector("#first_name")).sendKeys(name);
        return this;
    }


    public FormPage enterLastName(String lastName) {
        driver.findElement(cssSelector("#last_name")).sendKeys(lastName);
        return this;
    }


    public FormPage enterEmail(String email) {
        driver.findElement(cssSelector("#email")).sendKeys(email);
        return this;
    }


    public FormPage enterWebsiteUrl(String url) {
        driver.findElement(cssSelector("#website_url")).sendKeys(url);
        return this;
    }


    public FormPage selectPet(Pets pet) {
        driver.findElement(cssSelector("button#pet_select")).click();

        new Actions(driver).
                moveToElement(driver.findElement(cssSelector(String.format("li[rel='%d']", pet.ordinal())))).
                click().
                perform();

        return this;
    }

    public FormPage enterBirthDate(String date) {
        driver.findElement(cssSelector("input#date_of_birth")).sendKeys(date);
        return this;
    }


    public FormPage selectSex(String sex) {
        driver.findElement(cssSelector(String.format("label[for='%s']", sex))).click();
        return this;
    }

    public FormPage selectCommutingType(CommutingType type) {
        driver.findElement(cssSelector(String.format("label[for='%s']", type.name().toLowerCase()))).click();
        return this;
    }

    public ResultPage submit() {
        driver.findElement(id("submit_button")).click();
        return new ResultPage(driver);
    }
}
