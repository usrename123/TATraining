package com.tekarc.TAassignment;


import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TC06{

	static WebDriver driver;
	static ExtentReports reports;
	static ExtentTest logger;

	static void InitializationReport() {

		System.out.println(System.getProperty("user.dir") + "/report/myreport.html");
		reports = new ExtentReports(System.getProperty("user.dir") + "/report/myreport.html"
				+ new SimpleDateFormat("'SalesForceReport_'YYYYMMddHHmmss'.html'").format(new Date()));

	}

	public static String takeScreenshot() throws IOException {
		TakesScreenshot srcShot = ((TakesScreenshot) driver);
		File srcFile = srcShot.getScreenshotAs(OutputType.FILE);
		String imagePath = System.getProperty("user.dir") + "/report/myreport.html" + "ScreenShots/"
				+ new SimpleDateFormat("'Image_'YYYYMMddHHmmss'.png'").format(new Date());
		File destFile = new File(imagePath);
		FileUtils.copyFile(srcFile, destFile);
		return imagePath;
	}

	public static void main(String[] args) throws InterruptedException, IOException {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		InitializationReport();
		driver.get("https://login.salesforce.com/");

		logger = reports.startTest("TC06");

		driver.get("https://login.salesforce.com/");
		driver.findElement(By.xpath("//input[@id='username']")).sendKeys(" jack@mithun.com");
		driver.findElement(By.xpath("//input[@id='password']")).sendKeys("24july1996");
		driver.findElement(By.xpath("//input[@id='Login']")).click();
		Thread.sleep(2000L);
		driver.findElement(By.xpath("//div[@id='userNav-arrow']")).click();
		driver.findElement(By.xpath("//a[contains(text(),'My Profile')]")).click();
		Thread.sleep(2000L);
		driver.findElement(By.xpath("//a[@class='contactInfoLaunch editLink']//img")).click();
		driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@id='contactInfoContentId']")));
		Thread.sleep(1000L);
		driver.findElement(By.xpath("//li[@id='aboutTab']")).click();
		driver.findElement(By.xpath("//input[@id='lastName']")).clear();
		Thread.sleep(1000L);
		driver.findElement(By.xpath("//input[@id='lastName']")).sendKeys("bindra");
		driver.findElement(By.xpath("//input[contains(@class,'zen-btn zen-primaryBtn zen-pas')]")).click();

		driver.findElement(By.xpath("//span[contains(@class,'publisherattachtext')][contains(text(),'Post')]")).click();
		
		logger.log(LogStatus.PASS, "Test TC06 is passed");
		driver.findElement(By.xpath("//span[contains(@class,'publisherattachtext')][contains(text(),'File')]")).click();
		driver.findElement(By.xpath("//td[@id='chatterUploadFileActionPanel']/a")).click();
		Thread.sleep(3000L);
		driver.close();
		reports.endTest(logger);
		reports.flush();

	}

}

    