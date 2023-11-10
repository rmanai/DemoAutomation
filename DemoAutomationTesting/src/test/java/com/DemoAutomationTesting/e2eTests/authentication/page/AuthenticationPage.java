package com.DemoAutomationTesting.e2eTests.authentication.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class AuthenticationPage {
	
	
	 public WebDriver driver;
		
		public AuthenticationPage (WebDriver driver){
			
			this.driver=driver;	
			PageFactory.initElements(driver, this);
		}
	  
		
		@FindBy(how = How.XPATH , using ="//*[@id=\"headingText\"]/span")
		 public   WebElement login_page; 
	    
	    @FindBy(how = How.XPATH, using ="// input[@type='email']]") 
	  public   WebElement emailTextBox; 
	    
	    @FindBy(how = How.ID, using ="identifierId")
	    public   WebElement gmailIdentifierTxt; 
	  
	    @FindBy(how = How.XPATH, using ="// input[@type='password']") 
	    public    WebElement passwordTextBox; 

	    @FindBy(how = How.XPATH, using ="// div[@role = 'button' and @id  ='identifierNext']") 
	    public  WebElement nextButton; 
	    
	    @FindBy(how = How.XPATH, using ="//*[@id=\"yDmH0d\"]/c-wiz/div/div/div/div[2]/div[1]/div[2]")
	    public  WebElement isConnected; 
	    
		/*
		 * public static void setEmail(String strEmail) {
		 * emailTextBox.sendKeys(strEmail); }
		 * 
		 * public static void setPassword(String strPassword) {
		 * passwordTextBox.sendKeys(strPassword); }
		 * 
		 * public static void clickOnNextButton() { nextButton.click(); }
		 */

}
