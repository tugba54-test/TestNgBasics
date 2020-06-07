package com.test;

import org.testng.Assert;
import org.testng.annotations.*;

import com.syntax.utils.CommonMethods;
import com.syntax.utils.ConfigsReader;

public class AselTask extends CommonMethods {
//	Automate user stories below:
//		US 12678 As an Admin I should be able to create login credentials while adding employee
//
//		US 67789 As an admin while adding employee if I leave required fields empty I should see “Required” message
//		Note: first name and last name are required fields

	
	@Test
	public void AddloginCredential() {
		
		login.adminLogin();
		dashboard.navigateToAddEmployee();
		addEmp.addNewEmp();
		addEmp.CreateLogin();

		Assert.assertEquals(pdetails.verifyEmp.getText(),ConfigsReader.getProperty("fullname"));
		
		
	}
	
	@Test
	public void Requiredmessage() {
		login.adminLogin();
		dashboard.navigateToAddEmployee();
		sendText(addEmp.middleName,"Zeynep");
		click(addEmp.saveBtn);
		Assert.assertEquals(addEmp.requiredfirstName.getText(), "Required");
		Assert.assertEquals(addEmp.requiredLastName.getText(),"Required");
	}
	
	
	
	
	
}
