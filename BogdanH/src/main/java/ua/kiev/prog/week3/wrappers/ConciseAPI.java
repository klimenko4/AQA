package ua.kiev.prog.week3.wrappers;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import ua.kiev.prog.week3.waitconditions.ElementCondition;
import ua.kiev.prog.week3.waitconditions.ElementsConditions;

import java.util.List;

import static ua.kiev.prog.week3.utils.CoreConstants.WAIT_TIMEOUT;
import static ua.kiev.prog.week3.waitconditions.ElementCondition.visible;
import static ua.kiev.prog.week3.wrappers.WebDriverProvider.getDriver;

public abstract class ConciseAPI {

    private final WebDriverWait wait;

    public ConciseAPI() {
        this.wait = new WebDriverWait(getDriver(), WAIT_TIMEOUT);
    }

//    private WebElement waitUntilElementIsVisible(By locator) {
//        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
//    }

    protected void click(By locator) {
        waitFor(locator, visible).click();
    }

    protected void type(By locator, CharSequence text) {
        waitFor(locator, visible).sendKeys(text);
    }

    protected WebElement waitFor(By locator, ElementCondition condition) {
        return wait.until(condition.getType().apply(locator));
    }

    protected List<WebElement> waitForAll(By locator, ElementsConditions condition) {
        return wait.until(condition.getType().apply(locator));
    }

    protected <T> T executeJavaScript(String jsCode, Object... arguments) {
        return (T) ((JavascriptExecutor) getDriver()).executeScript(jsCode, arguments);
    }

    protected WebElement find(By by) {
        return waitFor(by, visible);
    }

    protected List<WebElement> findAll(String cssSelectors) {
        return findAll(By.cssSelector(cssSelectors));
    }

    protected WebElement find(String cssSelectors) {
        return find(By.cssSelector(cssSelectors));
    }

    protected List<WebElement> findAll(By by) {
        return waitForAll(by, ElementsConditions.visibilityOfElements);
    }

}
