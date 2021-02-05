package com.TekArc.Framework.PO;

import com.TekArc.Framework.Utilities.TestBase;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.DataProvider;

public class POLogin extends TestBase {
    public POLogin(WebDriver driver) {
        TestBase.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//input[@id='username']")
      WebElement username;

    @FindBy(xpath = "//input[@id='password']")
     WebElement password;

    @FindBy(xpath = "//input[@id='Login']")
    WebElement loginToAccount;

    @FindBy(xpath = "/html[1]/body[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[3]/form[1]/div[3]/input[1]")
    WebElement RememberMe;

    @FindBy(xpath = "//a[@id='forgot_password_link']")
    WebElement forgot_password_link;

    @FindBy(xpath = "//div[@id='userNav-arrow']")
    WebElement Usermenudrop;

    @FindBy(xpath = "//a[contains(text(),'Logout')]")
    WebElement logoutButton;

    @FindBy(xpath = "//input[@id='un']")
    WebElement Reenteruser;

    @FindBy(xpath = "//input[@id='continue']")
    WebElement Click_continue;

    static  String uservalue="jack@mithun.com";
    static String pwdvalue="24July1996#";

    public void loginToApp() throws Exception {
        oBroUti.waitForElementVisible(driver, username, oCons.WAIT_COMMON);
        oBroUti.ufSendKeys(driver, username, uservalue, oCons.WAIT_COMMON);
        if (username.isDisplayed() && username.isEnabled()) {
            System.out.println("usernamefield found");
        } else {
            System.out.println("usernamefield is  not displayed");
        }
        oBroUti.ufSendKeys(driver, password, pwdvalue, oCons.WAIT_COMMON);
   
    }

    public void logOutOfApp() throws Exception {
        oBroUti.ufClick(driver, Usermenudrop, 7);
        oBroUti.waitForElementVisible(driver, logoutButton, oCons.WAIT_COMMON);
        oBroUti.ufClick(driver, logoutButton, oCons.WAIT_COMMON);
    }

    public void rememberMe() throws Exception {
        oBroUti.waitForElementVisible(driver, RememberMe, oCons.WAIT_COMMON);
        oBroUti.ufClick(driver, RememberMe, oCons.WAIT_COMMON);

    }

    public void loginTAcc() throws Exception {
        oBroUti.waitForElementVisible(driver, loginToAccount, oCons.WAIT_COMMON);
        oBroUti.ufClick(driver, loginToAccount, oCons.WAIT_COMMON);
       // oBroUti.ufClick(driver, driver.findElement(By.xpath("//li[@id='home_Tab']//a[contains(text(),'Home')]")));

    }

    public void frgtPw() throws Exception {
        oBroUti.waitForElementVisible(driver, forgot_password_link, oCons.WAIT_COMMON);
        oBroUti.ufClick(driver, forgot_password_link, oCons.WAIT_COMMON);

    }

    public void clickCon() throws Exception {
        // oBroUti.waitForElementVisible(driver, Click_continue, oCons.WAIT_COMMON);(not needed for now )
        oBroUti.ufClick(driver, Click_continue, oCons.WAIT_COMMON);

    }
   
// Note: this  below mehtod never used as I have used this diretly in the LoginSFDC.java with data provider.

    public void WrongloginToApp() throws Exception {
        
        username.clear();
        oBroUti.waitForElementVisible(driver, username, oCons.WAIT_COMMON);
        oBroUti.ufSendKeys(driver, username, "123", oCons.WAIT_COMMON);
        oBroUti.ufSendKeys(driver, password, "112233", oCons.WAIT_COMMON);
    

    }
  

    }
       


