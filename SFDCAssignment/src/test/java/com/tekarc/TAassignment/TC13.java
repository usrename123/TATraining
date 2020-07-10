package com.tekarc.TAassignment;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TC13 {

	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		driver.get("https://login.salesforce.com/");
		driver.findElement(By.xpath("//input[@id='username']")).sendKeys(" jack@mithun.com");
		driver.findElement(By.xpath("//input[@id='password']")).sendKeys("24july1996");
		driver.findElement(By.xpath("//input[@id='Login']")).click();
		
		WebElement acc=driver.findElement(By.xpath("//a[contains(text(),'Accounts')]"));
		acc.click();
		WebElement meracc=driver.findElement(By.xpath("//a[contains(text(),'Merge Accounts')]"));
		meracc.click();
//		WebElement namebox=driver.findElement(By.xpath("//input[@id='srch']"));
//		namebox.sendKeys("Admin");
//		WebElement button=driver.findElement(By.xpath("//div[contains(@class,'pbWizardBody')]//input[contains(@name,'srchbutton')]"));
//		button.click();
//		Thread.sleep(3000L);
//		WebElement button1=driver.findElement(By.xpath("//div[contains(@class,'pbBottomButtons')]//input[contains(@name,'goNext')]"));
//		button1.click();
//		WebElement button2=driver.findElement(By.xpath("//div[contains(@class,'pbTopButtons')]//input[contains(@name,'save')]"));
//		button2.click();
//		driver.switchTo().alert().accept();
		Thread.sleep(4000L);
		driver.close();
	}
}