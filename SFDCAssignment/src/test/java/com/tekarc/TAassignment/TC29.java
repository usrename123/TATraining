package com.tekarc.TAassignment;


import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TC29 {

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
		WebElement drop_down=driver.findElement(By.xpath("//select[@id='fcf']"));
		selectDropDowntext(drop_down ,"My Contacts");
		WebElement name=driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[2]/table[1]/tbody[1]/tr[1]/td[2]"
				+ "/div[3]/div[1]/div[1]/div[2]/table[1]/tbody[1]/tr[2]/th[1]/a[1]"));
		name.click();
		
		driver.close();
		

	}
	public static void selectDropDowntext(WebElement ele,String text) {
		Select select = new Select(ele);
		select.selectByVisibleText(text);
	}

}