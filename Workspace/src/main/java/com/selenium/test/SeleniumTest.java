package com.selenium.test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

/**
 * Created by Lenovo on 9/15/2018.
 */
public class SeleniumTest {
    public static void main(String [] args){
        System.out.println("Test Started");
        /*System.setProperty("webdriver.chrome.driver", "./exefiles/chromedriver.exe");
        WebDriver driver=new ChromeDriver();*/
        System.setProperty("webdriver.gecko.driver", "./exefiles/geckodriver.exe");
        WebDriver driver=new FirefoxDriver();
    }



}
