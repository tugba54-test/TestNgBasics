package com.class01;

import org.testng.annotations.BeforeMethod;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.*;

import com.syntax.utils.CommonMethods;
import com.syntax.utils.ConfigsReader;

public class TitleLogoAndLoginValidation extends CommonMethods {
//	Three Test cases
//	before: open browser, navigate to the website
//	1. Test Case: Title Validation
//	after: quit the browser
//	before: open browser, navigate to the website
//	2. Test Case: Logo Validation
//	after: quit the browser
//	before: open browser, navigate to the website
//	3. Test Case Valid Login
//	after: quit the browser
	
	@BeforeMethod
	public void openAndNavigate() {
		setUp();
		
	}

	@AfterMethod
	public void quitBrowser() {
		tearDown();
		
	}
	@Test
	public void titleValidation() {
		String expectedTitle="Human Management System";
		String actualTitle=driver.getTitle();
		if(expectedTitle.equals(actualTitle)) {
			System.out.println("Title validation Test Passed");
		}else {
			System.out.println("Title validation Test Failed");
		}
	}
	
	@Test
	public void logoValidation() {
		boolean isDis=driver.findElement(By.xpath("//div[@id='divLogo']/img")).isDisplayed();
		if(isDis) {
			System.out.println("Logo validation Test Passed");
			
		}else {
			System.out.println("Logo validation Test Failed");
		}
	}
	
	@Test
	public void validLogin() {
		WebElement username=driver.findElement(By.id("txtUsername"));
		sendText(username,ConfigsReader.getProperty("username"));
		WebElement password=driver.findElement(By.id("txtPassword"));
		sendText(password, ConfigsReader.getProperty("password"));
		click(driver.findElement(By.id("btnLogin")));
		WebElement Login=driver.findElement(By.id("welcome"));
		if(Login.isDisplayed()) {
			System.out.println("login validation Test Pass");
		}else {
			System.out.println("login validation Test failed");
		}
		
	}
	
}
