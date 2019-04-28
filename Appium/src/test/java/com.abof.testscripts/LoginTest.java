package com.abof.testscripts;

import com.abof.generic.BaseLib;
import com.abof.generic.ExcelUtils;
import com.abof.generic.WaitStatementLib;
import com.abof.pageobjects.HomeActivity;
import com.abof.pageobjects.LoginActivity;
import com.abof.pageobjects.SideMenuActivity;
import org.testng.annotations.Test;


public class LoginTest extends BaseLib{
	
	public HomeActivity hmActi;
	public SideMenuActivity sideMenuActv;
	public LoginActivity loginActivity;
	
	@Test(description="TC_ID :1--> To validate valide login")
	public void validLoginTest(){
		hmActi=new HomeActivity(driver);
		WaitStatementLib.hardWait(2);
		hmActi.clickOnHamBurgerMenu();
		WaitStatementLib.hardWait(2);
		sideMenuActv=new SideMenuActivity(driver);
		sideMenuActv.clickOnHiGuestBtn();
		WaitStatementLib.hardWait(2);
		loginActivity=new LoginActivity(driver);
		String mobNo = ExcelUtils.readData("Sheet1", 1, 0);
		String pwd = ExcelUtils.readData("Sheet1", 1, 1);
		loginActivity.login(mobNo, pwd);
		WaitStatementLib.hardWait(2);
		loginActivity.validateLogin();
	
	}

}
