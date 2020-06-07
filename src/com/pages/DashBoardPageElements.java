package com.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.syntax.utils.BaseClass;
import com.syntax.utils.CommonMethods;

public class DashBoardPageElements extends CommonMethods{
	
	@FindBy(id = "welcome")
	public WebElement welcome;
	
      @FindBy(xpath="//div[@id='branding']/a[1]/img")
      public WebElement logo;
      
      @FindBy(xpath="//a[@id='menu_pim_viewPimModule']")
      public WebElement Pim;
      
      @FindBy(xpath="//a[@id='menu_pim_addEmployee']")
      public WebElement addEmployee;
      
     
      public DashBoardPageElements() {
  		PageFactory.initElements(BaseClass.driver, this);
  	}
      public void navigateToAddEmployee() {
    	  jsClick(Pim);
    	  jsClick(addEmployee);
      }
      
}
