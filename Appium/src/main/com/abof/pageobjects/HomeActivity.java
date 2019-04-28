package com.abof.pageobjects;

import org.openqa.selenium.support.PageFactory;

import com.abof.generic.AppUtils;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class HomeActivity {
	
	public AndroidDriver<MobileElement> driver;
	
	@AndroidFindBy(xpath="//android.view.View[@resource-id='toggle-menu']")
	private MobileElement hamBurgerMenu;
	
	@AndroidFindBy(xpath="//android.view.View[@text='?utm_source=app#']")
	private MobileElement searchIcon;
	
	@AndroidFindBy(xpath="//android.view.View[@resource-id='search_form']//android.widget.EditText")
	private MobileElement searchTxtBx;
	
	public HomeActivity(AndroidDriver<MobileElement> driver){
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
		this.driver=driver;
	}
	
	//Steps:---->
	
	public void clickOnHamBurgerMenu(){
		hamBurgerMenu.click();	
	}
	
	public void searchProduct(String prodName){
		searchIcon.click();
		searchTxtBx.sendKeys(prodName);
		AppUtils appUtils=new AppUtils(driver);
		appUtils.clickSearchFromKeypad();
	}

}
