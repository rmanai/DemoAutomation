package com.DemoAutomationTesting.e2eTests.authentication.models;



import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.DemoAutomationTesting.e2eTests.authentication.page.AuthenticationPage;

public class AuthenticationModel {
	
	

    public WebDriver driver;
    
    private AuthenticationPage AuthenticationPage = new AuthenticationPage(driver);
    
	
	public AuthenticationModel (WebDriver driver){
		
		this.driver=driver;	
		PageFactory.initElements(driver, this);
	}
	

	
/*Methods*/
	
	public boolean enterLoginPage() {
		return AuthenticationPage.login_page.isDisplayed();
		
		
	        
		
	}
	
	
	
	public void fillUserName() throws InterruptedException {
		
		/*
		 * WebElement element = new WebDriverWait(driver, 10)
		 * .until(ExpectedConditions.presenceOfElementLocated(AuthenticationPage.
		 * emailTextBox)); element.sendKeys("zied.ha.test@gmail.com");
		 */
	Thread.sleep(5000);
		
	// AuthenticationPage.emailTextBox.sendKeys("zied.ha.test@gmail.com");
		AuthenticationPage.gmailIdentifierTxt.sendKeys("zied.ha.test@gmail.com");
		
	
	
		
		
	}
	
	
	public void fillPassword() throws InterruptedException {
		AuthenticationPage.passwordTextBox.sendKeys("za_ha_test");
		
	}
	/*
	 * public void fillUserName(String name) {
	 * 
	 * username.sendKeys(name); } 
	 * 
	 * 
	 * public void fillPassword(String pswd) {
	 * password.sendKeys(pswd); }
	 */
	
	public void clickLoginButton() {
		AuthenticationPage.nextButton.click();
	}
	
	public boolean isConnectedToGmailAccount() {
		return AuthenticationPage.isConnected.isDisplayed();
	}

}
