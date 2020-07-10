package com.tekarc.TAassignment;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TC14 {

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
		WebElement activity=driver.findElement(By.xpath("//a[contains(text(),'Accounts with last activity > 30 days')]"));
		activity.click();
		WebElement drop=driver.findElement(By.xpath("//input[@name='dateColumn']"));
		drop.click();
		Actions a=new Actions(driver);
		a.sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ENTER).build().perform();
		WebElement accrep=driver.findElement(By.xpath("/html[1]/body[1]/div[2]/div[3]/div[1]/div[1]/div[1]"
				+ "/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/table[1]"
				+ "/tbody[1]/tr[2]/td[2]/div[1]/div[1]/form[1]/div[1]/div[3]/img[1]"));
		accrep.click();
		Thread.sleep(3000L);
		WebElement repoption=driver.findElement(By.xpath("//td[contains(@class,'x-date-active x-date-today x-date-selected')]"
				+ "//a[contains(@class,'x-date-date')]"));
		repoption.click();
		WebElement saverep=driver.findElement(By.xpath("/html[1]/body[1]/div[2]/div[1]/div[1]/div[1]/div[1]/table[1]"
				+ "/tbody[1]/tr[1]/td[1]/table[1]/tbody[1]/tr[1]/td[1]/table[1]/tbody[1]/tr[2]/td[2]/em[1]/button[1]"));
		saverep.click();
		
		driver.close();
	}

}