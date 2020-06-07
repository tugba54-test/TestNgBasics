package com.turkish;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.*;

import com.pages.LoginPageElements;
import com.syntax.utils.CommonMethods;

public class OrangeHrmTitleandLoginValidation extends CommonMethods{
	
	@BeforeMethod
	public void Open() {
		setUp();
	}
	@Test
	public void TitleValidation() {
		String actual=driver.getTitle();
		String expected="OrangeHRM";
		Assert.assertEquals(actual, expected,"Title mismatch");
		System.out.println("If test case is pass I am display ");
	}
	//enabled=false dedigimizde calistrmicak bu test i
	//buldugumuz bug i developer a duzelt diyrz diger testlere devam etmek icn
	//bu testi ignore ediyr skip ediyr
	@Test(groups= {"smoke","login"})//500 testin icnde sadece smoke testleri yada belli testleri calistrmak icn 
	public void LoginValidation() {
		LoginPageElements login=new LoginPageElements();
		//first way pom u kullanmadan
//		driver.findElement(By.id("txtUsername")).sendKeys("Admin");
//		driver.findElement(By.id("txtPassword")).sendKeys("admin123");
//		driver.findElement(By.id("btnLogin")).click();
		
		login.username.sendKeys("Admin");
		login.password.sendKeys("admin123");
		login.loginBtn.click();
		WebElement logo=driver.findElement(By.xpath("//div[@id='branding']/a/img"));
		Assert.assertTrue(logo.isDisplayed(), "Login Fail");
		
	}

	@AfterMethod
	public void Close() {
		tearDown();
	}
}
