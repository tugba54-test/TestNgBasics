package com.class02;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.syntax.utils.CommonMethods;

public class OrangeHrmAliBey extends CommonMethods{
	
		
		@BeforeMethod
		public void OpenBrowser() {
			setUp();
			
	}
		@AfterMethod
		public void closeBrowser() {
		tearDown();
		}
		@Test
		public void titleValidation() {
			String expectedTitle="OrangeHRM";
			String actualTitle=driver.getTitle();
			Assert.assertEquals(actualTitle, expectedTitle, "Title mismatch");//instead of using if
			System.out.println("i am after test");
		}
		@AfterMethod
		public void close() {
			tearDown();
			
		}


}
