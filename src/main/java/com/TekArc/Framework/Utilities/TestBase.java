package com.TekArc.Framework.Utilities;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Listeners;

@Listeners(com.TekArc.Framework.Utilities.TestListner.class)

public class TestBase {
  public static WebDriver driver;
  public static CommonUtilities oCommUtil = new CommonUtilities();
  public static BrowerUtilities oBroUti = new BrowerUtilities();
  public static constants oCons = new constants();

  public static ExtentReports reports;
  public static ExtentTest logger;

  public static void InitializeReport() {
    System.out.println(System.getProperty("user.dir") + "/report/");
    // reports= new ExtentReports(System.getProperty("user.dir") +
    // "/report/myreport.html", true);
    reports = new ExtentReports(System.getProperty("user.dir") + "/report/"
        + new SimpleDateFormat("'SalesForceReport_'YYYYMMddHHmmss'.html'").format(new Date()));
  }

  public String takeScreenshot() throws IOException {
    TakesScreenshot srcShot = ((TakesScreenshot) driver);
    File srcFile = srcShot.getScreenshotAs(OutputType.FILE);
    String imagePath = System.getProperty("user.dir") + "/report/myreport.html" + "ScreenShots/"
        + new SimpleDateFormat("'Image_'YYYYMMddHHmmss'.png'").format(new Date());
    File destFile = new File(imagePath);
    FileUtils.copyFile(srcFile, destFile);
    return imagePath;
  }

  @BeforeSuite
  public static void InitializeDependencies() throws Exception {
    System.out.println(System.getProperty("user.dir"));
    CommonUtilities.loadPropertyFiles(
        System.getProperty("user.dir") + "\\src\\main\\java\\com\\TekArc\\Framework\\Configrations\\config.properties");

    driver = BrowerUtilities.launchBrowser(System.getProperty("Browser"));

    InitializeReport();
  }

  @AfterSuite
  public void ShuttingDownAllDependencies() {
    driver.quit();
  }

}
