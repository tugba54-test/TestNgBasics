package com.test;

import org.junit.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.syntax.utils.CommonMethods;

public class SauceDemoTest extends CommonMethods{
	
	@Test(dataProvider="dataProvider")

	
	public static void logintosauceDemo(String username,String password) {
		sendText(loginSauce.usernametextBox,username);
		sendText(loginSauce.passwordTextBox,password);
		loginSauce.loginButton.click();
		
		if(username.equals("locked_out_user")){
				
		Assert.assertTrue(loginSauce.headerText.isDisplayed());
		}else {
		Assert.assertTrue(loginSauce.errorMsg.isDisplayed());
		}
	}
	@DataProvider (name="dataProvider")
	public Object [] [] setUpData () {
		Object [] [] data = new Object [4][2];	
		data [0][0]= "standard_user";
		data[0][1]="secret_sauce";
		data[1][0]="problem_user";
		data[1][1]="secret_sauce";
		data[2][0]="performance_user";
		data[2][1]="secret_sauce";
		data[3][0]="locked_out_user";
		data[3][1]="secret_sauce";
		return data;
	}
	

}
