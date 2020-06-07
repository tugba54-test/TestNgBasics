package com.class02;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.pages.LoginPageElements;
import com.syntax.utils.CommonMethods;
import com.syntax.utils.ConfigsReader;

public class Task2 extends CommonMethods{
//	Task 2
//	Open Application
//	Verify logo is displayed
//	Enter valid credentials
//	Verify user successfully logged in, by verifying welcome message
	
//	Hard Assert throws an AssertException immediately when an assert statement fails
//	and test suite continues with next 
	//@Test
//	SoftAssert : Soft Assert does not throw an exception when an assert fails and would
//	continue with the next step after the assert statement.
	
	@BeforeMethod
	public void Open() {
   	 setUp();
    }
     @AfterMethod
     public void Close() {
    	 tearDown();
     }
	@Test
	public void Logo() {
		LoginPageElements login=new LoginPageElements();
		boolean logoDis=login.logo.isDisplayed();
		Assert.assertTrue(logoDis,"Logo is not displayed");
		
		sendText(login.username,ConfigsReader.getProperty("username"));
		sendText(login.password,ConfigsReader.getProperty("password"));
		
		//Welcome msg assertion
		
   	 
    }
	
}
