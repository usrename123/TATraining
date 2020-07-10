package com.tekarc;

import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class OptyTc15 {

	

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
			Thread.sleep(2000L);
			WebElement opptab=driver.findElement(By.xpath("//a[contains(text(),'Opportunities')]"));
			opptab.click();
			
			WebElement dd=driver.findElement(By.xpath("//select[@id='fcf']"));
			Select s=new Select(dd);
			dd.click();
			if(dd.isDisplayed()) {
				System.out.println("drop down is present");
			}
			      Thread.sleep(4000L);
			      
			      
			      
			      
                   driver.close();
                    
}
}
