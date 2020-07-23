package com.tekarc.TAassignment;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;


public class javaScriptExecuter {
    static WebDriver driver;

    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        driver= new ChromeDriver();
        JavascriptExecutor js = (JavascriptExecutor) driver;
        driver.get("https://www.xero.com/us/");
        driver.manage().window().maximize();
       
        js.executeScript("Window.scrollBy(0,900)");
        
    
    

	
    



    
}
}