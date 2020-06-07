package com.turkish;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.pages.LoginPageElements;
import com.syntax.utils.CommonMethods;

public class dataProviderRecap extends CommonMethods{
	@BeforeMethod
	public void Open() {
		setUp();
	}
	@AfterMethod
	public void Close() {
		tearDown();
	}
	@Test (dataProvider = "getData")
	public void AddingMultipleEmployee(String name,String lastname) throws InterruptedException {
		//login Hrm
		LoginPageElements login=new LoginPageElements();
		login.username.sendKeys("Admin");
		login.password.sendKeys("admin123");
		login.loginBtn.click();
		Thread.sleep(3000);
		
		//navigate to add Employee page
		driver.findElement(By.xpath("//a[@id='menu_pim_viewPimModule']")).click();
		
		WebElement add=driver.findElement(By.xpath("//a[@id='menu_pim_addEmployee']"));
		jsClick( add);
		Thread.sleep(3000);
		
		//adding  Employee name and lastname
		driver.findElement(By.id("firstName")).sendKeys(name);
		driver.findElement(By.id("lastName")).sendKeys(lastname);
		
		String ExpEmpId=driver.findElement(By.id("employeeId")).getAttribute("value");
		
		driver.findElement(By.id("btnSave")).click();
		
		String actEmpId=driver.findElement(By.id("personal_txtEmployeeId")).getAttribute("value");
		
		Assert.assertEquals(actEmpId, ExpEmpId);
		
		
	}
	
	@DataProvider
	public Object[][] getData(){
		Object [][] data= {
				{"john","Smith"},
				{"Hakan","sukur"},
				{"Michael","Obama"}
		};
		return data;
	}

}
