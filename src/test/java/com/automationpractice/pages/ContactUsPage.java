package com.automationpractice.pages;

import net.thucydides.core.annotations.Managed;
import net.thucydides.core.pages.PageObject;
import org.junit.Assert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import java.awt.*;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.util.List;

public class ContactUsPage extends PageObject {

    @Managed
    private WebDriver driver;

    public ContactUsPage(WebDriver driver) {
        this.driver = driver;
    }

    /**
     * Declare WebElements at the class level
     * */

    @FindBy(id = "id_contact")
    WebElement SUBJECT_HEADING;

    @FindBy(id = "email")
    WebElement EMAIL_FIELD;

    @FindBy(id = "id_order")
    WebElement ORDER_ID;

    @FindBy(id = "uniform-fileUpload")
    WebElement FILE_UPLOAD;

    @FindBy(id = "message")
    WebElement MESSAGE_FIELD;

    @FindBy(id = "submitMessage")
    WebElement SEND_BUTTON;

    @FindBy(className = "alert-success")
    WebElement SUCCESS_MSG;


    public void verticalScrollBarMethod() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,500)");
    }

    public void submitButton() {
        verticalScrollBarMethod();
        SEND_BUTTON.isDisplayed();
    }

    public void chooseSubjectHeading(String subject) {
        int stateCount = 0;
        String[] inputState = {subject};

        Select listOfState = new Select(SUBJECT_HEADING);
        List<WebElement> stateOptions = listOfState.getOptions();
        for (WebElement states : stateOptions) {
            for (int i = 0; i < inputState.length; i++) {
                if (states.getText().equalsIgnoreCase(inputState[i])) {
                    stateCount++;
                }
            }
        }
        if (stateCount == inputState.length) {
            listOfState.selectByVisibleText(subject);
        } else {
            Assert.fail("Invalid " + subject + " option selected");
        }
    }

    public void enterEmailId(String email) {
        EMAIL_FIELD.sendKeys(email);
    }

    public void enterOrderId(String order_Id) {
        ORDER_ID.sendKeys(order_Id);
    }

    /**
     * Methods to is used to upload a file on the Contact us File upload field
     *
     * */
    public void uploadFile(String filePath) throws AWTException, InterruptedException {
        FILE_UPLOAD.click();
        Thread.sleep(3000);
        StringSelection chooseFile = new StringSelection(filePath);
        Toolkit.getDefaultToolkit().getSystemClipboard().setContents(chooseFile, null);

        Robot robot = new Robot();
        robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyRelease(KeyEvent.VK_ENTER);
        robot.keyPress(KeyEvent.VK_CONTROL);
        robot.keyPress(KeyEvent.VK_V);
        robot.keyRelease(KeyEvent.VK_V);
        robot.keyRelease(KeyEvent.VK_CONTROL);
        robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyRelease(KeyEvent.VK_ENTER);

    }

    public void enterMessage(String msg) {
        MESSAGE_FIELD.sendKeys(msg);
    }

    public void sendButton() {
        SEND_BUTTON.click();
    }

    public void conf_message() {
        SUCCESS_MSG.isDisplayed();
        System.out.println(SUCCESS_MSG.getText());
    }

}
