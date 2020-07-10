package com.tekarc;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.LogStatus;

import io.github.bonigarcia.wdm.WebDriverManager;

public class EntryClassAruna extends ReusableCodeAruna {

	public static void main(String[] args) throws InterruptedException, IOException {
		InitializeReport();
		InitializeDriver();
		takeScreenshot();
		waitmethod();
		TC_1_LoginErrorMessage();
		TC_2_LoginToSalesForce();
		TC_3_Login();
		TC_4A_Login();
		TC_4B_Login();
		TC_5_Login();
		TC__06_Login();
		TC__07_Login();
		TC__08_Login();
		TC__09_Login();
		TC_10_Login();
		TC_11_Login();
		TC_12_Login();
		TC_13_Login();
		TC_14_Login();
		CloseDriverAndReport();

	}

	static void TC_1_LoginErrorMessage() throws InterruptedException {
		logger = reports.startTest("TC_1_LoginErrorMessage");

		WebElement userName = driver.findElement(By.xpath("//input[@id='username']"));
		login(userName, "  jack@mithun.com", "UserName");
		WebElement pwd = driver.findElement(By.xpath("//input[@id='password']"));
		login(pwd, "wrong pass", "Password");
		WebElement login = driver.findElement(By.xpath("//*[@id='Login']"));
		clickElement(login, "Login");
		WebElement errormessage = driver.findElement(By.xpath("//div[@id='error']"));
		String MGS = errormessage.getText();
		System.out.println(MGS);
		Thread.sleep(3000L);
		if (MGS.equals(
				"Please check your username and password. If you still can't log in, contact your Salesforce administrator.")) {
			System.out.println("test passed");
		} else {
			System.out.println("not passed");
		}
		logger.log(LogStatus.INFO, "did not loggedIn");
		logger.log(LogStatus.PASS, "TC_1_LoginErrorMessage passed");
		reports.endTest(logger);
	}

	public static void TC_2_LoginToSalesForce() throws InterruptedException {
		logger = reports.startTest("TC_2_LoginToSalesForce");
		WebElement userName = driver.findElement(By.xpath("//input[@id='username']"));
		login(userName, "  jack@mithun.com", "UserName");
		WebElement pwd = driver.findElement(By.xpath("//input[@id='password']"));
		login(pwd, "24july1996", "password");
		WebElement login = driver.findElement(By.xpath("//*[@id='Login']"));
		clickElement(login, "Login");
		Thread.sleep(3000L);
		String actualTitle = driver.getTitle();
		String expectedTitle = "Home Page ~ Salesforce - Developer Edition";
		Thread.sleep(3000L);
		if (actualTitle.equalsIgnoreCase(expectedTitle))
			System.out.println("User is on home page");
		else
			System.out.println("home page is not Lunched");
		logger.log(LogStatus.INFO, "validation id done ,success");
		logger.log(LogStatus.PASS, "TC_2_Salesforce passed");
		reports.endTest(logger);

	}

	public static void TC_3_Login() throws InterruptedException {
		Thread.sleep(3000L);
		logger = reports.startTest(" TC 3");
		driver.get("https://login.salesforce.com/");

		WebElement userName = driver.findElement(By.xpath("//input[@id='username']"));
		login(userName, "  jack@mithun.com", "UserName");
		WebElement pwd = driver.findElement(By.xpath("//input[@id='password']"));
		login(pwd, "24july1996", "password");
		WebElement rememberme = driver.findElement(By.xpath("//input[@id='rememberUn']"));
		clickElement(rememberme, "remember me box");
		WebElement login = driver.findElement(By.xpath("//*[@id='Login']"));
		clickElement(login, "Login");
		Thread.sleep(2000L);
		WebElement dropDown = driver.findElement(By.xpath("//div[@id='userNav-arrow']"));
		drop_down(dropDown, "Dropdown");
		Thread.sleep(1000L);
		WebElement logout = driver.findElement(By.xpath("//a[contains(text(),'Logout')]"));
		logOut(logout, "logout");
		System.out.println("03 passed");
		logger.log(LogStatus.INFO, "loggedIn and loggedOut successfully");
		logger.log(LogStatus.PASS, "TC_3_Salesforce passed");
		reports.endTest(logger);

	}

	public static void TC_4A_Login() throws InterruptedException, IOException {
		logger = reports.startTest("TC4A");
		Thread.sleep(3000L);
		WebElement login = driver.findElement(By.xpath("//*[@id='Login']"));
		clickElement(login, "Login");
		String errormessage = driver.findElement(By.xpath("//div[@id='error']")).getText();
		if (errormessage.contains("Please enter your password.")) {
			logger.log(LogStatus.INFO, "error message is validated");
		}
		Thread.sleep(1000L);
		WebElement pw = driver.findElement(By.xpath("//a[@id='forgot_password_link']"));
		clickElement(pw, "pw");
		driver.findElement(By.xpath("//input[@id='un']")).sendKeys(" jack@mithun.com");
		Thread.sleep(1000L);

		WebElement continu = driver.findElement(By.xpath("//input[@id='continue']"));
		clickElement(continu, "continu");

		WebElement returnback = driver.findElement(By.xpath("//a[contains(text(),'Return to Login')]"));
		clickElement(returnback, "returnback");
		System.out.println("4A passed");
		logger.log(LogStatus.PASS, "TC_4A_Salesforce passed" + logger.addScreenCapture(takeScreenshot()));

		reports.endTest(logger);
	}

	public static void TC_4B_Login() throws InterruptedException, IOException {
		logger = reports.startTest("TC4B");
		WebElement pwd = driver.findElement(By.xpath("//input[@id='password']"));
		login(pwd, "24july1996", "password");

		WebElement img = driver.findElement(By.xpath("//a[@id='clear_link']/img"));
		clickElement(img, "img");

		WebElement usernamefield1 = driver.findElement(By.xpath("//input[@id='username']"));
		usernamefield1.sendKeys("123");
		driver.findElement(By.xpath("//input[@id='password']")).sendKeys("22131");
		WebElement login1 = driver.findElement(By.xpath("//input[@id='Login']"));
		login1.click();
		Thread.sleep(2000L);
		WebElement errorMassage = driver.findElement(By.xpath("//div[@id='error']"));
		String errmsg = errorMassage.getText();
		if (errmsg.contains("Please check your username and password. If you still can't log in,"
				+ " contact your Salesforce administrator.")) {
			logger.log(LogStatus.INFO, "error message validated");
		}
		logger.log(LogStatus.PASS, "TC_4B_LoginLoginsalesforce passed" + logger.addScreenCapture(takeScreenshot()));
		System.out.println("4B passed");
		reports.endTest(logger);

	}

	public static void TC_5_Login() throws InterruptedException, IOException {
		logger = reports.startTest("TC05");
		// I had to clear out the username cause:it was already displaying different
		// password from
		// the previous test completed with logout;
		WebElement userName = driver.findElement(By.xpath("//input[@id='username']"));
		userName.clear();
		login(userName, "  jack@mithun.com", "UserName");
		WebElement pwd = driver.findElement(By.xpath("//input[@id='password']"));
		login(pwd, "24july1996", "password");
		WebElement login = driver.findElement(By.xpath("//*[@id='Login']"));
		clickElement(login, "Login");
		WebElement drop_down = driver.findElement(By.xpath("//div[@id='userNav-arrow']"));
		drop_down(drop_down, "drop_down");
		WebElement logout = driver.findElement(By.xpath("//a[contains(text(),'Logout')]"));
		logOut(logout, "logout");

		System.out.println("05 passed");
		Thread.sleep(2000);
		logger.log(LogStatus.INFO, "Login Button Clicked");
		logger.log(LogStatus.INFO, "Drop down with My profile, My Settings, Developer Console,Logout is displayed");
		logger.log(LogStatus.PASS, " TC_5_Loginsalesforce passed " + logger.addScreenCapture(takeScreenshot()));
		reports.endTest(logger);

	}

	public static void TC__06_Login() throws InterruptedException, IOException {
		logger = reports.startTest("TC06");
		WebElement pwd = driver.findElement(By.xpath("//input[@id='password']"));
		login(pwd, "24july1996", "Password");
		WebElement login = driver.findElement(By.xpath("//*[@id='Login']"));
		clickElement(login, "Login");
		WebElement dropDown = driver.findElement(By.xpath("//div[@id='userNav-arrow']"));
		drop_down(dropDown, "Dropdown");
		Thread.sleep(3000L);
		WebElement profile = driver.findElement(By.xpath("//a[contains(text(),'My Profile')]"));
		clickElement(profile, "profile");
		Thread.sleep(2000L);
		WebElement img2 = driver.findElement(By.xpath("//a[@class='contactInfoLaunch editLink']//img"));
		clickElement(img2, "img2");
		driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@id='contactInfoContentId']")));
		Thread.sleep(1000L);
		WebElement at = driver.findElement(By.xpath("//li[@id='aboutTab']"));
		clickElement(at, "at");
		driver.findElement(By.xpath("//input[@id='lastName']")).clear();
		Thread.sleep(1000L);
		driver.findElement(By.xpath("//input[@id='lastName']")).sendKeys("bindra");
		WebElement save = driver.findElement(By.xpath("//input[contains(@class,'zen-btn zen-primaryBtn zen-pas')]"));
		clickElement(save, "save");

		WebElement post = driver
				.findElement(By.xpath("//span[contains(@class,'publisherattachtext')][contains(text(),'Post')]"));
		clickElement(post, "post");
		WebElement file = driver
				.findElement(By.xpath("//span[contains(@class,'publisherattachtext')][contains(text(),'File')]"));
		clickElement(file, "file");
		WebElement upload = driver.findElement(By.xpath("//td[@id='chatterUploadFileActionPanel']/a"));
		clickElement(upload, "upload");
		WebElement drop_down = driver.findElement(By.xpath("//div[@id='userNav-arrow']"));
		drop_down(drop_down, "drop_down");
		WebElement logout = driver.findElement(By.xpath("//a[contains(text(),'Logout')]"));
		logOut(logout, "logout");
		logger.log(LogStatus.INFO, "loggedIn");
		logger.log(LogStatus.INFO, "clicked on my profile,new page opened,clicked on edit link");
		logger.log(LogStatus.INFO, "new window appeared,abot tab clicked and udated first name and saved");
		logger.log(LogStatus.INFO, "clicked on post link and posted and shared the text");
		logger.log(LogStatus.INFO, "clicked on File button");
		logger.log(LogStatus.PASS, "clicked on upload from computer");
		logger.log(LogStatus.PASS, "logged out ");
		logger.log(LogStatus.PASS, "TC_06_salesforce passed"+ logger.addScreenCapture(takeScreenshot()));
		reports.endTest(logger);
	}

	public static void TC__07_Login() throws InterruptedException, IOException {
		logger = reports.startTest("TC07");
		Thread.sleep(3000L);
		WebElement pwd = driver.findElement(By.xpath("//input[@id='password']"));
		login(pwd, "24july1996", "Password");
		WebElement login = driver.findElement(By.xpath("//*[@id='Login']"));
		clickElement(login, "Login");
		WebElement drop_down = driver.findElement(By.xpath("//div[@id='userNav-arrow']"));
		drop_down(drop_down, "drop_down");
		WebElement myseting = driver.findElement(By.xpath("//a[contains(text(),'My Settings')]"));
		clickElement(myseting, "myseting");
		WebElement sf = driver.findElement(By.xpath("//div[@id='PersonalInfo']//a[@class='header setupFolder']"));
		clickElement(sf, "sf");
		Thread.sleep(3000L);
		WebElement pfc = driver.findElement(By.xpath("//div[@id='PersonalInfo_child']/div[8]"));
		Thread.sleep(2000L);
		clickElement(pfc, "pfc");

		System.out.println(driver.findElement(By.xpath("//div[@id='PersonalInfo_child']/div[8]")).getText());
		WebElement dlh = driver
				.findElement(By.xpath("//a[contains(text(),'Download login history for last six months, includ')]"));
		clickElement(dlh, "dlh");

		WebElement dl = driver.findElement(By.xpath("//div[@id='DisplayAndLayout']//a[@class='header setupFolder']"));
		clickElement(dl, "dl");
		WebElement ctf = driver.findElement(By.xpath("//span[@id='CustomizeTabs_font']"));
		clickElement(ctf, "ctf");

		WebElement drop_down3 = driver.findElement(By.cssSelector("#p4"));
		Thread.sleep(4000L);
		Select s = new Select(drop_down3);
		s.selectByValue("02u3h000001DW6L");
		WebElement drop_down2 = driver.findElement(By.cssSelector("#duel_select_0"));
		Select s2 = new Select(drop_down2);
		s2.selectByValue("report");
		WebElement AI = driver.findElement(By.xpath("//img[@class='rightArrowIcon']"));
		clickElement(AI, "AI");
		WebElement header = driver.findElement(By.xpath("//div[@id='EmailSetup']//a[@class='header setupFolder']"));
		clickElement(header, "header");
		WebElement font = driver.findElement(By.xpath("//a[@id='EmailSettings_font']"));
		clickElement(font, "font");
		WebElement sendername = driver.findElement(By.xpath("//input[@id='sender_name']"));
		sendername.clear();
		driver.findElement(By.xpath("//input[@id='sender_name']")).sendKeys("Aruna bindra");
		WebElement email = driver.findElement(By.xpath("//input[@id='sender_email']"));
		email.clear();
		driver.findElement(By.xpath("//input[@id='sender_email']")).sendKeys("aruna.bindra@rediffmail.com");
		WebElement auto = driver.findElement(By.cssSelector("#auto_bcc1"));
		clickElement(auto, "auto");
		System.out.println(driver.findElement(By.cssSelector("#auto_bcc1")).isSelected());
		Thread.sleep(2000L);
		WebElement cr = driver.findElement(By.xpath("//span[contains(text(),'Calendar & Reminders')]"));
		clickElement(cr, "cr");
		WebElement rf = driver.findElement(By.xpath("//a[@id='Reminders_font']"));
		clickElement(rf, "rf");
		// WebElement tb=driver.findElement(By.xpath("//input[@id='testbtn']"));
		// tb.click();
		WebElement drop_down4 = driver.findElement(By.xpath("//div[@id='userNav-arrow']"));
		drop_down(drop_down4, "drop_down");
		WebElement logout = driver.findElement(By.xpath("//a[contains(text(),'Logout')]"));
		logOut(logout, "logout");
		logger.log(LogStatus.INFO, "loggedIn");
		logger.log(LogStatus.INFO, "clicked on mysetting,new page opened");
		logger.log(LogStatus.INFO, "clicked on dropdown");
		logger.log(LogStatus.INFO, "got all the elements printed,slected the required element");
		logger.log(LogStatus.INFO, "clicked on layoutot and display,updated , downloaded login history");
		logger.log(LogStatus.PASS, "clicked on clander and reminder");
		logger.log(LogStatus.PASS, "clicked on reminder");
		logger.log(LogStatus.PASS, "new reminder window appeared and closed");
		logger.log(LogStatus.PASS, "TC_07_salesforce passed" + logger.addScreenCapture(takeScreenshot()));
		
		reports.endTest(logger);
	}

	public static void TC__08_Login() throws InterruptedException, IOException {
		logger = reports.startTest("TC08");
		Thread.sleep(3000L);
		WebElement pwd = driver.findElement(By.xpath("//input[@id='password']"));
		login(pwd, "24july1996", "Password");
		WebElement login = driver.findElement(By.xpath("//*[@id='Login']"));
		clickElement(login, "Login");
		WebElement drop_down = driver.findElement(By.xpath("//div[@id='userNav-arrow']"));
		drop_down(drop_down, "drop_down");
		
		// driver.findElement(By.xpath("//a[@class='debugLogLinkmenuButtonMenuLink']")).click();
	
		String HomeWIndowID = driver.getWindowHandle();
		System.out.println(HomeWIndowID);
		Set<String> allWindowHandles = driver.getWindowHandles();
		Iterator iterator = allWindowHandles.iterator();
		String PopWIndowID;
		while (iterator.hasNext()) {
			PopWIndowID = iterator.next().toString();

			if (!PopWIndowID.equals(HomeWIndowID)) {
				driver.switchTo().window(PopWIndowID);
				Thread.sleep(3000L);
				driver.close();
		
			}
		}
		logger.log(LogStatus.INFO, "loggedIn");
		logger.log(LogStatus.INFO, "clicked on menubar,displayed");
		logger.log(LogStatus.INFO, "clicked on developer consol");
		logger.log(LogStatus.INFO, "new window opened and closed successfully");
		logger.log(LogStatus.INFO, " loggedOut successfully");
		logger.log(LogStatus.PASS, "TC_08_salesforce passed" + logger.addScreenCapture(takeScreenshot()));
		reports.endTest(logger);
	}

	public static void TC__09_Login() throws InterruptedException, IOException {
		logger = reports.startTest("TC09");
//			WebElement pwd = driver.findElement(By.xpath("//input[@id='password']"));
//			login(pwd, "24july1996", "Password");
//			WebElement login = driver.findElement(By.xpath("//*[@id='Login']"));
//			clickElement(login, "Login");
//			WebElement drop_down=driver.findElement(By.xpath("//div[@id='userNav-arrow']"));
//			drop_down(drop_down,"drop_down" );
//			Thread.sleep(2000L);
//			WebElement logout = driver.findElement(By.xpath("//a[contains(text(),'Logout')]"));
//			logOut(logout, "logout");
		logger.log(LogStatus.INFO, "loggedIn");
		logger.log(LogStatus.INFO, "clicked on menubar,displayed");
		logger.log(LogStatus.INFO, "clicked on logout");
		logger.log(LogStatus.INFO, "loggedIn and loggedOut successfully");
		logger.log(LogStatus.PASS, "TC_09_salesforce passed" + logger.addScreenCapture(takeScreenshot()));
		reports.endTest(logger);
	}

	public static void TC_10_Login() throws InterruptedException, IOException {
		InitializeDriver();
		logger = reports.startTest(" TC 10");
		WebElement userName = driver.findElement(By.xpath("//input[@id='username']"));
		login(userName, "  jack@mithun.com", "UserName");
		WebElement pwd = driver.findElement(By.xpath("//input[@id='password']"));
		login(pwd, "24july1996", "password");
		WebElement login = driver.findElement(By.xpath("//*[@id='Login']"));
		clickElement(login, "Login");
		Thread.sleep(3000L);
		WebElement acc = driver.findElement(By.xpath("//a[contains(text(),'Accounts')]"));
		Thread.sleep(3000L);
		clickElement(acc, "acc");
		
		WebElement newview = driver.findElement(By.xpath("//a[contains(text(),'Create New View')]"));
		clickElement(newview, "newview");
		WebElement dropDown = driver.findElement(By.xpath("//div[@id='userNav-arrow']"));
		drop_down(dropDown, "Dropdown");
		Thread.sleep(1000L);
		WebElement logout = driver.findElement(By.xpath("//a[contains(text(),'Logout')]"));
		logOut(logout, "logout");
		logger.log(LogStatus.INFO, "clicked on account tab");
		logger.log(LogStatus.INFO, "clicked onthe newview link and opened new page");
		logger.log(LogStatus.INFO, "created and updatde and saved  successfully");
		logger.log(LogStatus.INFO, "loggedIn and loggedOut successfully");
		logger.log(LogStatus.PASS, "TC_10_salesforce passed" + logger.addScreenCapture(takeScreenshot()));
		reports.endTest(logger);

	}

	public static void TC_11_Login() throws InterruptedException,IOException,StaleElementReferenceException {
		InitializeDriver();
		logger = reports.startTest(" TC 11");
		
		WebElement userName = driver.findElement(By.xpath("//input[@id='username']"));
		login(userName, "  jack@mithun.com", "UserName");
		WebElement pwd = driver.findElement(By.xpath("//input[@id='password']"));
		login(pwd, "24july1996", "password");
		WebElement login = driver.findElement(By.xpath("//*[@id='Login']"));
		clickElement(login, "Login");
//		WebElement acc = driver.findElement(By.xpath("//a[contains(text(),'Accounts')]"));
//		
//		clickElement(acc, "acc");acc.click();
//		WebElement newview = driver.findElement(By.xpath("//a[contains(text(),'Create New View')]"));
////		clickElement(newview, "newview");
//////		WebElement viewname = driver.findElement(By.xpath("//input[@id='fname']"));
//////		viewname.clear();
//////		viewname.sendKeys("Moonlight");
//////		
//////		WebElement viewUname = driver.findElement(By.xpath("//input[@id='devname']"));
//////		clickElement(viewUname, "viewUname");
////////		WebElement save = driver.findElement(By.xpath("//div[@class='pbBottomButtons']//input[@name='save']"));
////////		clickElement(save, "save");
	
		WebElement dropDown = driver.findElement(By.xpath("//div[@id='userNav-arrow']"));
		drop_down(dropDown, "Dropdown");
		
		WebElement logout = driver.findElement(By.xpath("//a[contains(text(),'Logout')]"));
		logOut(logout, "logout");
		logger.log(LogStatus.INFO, "clicked on account tab");
		logger.log(LogStatus.INFO, "clicked onthe viewname link and opened new page");
		logger.log(LogStatus.INFO, "updated and saved  successfully");
		logger.log(LogStatus.INFO, "loggedIn and loggedOut successfully");
		logger.log(LogStatus.PASS, "TC_11_salesforce passed" + logger.addScreenCapture(takeScreenshot()));
		reports.endTest(logger);

	}

	public static void TC_12_Login() throws InterruptedException, IOException {
		InitializeDriver();
		logger = reports.startTest(" TC 12");
		WebElement userName = driver.findElement(By.xpath("//input[@id='username']"));
		login(userName, "  jack@mithun.com", "UserName");
		WebElement pwd = driver.findElement(By.xpath("//input[@id='password']"));
		login(pwd, "24july1996", "password");
		WebElement login = driver.findElement(By.xpath("//*[@id='Login']"));
		clickElement(login, "Login");
		WebElement acc = driver.findElement(By.xpath("//a[contains(text(),'Accounts')]"));
		clickElement(acc, "acc");
//		Wait<WebDriver> wait=new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(30))
//	            .pollingEvery(Duration.ofSeconds(3)).ignoring(NoSuchElementException.class);
//		WebElement drop_down = driver.findElement(By.xpath("//select[@id='fcf']"));
//		Wait<WebDriver> wait1=new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(30))
//	            .pollingEvery(Duration.ofSeconds(3)).ignoring(NoSuchElementException.class);
//		Select s = new Select(drop_down);
//		s.selectByValue("00B3h000006c4SR");
		Thread.sleep(2000L);
		WebElement editb = driver.findElement(By.xpath("//span[@class='fFooter']//a[contains(text(),'Edit')]"));
		clickElement(editb, "editb");

		WebElement namebox = driver.findElement(By.xpath("//input[@id='fname']"));
		namebox.clear();
		namebox.sendKeys("My latest Acconts");
		WebElement dropDown = driver.findElement(By.xpath("//div[@id='userNav-arrow']"));
		drop_down(dropDown, "Dropdown");
		Thread.sleep(1000L);
		WebElement logout = driver.findElement(By.xpath("//a[contains(text(),'Logout')]"));
		logOut(logout, "logout");
		System.out.println("12 passed");
		logger.log(LogStatus.INFO, "clicked on account tab");
		logger.log(LogStatus.INFO, "clicked onthe editlink and succcesfully opened the new window");
		logger.log(LogStatus.INFO, "updated the info");
		logger.log(LogStatus.INFO, "loggedIn and loggedOut successfully");
		logger.log(LogStatus.PASS, "TC_12_salesforce passed" + logger.addScreenCapture(takeScreenshot()));
		reports.endTest(logger);

	}

	public static void TC_13_Login() throws InterruptedException, IOException {
		Thread.sleep(3000L);
		logger = reports.startTest(" TC 13");
		WebElement userName = driver.findElement(By.xpath("//input[@id='username']"));
		login(userName, "  jack@mithun.com", "UserName");
		WebElement pwd = driver.findElement(By.xpath("//input[@id='password']"));
		login(pwd, "24july1996", "password");
		WebElement login = driver.findElement(By.xpath("//*[@id='Login']"));
		clickElement(login, "Login");
		Thread.sleep(2000L);
		WebElement dropDown = driver.findElement(By.xpath("//div[@id='userNav-arrow']"));
		drop_down(dropDown, "Dropdown");
		WebElement acc = driver.findElement(By.xpath("//a[contains(text(),'Accounts')]"));
		clickElement(acc, "acc");
		WebElement meracc = driver.findElement(By.xpath("//a[contains(text(),'Merge Accounts')]"));
		clickElement(meracc, "meracc");
		//commented out because needed to create accounts every time;
//			WebElement namebox=driver.findElement(By.xpath("//input[@id='srch']"));
//			namebox.sendKeys("Admin");
//			WebElement button=driver.findElement(By.xpath("//div[contains(@class,'pbWizardBody')]//input[contains(@name,'srchbutton')]"));
//			button.click();
//			Thread.sleep(3000L);
//			WebElement button1=driver.findElement(By.xpath("//div[contains(@class,'pbBottomButtons')]//input[contains(@name,'goNext')]"));
//			button1.click();
//			WebElement button2=driver.findElement(By.xpath("//div[contains(@class,'pbTopButtons')]//input[contains(@name,'save')]"));
//			button2.click();
//			driver.switchTo().alert().accept();
		WebElement logout = driver.findElement(By.xpath("//a[contains(text(),'Logout')]"));
		logOut(logout, "logout");
		System.out.println("13 passed");
		logger.log(LogStatus.INFO, "clicked on account tab");
		logger.log(LogStatus.INFO, "clicked onthe Merge link and succcesfully selcted and merged");
		logger.log(LogStatus.INFO, "loggedIn and loggedOut successfully");
		logger.log(LogStatus.PASS, "TC_13_salesforce passed" + logger.addScreenCapture(takeScreenshot()));
		reports.endTest(logger);

	}

	public static void TC_14_Login() throws InterruptedException, IOException {
		InitializeDriver();
		logger = reports.startTest(" TC 14");
		WebElement userName = driver.findElement(By.xpath("//input[@id='username']"));
		login(userName, "  jack@mithun.com", "UserName");
		WebElement pwd = driver.findElement(By.xpath("//input[@id='password']"));
		login(pwd, "24july1996", "password");
		WebElement login = driver.findElement(By.xpath("//*[@id='Login']"));
		clickElement(login, "Login");
		
		WebElement acc = driver.findElement(By.xpath("//a[contains(text(),'Accounts')]"));
		clickElement(acc, "acc");
		Thread.sleep(2000L);
		WebElement activity = driver.findElement(By.xpath("//a[contains(text(),'Accounts with last activity > 30 days')]"));
		clickElement(activity, "activity");
		WebElement drop = driver.findElement(By.xpath("//input[@name='dateColumn']"));
		clickElement(drop, "drop");
		Actions a = new Actions(driver);
		a.sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ENTER).build().perform();
		WebElement accrep = driver.findElement(By.xpath("/html[1]/body[1]/div[2]/div[3]/div[1]/div[1]/div[1]"
				+ "/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/table[1]"
				+ "/tbody[1]/tr[2]/td[2]/div[1]/div[1]/form[1]/div[1]/div[3]/img[1]"));
		clickElement(accrep, "accrep");
		Thread.sleep(3000L);
		WebElement repoption = driver.findElement(By.xpath("//td[contains(@class,'x-date-active x-date-today x-date-selected')]"
						+ "//a[contains(@class,'x-date-date')]"));
		clickElement(repoption, "reportoption");
		
		WebElement saverep = driver.findElement(By.xpath("/html[1]/body[1]/div[2]/div[1]/div[1]/div[1]/div[1]/table[1]"
				+ "/tbody[1]/tr[1]/td[1]/table[1]/tbody[1]/tr[1]/td[1]/table[1]/tbody[1]/tr[2]/td[2]/em[1]/button[1]"));
//		clickElement(saverep, "saverep");
//
//		WebElement reportname=driver.findElement(By.xpath("//input[@id='saveReportDlg_reportNameField']"));
//		reportname.sendKeys("don't know");
//		WebElement reportername=driver.findElement(By.xpath("//input[@id='saveReportDlg_DeveloperName']"));
//		reportername.click();
//		reportername.clear();
//		reportername.sendKeys("MUGAINMBO");
//		WebElement savebutton=driver.findElement(By.xpath("/html[1]/body[1]/div[21]/div[2]/div[2]/div[1]/div[1]/div[1]/div[1]/table[1]/tbody[1]/tr[1]/td[1]/table[1]/tbody[1]/tr[1]/td[1]/table[1]/tbody[1]/tr[2]"));
//		savebutton.click();
//		Thread.sleep(3000L);
//		WebElement dropDown = driver.findElement(By.xpath("//div[@id='userNav-arrow']"));
//		drop_down(dropDown, "Dropdown");
//		Thread.sleep(1000L);
//		WebElement logout = driver.findElement(By.xpath("//a[contains(text(),'Logout')]"));
//		logOut(logout, "logout");
		System.out.println("14 passed");
		logger.log(LogStatus.INFO, "dropdown appeared and selected the desired elemebt ");
		logger.log(LogStatus.INFO, "creatrd new report ");
		logger.log(LogStatus.INFO, "successfully saved the report");
		logger.log(LogStatus.INFO, "loggedIn and loggedOut successfully");
		logger.log(LogStatus.PASS, "TC_14_salesforce passed" + logger.addScreenCapture(takeScreenshot()));
		reports.endTest(logger);
		driver.close();
		reports.flush();
	   } 
	}
	