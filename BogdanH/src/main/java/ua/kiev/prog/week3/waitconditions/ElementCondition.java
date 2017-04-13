package ua.kiev.prog.week3.waitconditions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.function.Function;

public enum ElementCondition {
    visible(ExpectedConditions::visibilityOfElementLocated),
    clickable(ExpectedConditions::elementToBeClickable);

    private final Function<By, ExpectedCondition<WebElement>> type;

    ElementCondition(Function<By, ExpectedCondition<WebElement>> type) {
        this.type = type;
    }

    public Function<By, ExpectedCondition<WebElement>> getType() {
        return type;
    }
}
