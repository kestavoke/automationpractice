package com.automationpractice.pages;

import net.thucydides.core.annotations.Managed;
import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class OrderConfirmationPage extends PageObject {

    @Managed
    private WebDriver driver;

    public OrderConfirmationPage(WebDriver driver) {
        this.driver = driver;
    }

    @FindBy(className = "cheque-indent")
    WebElement ORDER_CONF_MSG;

    public void confirmOrderMSG() {
        ORDER_CONF_MSG.isDisplayed();
        System.out.println(ORDER_CONF_MSG.getText());
    }
}
