package com.tekarc.TAassignment;


import java.util.List;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TC18 {

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
		
		WebElement oppPipe=driver.findElement(By.xpath("//a[contains(text(),'Opportunity Pipeline')]"));
		oppPipe.click();
		WebElement drop_down = driver.findElement(By.xpath("//select[contains(@name,'break0')]"));

		Select select = new Select(drop_down);
		List<WebElement> dropdownlist = select.getOptions();
		System.out.println(dropdownlist.size());

		for (int i = 1; i < dropdownlist.size(); i++) {
			String texts = dropdownlist.get(i).getText();
			System.out.println(texts);
			if (texts.equals("Opportunity Owner")) {
				dropdownlist.get(i).click();

			}
		}
		Thread.sleep(3000L);
		WebElement opptab1=driver.findElement(By.xpath("//a[contains(text(),'Opportunities')]"));
		opptab1.click();
		WebElement stuckopp=driver.findElement(By.xpath("//a[contains(text(),'Stuck Opportunities')]"));
		stuckopp.click();
		Thread.sleep(3000L);
		driver.close();

	}
}