package com.DemoAutomationTesting.e2eTests.authentication.stepDefinitions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import com.DemoAutomationTesting.e2eTests.authentication.models.AuthenticationModel;


import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class AuthenticationStepDefinitions {
	

	public WebDriver driver;
	
	 private	AuthenticationModel loginpage =  PageFactory.initElements(driver,  AuthenticationModel.class); 
	
	
	@Given("^Navigate to Gmail login page$")
	public void navigateToGmailLoginPage() throws Throwable {
		
	    throw new PendingException();
	}

	@When("^the user enter Login in username field$")
	public void theUserEnterLoginInUsernameField() throws Throwable {
		
	
		
		loginpage.fillUserName();
		loginpage.clickLoginButton();
	
	    throw new PendingException();
	}

	@When("^the user enter Password in password field$")
	public void theUserEnterPasswordInPasswordField() throws Throwable {
		loginpage.fillPassword();
	
	    throw new PendingException();
	}

	@When("^the user clicks on connection button$")
	public void theUserClicksOnConnectionButton() throws Throwable {
	 
		loginpage.clickLoginButton();
		
	    throw new PendingException();
	}

	@Then("^the user is redirected to home page$")
	public void theUserIsRedirectedToHomePage() throws Throwable {
		
		loginpage.isConnectedToGmailAccount(); 
	   
	    throw new PendingException();
	}

}
