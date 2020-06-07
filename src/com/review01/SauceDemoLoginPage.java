package com.review01;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.syntax.utils.BaseClass;
import com.syntax.utils.CommonMethods;

public class SauceDemoLoginPage extends CommonMethods {
	//url=https://www.saucedemo.com/
	
	@FindBy (id="user-name")
	public  WebElement usernametextBox;
	
	@FindBy (id="password")
	public WebElement passwordTextBox;
	
	@FindBy (xpath="//input[@class='btn_action']")
	public WebElement loginButton;
	
	@FindBy (xpath="//div[@class='app_logo']")
	public WebElement headerText;
	
	@FindBy (xpath="//h3[contain(text(),'Epic sadface')]")
	public WebElement errorMsg;
	
	public SauceDemoLoginPage() {
		PageFactory.initElements(BaseClass.driver, this);
	}
	
	
}