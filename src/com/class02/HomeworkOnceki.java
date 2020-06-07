package com.class02;

import org.testng.annotations.*;

import com.syntax.utils.CommonMethods;

public class HomeworkOnceki extends CommonMethods{
//		// Create a class TaskOne that has 5 test methods named:
//	firstMethod
//	firstMethod1
//	secondMethod
//	thirdMethod
//	fourthMethod
//	
//	And each of them printing the method name
//	Run and observe results
//	Then, add the needed attributes to print the following result:
//	fourthMethod
//	thirdMethod
//	secondMethod
//	firstMethod

	
	@Test
	public void firstMethod() {
		
		System.out.println("i am first method");
	}
	@Test
	public void firstMethod1() {
		
		System.out.println("i am first method1");
	}
	@Test
	public void secondMethod() {
		
		System.out.println("i am second method");
	}
	@Test
	public void thirdMethod() {
		
		System.out.println("i am third method");
	}
	@Test(priority =1)
	public void fouthMethod() {
		
		System.out.println("i am fourth method");
	}


}
