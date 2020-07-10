package com.tekarc;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class contactsTC32 {

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
		WebElement edit=driver.findElement(By.xpath("//span[@class='fFooter']//a[contains(text(),'Edit')]"));
		edit.click();
		WebElement newtext=driver.findElement(By.xpath("//input[@id='fname']"));
		newtext.sendKeys("indian");
		WebElement compyname=driver.findElement(By.xpath("//input[@id='devname']"));
		compyname.sendKeys("global_media");
		WebElement save=driver.findElement(By.xpath("//div[3]//table[1]//tbody[1]//tr[1]//td[2]//input[1]"));
		save.click();
		Thread.sleep(5000L);
		driver.close();
		

	}

}
