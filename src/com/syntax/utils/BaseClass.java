package com.syntax.utils;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.*;


public class BaseClass {
	public static WebDriver driver;
	@BeforeMethod(alwaysRun=true)
	public static WebDriver setUp() {
		System.setProperty(ChromeDriverService.CHROME_DRIVER_SILENT_OUTPUT_PROPERTY, "true");
		ConfigsReader.readProperties(Constants.CONFIGURATION_FILEPATH);
		
		switch(ConfigsReader.getProperty("browser").toLowerCase()){
		case "chrome":
			System.setProperty("webdriver.chrome.driver",Constants.CHROME_DRIVER_PATH);
			driver=new ChromeDriver();
			break;
			
		case "firefox":
			System.setProperty("webdriver.gecko.driver",Constants.GECKO_DRIVER_PATH);
			driver=new FirefoxDriver();
			break;
			default:
				throw new RuntimeException("Browser is not supported");
		}
		driver.get(ConfigsReader.getProperty("url"));
		driver.manage().window().maximize();
		//driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		PageInitializer.initialize();
		return driver;
	}
	@AfterMethod (alwaysRun=true)
      public static void tearDown() {//bazen quit calismayabilir bu sinifa gel
    	  if(driver!=null) {
    		  driver.quit();
    	  }
      }
}
