package com.TekArc.Framework.frameWork_testCases;

import com.TekArc.Framework.PO.POLogin;
import com.TekArc.Framework.Utilities.TestBase;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Log4JDemo extends TestBase {
  Logger log = Logger.getLogger(getClass().getSimpleName());
  POLogin Pologin;
  @BeforeClass
	public void SetupEnvironment() {
		Pologin = new POLogin(driver);

	}
  @Test
  public void TC1() throws Exception {
    driver.get(oCons.getAppURL());
		WebElement username = driver.findElement(By.xpath("//input[@id='username']"));
		WebElement password = driver.findElement(By.xpath("//input[@id='password']"));
		username.clear();
		oBroUti.waitForElementVisible(driver, username, oCons.WAIT_COMMON);
		
		oBroUti.ufSendKeys(driver, username, "jack@mithun.com", oCons.WAIT_COMMON);
		log.trace("username entered successfuly");
		oBroUti.ufSendKeys(driver, password, "24july1996", oCons.WAIT_COMMON);
		log.info("password entered successfuly");
	    Pologin.loginTAcc();
		Pologin.logOutOfApp();
   
  }
}