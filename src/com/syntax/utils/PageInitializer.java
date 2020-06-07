package com.syntax.utils;

import com.pages.AddEmployeePageElements;
import com.pages.DashBoardPageElements;
import com.pages.LoginPageElements;
import com.pages.PersonalDetailsPageElements;
import com.review01.SauceDemoLoginPage;


	public class PageInitializer extends BaseClass {
		public static AddEmployeePageElements addEmp;
		public static DashBoardPageElements dashboard;
		public static LoginPageElements login;
		public static PersonalDetailsPageElements pdetails;
		public static SauceDemoLoginPage loginSauce;
		public static void initialize() {
			addEmp=new AddEmployeePageElements();
			dashboard=new DashBoardPageElements();
			login=new LoginPageElements();
			pdetails=new PersonalDetailsPageElements();
			loginSauce=new SauceDemoLoginPage();
		}

	}



