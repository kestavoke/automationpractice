package com.automationpractice.pages;

import net.thucydides.core.annotations.Managed;
import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ShoppingCartSummaryPage extends PageObject {

    @Managed
    private WebDriver driver;

    public ShoppingCartSummaryPage(WebDriver driver) {
        this.driver = driver;
    }

    public void verticalScrollBarMethod() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,500)");
    }

    @FindBy(xpath = "//*[@id=\"center_column\"]/p[2]/a[1]")
    WebElement CHECKOUT_OPTION;

    /**
     * Method is used to Proceed to Check out
     * */
    public void proceedToCheckOut() {
        verticalScrollBarMethod();
        CHECKOUT_OPTION.click();
    }

}
