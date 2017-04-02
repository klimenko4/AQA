package ua.prog.week2;

import org.junit.Assert;
import org.junit.Test;
import ua.prog.fixtures.BaseTest;
import ua.prog.week2.pagefactory.FormPageWithPF;
import ua.prog.week2.pageobject.ResultPage;

/**
 * Created by dmytro-mikhieiev on 30.03.17.
 */
public class PageObjectTest extends BaseTest {

    private FormPageWithPF formPage = new FormPageWithPF(driver);

    @Test
    public void fillForm() {

        formPage.openPage().
                searchField("iphone").
                range().
                webElements()

//
//        formPage.openPage();
//        ResultPage resultPage = formPage.
//                enterFirstName("firstName").
//                enterLastName("lastName").
//                enterEmail("email@gmail.com").
//                enterWebsiteUrl("http://rozetka.com.ua/").
//                selectPet(DOG).
//                selectSex("female").
//                enterBirthDate("09221991").
//                selectCommutingType(CommutingType.WALK).
//                submit();
//
//        String headerMessage = resultPage.getHeaderMessage();
//        String expectedMessage = "Thank you for submitting the form";
//
//        Assert.assertEquals(expectedMessage, headerMessage);





    }
}
