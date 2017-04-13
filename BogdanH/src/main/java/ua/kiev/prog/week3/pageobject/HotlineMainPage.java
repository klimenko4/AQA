package ua.kiev.prog.week3.pageobject;

import org.openqa.selenium.By;

import static org.openqa.selenium.Keys.ENTER;

public class HotlineMainPage extends BasePage {

    By searchbox = By.id("searchbox");

    public HotlineResultPage searchFor(String text) {
        type(searchbox, text + ENTER);
        return new HotlineResultPage();
    }
}