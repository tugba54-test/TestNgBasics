package com.class04;

import org.junit.Assert;
import org.testng.annotations.*;

public class ListenerDemo{
	@Test
	public void test1() {
		System.out.println("test1");
		Assert.assertTrue(true);
	}
	
	@Test
	public void test2() {
		System.out.println("test2");
		Assert.assertTrue(false);
	}
	
}