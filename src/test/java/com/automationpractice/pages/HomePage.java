package com.automationpractice.pages;

import com.automationpractice.filemanager.FileReaderManager;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.concurrent.TimeUnit;

public class HomePage extends PageObject {

    @Managed
    private WebDriver driver;

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    @FindBy(css = ".header_user_info a")
    WebElement signIn;

    @FindBy(xpath = "//*[@id='block_top_menu']/ul/li[3]/a")
    WebElement T_SHIRT;

    @FindBy(xpath = "//*[@id=\"block_top_menu\"]/ul/li[2]/a")
    WebElement DRESSES;

    @FindBy(xpath = "//*[@id=\"block_top_menu\"]/ul/li[1]/a")
    WebElement WOMEN;

    @FindBy(id = "contact-link")
    WebElement contactLink;

    /**
     * Methods navigates the page to the application Homepage. It calls the FileManager Class methods
     * */
    public void applicationHomePage() {
        driver = getDriver();
        driver.get(FileReaderManager.getInstance().getConfigFileReader().getApplicationUrl());
        if (FileReaderManager.getInstance().getConfigFileReader().getBrowserWindowSize())
            driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(FileReaderManager.getInstance().getConfigFileReader().getImplicitlyWait(), TimeUnit.SECONDS);
        setDriver(driver);
    }

    public void ensurePageLoad() {
        signIn.isDisplayed();
    }

    public void validatePageTitle(){
        System.out.println("Page title is : " + driver.getTitle());
    }

    public void signInOption() {
        signIn.click();
    }

    public void SHIRTCat_MENU() {
        T_SHIRT.click();
    }

    public void DRESSCat_MENU() {
        DRESSES.click();
    }

    public void WOMENCat_MENU() {
        WOMEN.click();
    }

    public void CONTACT_US() {
        contactLink.click();
    }
}
