package com.tekarc.TAassignment;


import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
public class TC25 {
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
		WebElement newtext=driver.findElement(By.xpath("//input[@name='new']"));
		newtext.click();
		WebElement nametext=driver.findElement(By.xpath("//input[@name='name_lastcon2']"));
		nametext.sendKeys("anshu");
		WebElement compy=driver.findElement(By.xpath("//input[@name='con4']"));
		compy.sendKeys("Admin Anshu");
		WebElement save=driver.findElement(By.xpath("//div[contains(@class,'pbBottomButtons')]//input[1]"));
		save.click();
		driver.close();

	}

}