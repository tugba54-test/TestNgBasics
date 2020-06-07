package com.class01;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class task1 {
  @BeforeClass//only once 
  public void beforeClass() {
	System.out.println("this is a before class");
}
	
   @AfterClass
   public void afterClass() {
	System.out.println("this is a after class");
}
   @BeforeMethod
   public void beforeMethod() {
   	System.out.println("this is a before method");
   }
   @AfterMethod
   public void afterMethod() {
   	System.out.println("this is after method");
   }
		@Test
		public void test1(){
			System.out.println("I am an actual test1");
		}
     @Test
	public void test2() {
    	 System.out.println("I am an actual test 2");
     }
     @Test
		public void test3(){
			System.out.println("I am an actual test3");
		}
//     BeforeMethod – Pre-condition for every Test case in a Class/Program
//     @AfterMethod Post-condition for every Test case in a Class/Program
//     @BeforeClass -Pre-condition for All Test cases in a Class/Program
//     @AfterClasee -Post-condition for All Test cases in a Class/Program

}
