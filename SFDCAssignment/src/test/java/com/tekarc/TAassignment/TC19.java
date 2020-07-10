package com.tekarc.TAassignment;


import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TC19 {

	

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
			WebElement opptab=driver.findElement(By.xpath("//a[contains(text(),'Opportunities')]"));
			opptab.click();
			WebElement drop_down = driver.findElement(By.xpath("//select[@name='quarter_q']"));
			Select select= new Select(drop_down);
			select.selectByValue("curnext1");
			
			WebElement oppPipe=driver.findElement(By.xpath("//a[contains(text(),'Opportunity Pipeline')]"));
			oppPipe.click();
			
			WebElement drop1=driver.findElement(By.xpath("//select[@id='scope']"));
			WebElement drop2=driver.findElement(By.xpath("//select[@id='open']"));
			WebElement drop3=driver.findElement(By.xpath("//select[@id='probability']"));
                   
                   selectValueFromDropDown(drop1 , "user");
                   selectValueFromDropDown(drop2 , "closed");
                   selectValueFromDropDown(drop3 , "gt90");
                   Thread.sleep(6000L);
                   driver.close();
}
		public static void selectValueFromDropDown(WebElement ele,String value) {
			Select s=new Select(ele);
			s.selectByValue(value);
			
		}
}