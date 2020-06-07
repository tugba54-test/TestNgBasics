package com.test;

import org.testng.Assert;
import org.testng.annotations.*;

import com.pages.DashBoardPageElements;
import com.pages.LoginPageElements;
import com.syntax.utils.CommonMethods;
import com.syntax.utils.ConfigsReader;

public class LoginTest extends CommonMethods{
	


	
	@Test
	public void validAdminLogin() {
		LoginPageElements login=new LoginPageElements();
		sendText(login.username,ConfigsReader.getProperty("username"));
		sendText(login.password,ConfigsReader.getProperty("password"));
		login.loginBtn.click();
		
		DashBoardPageElements dash=new DashBoardPageElements();
		String ActualUser=dash.welcome.getText();
		String expectedUser="Welcome Admin";
		Assert.assertEquals(ActualUser, expectedUser);
		Assert.assertTrue(ActualUser.contains(ConfigsReader.getProperty("username")));
	}
	
	@Test
	public void invalidpasswordLogin() {
		LoginPageElements login=new LoginPageElements();
		sendText(login.username,ConfigsReader.getProperty("username"));
		sendText(login.password,"ghjgjhg");
		login.loginBtn.click();
		String expected="Invalid credentials";
		Assert.assertEquals(login.errorMsg.getText(), expected, "Error message does not match");
		
	}
	
	@Test
	public void emptyUsernameLogin() {
		LoginPageElements login=new LoginPageElements();
		sendText(login.password,ConfigsReader.getProperty("password"));
		click(login.loginBtn);
		
		String expected="Username cannot be empty";
		Assert.assertEquals(login.errorMsg.getText(), expected, "Error message does not match");
		
		
	}
	@AfterMethod
	public void Close(){
		tearDown();
		}
	
}