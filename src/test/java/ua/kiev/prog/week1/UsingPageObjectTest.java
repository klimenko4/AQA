package ua.kiev.prog.week1;

import org.junit.Assert;
import org.junit.Test;
import ua.kiev.prog.week1.fixtures.BaseTest;
import ua.kiev.prog.week2.pagefactory.FormPageWithPF;
import ua.kiev.prog.week2.pageobject.CommutingType;
import ua.kiev.prog.week2.pageobject.Pets;
import ua.kiev.prog.week2.pageobject.ResultPage;

public class UsingPageObjectTest extends BaseTest {

    @Test
    public void fillForm() {

        FormPageWithPF formPage = new FormPageWithPF(driver);
        ResultPage resultPage = formPage.open().
                enterFirstName("firstName").
                enterLastName("lastName").
                enterEmail("email@gmail.com").
                enterWebsiteUrl("http://rozetka.com.ua/").
                selectPet(Pets.DOG).
                selectSex("female").
                enterBirthDate("09221991").
                selectCommutingType(CommutingType.WALK).
                submit();

        String headerMessage = resultPage.getHeaderMessage();
        String expectedMessage = "Thank you for submitting the form";


        Assert.assertEquals(expectedMessage, headerMessage);

    }
}
