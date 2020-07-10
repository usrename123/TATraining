package com.tekarc;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TableAssin {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://qa-tekarch.firebaseapp.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		
		WebElement username = driver.findElement(By.xpath("//input[@id='email_field']"));
		username.sendKeys("admin123@gmail.com");
		WebElement password = driver.findElement(By.xpath("//input[@id='password_field']"));
		password.sendKeys("admin123");
		WebElement logIn = driver.findElement(By.xpath("//button[contains(text(),'Login to Account')]"));
		logIn.click();
		Actions action= new Actions(driver);
		Thread.sleep(3000L);
		WebElement Widget=driver.findElement(By.xpath("//body/div[@id='user_div']/div/div[3]"));
		action.moveToElement(Widget).build().perform();

		WebElement tableTab=driver.findElement(By.xpath("//div[3]//div[1] //a[contains(text(),'Table')]"));
		tableTab.click();
		//WebElement tablerows=
//		int counts=driver.findElements(By.cssSelector("div:nth-child(2) div:nth-child(2) table:nth-child(2)"
//				+ " tbody:nth-child(1) > tr:nth-child(2)")).size();
//		
//	
//		for(int i=0;i<counts;i++) {
////			
//	    System.out.println(table.findElements(By.cssSelector("div:nth-child(2) div:nth-child(2)"
//	    		+ " table:nth-child(2) tbody:nth-child(1) > tr:nth-child(2)")).get(i).getText());
////			}
		//Thread.sleep(3000L);
		//driver.close();

	}
	} 
//}
