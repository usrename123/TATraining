package com.tekarc.TAassignment;


import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TC35 {
//Do not put this into the framework.
	static WebDriver driver;
//Do not add this also because when you run the programe file is removed;next time it stucks;
	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		driver.get("https://login.salesforce.com/");
		driver.findElement(By.xpath("//input[@id='username']")).sendKeys(" jack@mithun.com");
		driver.findElement(By.xpath("//input[@id='password']")).sendKeys("24july1996");
		driver.findElement(By.xpath("//input[@id='Login']")).click();
		
		WebElement img=driver.findElement(By.xpath("//li[@id='AllTab_Tab']/a/img"));
		img.click();
		WebElement custmizename=driver.findElement(By.xpath("//input[contains(@name,'customize')]"));
		custmizename.click();
		WebElement dropdown=driver.findElement(By.xpath("//select[@name='duel_select_1']"));
		Select s= new Select(dropdown);
		Thread.sleep(2000L);
		s.selectByVisibleText("Files");
		WebElement img2=driver.findElement(By.xpath("//td[contains(@class,'oRight')]//td[2]//div[3]/a/img"));
		img2.click();
		WebElement clicbutton=driver.findElement(By.xpath("//td[@id='bottomButtonRow']/input[1]"));
		clicbutton.click();
		driver.findElement(By.xpath("//div[@id='userNav-arrow']")).click();
		Thread.sleep(3000L);
		driver.findElement(By.xpath("//a[contains(text(),'Logout')]")).click();
		driver.findElement(By.xpath("//input[@id='username']")).sendKeys(" jack@mithun.com");
		driver.findElement(By.xpath("//input[@id='password']")).sendKeys("24july1996");
		driver.findElement(By.xpath("//input[@id='Login']")).click();
		
		
		driver.close();
		

	}

}