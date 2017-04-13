package ua.kiev.prog.week3.pageobject;

import org.apache.commons.lang3.math.NumberUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import ua.kiev.prog.week3.enums.PriceRange;

import java.util.List;

import static java.util.stream.Collectors.toList;
import static ua.kiev.prog.week3.waitconditions.ElementCondition.clickable;

public class HotlineResultPage extends BasePage {


    By prices = By.cssSelector("#catalogue div.text-14.text-13-480.orng");

    public HotlineResultPage selectPriceRange(PriceRange range) {
        By priceRangeLocator = By.cssSelector(String.format("#filters > div.cell.group-gr-185.full-list div:nth-child(%d)>a", range.getIndex()));
        WebElement element = waitFor(priceRangeLocator, clickable);
        executeJavaScript("arguments[0].click();", element);
        return new HotlineResultPage();
    }


    public List<Integer> selectAllPrices() {
        final String regex = "[а-яА-Я\\s\\u2009]";

        return findAll(prices).
                stream().
                map(WebElement::getText).
                map(s -> NumberUtils.toInt(s.replaceAll(regex, ""), 0)).
                collect(toList());
    }

    public int findProductWithMaxPrice() {
        return selectAllPrices().stream().mapToInt(i -> i).max().orElse(0);
    }

}