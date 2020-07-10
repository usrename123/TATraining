package com.tekarc.TAassignment;


import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TC27 {

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
		WebElement conTab=driver.findElement(By.xpath("//a[contains(text(),'Opportunities')]/following::li[2]"));
		conTab.click();
		WebElement new1=driver.findElement(By.xpath("//input[@name='new']"));
		new1.click();
		WebElement lname=driver.findElement(By.xpath("//input[@name='name_lastcon2']"));
		lname.sendKeys("anshu");
		WebElement compname=driver.findElement(By.xpath("//input[@name='con4']"));
		compname.sendKeys("Admin Anshu");
		WebElement save=driver.findElement(By.xpath("//div[contains(@class,'pbBottomButtons')]//input[1]"));
		save.click();
		WebElement conTab2=driver.findElement(By.xpath("//a[contains(text(),'Opportunities')]/following::li[2]"));
		conTab2.click();
		WebElement drop_down=driver.findElement(By.xpath("//select[@id='hotlist_mode']"));
		selectDropDowntext(drop_down ,"Recently Viewed");
		
		driver.close();

	}
	public static void selectDropDowntext(WebElement ele,String text) {
		Select select = new Select(ele);
		select.selectByVisibleText(text);
	}

}