package com.automationpractice.pages;

import net.thucydides.core.annotations.Managed;
import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ShippingPage extends PageObject {

    @Managed
    private WebDriver driver;

    public ShippingPage(WebDriver driver) {
        this.driver = driver;
    }

    @FindBy(name = "processCarrier")
    WebElement CHECKOUT_OPTION;

    @FindBy(id = "uniform-cgv")
    WebElement TERMS_CONDITIONS;

    public void termsAndConditions() {
        TERMS_CONDITIONS.click();
    }

    public void proceedToCheckOut() {
        CHECKOUT_OPTION.click();
    }
}
