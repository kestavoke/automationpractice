package com.automationpractice.pages;

import net.thucydides.core.annotations.Managed;
import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class ProductCategoriesPage extends PageObject {

    @Managed
    private WebDriver driver;

    public ProductCategoriesPage(WebDriver driver) {
        this.driver = driver;
    }

    /**
     * Method to Scroll to the middle of the current page
     */
    public void verticalScrollBarMethod() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,500)");
    }

    @FindBy(xpath = "//*[contains(text(), 'More')]")
    WebElement t_MORE;

    @FindBy(xpath = "//*[@id=\"center_column\"]/ul/li[3]/div/div[2]/div[2]/a[2]/span")
    WebElement d_MORE;

    @FindBy(id = "quantity_wanted")
    WebElement ITEM_QTY;

    @FindBy(name = "Submit")
    WebElement ADD_TO_CART;

    @FindBy(className = "available-now")
    WebElement QuickView;

    @FindBy(xpath = "//*[@id=\"layer_cart\"]/div[1]/div[2]/div[4]/span")
    WebElement ContinueShopping;

    @FindBy(xpath = "//*[contains(text(),'Proceed to checkout')]")
    WebElement CHECKOUT_OPTION;

    private HomePage homePage;

    public void tSHIRT_Category() {
        homePage.SHIRTCat_MENU();
    }

    public void DRESS_Category() {
        homePage.DRESSCat_MENU();
    }

    public void clickMoreOption() {
        verticalScrollBarMethod();

        /**
         * Action Class to hover a Product clicking on the VIEW MORE
         * */
        Actions builder = new Actions(driver);
        Action mouseOverHome = builder
                .moveToElement(QuickView)
                .build();
        mouseOverHome.perform();
        t_MORE.click();
    }

    /**
     * Method to increase Product quantity
     * */
    public void add_Item_Qty(String qty) {
        ITEM_QTY.clear();
        ITEM_QTY.sendKeys(qty);
    }

    public void addItemToCart() {
        ADD_TO_CART.click();
    }

    public void continueShoppingOption() {
        driver.switchTo().activeElement();
        ContinueShopping.click();
    }

    public void proceedToCheckOut() {
        driver.switchTo().activeElement();
        CHECKOUT_OPTION.click();
    }


}
