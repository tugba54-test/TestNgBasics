package com.test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.syntax.utils.CommonMethods;


public class Test2 extends CommonMethods{

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		setUp();
		driver.findElement(By.id("prompt")).click();
		
		Thread.sleep(2000);
		
		sendAlertText("Ahmet");
		acceptAlert();
		WebElement promptMssge=	driver.findElement(By.cssSelector("div[id='demo']"));	
		String msg=promptMssge.getText();
		if(msg.contains("Ahmet")) {
			System.out.println("alert box  Test Pass" );
		}else {
			System.out.println("Test Fail");
		}
				
	}

}
