package com.TekArc.Framework.PO;

import java.time.Duration;
import java.util.NoSuchElementException;

import com.TekArc.Framework.Utilities.TestBase;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

public class POHome extends TestBase {
    public POHome(WebDriver driver) {
        TestBase.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//div[@id='userNav-arrow']")
    WebElement user_menu_dropdown;
    @FindBy(xpath = "//a[contains(text(),'My Profile')]")
    WebElement my_profilElement;
    @FindBy(xpath = "//a[@class='contactInfoLaunch editLink']//img")
    WebElement profile_ediElement;
    @FindBy(xpath = "//input[contains(@class,'zen-btn zen-primaryBtn zen-pas')]")
    WebElement saveAll_bElement;
    @FindBy(xpath = "//li[@id='aboutTab']")
    WebElement about_tabElement;
    @FindBy(xpath = "//input[@id='lastName']")
    WebElement last_namElement;
    @FindBy(xpath = "//span[contains(@class,'publisherattachtext')][contains(text(),'Post')]")
    WebElement postLink_tab;
    @FindBy(xpath = "//iframe[@id='contactInfoContentId']")
    WebElement iFRAME_eElement;
    @FindBy(xpath = "//span[contains(@class,'publisherattachtext')][contains(text(),'File')]")
    WebElement fileClickElement;
    @FindBy(xpath = "//input[@id='publishersharebutton']")
    WebElement shareBtnElement;
    @FindBy(xpath = "//td[@id='chatterUploadFileActionPanel']/a")
    WebElement upload_fileElement;

    public void UserMenuDrodown() throws Exception {
        oBroUti.waitForElementVisible(driver, user_menu_dropdown, 15);
        oBroUti.ufClick(driver, user_menu_dropdown, 15);
       
    }

    public void MyProfile() throws Exception {
        oBroUti.waitForElementVisible(driver, my_profilElement, oCons.WAIT_COMMON);
        oBroUti.ufClick(driver, my_profilElement, 10);
        Wait<WebDriver> wait=new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(30))
	            .pollingEvery(Duration.ofSeconds(3)).ignoring(NoSuchElementException.class);
       
        oBroUti.ufClick(driver, profile_ediElement, 10);
       
        driver.switchTo().frame(iFRAME_eElement);
        oBroUti.ufClick(driver, about_tabElement, oCons.WAIT_COMMON);
        oBroUti.ufClick(driver, last_namElement, oCons.WAIT_COMMON);
        last_namElement.clear();
        oBroUti.ufSendKeys(driver, last_namElement, "annuRuna", oCons.WAIT_COMMON);
        oBroUti.ufClick(driver, saveAll_bElement, oCons.WAIT_COMMON);
        driver.switchTo().parentFrame();
    }

    public void postLink() throws Exception {
        oBroUti.waitForElementVisible(driver, postLink_tab, oCons.WAIT_COMMON);
        oBroUti.ufClick(driver, postLink_tab, oCons.WAIT_COMMON);
        Robot r2 = new Robot();
        for (int i = 0; i < 4; i++) {
            r2.keyPress(KeyEvent.VK_TAB);
            r2.keyRelease(KeyEvent.VK_TAB);
            r2.delay(1000);
        }
        for (int i = 0; i < 4; i++) {
            r2.keyPress(KeyEvent.VK_SHIFT);
            r2.keyPress(KeyEvent.VK_I);
            r2.keyPress(KeyEvent.VK_SPACE);
            r2.keyPress(KeyEvent.VK_A);
            r2.keyPress(KeyEvent.VK_M);
            r2.keyRelease(KeyEvent.VK_SHIFT);
        }
    }

    public void sharepost() throws AWTException{

  
 }
    public void fileLinkClick() throws Exception {
        oBroUti.waitForElementVisible(driver, fileClickElement, oCons.WAIT_COMMON);
        oBroUti.ufClick(driver, fileClickElement, oCons.WAIT_COMMON);

        oBroUti.waitForElementVisible(driver, upload_fileElement, 15);
        oBroUti.ufClick(driver, upload_fileElement, 10);

        Robot r2 = new Robot();
        r2.keyPress(KeyEvent.VK_TAB);
        r2.delay(1000);
        r2.keyPress(KeyEvent.VK_TAB);
        r2.delay(1000);
        r2.keyPress(KeyEvent.VK_ENTER);
        r2.delay(1000);
        r2.keyRelease(KeyEvent.VK_ENTER);
         Wait<WebDriver> wait=new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(30))
                 .pollingEvery(Duration.ofSeconds(3)).ignoring(ElementNotInteractableException.class);
               
        Runtime.getRuntime().exec("C://Users/annur/OneDrive/Desktop/autoituploadfile.exe");
        Thread.sleep(4000L);
      
        WebElement share = driver.findElement(By.cssSelector("#publishersharebutton"));
        oBroUti.waitForElementVisible(driver, share, oCons.WAIT_COMMON);
        share.click();
    }
}
