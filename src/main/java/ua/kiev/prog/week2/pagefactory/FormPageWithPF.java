package ua.kiev.prog.week2.pagefactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import ua.kiev.prog.week2.pageobject.CommutingType;
import ua.kiev.prog.week2.pageobject.Pets;
import ua.kiev.prog.week2.pageobject.ResultPage;

import static org.openqa.selenium.By.cssSelector;
import static org.openqa.selenium.By.id;

public class FormPageWithPF {


    private static final String URL = "http://derp-bear.herokuapp.com/forms/basic_form_example";
    private WebDriver driver;

    @FindBy(id = "first_name")
    private WebElement nameField;

    //Page Factory search by id and name by default;
    private WebElement last_name;

    @FindBy(id = "email")
    @CacheLookup
    private WebElement emailField;

    public FormPageWithPF(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public FormPageWithPF open() {
        driver.get(URL);
        return this;
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
}
