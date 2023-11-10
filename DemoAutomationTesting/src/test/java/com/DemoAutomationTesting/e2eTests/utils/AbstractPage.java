package com.DemoAutomationTesting.e2eTests.utils;

import org.openqa.selenium.WebDriver;

import net.codestory.simplelenium.SectionObject;

public class AbstractPage implements SectionObject {

	public static WebDriver driver;
	public static boolean bResult;

	public  AbstractPage(WebDriver driver){
		AbstractPage.driver = driver;
		AbstractPage.bResult = true; 	
	
}
}