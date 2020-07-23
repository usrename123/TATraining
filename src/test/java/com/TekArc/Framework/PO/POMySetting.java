package com.TekArc.Framework.PO;

import com.TekArc.Framework.Utilities.TestBase;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class POMySetting extends TestBase{
    public POMySetting(WebDriver driver){
       TestBase.driver =driver;
       PageFactory.initElements(driver, this);
    }
    
    @FindBy(xpath = "//a[contains(text(),'My Settings')]")
    WebElement mySettinElement;
    @FindBy(xpath = "//div[@id='PersonalInfo']//a[@class='header setupFolder']")
    WebElement personal_headingElement;
    @FindBy(xpath = "//div[@id='PersonalInfo_child']/div[8]")
    WebElement persona_lInfoElement;
    @FindBy(xpath = "//a[contains(text(),'Download login history for last six months, includ')]")
    WebElement download_loginHistory;
    @FindBy(xpath = "//div[@id='DisplayAndLayout']//a[@class='header setupFolder']")
    WebElement headerSetUp_folder;
    @FindBy(xpath = "//span[@id='CustomizeTabs_font']")
    WebElement customize_TabElement;
    @FindBy(xpath = "//div[@id='EmailSetup']//a[@class='header setupFolder']")
    WebElement header_setUpElement;
    @FindBy(xpath = "//a[@id='EmailSettings_font']")
    WebElement email_setting_foElement;
    // @FindBy(xpath = "//input[@id='sender_name']")
    // WebElement sender_namElement;
    // @FindBy(xpath = "//input[@id='sender_email']")
    // WebElement sender_emaiElement;
    @FindBy(css = "#auto_bcc1")
    WebElement autoElement;
    @FindBy(xpath = "//span[contains(text(),'Calendar & Reminders')]")
    WebElement calender_reminderElement;
    @FindBy(xpath = "//a[@id='Reminders_font']")
    WebElement reminderFont;
    @FindBy(xpath = "//input[@id='testbtn']")
    WebElement test_btnElement;
    @FindBy(xpath = "//img[@class='rightArrowIcon']")
    WebElement right_arrow_icon;
    @FindBy(css = "#duel_select_0")
    WebElement dropdowElement;






    public void My_setting() throws Exception {
        oBroUti.ufClick(driver, mySettinElement,oCons.WAIT_COMMON);
    oBroUti.ufClick(driver, personal_headingElement, oCons.WAIT_COMMON);
    oBroUti.ufClick(driver, persona_lInfoElement, oCons.WAIT_COMMON);
    oBroUti.ufClick(driver, download_loginHistory,oCons.WAIT_COMMON);
    oBroUti.ufClick(driver, headerSetUp_folder,oCons.WAIT_COMMON);
    oBroUti.ufClick(driver, customize_TabElement,oCons.WAIT_COMMON);
    WebElement drop_down=driver.findElement(By.cssSelector("#p4"));
Select s= new Select(drop_down);
Thread.sleep(2000L);
s.selectByValue("02u3h000001DW6L");
oBroUti.ufClick(driver, dropdowElement,oCons.WAIT_COMMON);
//WebElement drop_down2=driver.findElement(By.cssSelector("#duel_select_0"));
Select s2= new Select(dropdowElement);
Thread.sleep(2000L);
s2.selectByValue("report");
oBroUti.ufClick(driver, right_arrow_icon,oCons.WAIT_COMMON);
oBroUti.ufClick(driver, header_setUpElement, oCons.WAIT_COMMON);
oBroUti.ufClick(driver, email_setting_foElement, oCons.WAIT_COMMON);
WebElement sender_namElement= driver.findElement(By.xpath("//input[@id='sender_name']"));
sender_namElement.clear();
sender_namElement.sendKeys("Aruna bindra");
WebElement sender_emaiElement= driver.findElement(By.xpath("//input[@id='sender_email']"));
sender_emaiElement.clear();
sender_emaiElement.sendKeys("aruna.bindra@rediffmail.com");
oBroUti.ufClick(driver, autoElement,oCons.WAIT_COMMON);
oBroUti.ufClick(driver, calender_reminderElement,oCons.WAIT_COMMON);
oBroUti.ufClick(driver, reminderFont,oCons.WAIT_COMMON);
oBroUti.ufClick(driver, test_btnElement,oCons.WAIT_COMMON);






    }
    
}
