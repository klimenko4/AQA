package ua.kiev.prog.week2.pagefactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import ua.kiev.prog.week2.pageobject.BasePage;
import ua.kiev.prog.week2.pageobject.CommutingType;
import ua.kiev.prog.week2.pageobject.Pets;
import ua.kiev.prog.week2.pageobject.ResultPage;

import java.util.List;

import static org.openqa.selenium.By.cssSelector;
import static org.openqa.selenium.By.id;

public class FormPageWithPF extends BasePage {

    @FindBy(id = "first_name")
    private WebElement nameField;

    private WebElement last_name;

    @FindBy(css = "#email")
    @CacheLookup
    private WebElement emailField;

    @FindBy(className = ".class")
    List<WebElement> webElements;

    public FormPageWithPF(WebDriver driver) {
        super(driver);
        URL = "http://derp-bear.herokuapp.com/forms/basic_form_example";
    }

    public FormPageWithPF enterFirstName(String name) {
        nameField.sendKeys(name);
        return this;
    }

    public FormPageWithPF enterLastName(String lastName) {

        last_name.sendKeys(lastName);
        return this;
    }

    public FormPageWithPF enterEmail(String email) {
        emailField.sendKeys(email);
        return this;
    }

    public FormPageWithPF enterWebsiteUrl(String url) {
        driver.findElement(cssSelector("#website_url")).sendKeys(url);
        return this;
    }

    public FormPageWithPF selectPet(Pets pet) {
        driver.findElement(cssSelector("button#pet_select")).click();

        new Actions(driver).
                moveToElement(driver.findElement(cssSelector(String.format("li[rel='%d']", pet.ordinal())))).
                click().
                perform();

        return this;
    }

    public FormPageWithPF enterBirthDate(String date) {
        driver.findElement(cssSelector("input#date_of_birth")).sendKeys(date);
        return this;
    }

    public FormPageWithPF selectSex(String sex) {
        driver.findElement(cssSelector(String.format("label[for='%s']", sex))).click();
        return this;
    }

    public FormPageWithPF selectCommutingType(CommutingType type) {
        driver.findElement(cssSelector(String.format("label[for='%s']", type.name().toLowerCase()))).click();
        return this;
    }

    public ResultPage submit() {
        driver.findElement(id("submit_button")).click();
        return new ResultPage(driver);
    }

    @Override
    public String getURL() {
        return URL;
    }
}
