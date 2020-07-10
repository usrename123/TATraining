package com.tekarc;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class LeadTC21 {

	

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
			Thread.sleep(3000L);
			driver.findElement(By.xpath("//a[contains(text(),'Opportunities')]/following::li[1]")).click();
			driver.findElement(By.xpath("//select[@id='fcf']")).click();
			Thread.sleep(4000L);
    driver.close();
			
		}
}
