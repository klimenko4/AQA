package ua.kiev.prog.week3.wrappers;

import org.testng.IClassListener;
import org.testng.ITestClass;

public class BeforeClassWebDriverProvider extends WebDriverProvider implements IClassListener {

    @Override
    public void onBeforeClass(ITestClass testClass) {
        setupDriver();
    }

    @Override
    public void onAfterClass(ITestClass testClass) {
        cleanUp();
    }
}
