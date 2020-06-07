package com.class01;

import org.testng.annotations.Test;

public class TestNGDemo{
	
	@Test//testCase
	public void testOne() {
		System.out.println("Step 1");
		System.out.println("Step 2");
		System.out.println("Step 3");
		
	}
	

	@Test
	public void testTwo() {
		System.out.println("test 2");
		
	}

	@Test
	public void testThree() {
		System.out.println("test 3");}
		
//	       Why we use TestNG ?
//			* It gives the ability to produce HTMl reports of 
//			execution ( Selenium was running tests but no reports)
//			* Annotations made testers life easier
//			* Test cases can grouped & prioritized (we can set the execution order) easly.
//			* Parallel testing is possible with TestNG.
//		    * Batch execution is possible ( means group of tests )
//		    * Assertation (verification) is possible
//		    * Data parametiration is possible
//		    * TestNG can be easliy integrated with many different tools- Selenium, maven, cucumber etc	
}