package com.abof.generic;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class WaitStatementLib {
	
	
	/**
	 * @author Kanhaiya
	 * @param sec
	 * @Desc: Method will wait for the time you have provided
	 */
	public static void hardWait(int sec){
		try {
			Thread.sleep(sec*1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
	}
	
	/**
	 * 
	 * @param driver
	 * @param sec
	 * @Desc: Implicit Wait, just you need to call method and give respective arguments
	 */
	public static void iWait(WebDriver driver, int sec){
		driver.manage().timeouts().implicitlyWait(sec, TimeUnit.SECONDS);
	}
	
	/**
	 * 
	 * @param driver
	 * @param sec
	 * @param element
	 * @ Desc: explicit wait
	 */
	public static void eWait(WebDriver driver, int sec, WebElement element){
		WebDriverWait wait=new WebDriverWait(driver, sec);
		wait.until(ExpectedConditions.visibilityOf(element));
		
	}
	
	

}
