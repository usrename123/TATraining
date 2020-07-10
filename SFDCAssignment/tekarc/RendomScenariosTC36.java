package com.tekarc;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class RendomScenariosTC36 {
//Do not put this into the framework.
	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException, AWTException {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		driver.get("https://login.salesforce.com/");
		driver.findElement(By.xpath("//input[@id='username']")).sendKeys(" jack@mithun.com");
		driver.findElement(By.xpath("//input[@id='password']")).sendKeys("24july1996");
		driver.findElement(By.xpath("//input[@id='Login']")).click();
		WebElement hometab=driver.findElement(By.xpath("//li[@id='home_Tab']//a[contains(text(),'Home')]"));
		hometab.click();
		WebElement pickAday=driver.findElement(By.xpath("//a[contains(text(),'Saturday July 4, 2020')]"));
		pickAday.click();
		WebElement table=driver.findElement(By.xpath("//td[contains(@class,'fixedTable')]//div[5]/a"));
		table.click();
		Thread.sleep(2000L);
		WebElement tableEle=driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[2]/table[1]/tbody[1]/tr[1]/td"
				+ "[2]/form[1]/div[1]/div[2]/div[4]/table[1]/tbody[1]/tr[2]/td[2]/div[1]/a[1]/img[1]"));
		tableEle.click();

		Set<String> windowhandles = driver.getWindowHandles();
		String homewindow = driver.getWindowHandle();
		windowhandles.remove(homewindow);
		Iterator<String> iterator = windowhandles.iterator();
		while (iterator.hasNext()) {
			String popupWindow = iterator.next().toString();
			if (!popupWindow.equals(homewindow)) {
				driver.switchTo().window(popupWindow);
				Thread.sleep(3000L);
				driver.findElement(By.xpath("//body//li[5]/a")).click();
						
			}
		}
		driver.switchTo().window(homewindow);
		Thread.sleep(3000L);
		driver.close();

	}

}
