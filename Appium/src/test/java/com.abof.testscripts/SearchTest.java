package com.abof.testscripts;

import org.testng.annotations.Test;

import com.abof.generic.BaseLib;
import com.abof.generic.ExcelUtils;
import com.abof.generic.WaitStatementLib;
import com.abof.pageobjects.HomeActivity;
import com.abof.pageobjects.ProductListingActivity;

public class SearchTest extends BaseLib{
	
	public HomeActivity homeActivity;
	public ProductListingActivity prodListActvity;
	
	@Test
	public void searchProdTest(){
		WaitStatementLib.hardWait(2);
		homeActivity=new HomeActivity(driver);
		String prodName = ExcelUtils.readData("Sheet1", 1, 2);
		homeActivity.searchProduct(prodName);
		WaitStatementLib.hardWait(2);
		prodListActvity=new ProductListingActivity(driver);
		prodListActvity.verifyShirtMenu();
	}

}
