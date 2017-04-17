package ua.kiev.prog.week1;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CustomConditions {



    // interface
    // abstract classes
    // anon class
//    private static ExpectedCondition<Boolean> hasTitle(String title) {
//        return webDriver -> webDriver.getTitle().equals(title);
//    }


    public static ExpectedCondition<Boolean> titleContainsWord(String wordToSearch) {
        return driver -> driver.getTitle().contains(wordToSearch);
    }


    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        WebDriverWait wait = new WebDriverWait(driver,4);
        wait.until(CustomConditions.titleContainsWord("word"));
        wait.until(new CustomCondition2("word"));
    }
}

class CustomCondition2 implements ExpectedCondition<Boolean>{

    private String wordToSearch;

    public CustomCondition2(String word) {
        this.wordToSearch = word;
    }

    @Override
    public Boolean apply(WebDriver driver) {
        return driver.getTitle().contains(wordToSearch);
    }
}
