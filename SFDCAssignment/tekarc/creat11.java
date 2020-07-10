package com.tekarc;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class creat11 {

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
		WebElement acc=driver.findElement(By.xpath("//a[contains(text(),'Accounts')]"));
		acc.click();
		WebElement newview=driver.findElement(By.xpath("//a[contains(text(),'Create New View')]"));
		newview.click();
		WebElement viewname=driver.findElement(By.xpath("//input[@id='fname']"));
		viewname.clear();
		viewname.sendKeys("Moonlight");
		Thread.sleep(2000L);
		WebElement viewUname=driver.findElement(By.xpath("//input[@id='devname']"));
		viewUname.click();
		WebElement save=driver.findElement(By.xpath("//div[@class='pbBottomButtons']//input[@name='save']"));
		save.click();
		Thread.sleep(4000L);
		driver.close();

}
}