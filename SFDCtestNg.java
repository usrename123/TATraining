package com.TekArc;

import static org.testng.Assert.assertEquals;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SFDCtestNg{
	
	static WebDriver driver;
	static ExtentReports reports;
	static ExtentTest logger;
	
@BeforeTest 
public static void InitializeDriver() {
	WebDriverManager.chromedriver().setup();
	driver = new ChromeDriver();
	driver.get("https://login.salesforce.com");
}
@BeforeTest
public static void InitializeReport() {
	reports = new ExtentReports(System.getProperty("user.dir") + "/report/" + 
			new SimpleDateFormat("'SalesForceReport_'YYYYMMddHHmmss'.html'").format(new Date()));
}
@BeforeTest
public static void waitmethod() {
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
}


@AfterSuite
public static void CloseReport() {
	
	reports.flush();
}

@Test
public void salesforce_TC5() throws InterruptedException {
	InitializeDriver();
	logger = reports.startTest(" TC 5");
	
	WebElement usernamefield=driver.findElement(By.xpath("//input[@id='username']"));
	usernamefield.sendKeys("123");
	 driver.findElement(By.xpath("//input[@id='password']")).sendKeys("22131");
	 WebElement login=driver.findElement(By.xpath("//input[@id='Login']"));
		login.click();
		
		WebElement errorMassage=driver.findElement(By.xpath("//div[@id='error']"));
		String actualerror=errorMassage.getText();
		String expectederror="Please check your username and password. If you still can't log in, contact your Salesforce administrator.";
       if(actualerror.contains(expectederror)) {
    	   logger.log(LogStatus.PASS, "errorMessage");
       }
	logger.log(LogStatus.PASS, "salesforce_TC5 " );
	reports.endTest(logger);
	driver.close();
	
	
}
@Test
public void salesforce_TC1() throws InterruptedException {

	logger = reports.startTest(" TC 1");
	InitializeDriver();
	WebElement username = driver.findElement(By.xpath("//input[@id='username']"));
	username.sendKeys(" jack@mithun.com");
	WebElement password = driver.findElement(By.xpath("//input[@id='password']"));
	password.sendKeys("24july1996");
	driver.findElement(By.xpath("//input[@id='Login']")).click();

	logger.log(LogStatus.INFO, "Login Button Clicked");
	logger.log(LogStatus.PASS, " salesforce_TC1" );
	reports.endTest(logger);
	driver.close();
}
@Test
public void salesforce_TC4A() throws InterruptedException {
	InitializeDriver();
	logger = reports.startTest(" TC4A");
	WebElement username = driver.findElement(By.xpath("//input[@id='username']"));
	username.sendKeys(" jack@mithun.com");

	driver.findElement(By.xpath("//input[@id='password']")).clear();
	WebElement login = driver.findElement(By.xpath("//input[@id='Login']"));
	login.click();
	Thread.sleep(3000L);
	String actualErrormessage = driver.findElement(By.xpath("//div[@id='error']")).getText();
	Thread.sleep(3000L);
	String Expectedmessage="Please enter your password.";
	assertEquals(actualErrormessage, Expectedmessage);
	Thread.sleep(3000L);
	
	driver.findElement(By.xpath("//a[@id='forgot_password_link']")).click();
	driver.findElement(By.xpath("//input[@id='un']")).sendKeys(" jack@mithun.com");
	Thread.sleep(3000L);

	driver.findElement(By.xpath("//input[@id='continue']")).click();
	logger.log(LogStatus.PASS, " salesforce_TC4A" );
	reports.endTest(logger);
	driver.close();
}
} 