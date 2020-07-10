package com.tekarc;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.relevantcodes.extentreports.LogStatus;

public class Entry2 extends ReusableCodeAruna {

	public static void main(String[] args) throws IOException {
		InitializeReport();
		InitializeDriver();
		takeScreenshot();
		waitmethod();

	}
	
	
	public static void TC__15_Login() throws InterruptedException, IOException {
		logger = reports.startTest("TC15");
		WebElement userName = driver.findElement(By.xpath("//input[@id='username']"));
		login(userName, "  jack@mithun.com", "UserName");
			WebElement pwd = driver.findElement(By.xpath("//input[@id='password']"));
			login(pwd, "24july1996", "Password");
			WebElement login = driver.findElement(By.xpath("//*[@id='Login']"));
			clickElement(login, "Login");
			Thread.sleep(2000L);
			WebElement opptab=driver.findElement(By.xpath("//a[contains(text(),'Opportunities')]"));
			clickElement(opptab, "opptab");
			
			WebElement dd=driver.findElement(By.xpath("//select[@id='fcf']"));
			Select s=new Select(dd);
			dd.click();
			if(dd.isDisplayed()) {
				System.out.println("drop down is present");
			}
			WebElement drop_down=driver.findElement(By.xpath("//div[@id='userNav-arrow']"));
			drop_down(drop_down,"drop_down" );
			Thread.sleep(2000L);
			WebElement logout = driver.findElement(By.xpath("//a[contains(text(),'Logout')]"));
			logOut(logout, "logout");
		logger.log(LogStatus.PASS, "Test TC15 is passed");
		reports.endTest(logger);
	}
	public static void TC__16_Login() throws InterruptedException, IOException {
		logger = reports.startTest("TC16");
		WebElement userName = driver.findElement(By.xpath("//input[@id='username']"));
		login(userName, "  jack@mithun.com", "UserName");
			WebElement pwd = driver.findElement(By.xpath("//input[@id='password']"));
			login(pwd, "24july1996", "Password");
			WebElement login = driver.findElement(By.xpath("//*[@id='Login']"));
			clickElement(login, "Login");
			WebElement opptab=driver.findElement(By.xpath("//a[contains(text(),'Opportunities')]"));
			clickElement(opptab, "opptab");
			WebElement dd=driver.findElement(By.xpath("//select[@id='fcf']"));
			Select s=new Select(dd);
			clickElement(dd, "dd");
			if(dd.isDisplayed()) {
				System.out.println("drop down is present");
			}
			      Thread.sleep(3000L);
			      WebElement textnew= driver.findElement(By.xpath("//input[contains(@name,'new')]"));
			      clickElement(textnew, "textnew");
			      WebElement textbox= driver.findElement(By.xpath("//input[contains(@name,'opp3')]"));
			      textbox.sendKeys(" Marketing");
			      WebElement tb=driver.findElement(By.xpath("//span[contains(@class,'lookupInput')]//input[contains(@name,'opp4')]"));
			      tb.sendKeys("Admin Account");
		      WebElement leadSource=driver.findElement(By.xpath("//select[contains(@name,'opp6')]"));
			     Select select= new Select(leadSource) ;
			     select.selectByValue("Web");
			     WebElement tb2=driver.findElement(By.xpath("//span[contains(@class,'lookupInput')]//input[contains(@name,'opp17')]"));
			     tb2.sendKeys("creating E-books");
			     WebElement clicksave=driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[2]/table[1]/tbody[1]/tr[1]"
			     		+ "/td[2]/form[1]/div[1]/div[3]/table[1]/tbody[1]/tr[1]/td[2]/input[1]"));
			     
			     clickElement(clicksave, "clicksave");
			WebElement drop_down=driver.findElement(By.xpath("//div[@id='userNav-arrow']"));
			drop_down(drop_down,"drop_down" );
			Thread.sleep(2000L);
			WebElement logout = driver.findElement(By.xpath("//a[contains(text(),'Logout')]"));
			logOut(logout, "logout");
		logger.log(LogStatus.PASS, "Test TC16 is passed");
		reports.endTest(logger);
	}
	public static void TC__17_Login() throws InterruptedException, IOException {
		logger = reports.startTest("TC17");
		WebElement userName = driver.findElement(By.xpath("//input[@id='username']"));
		login(userName, "  jack@mithun.com", "UserName");
			WebElement pwd = driver.findElement(By.xpath("//input[@id='password']"));
			login(pwd, "24july1996", "Password");
			WebElement login = driver.findElement(By.xpath("//*[@id='Login']"));
			clickElement(login, "Login");
			WebElement opptab=driver.findElement(By.xpath("//a[contains(text(),'Opportunities')]"));
			clickElement(opptab, "opptab");
			WebElement oppPipe=driver.findElement(By.xpath("//a[contains(text(),'Opportunity Pipeline')]"));
			clickElement(oppPipe, "oppPipe");
			WebElement drop_down=driver.findElement(By.xpath("//div[@id='userNav-arrow']"));
			drop_down(drop_down,"drop_down" );
			Thread.sleep(2000L);
			WebElement logout = driver.findElement(By.xpath("//a[contains(text(),'Logout')]"));
			logOut(logout, "logout");
		logger.log(LogStatus.PASS, "Test TC17 is passed");
		reports.endTest(logger);
	}
	public static void TC__18_Login() throws InterruptedException, IOException {
		logger = reports.startTest("TC18");
		WebElement userName = driver.findElement(By.xpath("//input[@id='username']"));
		login(userName, "  jack@mithun.com", "UserName");
			WebElement pwd = driver.findElement(By.xpath("//input[@id='password']"));
			login(pwd, "24july1996", "Password");
			WebElement login = driver.findElement(By.xpath("//*[@id='Login']"));
			clickElement(login, "Login");
			WebElement opptab=driver.findElement(By.xpath("//a[contains(text(),'Opportunities')]"));
			clickElement(opptab, "opptab");
			WebElement oppPipe=driver.findElement(By.xpath("//a[contains(text(),'Opportunity Pipeline')]"));
			clickElement(oppPipe, "oppPipe");
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
			clickElement(opptab1, "opptab1");
			WebElement stuckopp=driver.findElement(By.xpath("//a[contains(text(),'Stuck Opportunities')]"));
			clickElement(login, "Login");
			WebElement drop_down1=driver.findElement(By.xpath("//div[@id='userNav-arrow']"));
			drop_down(drop_down1,"drop_down" );
			Thread.sleep(2000L);
			WebElement logout = driver.findElement(By.xpath("//a[contains(text(),'Logout')]"));
			logOut(logout, "logout");
		logger.log(LogStatus.PASS, "Test TC18 is passed");
		reports.endTest(logger);
	}
	public static void TC__19_Login() throws InterruptedException, IOException {
		logger = reports.startTest("TC19");
		WebElement userName = driver.findElement(By.xpath("//input[@id='username']"));
		login(userName, "  jack@mithun.com", "UserName");
			WebElement pwd = driver.findElement(By.xpath("//input[@id='password']"));
			login(pwd, "24july1996", "Password");
			WebElement login = driver.findElement(By.xpath("//*[@id='Login']"));
			clickElement(login, "Login");
			WebElement opptab=driver.findElement(By.xpath("//a[contains(text(),'Opportunities')]"));
			clickElement(opptab, "opptab");
			WebElement drop_down = driver.findElement(By.xpath("//select[@name='quarter_q']"));
			Select select= new Select(drop_down);
			select.selectByValue("curnext1");
			
			WebElement oppPipe=driver.findElement(By.xpath("//a[contains(text(),'Opportunity Pipeline')]"));
			clickElement(oppPipe, "oppPipe");
			
			WebElement drop1=driver.findElement(By.xpath("//select[@id='scope']"));
			WebElement drop2=driver.findElement(By.xpath("//select[@id='open']"));
			WebElement drop3=driver.findElement(By.xpath("//select[@id='probability']"));
                   
                   selectValueFromDropDown(drop1 , "user");
                   selectValueFromDropDown(drop2 , "closed");
                   selectValueFromDropDown(drop3 , "gt90");
			WebElement drop_down1=driver.findElement(By.xpath("//div[@id='userNav-arrow']"));
			drop_down(drop_down1,"drop_down" );
			Thread.sleep(2000L);
			WebElement logout = driver.findElement(By.xpath("//a[contains(text(),'Logout')]"));
			logOut(logout, "logout");
		logger.log(LogStatus.PASS, "Test TC19 is passed");
		reports.endTest(logger);
	}
	public static void TC__20_Login() throws InterruptedException, IOException {
		logger = reports.startTest("TC20");
		WebElement userName = driver.findElement(By.xpath("//input[@id='username']"));
		login(userName, "  jack@mithun.com", "UserName");
			WebElement pwd = driver.findElement(By.xpath("//input[@id='password']"));
			login(pwd, "24july1996", "Password");
			WebElement login = driver.findElement(By.xpath("//*[@id='Login']"));
			clickElement(login, "Login");
			WebElement leadTab=driver.findElement(By.xpath("//a[contains(text(),'Opportunities')]/following::li[1]"));
			clickElement(leadTab, "leadTab");
			WebElement drop_down=driver.findElement(By.xpath("//div[@id='userNav-arrow']"));
			drop_down(drop_down,"drop_down" );
			Thread.sleep(2000L);
			WebElement logout = driver.findElement(By.xpath("//a[contains(text(),'Logout')]"));
			logOut(logout, "logout");
		logger.log(LogStatus.PASS, "Test TC20 is passed");
		reports.endTest(logger);
	}
	public static void TC__21_Login() throws InterruptedException, IOException {
		logger = reports.startTest("TC21");
			WebElement pwd = driver.findElement(By.xpath("//input[@id='password']"));
			login(pwd, "24july1996", "Password");
			WebElement login = driver.findElement(By.xpath("//*[@id='Login']"));
			clickElement(login, "Login");
			driver.findElement(By.xpath("//a[contains(text(),'Opportunities')]/following::li[1]")).click();
			driver.findElement(By.xpath("//select[@id='fcf']")).click();
			WebElement drop_down=driver.findElement(By.xpath("//div[@id='userNav-arrow']"));
			drop_down(drop_down,"drop_down" );
			Thread.sleep(2000L);
			WebElement logout = driver.findElement(By.xpath("//a[contains(text(),'Logout')]"));
			logOut(logout, "logout");
		logger.log(LogStatus.PASS, "Test TC21 is passed");
		reports.endTest(logger);
	}
	public static void TC__22_Login() throws InterruptedException, IOException {
		logger = reports.startTest("TC09");
			WebElement pwd = driver.findElement(By.xpath("//input[@id='password']"));
			login(pwd, "24july1996", "Password");
			WebElement login = driver.findElement(By.xpath("//*[@id='Login']"));
			clickElement(login, "Login");
			WebElement leadTab=driver.findElement(By.xpath("//a[contains(text(),'Opportunities')]/following::li[1]"));
			clickElement(leadTab, "leadTab");
			WebElement dropSelect=driver.findElement(By.xpath("//select[@id='fcf']"));
			clickElement(dropSelect, "dropSelect");
			 selectValueFromDropDowntext(dropSelect,"Today's Leads") ;
			WebElement drop_down=driver.findElement(By.xpath("//div[@id='userNav-arrow']"));
			drop_down(drop_down,"drop_down" );
			Thread.sleep(3000L);
			WebElement userName = driver.findElement(By.xpath("//input[@id='username']"));
			login(userName, "  jack@mithun.com", "UserName");
			WebElement pwd2 = driver.findElement(By.xpath("//input[@id='password']"));
			login(pwd2, "24july1996", "Password");
			WebElement login2 = driver.findElement(By.xpath("//*[@id='Login']"));
			clickElement(login2, "login2");
			WebElement leadTab1=driver.findElement(By.xpath("//a[contains(text(),'Opportunities')]/following::li[1]"));
			clickElement(leadTab1, "leadTab1");
			driver.findElement(By.xpath("//span[contains(@class,'fBody')]//input[contains(@name,'go')]")).click();
			Thread.sleep(2000L);
			WebElement logout = driver.findElement(By.xpath("//a[contains(text(),'Logout')]"));
			logOut(logout, "logout");
		logger.log(LogStatus.PASS, "Test TC22 is passed");
		reports.endTest(logger);
	}
	public static void TC__23_Login() throws InterruptedException, IOException {
		logger = reports.startTest("TC23");
			WebElement pwd = driver.findElement(By.xpath("//input[@id='password']"));
			login(pwd, "24july1996", "Password");
			WebElement login = driver.findElement(By.xpath("//*[@id='Login']"));
			clickElement(login, "Login");
			WebElement leadTab=driver.findElement(By.xpath("//a[contains(text(),'Opportunities')]/following::li[1]"));
			clickElement(leadTab, "leadTab");
			
			WebElement dropSelect=driver.findElement(By.xpath("//select[@id='fcf']"));
			clickElement(dropSelect, "dropSelect");
			 selectValueFromDropDowntext(dropSelect,"Today's Leads") ;
			WebElement drop_down=driver.findElement(By.xpath("//div[@id='userNav-arrow']"));
			drop_down(drop_down,"drop_down" );
			Thread.sleep(2000L);
			WebElement logout = driver.findElement(By.xpath("//a[contains(text(),'Logout')]"));
			logOut(logout, "logout");
		logger.log(LogStatus.PASS, "Test TC23 is passed");
		reports.endTest(logger);
	}
	public static void TC__24_Login() throws InterruptedException, IOException {
		logger = reports.startTest("TC24");
			WebElement pwd = driver.findElement(By.xpath("//input[@id='password']"));
			login(pwd, "24july1996", "Password");
			WebElement login = driver.findElement(By.xpath("//*[@id='Login']"));
			clickElement(login, "Login");
			WebElement leadTab=driver.findElement(By.xpath("//a[contains(text(),'Opportunities')]/following::li[1]"));
			clickElement(leadTab, "leadTab");
			WebElement dropSelect=driver.findElement(By.xpath("//select[@id='fcf']"));
			clickElement(dropSelect, "dropSelect");
			 selectValueFromDropDowntext(dropSelect,"Today's Leads") ;
			 WebElement textbox=driver.findElement(By.xpath("//input[@name='new']"));
			 clickElement(textbox, "textbox");
			 WebElement tbox1=driver.findElement(By.xpath("//input[contains(@name,'name_lastlea2')]"));
			 tbox1.sendKeys("ABCD");
			 WebElement tbox2=driver.findElement(By.xpath("//input[contains(@name,'lea3')]"));
			 tbox2 .sendKeys("EFGH");
			 WebElement tbox3=driver.findElement(By.xpath("//div[contains(@class,'pbBottomButtons')]//input[1]"));
			 clickElement(tbox3, "tbox3");
			WebElement drop_down=driver.findElement(By.xpath("//div[@id='userNav-arrow']"));
			drop_down(drop_down,"drop_down" );
			Thread.sleep(2000L);
			WebElement logout = driver.findElement(By.xpath("//a[contains(text(),'Logout')]"));
			logOut(logout, "logout");
		logger.log(LogStatus.PASS, "Test TC24 is passed");
		reports.endTest(logger);
	}
	public static void TC__25_Login() throws InterruptedException, IOException {
		logger = reports.startTest("TC25");
			WebElement pwd = driver.findElement(By.xpath("//input[@id='password']"));
			login(pwd, "24july1996", "Password");
			WebElement login = driver.findElement(By.xpath("//*[@id='Login']"));
			clickElement(login, "Login");
			WebElement conTab=driver.findElement(By.xpath("//a[contains(text(),'Opportunities')]/following::li[2]"));
			clickElement(conTab, "conTab");
			WebElement newtext=driver.findElement(By.xpath("//input[@name='new']"));
			clickElement(newtext, "newtext");
			WebElement nametext=driver.findElement(By.xpath("//input[@name='name_lastcon2']"));
			nametext.sendKeys("anshu");
			WebElement compy=driver.findElement(By.xpath("//input[@name='con4']"));
			compy.sendKeys("Admin Anshu");
			WebElement save=driver.findElement(By.xpath("//div[contains(@class,'pbBottomButtons')]//input[1]"));
			clickElement(save, "save");
			WebElement drop_down=driver.findElement(By.xpath("//div[@id='userNav-arrow']"));
			drop_down(drop_down,"drop_down" );
			Thread.sleep(2000L);
			WebElement logout = driver.findElement(By.xpath("//a[contains(text(),'Logout')]"));
			logOut(logout, "logout");
		logger.log(LogStatus.PASS, "Test TC25 is passed");
		reports.endTest(logger);
	}
	public static void TC__26_Login() throws InterruptedException, IOException {
		logger = reports.startTest("TC26");
			WebElement pwd = driver.findElement(By.xpath("//input[@id='password']"));
			login(pwd, "24july1996", "Password");
			WebElement login = driver.findElement(By.xpath("//*[@id='Login']"));
			clickElement(login, "Login");
			WebElement conTab=driver.findElement(By.xpath("//a[contains(text(),'Opportunities')]/following::li[2]"));
			clickElement(conTab, "conTab");
			WebElement newview=driver.findElement(By.xpath("//a[contains(text(),'Create New View')]"));
			clickElement(newview, "newview");
			WebElement opname=driver.findElement(By.xpath("//input[@id='fname']"));
			opname.sendKeys("Optimized Name");
			WebElement opUname=driver.findElement(By.xpath("//input[@id='devname']"));
			opUname.sendKeys("Optimized_uniqueName");
			WebElement save=driver.findElement(By.xpath("//div[@class='pbBottomButtons']//input[@name='save']"));
			clickElement(save, "save");
			WebElement drop_down=driver.findElement(By.xpath("//div[@id='userNav-arrow']"));
			drop_down(drop_down,"drop_down" );
			Thread.sleep(2000L);
			WebElement logout = driver.findElement(By.xpath("//a[contains(text(),'Logout')]"));
			logOut(logout, "logout");
		logger.log(LogStatus.PASS, "Test TC26 is passed");
		reports.endTest(logger);
	}
	public static void TC__27_Login() throws InterruptedException, IOException {
		logger = reports.startTest("TC27");
			WebElement pwd = driver.findElement(By.xpath("//input[@id='password']"));
			login(pwd, "24july1996", "Password");
			WebElement login = driver.findElement(By.xpath("//*[@id='Login']"));
			clickElement(login, "Login");
			WebElement conTab=driver.findElement(By.xpath("//a[contains(text(),'Opportunities')]/following::li[2]"));
			clickElement(conTab, "conTab");
			WebElement new1=driver.findElement(By.xpath("//input[@name='new']"));
			clickElement(new1, "new1");
			WebElement lname=driver.findElement(By.xpath("//input[@name='name_lastcon2']"));
			lname.sendKeys("anshu");
			WebElement compname=driver.findElement(By.xpath("//input[@name='con4']"));
			compname.sendKeys("Admin Anshu");
			WebElement save=driver.findElement(By.xpath("//div[contains(@class,'pbBottomButtons')]//input[1]"));
			clickElement(save, "save");
			WebElement conTab2=driver.findElement(By.xpath("//a[contains(text(),'Opportunities')]/following::li[2]"));
			clickElement(conTab2, "conTab2");
			WebElement drop_down=driver.findElement(By.xpath("//select[@id='hotlist_mode']"));
			selectValueFromDropDowntext(drop_down ,"Recently Viewed");
			WebElement drop_down1=driver.findElement(By.xpath("//div[@id='userNav-arrow']"));
			drop_down(drop_down1,"drop_down" );
			Thread.sleep(2000L);
			WebElement logout = driver.findElement(By.xpath("//a[contains(text(),'Logout')]"));
			logOut(logout, "logout");
		logger.log(LogStatus.PASS, "Test TC27 is passed");
		reports.endTest(logger);
	}
	public static void TC__28_Login() throws InterruptedException, IOException {
		logger = reports.startTest("TC28");
			WebElement pwd = driver.findElement(By.xpath("//input[@id='password']"));
			login(pwd, "24july1996", "Password");
			WebElement login = driver.findElement(By.xpath("//*[@id='Login']"));
			clickElement(login, "Login");
			WebElement leadTab=driver.findElement(By.xpath("//a[contains(text(),'Opportunities')]/following::li[2]"));
			clickElement(leadTab, "leadTab");
			WebElement drop_down=driver.findElement(By.xpath("//select[@id='fcf']"));
			selectValueFromDropDowntext(drop_down ,"All Contacts");
			WebElement drop_down1=driver.findElement(By.xpath("//div[@id='userNav-arrow']"));
			drop_down(drop_down1,"drop_down" );
			Thread.sleep(2000L);
			WebElement logout = driver.findElement(By.xpath("//a[contains(text(),'Logout')]"));
			logOut(logout, "logout");
		logger.log(LogStatus.PASS, "Test TC28 is passed");
		reports.endTest(logger);
	}
	public static void TC__29_Login() throws InterruptedException, IOException {
		logger = reports.startTest("TC29");
			WebElement pwd = driver.findElement(By.xpath("//input[@id='password']"));
			login(pwd, "24july1996", "Password");
			WebElement login = driver.findElement(By.xpath("//*[@id='Login']"));
			clickElement(login, "Login");
			WebElement leadTab=driver.findElement(By.xpath("//a[contains(text(),'Opportunities')]/following::li[2]"));
			clickElement(leadTab, "leadTab");
			WebElement drop_down=driver.findElement(By.xpath("//select[@id='fcf']"));
			selectValueFromDropDowntext(drop_down ,"My Contacts");
			WebElement name=driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[2]/table[1]/tbody[1]/tr[1]/td[2]"
					+ "/div[3]/div[1]/div[1]/div[2]/table[1]/tbody[1]/tr[2]/th[1]/a[1]"));
			clickElement(name, "name");
			WebElement drop_down1=driver.findElement(By.xpath("//div[@id='userNav-arrow']"));
			drop_down(drop_down1,"drop_down" );
			Thread.sleep(2000L);
			WebElement logout = driver.findElement(By.xpath("//a[contains(text(),'Logout')]"));
			logOut(logout, "logout");
		logger.log(LogStatus.PASS, "Test TC29 is passed");
		reports.endTest(logger);
	}
	public static void TC__30_Login() throws InterruptedException, IOException {
		logger = reports.startTest("TC30");
			WebElement pwd = driver.findElement(By.xpath("//input[@id='password']"));
			login(pwd, "24july1996", "Password");
			WebElement login = driver.findElement(By.xpath("//*[@id='Login']"));
			clickElement(login, "Login");
			WebElement leadTab=driver.findElement(By.xpath("//a[contains(text(),'Opportunities')]/following::li[2]"));
			clickElement(leadTab, "leadTab");
			WebElement CNewVie=driver.findElement(By.xpath("//a[contains(text(),'Create New View')]"));
			clickElement(CNewVie, "CNewVie");
			WebElement Ntab=driver.findElement(By.xpath("//input[@id='fname']"));
			Ntab.sendKeys("ABCD");
			WebElement Ntab2=driver.findElement(By.xpath("//input[@id='devname']"));
			Ntab2.sendKeys("EFGH");
			WebElement save=driver.findElement(By.xpath("//div[@class='pbBottomButtons']//input[@name='cancel']"));
			clickElement(save, "save");
			WebElement drop_down=driver.findElement(By.xpath("//div[@id='userNav-arrow']"));
			drop_down(drop_down,"drop_down" );
			Thread.sleep(2000L);
			WebElement logout = driver.findElement(By.xpath("//a[contains(text(),'Logout')]"));
			logOut(logout, "logout");
		logger.log(LogStatus.PASS, "Test TC30 is passed");
		reports.endTest(logger);
	}
	public static void TC__31_Login() throws InterruptedException, IOException {
		logger = reports.startTest("TC31");
			WebElement pwd = driver.findElement(By.xpath("//input[@id='password']"));
			login(pwd, "24july1996", "Password");
			WebElement login = driver.findElement(By.xpath("//*[@id='Login']"));
			clickElement(login, "Login");
			WebElement leadTab=driver.findElement(By.xpath("//a[contains(text(),'Opportunities')]/following::li[2]"));
			clickElement(leadTab, "leadTab");
			WebElement newview=driver.findElement(By.xpath("//a[contains(text(),'Create New View')]"));
			clickElement(newview, "newview");
			WebElement nametext=driver.findElement(By.xpath("//input[@id='fname']"));
			nametext.sendKeys("shu an");
			WebElement nametext2=driver.findElement(By.xpath("//input[@id='devname']"));
			nametext2.sendKeys("shu_an");
			WebElement clicbox=driver.findElement(By.xpath("//div[3]//table[1]//tbody[1]//tr[1]//td[2]//input[1]"));
			clickElement(clicbox, "clicbox");
			WebElement drop_down=driver.findElement(By.xpath("//div[@id='userNav-arrow']"));
			drop_down(drop_down,"drop_down" );
			Thread.sleep(2000L);
			WebElement logout = driver.findElement(By.xpath("//a[contains(text(),'Logout')]"));
			logOut(logout, "logout");
		logger.log(LogStatus.PASS, "Test TC31 is passed");
		reports.endTest(logger);
	}
	public static void TC__32_Login() throws InterruptedException, IOException {
		logger = reports.startTest("TC32");
			WebElement pwd = driver.findElement(By.xpath("//input[@id='password']"));
			login(pwd, "24july1996", "Password");
			WebElement login = driver.findElement(By.xpath("//*[@id='Login']"));
			clickElement(login, "Login");
			WebElement leadTab=driver.findElement(By.xpath("//a[contains(text(),'Opportunities')]/following::li[2]"));
			clickElement(leadTab, "leadTab");
			WebElement edit=driver.findElement(By.xpath("//span[@class='fFooter']//a[contains(text(),'Edit')]"));
			clickElement(edit, "edit");
			WebElement newtext=driver.findElement(By.xpath("//input[@id='fname']"));
			newtext.sendKeys("indian");
			WebElement compyname=driver.findElement(By.xpath("//input[@id='devname']"));
			compyname.sendKeys("global_media");
			WebElement save=driver.findElement(By.xpath("//div[3]//table[1]//tbody[1]//tr[1]//td[2]//input[1]"));
			clickElement(save, "save");
			WebElement drop_down=driver.findElement(By.xpath("//div[@id='userNav-arrow']"));
			drop_down(drop_down,"drop_down" );
			Thread.sleep(2000L);
			WebElement logout = driver.findElement(By.xpath("//a[contains(text(),'Logout')]"));
			logOut(logout, "logout");
		logger.log(LogStatus.PASS, "Test TC32 is passed");
		reports.endTest(logger);
	}
	public static void TC__33_Login() throws InterruptedException, IOException {
		logger = reports.startTest("TC33");
			WebElement pwd = driver.findElement(By.xpath("//input[@id='password']"));
			login(pwd, "24july1996", "Password");
			WebElement login = driver.findElement(By.xpath("//*[@id='Login']"));
			clickElement(login, "Login");
			WebElement hometab=driver.findElement(By.xpath("//li[@id='home_Tab']//a[contains(text(),'Home')]"));
			clickElement(hometab, "hometab");
			WebElement profilename=driver.findElement(By.xpath("//a[contains(text(),'Aruna bindra')]"));
			clickElement(profilename, "profilename");
			WebElement drop_down=driver.findElement(By.xpath("//div[@id='userNav-arrow']"));
			drop_down(drop_down,"drop_down" );
			Thread.sleep(2000L);
			WebElement logout = driver.findElement(By.xpath("//a[contains(text(),'Logout')]"));
			logOut(logout, "logout");
		logger.log(LogStatus.PASS, "Test TC33 is passed");
		reports.endTest(logger);
	}
	public static void TC__36_Login() throws InterruptedException, IOException {
		logger = reports.startTest("TC36");
			WebElement pwd = driver.findElement(By.xpath("//input[@id='password']"));
			login(pwd, "24july1996", "Password");
			WebElement login = driver.findElement(By.xpath("//*[@id='Login']"));
			clickElement(login, "Login");
			WebElement hometab=driver.findElement(By.xpath("//li[@id='home_Tab']//a[contains(text(),'Home')]"));
			clickElement(hometab,"hometab");
			WebElement pickAday=driver.findElement(By.xpath("//a[contains(text(),'Saturday July 4, 2020')]"));
			clickElement(pickAday,"pickAday");
			WebElement table=driver.findElement(By.xpath("//td[contains(@class,'fixedTable')]//div[5]/a"));
			clickElement(table,"table");
			Thread.sleep(2000L);
			WebElement tableEle=driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[2]/table[1]/tbody[1]/tr[1]/td"
					+ "[2]/form[1]/div[1]/div[2]/div[4]/table[1]/tbody[1]/tr[2]/td[2]/div[1]/a[1]/img[1]"));
			clickElement(tableEle,"tableEle");

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
			WebElement drop_down=driver.findElement(By.xpath("//div[@id='userNav-arrow']"));
			drop_down(drop_down,"drop_down" );
			Thread.sleep(2000L);
			WebElement logout = driver.findElement(By.xpath("//a[contains(text(),'Logout')]"));
			logOut(logout, "logout");
		logger.log(LogStatus.PASS, "Test TC36 is passed");
		reports.endTest(logger);
		reports.flush();
	}
	
}


