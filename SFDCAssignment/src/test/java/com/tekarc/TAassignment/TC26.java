package com.tekarc.TAassignment;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class TC26 {

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
		WebElement conTab=driver.findElement(By.xpath("//a[contains(text(),'Opportunities')]/following::li[2]"));
		conTab.click();
		WebElement newview=driver.findElement(By.xpath("//a[contains(text(),'Create New View')]"));
		newview.click();
		WebElement opname=driver.findElement(By.xpath("//input[@id='fname']"));
		opname.sendKeys("Optimized Name");
		WebElement opUname=driver.findElement(By.xpath("//input[@id='devname']"));
		opUname.sendKeys("Optimized_uniqueName");
		WebElement save=driver.findElement(By.xpath("//div[@class='pbBottomButtons']//input[@name='save']"));
		save.click();

		Thread.sleep(3000L);
		driver.close();

	}

}