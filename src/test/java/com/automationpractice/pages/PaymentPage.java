package com.automationpractice.pages;

import net.thucydides.core.annotations.Managed;
import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PaymentPage extends PageObject {

    @Managed
    private WebDriver driver;

    public PaymentPage(WebDriver driver) {
        this.driver = driver;
    }

    @FindBy(xpath = "//*[contains(text(),'I confirm my order')]")
    WebElement CONFIRM_ORDER;

    @FindBy(xpath = "//*[contains(text(),'Pay by bank wire')]")
    WebElement PAYMENT_OPTION;

    public void paymentOption() {
        PAYMENT_OPTION.click();
    }

    public void confirmOrder() {
        CONFIRM_ORDER.click();
    }
}
