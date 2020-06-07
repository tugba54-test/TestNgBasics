package com.class02;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.pages.LoginPageElements;
import com.syntax.utils.CommonMethods;

public class AssertionDemo extends CommonMethods{

//	Assert.assertEqual(String actual,String expected, String message) :
//		Asserts that two Strings are equal.
//	If they are not, an AssertionError,
//	with the given message, is thrown
		@BeforeMethod
		public void openBrowserandnavigate() {
			setUp();
		
	}
		
		@AfterMethod
		public void QuitBrowser() {
		tearDown();	
		}
		
		//Assertion error is handled within TestNg
		
		@Test
		public void TitleValidation() {
			String expectedTitle="Human Management System";
			String actualTitle=driver.getTitle();
			Assert.assertEquals(actualTitle, expectedTitle, "Title does  not match");
			//if hard assertion is fail then statement not executed
			System.out.println("Text after assertion");
		}
	
		@Test//(priority=2,dependsOnMethods= {"titleValidation"})
		public void logoValidation() {
			LoginPageElements login=new LoginPageElements();
			boolean logoDisplay=login.logo.isDisplayed();
			//first way
			//Assert.assertEquals(logoDisplay, true, "Logo is not displayed");
			//secondWay
			Assert.assertTrue(logoDisplay,"Logo is not displayed");
			
		}

}
