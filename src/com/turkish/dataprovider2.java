package com.turkish;

import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.*;

import com.syntax.utils.CommonMethods;

public class dataprovider2 extends CommonMethods {

	/*
	 * 1. Open browser and navigate to orangeHrM 2. login on Orange HRM 3. navigate
	 * to add Employee page 4. Enter Employee name and last name Click save 5.
	 * verify that Employee is added succesfully 6. Close browser
	 */

	// @BeforeMethod
	public void Login() throws InterruptedException {

		sendText(login.username, "Admin");
		sendText(login.password, "admin123");
		click(login.loginBtn);
		Thread.sleep(3000);

	}

	// @AfterMethod
	public void LogOut() {

		jsClick(login.logoutBtn);

		click(login.logout);

	}

	@Test(dataProvider = "getData")
	public void addEmployee(String name, String Lastname, String username, String Password) {

		// navigate to add Employee page
		login.adminLogin();
		dashboard.navigateToAddEmployee();

		sendText(addEmp.firstName, name);
		sendText(addEmp.lastName, Lastname);

		jsClick(addEmp.chkLogin);
		sendText(addEmp.newEmpName, username);
		sendText(addEmp.newEmpPassword, Password);
		sendText(addEmp.confirmPassword, Password);
		Select select = new Select(addEmp.status);
		select.selectByVisibleText("Enabled");

		jsClick(addEmp.saveBtn);

		String ActualFN = pdetails.verifyEmp.getText();
		String ExpectedFN = name + " " + Lastname;

		Assert.assertEquals(ActualFN, ExpectedFN, "Name MISMATCH");
		wait(2);
		takesScreenshot(name + Lastname);
	}

	@DataProvider(name = "userDataFromExcel")
	public Object[][] getData2() {
		return null;

	}

	@DataProvider
	public Object[][] getData() {
		Object[][] data = { { "Jane", "Smith", "jane21433", "Janeh13-9=*" },
				{ "John", "Smith", "jho2n0193", "Jhon345+)9" }, { "Ayse", "Yilmaz", "ayse21943", "Ayse789#$%" },
				{ "Ahmet", "Haci", "Haci1323", "Ahmet9287&*%$" }, { "Ali", "Tarlaci", "Tarlaci72289", "Ali456&*$#" }

		};

		return data;

	}

}
