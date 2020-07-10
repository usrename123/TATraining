package com.tekarc;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TC07 {
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
		driver.findElement(By.xpath("//a[contains(text(),'My Settings')]")).click();
		driver.findElement(By.xpath("//div[@id='PersonalInfo']//a[@class='header setupFolder']")).click();
		Thread.sleep(2000L);
		driver.findElement(By.xpath("//div[@id='PersonalInfo_child']/div[8]")).click();
		System.out.println(driver.findElement(By.xpath("//div[@id='PersonalInfo_child']/div[8]")).getText());
		driver.findElement(By.xpath("//a[contains(text(),'Download login history for last six months, includ')]")).click();
		Thread.sleep(3000L);
		driver.findElement(By.xpath("//div[@id='DisplayAndLayout']//a[@class='header setupFolder']")).click();
		driver.findElement(By.xpath("//span[@id='CustomizeTabs_font']")).click();
		WebElement drop_down=driver.findElement(By.cssSelector("#p4"));
		Select s= new Select(drop_down);
		Thread.sleep(2000L);
		s.selectByValue("02u3h000001DW6L");
		WebElement drop_down2=driver.findElement(By.cssSelector("#duel_select_0"));
		Select s2= new Select(drop_down2);
		Thread.sleep(2000L);
		s2.selectByValue("report");
		driver.findElement(By.xpath("//img[@class='rightArrowIcon']")).click();
		Thread.sleep(2000L);
		driver.findElement(By.xpath("//div[@id='EmailSetup']//a[@class='header setupFolder']")).click();
		driver.findElement(By.xpath("//a[@id='EmailSettings_font']")).click();
		driver.findElement(By.xpath("//input[@id='sender_name']")).clear();
		driver.findElement(By.xpath("//input[@id='sender_name']")).sendKeys("Aruna bindra");
		driver.findElement(By.xpath("//input[@id='sender_email']")).clear();
		driver.findElement(By.xpath("//input[@id='sender_email']")).sendKeys("aruna.bindra@rediffmail.com");
		driver.findElement(By.cssSelector("#auto_bcc1")).click();
		System.out.println(driver.findElement(By.cssSelector("#auto_bcc1")).isSelected());
		Thread.sleep(2000L);
		driver.findElement(By.xpath("//span[contains(text(),'Calendar & Reminders')]")).click();
		driver.findElement(By.xpath("//a[@id='Reminders_font']")).click();
		driver.findElement(By.xpath("//input[@id='testbtn']")).click();
		
		
		Thread.sleep(6000L);
      driver.close();
	}

}
