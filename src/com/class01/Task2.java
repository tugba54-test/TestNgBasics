package com.class01;

import org.openqa.selenium.By;
import org.testng.annotations.*;
import org.testng.annotations.Test;

import com.pages.DashBoardPageElements;
import com.pages.LoginPageElements;
import com.syntax.utils.CommonMethods;
import com.syntax.utils.ConfigsReader;


public class Task2 extends CommonMethods{
//	HRMS Application Login: 1.Open chrome browser
//	 * 2.Go to “http://166.62.36.207/humanresources/symfony/web/index.php/auth/login”
//	 * 3.Enter valid username and password
//	 * 4.Click on login button
//	 * 5.Then verify Syntax Logo is displayed
//	 * 6.Close the browser
//	 *
//	 * 3.Enter valid username
//	 * 4.Leave password field empty
//	 * 5.Verify error message with text “Password cannot be empty” is displayed.
	@BeforeMethod
	public void beforeTest() {
		setUp();
		
	}
		//dependsOnMethods to tell TestNG which methods this test is dependent on,
//	so those methods should be executed before this method
	//alphbetical<priority<dependsOnMethods
	@Test
	public void inValidLogin() {
		//WebElement user=driver.findElement(By.id("txtUsername"));
		//first way
		//user.sendKeys(ConfigsReader.getProperty("username"));
		
		//second way
		//sendText(user, ConfigsReader.getProperty("username"));
		
		
		
		
		
		driver.findElement(By.id("btnLogin")).click();
		
	//First way
		//WebElement login=driver.findElement(By.cssSelector("span[id='spanMessage']"));
		//login.click();
		 //String  actual=login.getText();
		 
		LoginPageElements logo=new LoginPageElements();
		
      
       String expect="Password cannot be empty";
       if(logo.errorMsg.getText().equals(expect)) {
    	   System.out.println("error message is pass");
       }else {
    	   System.out.println("error message is failed");
       }
       wait(2);
		
	}
	@Test(priority=3, enabled=true)//priority break alphabetical order
	public void validLogin() {
//		WebElement user=driver.findElement(By.id("txtUsername"));
//		sendText(user, ConfigsReader.getProperty("username"));
//		WebElement pass=driver.findElement(By.id("txtPassword"));
//		sendText(pass, ConfigsReader.getProperty("password"));
//		driver.findElement(By.id("btnLogin")).click();
		
		LoginPageElements login=new LoginPageElements();
//		login.username.sendKeys("Admin");
//		login.password.sendKeys("Hum@nhrm123");
//		login.loginBtn.click();
		
		//Best Way
		sendText(login.username,ConfigsReader.getProperty("username"));
		sendText(login.password,ConfigsReader.getProperty("password"));
		
		//firstway
//		WebDriverWait wait=new WebDriverWait(driver, Constants.EXPLICIT_WAIT_TIME);
//		wait.until(ExpectedConditions.elementToBeClickable(login.loginBtn));
		
		//second way
		//waitForClickability(login.loginBtn);//we are using methos here
		//login.loginBtn.click();
		
		//thirdWay
		click(login.loginBtn);
		
		//first way
		//WebElement Logo=driver.findElement(By.xpath("//img[@alt='OrangeHRM']"));
		
		DashBoardPageElements dashboard=new DashBoardPageElements();
		
		if(dashboard.logo.isDisplayed()) {
			System.out.println("Logo displayed test pass");
		}else {
			System.out.println("Logo displayed test failed");
		}
	}
	@AfterMethod
	public void closeBrowsr() {
		tearDown();
	}

}
