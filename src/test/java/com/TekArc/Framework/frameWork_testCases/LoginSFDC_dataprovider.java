package com.TekArc.Framework.frameWork_testCases;

import com.TekArc.Framework.PO.POLogin;
import com.TekArc.Framework.Utilities.TestBase;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;



public class LoginSFDC_dataprovider extends TestBase {

	@DataProvider(name = "DataSet1")
	public Object[][] getdata() {
		String[][] data = { { " jack@mithun.com", "24july1996" } };
		return data;

	}

	@DataProvider(name = "DataSet2")
	public Object[][] getdata2() {
		String[][] data = { { "123", "112233" },{"567","556644"} };
		return data;

	}

	POLogin Pologin;

	@BeforeClass
	public void SetupEnvironment() {
		Pologin = new POLogin(driver);

	}


	
	public void salesforce_TC1() throws Exception {
		driver.get(oCons.getAppURL());
		Pologin.loginToApp();
	
		Pologin.loginTAcc();
		
		Pologin.logOutOfApp();

	}

	@Test
	public void salesforce_TC2() throws Exception {

		driver.get(oCons.getAppURL());
		Pologin.loginToApp();
		Pologin.rememberMe();
		Pologin.loginTAcc();
		Pologin.logOutOfApp();
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
	
		if (actualMassage.equals(exceptedMessage)){
			System.out.println("success");
		}
		
		}
	}


