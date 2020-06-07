package com.review01;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.syntax.utils.CommonMethods;

public class sauceParameterDemo extends CommonMethods {
	
	
	@Parameters({"username","password"})
    @Test
	public static void logintosauceDemo(String username,String password) {
		sendText(loginSauce.usernametextBox,username);
		sendText(loginSauce.passwordTextBox,password);
		loginSauce.loginButton.click();

}}
