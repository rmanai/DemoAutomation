package com.DemoAutomationTesting.e2eTests.utils;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
// import org.openqa.selenium.WebDriverException;


import com.cucumber.listener.Reporter;
import com.google.common.io.Files;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;

public class Setup {
	
	public static WebDriver driver; 
	static DriverManager driverManager;
	
	@Before 
	/*
	 * Call browser with the design pattern factory navigator
	  */
	public static void setup() {
		driverManager = DriverManagerFactory.getManager(DriverType.CHROME);
		driver = driverManager.getDriver();
		driver.get("https://www.gmail.com");
	}
	
	@After
	/*
	 * Embed a screenshot in test report if is test is marked as failed
	  */
/*	public void embedScreenshot(Scenario scenario) {
		if (scenario.isFailed()) {
			try {
				scenario.write("current page url is " +driver.getCurrentUrl() );
				byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
				scenario.embed(screenshot, "image/png");
			}catch(WebDriverException somPlateformDontSupportScreenshots) {
				System.err.println(somPlateformDontSupportScreenshots.getMessage());
			}
		}
	//	driver.quit();
		
	}*/
	
	 public void afterScenario(Scenario scenario) {
		 
		 if (scenario.isFailed()) {
			 
				String screenshotName = scenario.getName().replaceAll(" ", "_");
				try {
					//This takes a screenshot from the driver at save it to the specified location
					File sourcePath = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
					
					//Building up the destination path for the screenshot to save
					//Also make sure to create a folder 'screenshots' with in the cucumber-report folder
					File destinationPath = new File(System.getProperty("user.dir") + "/target/cucumber-reports/" + screenshotName + ".png");
					
					//Copy taken screenshot from source location to destination location
					Files.copy(sourcePath, destinationPath);   

					//This attach the specified screenshot to the test
					Reporter.addScreenCaptureFromPath(destinationPath.toString());
				} catch (IOException e) {
				} 
			}
		    
		      // driver.quit();  
		       
		    }
	
	
}

