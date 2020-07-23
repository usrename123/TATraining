package com.TekArc.Framework.PO;

import java.util.Iterator;
import java.util.Set;

import com.TekArc.Framework.Utilities.TestBase;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PODevelopers_console extends TestBase {
    public PODevelopers_console(WebDriver driver){
       TestBase.driver =driver;
       PageFactory.initElements(driver, this);
    }
    
    @FindBy(xpath = "///a[@class='debugLogLink menuButtonMenuLink']")
    WebElement developer_consoElement;
  


    public void Developerconsol() throws Exception {
        oBroUti.waitForElementVisible(driver, developer_consoElement, oCons.WAIT_COMMON);
        oBroUti.ufClick(driver, developer_consoElement, oCons.WAIT_COMMON);
        String HomeWIndowID=driver.getWindowHandle();
        System.out.println(HomeWIndowID);
        Set<String> allWindowHandles=driver.getWindowHandles();
        Iterator iterator = allWindowHandles. iterator();
        String PopWIndowID;
        while(iterator.hasNext()) {
               PopWIndowID=iterator.next().toString();	 
       
        if(!PopWIndowID.equals(HomeWIndowID)) {
            driver.switchTo().window(PopWIndowID);
            
            driver.close();
            

    }

        }

}
    }
