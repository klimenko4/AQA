package ua.kiev.prog.week3.pageobject;

import ua.kiev.prog.week3.wrappers.ConciseAPI;

import static ua.kiev.prog.week3.utils.CoreConstants.SITE_URL;
import static ua.kiev.prog.week3.wrappers.WebDriverProvider.getDriver;

public abstract class BasePage extends ConciseAPI {

    public void openPage() {
        getDriver().get(getPageUrl());
    }

    private String getPageUrl() {
        return SITE_URL;
    }

}
