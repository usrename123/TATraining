package com.tekarc;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TableWithForLoop {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://qa-tekarch.firebaseapp.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);

		WebElement username = driver.findElement(By.xpath("//input[@id='email_field']"));
		username.sendKeys("admin123@gmail.com");
		WebElement password = driver.findElement(By.xpath("//input[@id='password_field']"));
		password.sendKeys("admin123");
		WebElement logIn = driver.findElement(By.xpath("//button[contains(text(),'Login to Account')]"));
		logIn.click();
		Actions action = new Actions(driver);
		Thread.sleep(3000L);
		WebElement Widget = driver.findElement(By.xpath("//body/div[@id='user_div']/div/div[3]"));
		action.moveToElement(Widget).build().perform();

		WebElement tableTab = driver.findElement(By.xpath("//div[3]//div[1] //a[contains(text(),'Table')]"));
		tableTab.click();
		int rows = driver.findElements(By.xpath("//div[@id='user_div']//div//table//tbody/tr")).size();
		System.out.println(rows);
		int cols = driver.findElements(By.xpath("//div[@id='user_div']//div//table//tbody/tr/th")).size();
		System.out.println(cols);
		Thread.sleep(2000L);
		for (int i = 2; i <= rows; i++) {
			for(int j=1;j<=cols;j++) {
				System.out.print(driver.findElement(By.xpath("//div[@id='user_div']//div//table//tbody/tr["+i+"]/td["+j+"]")).getText());
				
			}
			System.out.println();
		}
		driver.close();

	}

}
