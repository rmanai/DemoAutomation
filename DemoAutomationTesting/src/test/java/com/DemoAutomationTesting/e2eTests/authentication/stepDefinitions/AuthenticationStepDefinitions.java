package com.DemoAutomationTesting.e2eTests.authentication.stepDefinitions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import com.DemoAutomationTesting.e2eTests.authentication.models.AuthenticationModel;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class AuthenticationStepDefinitions {
	

	public WebDriver driver;
	
	 private	AuthenticationModel loginPage =  PageFactory.initElements(driver,  AuthenticationModel.class); 
	
	
	@Given("^Navigate to Gmail login page$")
	public void navigateToGmailLoginPage() throws Throwable {
		
		loginPage.enterLoginPage();
		
	  //  throw new PendingException();
	}

	@When("^the user enter Login in username field$")
	public void theUserEnterLoginInUsernameField() throws Throwable {
		
	
		
		loginPage.fillUserName();
		loginPage.clickLoginButton();
	
		//   throw new PendingException();
	}

	@When("^the user enter Password in password field$")
	public void theUserEnterPasswordInPasswordField() throws Throwable {
		loginPage.fillPassword();
	
		//   throw new PendingException();
	}

	@When("^the user clicks on connection button$")
	public void theUserClicksOnConnectionButton() throws Throwable {
	 
		loginPage.clickLoginButton();
		
		//  throw new PendingException();
	}

	@Then("^the user is redirected to home page$")
	public void theUserIsRedirectedToHomePage() throws Throwable {
		
		loginPage.isConnectedToGmailAccount(); 
	   
		//   throw new PendingException();
	}

}
