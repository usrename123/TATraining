package com.tekarc;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;
//DOn't add this test in the test case frame work;Profile name is changed.
public class validationsOfTC34caseTC35 {

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
		driver.findElement(By.xpath("//li[@id='home_Tab']//a[contains(text(),'Home')]")).click();
		WebElement Name = driver.findElement(By.xpath("//div[@class='content']/span/h1/a"));
		String updatedname=Name.getText();
		
		if (updatedname.equals("Aruna ABCD")) {
			System.out.println("got updated");
		

		Thread.sleep(4000L);
		driver.close();

	}
	}
}
