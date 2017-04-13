package ua.kiev.prog.week3.waitconditions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;
import java.util.function.Function;

public enum ElementsConditions {
    visibilityOfElements(ExpectedConditions::visibilityOfAllElementsLocatedBy);

    private final Function<By, ExpectedCondition<List<WebElement>>> type;

    ElementsConditions(Function<By, ExpectedCondition<List<WebElement>>> type) {
        this.type = type;
    }

    public Function<By, ExpectedCondition<List<WebElement>>> getType() {
        return type;
    }
}
