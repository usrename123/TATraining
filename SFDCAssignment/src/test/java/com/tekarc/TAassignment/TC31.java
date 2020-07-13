package com.tekarc.TAassignment;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


import io.github.bonigarcia.wdm.WebDriverManager;

public class TC31 {

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
		WebElement leadTab=driver.findElement(By.xpath("//a[contains(text(),'Opportunities')]/following::li[2]"));
		leadTab.click();
		WebElement newview=driver.findElement(By.xpath("//a[contains(text(),'Create New View')]"));
		newview.click();
		WebElement nametext=driver.findElement(By.xpath("//input[@id='fname']"));
		nametext.sendKeys("shu an");
		WebElement nametext2=driver.findElement(By.xpath("//input[@id='devname']"));
		nametext2.sendKeys("shu_an");
		WebElement clicbox=driver.findElement(By.xpath("//div[3]//table[1]//tbody[1]//tr[1]//td[2]//input[1]"));
		clicbox.click();
		Thread.sleep(3000L);
		driver.close();
		

	}

}