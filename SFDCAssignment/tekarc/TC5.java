package com.tekarc;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TC5 {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();

		driver.get("https://login.salesforce.com/");
		
		WebElement usernamefield=driver.findElement(By.xpath("//input[@id='username']"));
		usernamefield.sendKeys("123");
		 driver.findElement(By.xpath("//input[@id='password']")).sendKeys("22131");
		 WebElement login=driver.findElement(By.xpath("//input[@id='Login']"));
			login.click();
			Thread.sleep(3000L);
			WebElement errorMassage=driver.findElement(By.xpath("//div[@id='error']"));
			System.out.println(errorMassage.getText());
			driver.close();
	}

}
