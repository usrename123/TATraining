package com.tekarc;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LeadTC24 {

	

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
			WebElement leadTab=driver.findElement(By.xpath("//a[contains(text(),'Opportunities')]/following::li[1]"));
			leadTab.click();
			
			WebElement dropSelect=driver.findElement(By.xpath("//select[@id='fcf']"));
			dropSelect.click();
			 selectValueFromDropDowntext(dropSelect,"Today's Leads") ;
			 WebElement tbox=driver.findElement(By.xpath("//input[@name='new']"));
			 tbox.click();
			 WebElement tbox1=driver.findElement(By.xpath("//input[contains(@name,'name_lastlea2')]"));
			 tbox1.sendKeys("ABCD");
			 WebElement tbox2=driver.findElement(By.xpath("//input[contains(@name,'lea3')]"));
			 tbox2 .sendKeys("EFGH");
			 WebElement tbox3=driver.findElement(By.xpath("//div[contains(@class,'pbBottomButtons')]//input[1]"));
			 tbox2.click();
			
			
			
			Thread.sleep(3000L);
    driver.close();
			
		}

		public static void selectValueFromDropDowntext(WebElement ele,String text) {
			Select s=new Select(ele);
			s.selectByVisibleText(text);;
		}
}
