package com.TekArc.TestNgSample1;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CreatAccTestNg {
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
	public void salesforce_TC10() throws InterruptedException {
        InitializeDriver();
		driver.findElement(By.xpath("//input[@id='username']")).sendKeys(" jack@mithun.com");
		driver.findElement(By.xpath("//input[@id='password']")).sendKeys("24july1996");
		driver.findElement(By.xpath("//input[@id='Login']")).click();
		WebElement acc=driver.findElement(By.xpath("//a[contains(text(),'Accounts')]"));
		acc.click();
		WebElement newview=driver.findElement(By.xpath("//input[@name='new']"));
		newview.click();
		WebElement nameBox=driver.findElement(By.xpath("//div[contains(@class,'requiredInput')]//input[contains(@name,'acc2')]"));
		Thread.sleep(2000L);
		nameBox.sendKeys("sushil bindra");
		WebElement save=driver.findElement(By.xpath("//td[@id='bottomButtonRow']//input[@name='save']"));
		save.click();
	
		driver.close();
    }
    @Test
    public void salesforce_TC11() throws InterruptedException {
    InitializeDriver();
    driver.findElement(By.xpath("//input[@id='username']")).sendKeys(" jack@mithun.com");
    driver.findElement(By.xpath("//input[@id='password']")).sendKeys("24july1996");
    driver.findElement(By.xpath("//input[@id='Login']")).click();
    WebElement acc=driver.findElement(By.xpath("//a[contains(text(),'Accounts')]"));
    acc.click();
    Thread.sleep(3000L);
    WebElement newview=driver.findElement(By.xpath("//a[contains(text(),'Create New View')]"));
    newview.click();
    WebElement viewname=driver.findElement(By.xpath("//input[@id='fname']"));
    viewname.sendKeys("Moonlight");
    Thread.sleep(3000L);
    WebElement viewUname=driver.findElement(By.xpath("//input[@id='devname']"));
    viewUname.click();
    viewUname.clear();
    viewUname.sendKeys("Moon_Light");
    WebElement save=driver.findElement(By.xpath("//div[@class='pbBottomButtons']//input[@name='save']"));
    save.click();
    
    driver.close();


    }
    
}