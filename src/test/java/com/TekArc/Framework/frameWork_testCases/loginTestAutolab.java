package com.TekArc.Framework.frameWork_testCases;

import com.TekArc.Framework.PO.POLogin;
import com.TekArc.Framework.Utilities.TestBase;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class loginTestAutolab extends TestBase {

    POLogin Pologin;

	@BeforeClass
	public void SetupEnvironment() {
		Pologin = new POLogin(driver);

	}


@Test
    public void salesforce_TC4B(String user_name, String pass) throws Exception {

		driver.get(oCons.getAppURL());
		WebElement username = driver.findElement(By.xpath("//input[@id='username']"));
		WebElement password = driver.findElement(By.xpath("//input[@id='password']"));
		username.clear();
		oBroUti.waitForElementVisible(driver, username, oCons.WAIT_COMMON);
		oBroUti.ufSendKeys(driver, username, user_name, oCons.WAIT_COMMON);
		oBroUti.ufSendKeys(driver, password, pass, oCons.WAIT_COMMON);
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