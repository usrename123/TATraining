package com.TekArc.Framework.frameWork_testCases;

import com.TekArc.Framework.PO.POLogin;
import com.TekArc.Framework.Utilities.TestBase;
import com.relevantcodes.extentreports.LogStatus;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

//This test is reading the properties file for ch and environment
//log4j is working,as I had to create the folder in the resources section and gave the path,
//Alog with this I had to and will have to put the ,Logger log = Logger.getLogger(getClass().getSimpleName());
//In every class individually and also it will remain there in the commonUtilities ofr the extent report
//this is something strange but working and giving me output ,but twice(:Happy Coding)
public class LoginSFDC_dataprovider extends TestBase {

	Logger log = Logger.getLogger(getClass().getSimpleName());

	@DataProvider(name = "DataSet1")
	public Object[][] getdata() {
		String[][] data = { { "jack@mithun.com", "24July1996" } };
		return data;

	}

	@DataProvider(name = "DataSet2")
	public Object[][] getdata2() {
		String[][] data = { { "123", "112233" }, { "567", "556644" } };
		return data;

	}

	POLogin Pologin;

	@BeforeClass
	public void SetupEnvironment() {
		Pologin = new POLogin(driver);

	}

	@Test
	public void salesforce_TC1() throws Exception {
		driver.get(oCons.getAppURL());
		Pologin.loginToApp();

		Pologin.loginTAcc();

		// Pologin.logOutOfApp();

	}

	@Test
	public void salesforce_TC2() throws Exception {

		driver.get(oCons.getAppURL());
		Pologin.loginToApp();
		Pologin.rememberMe();
		Pologin.loginTAcc();
		Thread.sleep(3000);

		Pologin.logOutOfApp();
		logger.log(LogStatus.PASS, "test is failing because dropdown is not found");
		logger.log(LogStatus.PASS, " My Login Test 1 failed" + logger.addScreenCapture(takeScreenshot()));
		
	}

	@Test(dataProvider = "DataSet2")
	public void salesforce_TC4B(String user_name, String pass) throws Exception {

		driver.get(oCons.getAppURL());
		WebElement username = driver.findElement(By.xpath("//input[@id='username']"));
		WebElement password = driver.findElement(By.xpath("//input[@id='password']"));

		username.clear();

		oBroUti.waitForElementVisible(driver, username, oCons.WAIT_COMMON);
		oBroUti.ufSendKeys(driver, username, user_name, oCons.WAIT_COMMON);
		oBroUti.ufSendKeys(driver, password, pass, oCons.WAIT_COMMON);
		Pologin.loginTAcc();
		WebElement actualMassage = driver.findElement(By.xpath("//div[@id='error']"));
		oBroUti.waitForElementVisible(driver, actualMassage, oCons.WAIT_COMMON);
		String exceptedMessage = "Please check your username and password. If you still can't log in, contact your Salesforce administrator.";

		if (actualMassage.equals(exceptedMessage)) {
			System.out.println("success");
		}
		logger.log(LogStatus.PASS, "successfully completed the test");
		logger.log(LogStatus.PASS, " My Login Test 1 failed" + logger.addScreenCapture(takeScreenshot()));
		log.info("MISSION is failing and somtimes its a success");
	}
}
