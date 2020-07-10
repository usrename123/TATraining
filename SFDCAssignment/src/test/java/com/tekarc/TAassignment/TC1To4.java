package com.tekarc.TAassignment;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TC1To4 {

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
		driver.get("https://login.salesforce.com/");
		// driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);

		logger = reports.startTest(" TC 1");

		WebElement username = driver.findElement(By.xpath("//input[@id='username']"));

		username.sendKeys(" jack@mithun.com");
		WebElement password = driver.findElement(By.xpath("//input[@id='password']"));

		password.sendKeys("24july1996");
		driver.findElement(By.xpath("//input[@id='Login']")).click();
		Thread.sleep(2000);
		logger.log(LogStatus.INFO, "Login Button Clicked");
		logger.log(LogStatus.PASS, " My Login TC 1 passed ");
		reports.endTest(logger);

		logger = reports.startTest(" TC 2");

		driver.get("https://login.salesforce.com/");
		WebElement usernamefield = driver.findElement(By.xpath("//input[@id='username']"));
		usernamefield.clear();
		usernamefield.sendKeys(" jack@mithun.com");

		if (usernamefield.isDisplayed()&&usernamefield.isEnabled()) {
			logger.log(LogStatus.INFO, "usernamefield found");
		} else {
			logger.log(LogStatus.ERROR, "usernamefield is  not displayed");
		}
		driver.findElement(By.xpath("//input[@id='password']")).sendKeys("24july1996");
		driver.findElement(By.xpath("//input[@id='rememberUn']")).click();
		driver.findElement(By.xpath("//input[@id='Login']")).click();
		Thread.sleep(2000L);
		logger.log(LogStatus.PASS, "User menu is  opened");
		Thread.sleep(2000L);
		driver.findElement(By.xpath("//div[@id='userNav-arrow']")).click();
		Thread.sleep(2000L);
		driver.findElement(By.xpath("//a[contains(text(),'Logout')]")).click();
		logger.log(LogStatus.INFO, "loggedIn and loggedOut successfully");
		logger.log(LogStatus.PASS, "MyTC2 passed");
		reports.endTest(logger);

		logger = reports.startTest("TC4A");
		driver.get("https://login.salesforce.com/");
		

		driver.findElement(By.xpath("//input[@id='password']")).clear();
	
		WebElement login = driver.findElement(By.xpath("//input[@id='Login']"));
		login.click();
		String errormessage = driver.findElement(By.xpath("//div[@id='error']")).getText();
		if (errormessage.contains("Please enter your password.")) {
			logger.log(LogStatus.INFO, "error message is validated");
		}
		
		driver.findElement(By.xpath("//a[@id='forgot_password_link']")).click();
		driver.findElement(By.xpath("//input[@id='un']")).sendKeys(" jack@mithun.com");
	

		driver.findElement(By.xpath("//input[@id='continue']")).click();
		logger.log(LogStatus.PASS, "My Test TC4 is passed ");

		reports.endTest(logger);

		logger = reports.startTest("TC4B");
		driver.get("https://login.salesforce.com/");
		driver.findElement(By.xpath("//a[@id='clear_link']/img")).click();

		WebElement usernamefield1 = driver.findElement(By.xpath("//input[@id='username']"));
		usernamefield1.sendKeys("123");
		driver.findElement(By.xpath("//input[@id='password']")).sendKeys("22131");
		WebElement login1 = driver.findElement(By.xpath("//input[@id='Login']"));
		login1.click();
		
		WebElement errorMassage = driver.findElement(By.xpath("//div[@id='error']"));
		String errmsg = errorMassage.getText();
		if (errmsg.contains("Please check your username and password. If you still can't log in,"
				+ " contact your Salesforce administrator.")) {
			logger.log(LogStatus.INFO, "error message validated");
		}
		logger.log(LogStatus.PASS, "TC4B is success");
			reports.endTest(logger);
		driver.close();
		reports.flush();
		
        
    }
    
}