package ua.kiev.prog.week2;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import ua.kiev.prog.week1.fixtures.BaseTest;

import java.util.Set;

@SuppressWarnings("ALL")
public class WebDrverApiTest extends BaseTest {

    @Test
    public void testWindowHandles() throws Exception {

        driver.get("https://users.wix.com/signin");

        String originalWindow = driver.getWindowHandle();
        final Set<String> oldWindowsSet = driver.getWindowHandles();

        driver.findElement(By.cssSelector("button.signin-sozial-fazebook")).click();

        String newWindow = wait
                .until((ExpectedCondition<String>) driver -> {
                            Set<String> newWindowsSet = driver.getWindowHandles();
                            newWindowsSet.removeAll(oldWindowsSet);
                            return newWindowsSet.size() > 0 ?
                                    newWindowsSet.iterator().next() : null;
                        }
                );

        driver.switchTo().window(newWindow);

        System.out.println("New window title: " + driver.getTitle());
        driver.close();

        driver.switchTo().window(originalWindow);
        System.out.println("Old window title: " + driver.getTitle());

    }

    @Test
    public void testJSAlerts() throws Exception {

        driver.get("http://the-internet.herokuapp.com/javascript_alerts");

        driver.findElement(By.cssSelector("#content li:nth-child(1)>button")).click();
        Alert alert = driver.switchTo().alert();

        Thread.sleep(1000);
        //alert.accept();
        alert.dismiss();
    }

    @Test
    public void testJSConfirm() throws Exception {
        driver.get("http://the-internet.herokuapp.com/javascript_alerts");
        driver.findElement(By.cssSelector("#content li:nth-child(2)>button")).click();
        Alert alert = driver.switchTo().alert();
        Thread.sleep(1000);
        System.out.println(alert.getText());
        //alert.accept();
        alert.accept();
    }

    @Test
    public void testJSPrompt() throws Exception {
        driver.get("http://the-internet.herokuapp.com/javascript_alerts");
        driver.findElement(By.cssSelector("#content li:nth-child(3)>button")).click();
        Alert alert = driver.switchTo().alert();
        Thread.sleep(1000);
        alert.sendKeys("yo");
        //alert.accept();
        alert.accept();
    }

    @Test
    public void testFrames() throws Exception {
        driver.get("http://the-internet.herokuapp.com/tinymce");
        driver.switchTo().frame("mce_0_ifr");

        WebElement editor = driver.findElement(By.id("tinymce"));
        String textBefore = editor.getText();

        editor.clear();
        String typedText = "hi guys";
        editor.sendKeys(typedText);

        Assert.assertNotEquals(typedText, textBefore);

        driver.switchTo().defaultContent();
        Assert.assertTrue(!driver.findElement(By.tagName("h3")).getText().isEmpty());
    }
}