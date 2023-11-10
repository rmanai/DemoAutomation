package com.DemoAutomationTesting.e2eTests.utils;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Common {
	
	protected static final Logger logger = LoggerFactory
			.getLogger(AbstractPage.class);
	
	 /**

     * Open Chrome and go to rct

     */
	public void openApplication() throws InterruptedException {
		logger.info("Begin : Ouvrir le site Gmail ");
       AbstractPage.driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
       
        AbstractPage.driver.get("https://www.gmail.com");
	}
	 /**

     * Scroll bottom of the Page

     */
 public static void scrollerFooter() throws Throwable {
		    
		 for (int second = 0;; second++) {
	            if(second >=60){
	                break;
	            }
	            ((JavascriptExecutor) AbstractPage.driver).executeScript("window.scrollBy(0,1200)", "");
	           
	        }
	 }
	 
	 /**
		 * Scroll the page up when x is positive and y is negative and down when
		 * both are positive.
		 * 
		 * @param x
		 *            -axis
		 * @param y
		 *            -axis
		 */
		public void scrollToTop() {
			JavascriptExecutor javascriptExecutor = (JavascriptExecutor) AbstractPage.driver;
			javascriptExecutor.executeScript(
					"window.scrollTo(" + 0 + "," + 0 + ")", "");
		}
		
	
		 /**

	     * AutoComplete

	     */
		
		/*
		 public void AutoComplete() throws Throwable {
			    
			 WebElement autoOptions = driver.findElement(By.id("ui-id-1"));
				List<WebElement> optionsToSelect = autoOptions.findElements(By.tagName("li"));
			        int indexToSelect = 3;
					if(indexToSelect<=optionsToSelect.size()) {
			           optionsToSelect.get(indexToSelect).click();
			        }
		 }
	*/
	
		 /**

	     * Choisir Langue Francais 

	     */
		
		public void choisirLangueFr() throws Throwable {
			
			AbstractPage.driver.findElement(By.xpath("//*[@id=\"footer\"]/div/section[2]/div/div/p")).click();
			AbstractPage.driver.findElement(By.xpath("//*[@id=\"footer\"]/div/section[2]/div/div/ul/li[1]/a")).click();
			             
		}
		
		 /**

	     * Choisir Langue English 

	     */
		
		public void choisirLangueEn() throws Throwable {
			
			AbstractPage.driver.findElement(By.xpath("//*[@id=\"footer\"]/div/section[2]/div/div/p")).click();
			AbstractPage.driver.findElement(By.xpath("//*[@id=\"footer\"]/div/section[2]/div/div/ul/li[2]/a")).click();
			             
		}
		
		// Go back 
		public void goBack() throws Throwable {
			
			AbstractPage.driver.navigate().back();
		}
		
		// Refresh browser
		public void refreshBrowser() throws Throwable {
			
			AbstractPage.driver.navigate().refresh();
		}
		
		/**

	     * Drag And Drop

	     */
		public void DragAndDrop() {
	
		WebElement source = AbstractPage.driver.findElement(By.xpath(""));
		WebElement target = AbstractPage.driver.findElement(By.xpath(""));
		Actions actions = new Actions(AbstractPage.driver);
		actions.dragAndDrop(source, target).perform();
				
		}
	
		public void TabHandling() {
		
		String parentWindowsHandle = AbstractPage.driver.getWindowHandle();
		System.out.println("parentWindowsHandle"+parentWindowsHandle);
	
		for (String childTab:AbstractPage.driver.getWindowHandles())
		{
			AbstractPage.driver.switchTo().window(childTab);
		}
	}
		

	    /**
	     *
	     * @param fileInput
	     */
	    public static void UploadFileNoInput (WebElement fileInput2) {
	        ((JavascriptExecutor) AbstractPage.driver).executeScript(
	                "HTMLInputElement.prototype.click = function() {                     " +
	                        "  if(this.type !== 'file') HTMLElement.prototype.click.call(this);  " +
	                        "};                                                                  ");
	        fileInput2.click();
	        AbstractPage.driver.findElement(By.cssSelector("")).sendKeys("path to file");
	    }
	    
	    /**
	     *
	     * handle alert pop-up
	     */
	    
		public void handleAlertPopUp() {

			String mainPage = AbstractPage.driver.getWindowHandle();

			Alert alt = AbstractPage.driver.switchTo().alert(); // to move control to alert popup

			alt.accept(); // to click on ok.

			alt.dismiss(); // to click on cancel.

			//Then move the control back to main web page-

			AbstractPage.driver.switchTo().window(mainPage); //to switch back to main page.

		}
		
		/**
	     *
	     * right Click
	     */
		public void rightClick() {

			WebElement wE =  AbstractPage.driver.findElement(By.xpath(""));
			Actions act = new Actions(AbstractPage.driver); // where driver is WebDriver type

			act.moveToElement(wE).perform();

			act.contextClick().perform();
		}
		
		/**
	     *
	     * Double Click
	     */
		
		public void doubleClick() {

			WebElement wE =  AbstractPage.driver.findElement(By.xpath(""));
			Actions act = new Actions(AbstractPage.driver);
			 
			act.doubleClick(wE);
		}
		
		public void handlePopUp () {
			
			String parentWindowHandler = AbstractPage.driver.getWindowHandle(); // Store your parent window
			String subWindowHandler = null;

			Set<String> handles = AbstractPage.driver.getWindowHandles(); // get all window handles
			Iterator<String> iterator = handles.iterator();
			while (iterator.hasNext()){
			    subWindowHandler = iterator.next();
			}
			AbstractPage.driver.switchTo().window(subWindowHandler); // switch to popup window

			// Now you are in the popup window, perform necessary actions here

			AbstractPage.driver.switchTo().window(parentWindowHandler);  // switch back to parent window
		}
		
}
