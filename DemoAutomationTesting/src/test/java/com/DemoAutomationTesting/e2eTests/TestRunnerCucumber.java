package com.DemoAutomationTesting.e2eTests;

import org.junit.AfterClass;

import org.junit.runner.RunWith;


import cucumber.api.CucumberOptions;
import com.cucumber.listener.Reporter;

import java.io.File;

import cucumber.api.junit.Cucumber;
import cucumber.api.SnippetType;

@RunWith(Cucumber.class)
@CucumberOptions(

		strict = true, 
		features = { "src/test/features" }, 
		plugin = { "pretty", "html:target/cucumber-html-report",
				"json:target/cucumber.json",
				"com.cucumber.listener.ExtentCucumberFormatter:target/cucumber-reports/DemoAutomationTesting_TestReport.html" }, 
		tags = {"@success_login" }, 
		snippets = SnippetType.CAMELCASE, 
		monochrome = true)

public class TestRunnerCucumber {

	@AfterClass
	public static void writeExtentReport() {

		Reporter.loadXMLConfig(new File("src\\test\\ressources\\Configs\\extent-config.xml"));
	}
}
