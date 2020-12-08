package com.automationpractice.pages;

import net.thucydides.core.annotations.Managed;
import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MyAccountPage extends PageObject {

    @Managed
    private WebDriver driver;

    public MyAccountPage(WebDriver driver) {
        this.driver = driver;
    }

    @FindBy(xpath = "//span[contains(text(), 'My account')]")
    WebElement MY_ACCOUNT;

    @FindBy(xpath = "//*[contains(text(),'Order history and details')]")
    WebElement ORDER_HISTORY_MENU;

    @FindBy(xpath = "//*[@id=\"header\"]/div[2]/div/div/nav/div[2]")
    WebElement SIGN_OUT_MENU;


    public void validateUserIsLoggedIn() {
        MY_ACCOUNT.isDisplayed();
    }

    public void orderHistoryMenu() {
        ORDER_HISTORY_MENU.click();
    }

    public void logOutButton() {
        SIGN_OUT_MENU.click();
    }

}
