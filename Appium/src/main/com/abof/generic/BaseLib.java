package com.abof.generic;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

public class BaseLib {
	
	public static final String APPIUM_JS="C:/Users/Lenovo/AppData/Local/Programs/appium-desktop/resources"
			+ "/app/node_modules/appium/build/lib/main.js";
	public static final String NODE_JS="C:/Program Files/nodejs/node.exe";
	
	public static AppiumDriverLocalService service;
	public AndroidDriver<MobileElement> driver;
	public AppUtils appUtil;


	public static void startAppiumServer(){
		System.out.println("Appium server statrting...");
		service=AppiumDriverLocalService.buildService(new AppiumServiceBuilder().usingAnyFreePort()
				.usingDriverExecutable(new File(NODE_JS)).withAppiumJS(new File(APPIUM_JS)));
		service.start();
		System.out.println("Appium server started.");

	}

	public static void stopAppiumServer(){
		System.out.println("Appium server stopping...");
		service.stop();
		System.out.println("Appium server stopped.");
	}

	@BeforeMethod
	public void setUp(){
		startAppiumServer();
		DesiredCapabilities dc=new DesiredCapabilities();
		dc.setCapability("automationName", GetPropertyValue.readValue("AutomationName"));
		dc.setCapability("deviceName", GetPropertyValue.readValue("DeviceName"));
		dc.setCapability("platformName", GetPropertyValue.readValue("PlatformName"));
		dc.setCapability("platformVersion", GetPropertyValue.readValue("PlatformVersion"));
		dc.setCapability("appPackage", GetPropertyValue.readValue("AppPackage"));
		dc.setCapability("appActivity", GetPropertyValue.readValue("AppActivity"));
		dc.setCapability("noReset", GetPropertyValue.readValue("NoReset"));
		try {
			driver=new AndroidDriver<MobileElement>(new URL(service.getUrl().toString()), dc);
			WaitStatementLib.iWait(driver, 40);
			appUtil = new AppUtils(driver);
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
		
	}
	@AfterMethod
	public void tearDownActivity(ITestResult result){
		if(!result.isSuccess()){
			TakesScreenshot ts=(TakesScreenshot) driver;
			File source = ts.getScreenshotAs(OutputType.FILE);
			try {
				FileUtils.copyFile(source, new File("./screenshots/"+result.getMethod().getMethodName()+".png"));
			} catch (IOException e) {
				e.printStackTrace();
			}
			
		}
		
		if(driver!=null){
			driver.closeApp();
			stopAppiumServer();
		}
		
		
	}

}
