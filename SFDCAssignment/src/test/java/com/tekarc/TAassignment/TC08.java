package com.tekarc.TAassignment;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TC08 {
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
		driver.findElement(By.xpath("//div[@id='userNav-arrow']")).click();
		Thread.sleep(6000L);
		driver.findElement(By.xpath("//a[@class='debugLogLink menuButtonMenuLink']")).click();
		driver.findElement(By.xpath("//div[@id='userNav-arrow']")).click();
		driver.findElement(By.xpath("//a[contains(text(),'Logout')]")).click();
		 String HomeWIndowID=driver.getWindowHandle();
         System.out.println(HomeWIndowID);
         Set<String> allWindowHandles=driver.getWindowHandles();
         Iterator<String> iterator = allWindowHandles. iterator();
         String PopWIndowID;
         while(iterator.hasNext()) {
        	    PopWIndowID=iterator.next().toString();	 
     
         if(!PopWIndowID.equals(HomeWIndowID)) {
        	 driver.switchTo().window(PopWIndowID);
        	 
        	 driver.close();
        	 Thread.sleep(2000L);
         }
      
	}
	}
}