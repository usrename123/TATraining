package com.tekarc;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DropdownTC08 {
	static ExtentReports reports;
	static ExtentTest logger;
	static WebDriver driver;

	public static void InitializationReport() {
		System.out.println(System.getProperty("user.dir") + "/report/myreport.html");
		reports = new ExtentReports(System.getProperty("user.dir") + "/report/myreport.html"
				+ new SimpleDateFormat("'SalesForceReport_'YYYYMMddHHmmss'.html'").format(new Date()));
	}

	public static String takeScreenshot() throws IOException {
		TakesScreenshot srcShot = ((TakesScreenshot) driver);
		File srcFile = srcShot.getScreenshotAs(OutputType.FILE);
		String imagePath = System.getProperty("user.dir") + "/report/myreport" + "ScreenShots/"
				+ new SimpleDateFormat("'Image_'YYYYMMddHHmmss'.png'").format(new Date());
		File destFile = new File(imagePath);
		FileUtils.copyFile(srcFile, destFile);
		return imagePath;
	}

	public static void main(String[] args) throws InterruptedException, IOException {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		InitializationReport();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
	logger=reports.startTest("DropdownTC08");
		driver.get("https://login.salesforce.com/");
		driver.findElement(By.xpath("//input[@id='username']")).sendKeys(" jack@mithun.com");
		driver.findElement(By.xpath("//input[@id='password']")).sendKeys("24july1996");
		driver.findElement(By.xpath("//input[@id='Login']")).click();
		Thread.sleep(2000L);
		driver.findElement(By.xpath("//div[@id='userNav-arrow']")).click();
		driver.findElement(By.xpath("//a[@class='debugLogLink menuButtonMenuLink']")).click();
		 String HomeWIndowID=driver.getWindowHandle();
         //System.out.println(HomeWIndowID);
         Set<String> allWindowHandles=driver.getWindowHandles();
         Iterator iterator = allWindowHandles. iterator();
         String PopWIndowID;
         while(iterator.hasNext()) {
        	    PopWIndowID=iterator.next().toString();	 
     
         if(!PopWIndowID.equals(HomeWIndowID)) {
        	 driver.switchTo().window(PopWIndowID);
        	 driver.close();
         }
        	 logger.log(LogStatus.INFO, "menu dropdown opened");
        	 logger.log(LogStatus.INFO, "selected the developers consol");
        	 logger.log(LogStatus.INFO, "new window popped up");
        	 logger.log(LogStatus.PASS," DropdownTC08 passed" +logger.addScreenCapture(takeScreenshot()));
         
         reports.endTest(logger);
         reports.flush();
         Thread.sleep(3000L);
         
         driver.close();
	}

}
}