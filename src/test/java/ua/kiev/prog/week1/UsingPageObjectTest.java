package ua.kiev.prog.week1;

import org.junit.Assert;
import org.junit.Test;
import ua.kiev.prog.week1.fixtures.BaseTest;
import ua.kiev.prog.week2.pagefactory.FormPageWithPF;
import ua.kiev.prog.week2.pageobject.CommutingType;
import ua.kiev.prog.week2.pageobject.ResultPage;

import static ua.kiev.prog.week2.pageobject.Pets.DOG;

public class UsingPageObjectTest extends BaseTest {

    // identical to creating pageobject in @Before method
   private FormPageWithPF formPage = new FormPageWithPF(driver);


    @Test
    public void fillForm() {


        formPage.openPage();
        ResultPage resultPage = formPage.
                enterFirstName("firstName").
                enterLastName("lastName").
                enterEmail("email@gmail.com").
                enterWebsiteUrl("http://rozetka.com.ua/").
                selectPet(DOG).
                selectSex("female").
                enterBirthDate("09221991").
                selectCommutingType(CommutingType.WALK).
                submit();

        String headerMessage = resultPage.getHeaderMessage();
        String expectedMessage = "Thank you for submitting the form";

        Assert.assertEquals(expectedMessage, headerMessage);

    }
}
