package com.automationpractice.pages;

import net.thucydides.core.annotations.Managed;
import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AddressPage extends PageObject {

    @Managed
    private WebDriver driver;

    /**
     * This Class extends the PageObject class and declare a Constructor
     * */
    public AddressPage(WebDriver driver) {
        this.driver = driver;
    }

    @FindBy(name = "processAddress")
    WebElement CHECKOUT_OPTION;

    public void proceedToCheckOut() {
        CHECKOUT_OPTION.click();
    }

}
