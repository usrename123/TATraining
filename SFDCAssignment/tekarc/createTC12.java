package com.tekarc;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class createTC12 {

	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException, AWTException {
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
       WebElement drop_down=driver.findElement(By.xpath("//select[@id='fcf']"));
       Select s= new Select(drop_down);
       s.selectByValue("00B3h000006c4SR");
       Thread.sleep(2000L);
       WebElement editb=driver.findElement(By.xpath("//span[@class='fFooter']//a[contains(text(),'Edit')]"));
       editb.click();
       
       WebElement namebox=driver.findElement(By.xpath("//input[@id='fname']"));
       namebox.clear();
       namebox.sendKeys("My latest Acconts");
       Thread.sleep(3000L);
       driver.close();
	}
}
