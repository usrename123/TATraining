package com.tekarc;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class RendomScenariosTC34 {

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
		driver.findElement(By.xpath("//li[@id='home_Tab']//a[contains(text(),'Home')]")).click();
		/*
		 * IMPORTANT NOTE:Below code is running successfully but do not run this code or add into the frame work,
		 * -----------------------------------------------------------------------------------------------------
		 * this may effect the other tests,because we are updating the profile name here.
		 * --------------------------------------------------------------------------------
		 */
//		driver.findElement(By.xpath("//a[contains(text(),'Aruna bindra')]")).click();
//		Thread.sleep(3000L);
//		driver.findElement(By.xpath("//a[contains(@class,'contactInfoLaunch editLink')]//img")).click();
//		WebElement iframe = driver.findElement(By.xpath("//iframe[@id='contactInfoContentId']"));
//
//		driver.switchTo().frame(iframe);
//		Thread.sleep(2000L);
//		driver.findElement(By.xpath("//a[contains(text(),'About')]")).click();
//		driver.findElement(By.xpath("//input[@id='firstName']")).click();
//		WebElement lastName = driver.findElement(By.xpath("//input[@id='lastName']"));
//		lastName.clear();
//		lastName.sendKeys("ABCD");
//		driver.findElement(By.xpath("//input[contains(@class,'zen-btn zen-primaryBtn zen-pas')]")).click();


		Thread.sleep(4000L);
		driver.close();

	}

}
