package com.abof.pageobjects;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.Reporter;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class LoginActivity {
	
	@AndroidFindBy(xpath="//android.widget.EditText[@resource-id='sleCustomerMobNo']")
	private MobileElement mobNoTxtBx;
	
	@AndroidFindBy(xpath="//android.widget.EditText[@resource-id='sleCustomerPassword']")
	private MobileElement pwdTxtBx;
	
	@AndroidFindBy(xpath="//android.widget.Button[@resource-id='btnCustomerLogin']")
	private MobileElement loginBtn;

	public LoginActivity(AndroidDriver<MobileElement> driver){
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
		
	}
	
	/**
	 * 
	 * @param mobNo
	 * @param pwd
	 */
	public void login(String mobNo, String pwd){
		mobNoTxtBx.sendKeys(mobNo);
		pwdTxtBx.sendKeys(pwd);
		loginBtn.click();
	}
	
	public void validateLogin(){
		boolean flag=false;
		try {
			flag = loginBtn.isDisplayed();
		} catch (Exception e) {
			//e.printStackTrace();
		}
		Assert.assertFalse(flag,"Login Failed");
		Reporter.log("User has been successfully logged in, verified", true);
		
	}
	
	
	

}
