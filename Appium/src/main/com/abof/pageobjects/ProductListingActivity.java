package com.abof.pageobjects;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.Reporter;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class ProductListingActivity {
	
	@AndroidFindBy(xpath="//android.view.View[@text='abof Men Multicolored Printed Slim Fit Casual Shirt']")
	private MobileElement shirtName;
	
	public ProductListingActivity(AndroidDriver<MobileElement> driver){
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}
	
	public void verifyShirtMenu(){
		String shirt = shirtName.getText();
		Assert.assertTrue(shirt.contains("Shirt"),"Shirt list is not appearing");
		Reporter.log("Shirt list has been verified",true);
	}

}
