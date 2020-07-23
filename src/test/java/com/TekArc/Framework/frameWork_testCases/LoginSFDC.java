package com.TekArc.Framework.frameWork_testCases;


import com.TekArc.Framework.PO.POLogin;
import com.TekArc.Framework.Utilities.TestBase;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;



public class LoginSFDC extends TestBase {
	
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

	@Test
	public void salesforce_TC4A() throws Exception {
		driver.get(oCons.getAppURL());
		Pologin.loginTAcc();
		WebElement Errormessage = driver.findElement(By.xpath("//div[@id='error']"));
		String ActualErrorMessage = Errormessage.getText();
		String Expectedmessage = "Please enter your password.";
		if (ActualErrorMessage.contains(Expectedmessage)) {
			System.out.println("Error message is validted");
		}
		oBroUti.waitForElementVisible(driver, Errormessage, oCons.WAIT_COMMON);
		Pologin.frgtPw();
		WebElement re_enter_Username = driver.findElement(By.xpath("//input[@id='un']"));
		re_enter_Username.sendKeys("jack@mithun.com");
		Pologin.clickCon();
	}

	@Test
	public void salesforce_TC4B() throws Exception {

		driver.get(oCons.getAppURL());
		Pologin.WrongloginToApp();
		Pologin.loginTAcc();
		WebElement errorMassage = driver.findElement(By.xpath("//div[@id='error']"));
		oBroUti.waitForElementVisible(driver, errorMassage, oCons.WAIT_COMMON);
		String errmsg = errorMassage.getText();
		if (errmsg.contains("Please check your username and password. If you still can't log in,"
				+ " contact your Salesforce administrator.")) {
			System.out.println("Error for wrong UserName and PassWrd is validated");
		}
	}
	

}


