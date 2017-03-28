package ua.kiev.prog.week1;

import org.openqa.selenium.support.ui.ExpectedCondition;

public class CustomConditions {

    private static ExpectedCondition<Boolean> hasTitle(String title) {
        return webDriver -> webDriver.getTitle().equals(title);
    }
}
