package com.automationpractice.pages;

import com.automationpractice.filemanager.OrderReference;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.io.IOException;
import java.util.List;

public class OrderHistoryPage extends PageObject {

    @Managed
    private WebDriver driver;

    WebElement orderID = null;
    String strOrderNumber =null;

    public OrderHistoryPage(WebDriver driver) {
        this.driver = driver;
    }

    @FindBy(className = "info-title")
    WebElement ORDER_HISTORY_PAGE;

    @FindBy(id = "order-list")
    WebElement ORDER_HISTORY_TABLE;

    public void validateOrderHistoryPage(){
        ORDER_HISTORY_PAGE.isDisplayed();
        System.out.println(ORDER_HISTORY_PAGE.getText());
    }

    /**
     * Methods Loops through the User's Order History Table and get the Order reference number
     * */
    public void loopThroughMyOrderTable() {
        WebElement dataTB = ORDER_HISTORY_TABLE;
        List<WebElement> lstRows = dataTB.findElement(By.tagName("tbody")).findElements(By.tagName("tr"));

        for (WebElement eleRow : lstRows) {
            String orderReferenceFromTable = "";

            List<WebElement> lstColumns = eleRow.findElements(By.tagName("td"));

            for (WebElement eleColumn : lstColumns) {
                if (eleColumn.getText().equalsIgnoreCase("Order reference")) {
                    orderReferenceFromTable = eleColumn.getText();
                }
            }
            if (orderReferenceFromTable !=null) {
                orderID = lstColumns.get(lstColumns.size() - 7);
            }
        }

    }

    /**
     * Method to write the order number to a text file
     * */
    public void getOrderInformation(String fileName) throws IOException {
        OrderReference orderReference = new OrderReference();
        strOrderNumber = orderID.getText();
        if (!strOrderNumber.isEmpty()) {
            orderReference.createOrderReference(fileName, strOrderNumber);
        }
    }
}
