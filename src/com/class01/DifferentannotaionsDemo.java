package com.class01;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class DifferentannotaionsDemo {
	@BeforeSuite
	public void beforeSuite() {
		System.out.println("before suite");
	}
      
	@AfterSuite
	public void afterSuite(){
		System.out.println("After suite");
		
	}
	
	@BeforeClass
	public void beforeClass() {
		System.out.println("before class ");
	}
      
	@AfterClass
	public void afterClass(){
		System.out.println("After Class");
		
	}
	@BeforeMethod
	public void beforeMethod() {
		System.out.println("before Method");
	}
      
	@AfterMethod
	public void afterMethod(){
		System.out.println("After Method");
		
	}
	@Test
	public void testA() {
		System.out.println("Actual test case A is running");
	}
	@Test
	public void testB() {
		System.out.println("Actual test case B is running");
	}
	
	
	
	
	
	
	
	
	
	
	
}
