package com.class02;



import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.*;

import com.syntax.utils.CommonMethods;
import com.syntax.utils.ConfigsReader;


public class HRMSAddEmployee extends CommonMethods{
//	TC 1: HRMS Add Employee: 1.Open chrome browser
//	2.Go to “http://166.62.36.207/humanresources/symfony/web/index.php/auth/login”
//	3.Login into the application
//	4.Click on Add Employee
//	5.Verify labels: Full Name, Employee Id, Photograph are displayed
//	6.Provide Employee First and Last Name
//	7.Add a picture to the profile 
//	8.Verify Employee has been added successfully
//	9.Close the browser
	@BeforeMethod
	public void Open() {
		setUp();
		initialize();
		//LoginPageElements login=new LoginPageElements();
		
		sendText(login.username,ConfigsReader.getProperty("username"));
		sendText(login.password, ConfigsReader.getProperty("password"));
		login.loginBtn.click();
		
      //DashBoardPageElements board=new DashBoardPageElements();
		
		dashboard.Pim.click();
		jsClick(dashboard.addEmployee );
		
		
	}
	
	@Test
	public void DisplayFunction()  {
		
		//AddEmployeePageElements board=new AddEmployeePageElements();
		
		Assert.assertTrue(addEmp.fullName.isDisplayed(), "Full name is not displayed");
	    Assert.assertTrue(addEmp.EmpId.isDisplayed(),"Id Is Not Displayed");
	    Assert.assertTrue(addEmp.uploadPhoto.isDisplayed());
		
	}
	
	@Test
	public void AddEmployee() throws InterruptedException {
		//AddEmployeePageElements board=new AddEmployeePageElements();
		String expname="Kubra";
		String Explast="Akca";
		
		sendText(addEmp.firstName, expname);
        sendText(addEmp.lastName, Explast);
		String expId=addEmp.EmpId.getText();
		
		String filePath="C:\\Users\\16824\\Pictures\\Saved Pictures\\screen.png";
		
		WebElement ExpPhoto=addEmp.uploadPhoto;
		ExpPhoto.sendKeys(filePath);
		jsClick(addEmp.saveBtn );
	
		String actID=driver.findElement(By.id("personal_txtEmployeeId")).getText();
		
		WebElement Actphoto=driver.findElement(By.xpath("//img[@id='empPic']"));
		String expFull=expname+" "+Explast;
		
		Thread.sleep(3000);
		String AfullText=driver.findElement(By.xpath("//div[@id='profile-pic']/h1")).getText();     
		
		Assert.assertEquals(AfullText, expFull);
		Assert.assertEquals(actID, expId);
		Assert.assertTrue(Actphoto.isDisplayed());
		
	}
	@AfterMethod
	public void close() {
		tearDown();
	}
}