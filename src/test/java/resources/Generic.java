package resources;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.NoSuchFrameException;
import org.openqa.selenium.NoSuchWindowException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import browser.Browser;

public class Generic {
	
	@SuppressWarnings("unused")
	private static final WebElement WebElement = null;
	private static WebDriver driver;
	public static String winHandleBefore;
	public static String strErrorMessage;
	public static Actions act ;
	
	public Generic(){
		driver = Browser.driver;
		act = new Actions(driver);
	}
	
	/*******************************************************************************************************************************************************************************************************************
    'Created By			: vkamara3						
    'Created On			: 2-july-2017				
    'Last Updated By	: NA
    'Last Updated On	: NA
    'Parameters Used	: NA
    'Purpose			: To Close the browser
    'Steps:
    '************************************************************************************************************************************************************************************************************************/	
	
	public static void closeBrowser() {
		try {
			driver.close();
		} catch (WebDriverException e) {
			strErrorMessage = "The browser is not available for unknown reason.";
		}catch(Exception e){
			 strErrorMessage =  e.getMessage();
		}

	}
	
	/*******************************************************************************************************************************************************************************************************************
    'Created By			: vkamara3						
    'Created On			: 2-july-2017				
    'Last Updated By	: NA
    'Last Updated On	: NA
    'Parameters Used	: NA
    'Purpose			: To quit the browser
    'Steps:
    '************************************************************************************************************************************************************************************************************************/	
	
	public static void quitBrowser() {
		try {
			driver.quit();
		}catch(WebDriverException e) {
			strErrorMessage = "The browser is not available for unknown reason.";
		}catch(Exception e){
			 strErrorMessage =  e.getMessage();
		}

	}
	
	/*******************************************************************************************************************************************************************************************************************
    'Created By			: vkamara3						
    'Created On			: 2-july-2017				
    'Last Updated By	: NA
    'Last Updated On	: NA
    'Parameters Used	: NA
    'Purpose			:  Get page title
    'Steps:
    '************************************************************************************************************************************************************************************************************************/	
	
	public static String getTitle() {
		String sReturn = "";
		try {
			sReturn = driver.getTitle();
		}catch(WebDriverException e) {
			strErrorMessage = "The browser is not available for unknown reason.";
		}catch(Exception e){
			 strErrorMessage =  e.getMessage();
		}
		return sReturn;
	}

	
	/*******************************************************************************************************************************************************************************************************************
    'Created By			: vkamara3						
    'Created On			: 2-july-2017				
    'Last Updated By	: NA
    'Last Updated On	: NA
    'Parameters Used	: pageTitle - the expected title of the page
    'Purpose			: Verify the title of the page
    'Steps:
    '
	 ************************************************************************************************************************************************************************************************************************/	
		public static boolean verifyTitle(String pageTitle) {
			boolean bReturn = false;
			String actualTitle;
			try{
				actualTitle = getTitle();
			    if(actualTitle.equals(pageTitle)){
						bReturn = true;
				}else{
					strErrorMessage = "The expected page title " +"\""+ pageTitle + "\"" + " Actual page title: " + "\""+ actualTitle +"\"" + " are not matched";
			    }
			}catch(Exception e){
				 strErrorMessage =  e.getMessage();
			}
			return bReturn;
		}
		/*******************************************************************************************************************************************************************************************************************
	    'Created By			: vkamara3						
	    'Created On			: 2-july-2017				
	    'Last Updated By	: NA
	    'Last Updated On	: NA
	    'Parameters Used	: locatorId -id,textValue - text to be verified
	    'Purpose			: Verify the text by locator id
	    'Steps:
	    '
		 ************************************************************************************************************************************************************************************************************************/	
		
		public static boolean verifyTextById(String locatorId, String textValue){
			boolean bReturn = false;
			try {
				String verifyText = getTextById(locatorId);
				if (verifyText.equals(textValue)) {
					bReturn= true;
				} else {
					strErrorMessage = "The expected text " +"\""+ textValue + "\"" + " Actual text: " + "\""+ verifyText +"\"" + " are not matched";					
				} 
			}catch(Exception e){
				 strErrorMessage =  e.getMessage();
			}
			return bReturn;
		}
	
		
		/*******************************************************************************************************************************************************************************************************************
	    'Created By			: vkamara3						
	    'Created On			: 2-july-2017				
	    'Last Updated By	: NA
	    'Last Updated On	: NA
	    'Parameters Used	:  locatorName - name,textValue - text to be verified
	    'Purpose			:  Verify the text by locator name
	    'Steps:
	    '
        ************************************************************************************************************************************************************************************************************************/	
		public static boolean verifyTextByName(String locatorName, String textValue){
			boolean bReturn = false;
			try {
				String verifyText = getTextByName(locatorName);
				if (verifyText.equals(textValue)) {
					bReturn = true;
				}else{
					strErrorMessage = "The expected text " +"\""+ textValue + "\"" + " Actual text: " + "\""+ verifyText +"\"" + " are not matched";
				} 
			}catch(Exception e){
				 strErrorMessage =  e.getMessage();
			}
			return bReturn;	
		}
		
		
		/*******************************************************************************************************************************************************************************************************************
	    'Created By			: vkamara3						
	    'Created On			: 2-july-2017				
	    'Last Updated By	: NA
	    'Last Updated On	: NA
	    'Parameters Used	:  locatorClassName - class name,textValue - text to be verified
	    'Purpose			:  Verify the text by locator class name
	    'Steps:
	    '
        ************************************************************************************************************************************************************************************************************************/	
		public static boolean verifyTextByClassName(String locatorClassName, String textValue){
			boolean bReturn = false;
			try {
				String verifyText = getTextByClassName(locatorClassName);
				if (verifyText.equals(textValue)) {
					bReturn = true;
				}else{
					strErrorMessage = "The expected text " +"\""+ textValue + "\"" + " Actual text: " + "\""+ verifyText +"\"" + " are not matched";
				} 
			}catch(Exception e){
				 strErrorMessage =  e.getMessage();
			}
			return bReturn;	
		}
		
		/*******************************************************************************************************************************************************************************************************************
	    'Created By			: vkamara3						
	    'Created On			: 2-july-2017				
	    'Last Updated By	: NA
	    'Last Updated On	: NA
	    'Parameters Used	:  locatorLinkText - name,textValue - text to be verified
	    'Purpose			:  Verify the text by locator linkText
	    'Steps:
        ************************************************************************************************************************************************************************************************************************/	
		public static boolean verifyTextByLinkText(String locatorLinkText, String textValue){
			boolean bReturn = false;
			try {
				String verifyText = getTextByLinkText(locatorLinkText);
				if (verifyText.equals(textValue)) {
					bReturn = true;
				}else{
					strErrorMessage = "The expected text " +"\""+ textValue + "\"" + " Actual text: " + "\""+ verifyText +"\"" + " are not matched";
				} 
			}catch(Exception e){
				 strErrorMessage =  e.getMessage();
			}
			return bReturn;	
		}

		/*******************************************************************************************************************************************************************************************************************
	    'Created By			: vkamara3						
	    'Created On			: 2-july-2017				
	    'Last Updated By	: NA
	    'Last Updated On	: NA
	    'Parameters Used	:  locatorLinkText - name,textValue - text to be verified
	    'Purpose			:  Verify the text by locator partial linkText
	    'Steps:
        ************************************************************************************************************************************************************************************************************************/	
		public static boolean verifyTextByPartialLinkText(String locatorLinkText, String textValue){
			boolean bReturn = false;
			try {
				String verifyText = getTextByLinkText(locatorLinkText);
				if (verifyText.equals(textValue)) {
					bReturn = true;
				}else{
					strErrorMessage = "The expected text " +"\""+ textValue + "\"" + " Actual text: " + "\""+ verifyText +"\"" + " are not matched";
				} 
			}catch(Exception e){
				 strErrorMessage =  e.getMessage();
			}
			return bReturn;	
		}
		/*******************************************************************************************************************************************************************************************************************
	    'Created By			: vkamara3						
	    'Created On			: 2-july-2017				
	    'Last Updated By	: NA
	    'Last Updated On	: NA
	    'Parameters Used	: locatorXpath - xpath, textValue - text to be verified
	    'Purpose			: Verify the text by locator xpath
	    'Steps:
	    '
	   ************************************************************************************************************************************************************************************************************************/	
		public static boolean verifyTextByXpath(String locatorXpath, String textValue){
			boolean bReturn = false;
			try {
				String verifyText = getTextByXpath(locatorXpath);
				if (verifyText.equals(textValue)) {
					bReturn = true;
				}else{
					strErrorMessage = "The expected text " +"\""+ textValue + "\"" + " Actual text: " + "\""+ verifyText +"\"" + " are not matched";
				} 
			}catch(Exception e){
				 strErrorMessage =  e.getMessage();
			}
			return bReturn;
		}
		
		/*******************************************************************************************************************************************************************************************************************
	    'Created By			: vkamara3						
	    'Created On			: 2-july-2017				
	    'Last Updated By	: NA
	    'Last Updated On	: NA
	    'Parameters Used	: locatorId - id
	    'Purpose			: Method to click using the locator id
	    'Steps:
	    '************************************************************************************************************************************************************************************************************************/	
		public static void clickById(String locatorId){		
			try {
				FindElementByID(locatorId).click();
			}catch (Exception e) {
				strErrorMessage =  e.getMessage();
			}
		}
		
		/*******************************************************************************************************************************************************************************************************************
	    'Created By			: vkamara3						
	    'Created On			: 2-july-2017				
	    'Last Updated By	: NA
	    'Last Updated On	: NA
	    'Parameters Used	: locatorName - Name
	    'Purpose			: Method to click using the locator name
	    'Steps:
	    '************************************************************************************************************************************************************************************************************************/	
		public static void clickByName(String locatorName){
			try {
				FindElementByName(locatorName).click();
			} catch (Exception e) {
				strErrorMessage =  e.getMessage();
			}	
		}	
	
		/*******************************************************************************************************************************************************************************************************************
	    'Created By			: vkamara3						
	    'Created On			: 2-july-2017				
	    'Last Updated By	: NA
	    'Last Updated On	: NA
	    'Parameters Used	: locatorClassName - ClassName
	    'Purpose			: Method to click using the locator class name
	    'Steps:
	    '************************************************************************************************************************************************************************************************************************/	
		
		public static void clickByClassName(String locatorClassName){
			try {
				FindElementByClassName(locatorClassName).click();
			}catch (Exception e) {
				strErrorMessage =  e.getMessage();
			} 	
		}

		/*******************************************************************************************************************************************************************************************************************
	    'Created By			: vkamara3						
	    'Created On			: 2-july-2017				
	    'Last Updated By	: NA
	    'Last Updated On	: NA
	    'Parameters Used	: locatorLinkText - LinkText
	    'Purpose			:Method to click using the locator linktext
	    'Steps:
	    '************************************************************************************************************************************************************************************************************************/		
		
		public static void clickByLinkText(String locatorLinkText){
			try {
				FindElementByLinkText(locatorLinkText).sendKeys("");
				FindElementByLinkText(locatorLinkText).click();
			}catch (Exception e) {
				strErrorMessage =  e.getMessage();
			} 
		}
		
		/*******************************************************************************************************************************************************************************************************************
	    'Created By			: vkamara3						
	    'Created On			: 2-july-2017				
	    'Last Updated By	: NA
	    'Last Updated On	: NA
	    'Parameters Used	: locatorPartialLinkText - PartialLinkText
	    'Purpose			:Method to click using the locator Partial linktext
	    'Steps:
	    '************************************************************************************************************************************************************************************************************************/		
		public static void clickByPartialLinkText(String locatorPartialLinkText){
			try {
				FindElementByPartialLinkText(locatorPartialLinkText).click();
			}catch (Exception e) {
				strErrorMessage =  e.getMessage();
			} 
		}
		
		/*******************************************************************************************************************************************************************************************************************
	    'Created By			: vkamara3						
	    'Created On			: 2-july-2017				
	    'Last Updated By	: NA
	    'Last Updated On	: NA
	    'Parameters Used	: 	locatorTagName - locator
	    'Purpose			: Method to click using the locator tagname
	    'Steps:
	    '************************************************************************************************************************************************************************************************************************/		
		public static void clickByTagName(String locatorTagName){
			try {
				FindElementByTagname(locatorTagName).click();
			}catch (Exception e) {
				strErrorMessage =  e.getMessage();
			} 
	
		}
		
		/*******************************************************************************************************************************************************************************************************************
	    'Created By			: vkamara3						
	    'Created On			: 2-july-2017				
	    'Last Updated By	: NA
	    'Last Updated On	: NA
	    'Parameters Used	: locatorCss - Css
	    'Purpose			: Method to click using the locator css
	    'Steps:
	    '************************************************************************************************************************************************************************************************************************/		
		public static void clickByCss(String locatorCss){
			try {
				FindElementByCSS(locatorCss).click();
			}catch (Exception e) {
				strErrorMessage =  e.getMessage();
			} 
		}	
		
		/*******************************************************************************************************************************************************************************************************************
	    'Created By			: vkamara3						
	    'Created On			: 2-july-2017				
	    'Last Updated By	: NA
	    'Last Updated On	: NA
	    'Parameters Used	: locatorXpath - Xpath
	    'Purpose			:  Method to click using the locator xpath
	    'Steps:
	    '************************************************************************************************************************************************************************************************************************/		
		public static void clickByXpath(String locatorXpath){
			try {
				//FindElementByXpath(locatorXpath).sendKeys("");
				FindElementByXpath(locatorXpath).click();
			}catch (Exception e) {
				strErrorMessage =  e.getMessage();
			} 		
		}
	
		/*******************************************************************************************************************************************************************************************************************
	    'Created By			: vkamara3						
	    'Created On			: 2-july-2017				
	    'Last Updated By	: NA
	    'Last Updated On	: NA
	    'Parameters Used	: locatorId - ID ,textValue - Value 
	    'Purpose			:  Enter the value using the locator Id
	    'Steps:
	    '************************************************************************************************************************************************************************************************************************/		
		public static void enterByID(String locatorId,String textValue){
			try {
				try{
				 FindElementByID(locatorId).clear();
				}catch(Exception e){
					strErrorMessage = "Not able to clear the values";	
				}
				FindElementByID(locatorId).sendKeys(textValue);
			}catch (Exception e) {
				strErrorMessage =  e.getMessage();
			}
		}
		
		/*******************************************************************************************************************************************************************************************************************
	    'Created By			: vkamara3						
	    'Created On			: 2-july-2017				
	    'Last Updated By	: NA
	    'Last Updated On	: NA
	    'Parameters Used	: locatorName - Name ,textValue - Value 
	    'Purpose			: Enter the value using the locator name
	    'Steps:
	    '************************************************************************************************************************************************************************************************************************/		
		public static void enterByName(String locatorName,String textValue){
			try {
				try{
					FindElementByName(locatorName).clear();
				}catch(Exception e){
					strErrorMessage ="Not able to clear the value";	
				}
				FindElementByName(locatorName).sendKeys(textValue);
			}catch (Exception e) {
				strErrorMessage =  e.getMessage();
			}	
		}	
		

		/*******************************************************************************************************************************************************************************************************************
	    'Created By			: vkamara3						
	    'Created On			: 2-july-2017				
	    'Last Updated By	: NA
	    'Last Updated On	: NA
	    'Parameters Used	: locatorClassName - ClassName  ,textValue - Value 
	    'Purpose			: Enter the value using the Classname
	    'Steps:
	    '************************************************************************************************************************************************************************************************************************/		
		
		public static void enterByClassName(String locatorClassName,String textValue){
			try {
				try{
				 FindElementByClassName(locatorClassName).clear();
				}catch(Exception e){
					strErrorMessage = "Not able to clear the value";	
				}
				FindElementByClassName(locatorClassName).sendKeys(textValue);
			}catch (Exception e) {
				strErrorMessage =  e.getMessage();
			}	
		}	
		
		
		/*******************************************************************************************************************************************************************************************************************
	    'Created By			: vkamara3						
	    'Created On			: 2-july-2017				
	    'Last Updated By	: NA
	    'Last Updated On	: NA
	    'Parameters Used	: locatorTagName - Tagname  ,textValue - Value 
	    'Purpose			: Enter the value using the locator TagName
	    'Steps:
	    '************************************************************************************************************************************************************************************************************************/		
		public static void enterByTagName(String locatorTagName,String textValue){
			try {
				try{
				 FindElementByTagname(locatorTagName).clear();
				}catch(Exception e){
					strErrorMessage = "Not able to clear the value";	
				}
				FindElementByTagname(locatorTagName).sendKeys(textValue);
			}catch (Exception e) {
				strErrorMessage =  e.getMessage();
			}	
		}	
		/*******************************************************************************************************************************************************************************************************************
	    'Created By			: vkamara3						
	    'Created On			: 2-july-2017				
	    'Last Updated By	: NA
	    'Last Updated On	: NA
	    'Parameters Used	:locatorCss - Css ,textValue - Value 
	    'Purpose			:Enter the value using the locator css
	    'Steps:
	    '************************************************************************************************************************************************************************************************************************/				
	
		public static void enterByCss(String locatorCss,String textValue){
			try {
				try{
				 FindElementByCSS(locatorCss).clear();
				}catch(Exception e){
					strErrorMessage = "Not able to clear the value";	
				}
				FindElementByCSS(locatorCss).sendKeys(textValue);
			}catch (Exception e) {
				strErrorMessage =  e.getMessage();
			}		
		}
		
		/*******************************************************************************************************************************************************************************************************************
	    'Created By			: vkamara3						
	    'Created On			: 2-july-2017				
	    'Last Updated By	: NA
	    'Last Updated On	: NA
	    'Parameters Used	: locatorXpath - Xpath ,textValue - Value 
	    'Purpose			:Enter the value using the locator xpath
	    'Steps:
	    '************************************************************************************************************************************************************************************************************************/				
		public static void enterByXpath(String locatorXpath,String textValue){
			try {
				try{
				  FindElementByXpath(locatorXpath).clear();
				}catch(Exception e){
					strErrorMessage = "Not able to clear the value";	
				}
				FindElementByXpath(locatorXpath).sendKeys(textValue);
			}catch (Exception e) {
				strErrorMessage =  e.getMessage();
			}		
		}	
		
		
		/*******************************************************************************************************************************************************************************************************************
	    'Created By			: vkamara3						
	    'Created On			: 2-july-2017				
	    'Last Updated By	: NA
	    'Last Updated On	: NA
	    'Parameters Used	:locatorId -id
	    'Purpose			:Switch to frame using the locator id
	    'Steps:
	    '************************************************************************************************************************************************************************************************************************/				
	
		public static void switchToFrameById(String locatorId){
			try {
				driver.switchTo().frame(locatorId);		
			} catch (NoSuchFrameException e) {
				strErrorMessage = "Frame not found with locator id '" + locatorId + "'";	
			}catch (NoSuchElementException e) {
				strErrorMessage = "Element not found with id '" + locatorId + "'";
			}catch (WebDriverException e) {
				strErrorMessage = "The browser is not available for unknown reason.";
			}catch (Exception e) {
				strErrorMessage =  e.getMessage();
			}
		}	
		
		/*******************************************************************************************************************************************************************************************************************
	    'Created By			: vkamara3						
	    'Created On			: 2-july-2017				
	    'Last Updated By	: NA
	    'Last Updated On	: NA
	    'Parameters Used	:locatorName - name
	    'Purpose			:Switch to frame using the locator name
	    'Steps:
	    '************************************************************************************************************************************************************************************************************************/				
		public static void switchToFrameByName(String locatorName){
			try {
				driver.switchTo().frame(locatorName);	
			} catch (NoSuchFrameException e) {
				strErrorMessage = "Frame not found with locator name '" + locatorName + "'";	
			}catch (NoSuchElementException e) {
				strErrorMessage = "Element not found with ClassName '" + locatorName + "'";
			}catch (WebDriverException e) {
				strErrorMessage = "The browser is not available for unknown reason.";
			}catch (Exception e) {
				strErrorMessage =  e.getMessage();
			}
		}	

		/*******************************************************************************************************************************************************************************************************************
	    'Created By			: vkamara3						
	    'Created On			: 2-july-2017				
	    'Last Updated By	: NA
	    'Last Updated On	: NA
	    'Parameters Used	:locatorClassName - ClassName
	    'Purpose			:Switch to frame using the locator ClassName
	    'Steps:
	    '************************************************************************************************************************************************************************************************************************/
		public static void switchToFrameByClassName(String locatorClassName){
			try {
				driver.switchTo().frame(driver.findElement(By.className(locatorClassName)));			
			} catch (NoSuchFrameException e) {
				strErrorMessage = "Frame not found with locator ClassName '" + locatorClassName + "'";
			}catch (NoSuchElementException e) {
				strErrorMessage = "Element not found with ClassName '" + locatorClassName + "'";
			}catch (WebDriverException e) {
				strErrorMessage = "The browser is not available for unknown reason.";
			}catch (Exception e) {
				strErrorMessage =  e.getMessage();
			}
			
		}	
		/*******************************************************************************************************************************************************************************************************************
	    'Created By			: vkamara3						
	    'Created On			: 2-july-2017				
	    'Last Updated By	: NA
	    'Last Updated On	: NA
	    'Parameters Used	: locatorTagName - tagname
	    'Purpose			:Switch to frame using the tag name
	    'Steps:
	    '************************************************************************************************************************************************************************************************************************/	
		public static void switchToFrameByTagName(String locatorTagName){
			try {
				driver.switchTo().frame(driver.findElement(By.tagName(locatorTagName)));				
			} catch (NoSuchFrameException e) {
				strErrorMessage = "Frame not found with locator TagnName '" + locatorTagName + "'";
			}catch (NoSuchElementException e) {
				strErrorMessage = "Element not found with TagnName '" + locatorTagName + "'";
			}catch (WebDriverException e) {
				strErrorMessage = "The browser is not available for unknown reason.";				
			}catch (Exception e) {
				strErrorMessage =  e.getMessage();
			}

		}	
		
		/*******************************************************************************************************************************************************************************************************************
	    'Created By			: vkamara3						
	    'Created On			: 2-july-2017				
	    'Last Updated By	: NA
	    'Last Updated On	: NA
	    'Parameters Used	: frameIndex - Index
	    'Purpose			:Switch to frame using the index
	    'Steps:
	    '************************************************************************************************************************************************************************************************************************/	
		public static void switchToFrameByIndex(int frameIndex){
			try {
				driver.switchTo().frame(frameIndex);		
			} 
			 catch (NoSuchFrameException e) {
				 strErrorMessage = "Frame not found with locator index '" + frameIndex + "'";
	         }catch (NoSuchElementException e) {
	        	 strErrorMessage = "Element not found with index '" + frameIndex + "'";
			}catch (WebDriverException e) {
				strErrorMessage = "The browser is not available for unknown reason.";				
			}catch (Exception e) {
				strErrorMessage =  e.getMessage();
			}
		}
	
	
		/*******************************************************************************************************************************************************************************************************************
	    'Created By			: vkamara3						
	    'Created On			: 2-july-2017				
	    'Last Updated By	: NA
	    'Last Updated On	: NA
	    'Parameters Used	: 
	    'Purpose			:Switch to default page
	    'Steps:
	    '************************************************************************************************************************************************************************************************************************/	
		public static void switchToDefaultContent(){
			try {
				driver.switchTo().defaultContent();		
			} catch (WebDriverException e) {
				strErrorMessage = "The browser is not available for unknown reason.";				
			}catch (Exception e) {
				strErrorMessage =  e.getMessage();
			}
		}	
		

		/*******************************************************************************************************************************************************************************************************************
	    'Created By			: vkamara3						
	    'Created On			: 2-july-2017				
	    'Last Updated By	: NA
	    'Last Updated On	: NA
	    'Parameters Used	: locatorId - id
	    'Purpose			:Get the text using the locator Id
	    'Steps:
	    '************************************************************************************************************************************************************************************************************************/	
				
		public static String getTextById(String locatorId) {
			String getText = "";
			try {
				getText =FindElementByID(locatorId).getText();
			}catch (Exception e) {
				strErrorMessage =  e.getMessage();
			}
			return getText;		
		}	
	
		
		/*******************************************************************************************************************************************************************************************************************
	    'Created By			: vkamara3						
	    'Created On			: 2-july-2017				
	    'Last Updated By	: NA
	    'Last Updated On	: NA
	    'Parameters Used	:  locatorName - name
	    'Purpose			:Get the text using the locator name
	    'Steps:
	    '************************************************************************************************************************************************************************************************************************/	
			
		public static String getTextByName(String locatorName) {
			String getText = "";
			try {
				getText = FindElementByName(locatorName).getText();
			}catch (Exception e) {
				strErrorMessage =  e.getMessage();
			}
			return getText;		
		}	
			
		/*******************************************************************************************************************************************************************************************************************
	    'Created By			: vkamara3						
	    'Created On			: 2-july-2017				
	    'Last Updated By	: NA
	    'Last Updated On	: NA
	    'Parameters Used	:locatorclassName - Classname
	    'Purpose			:Get the text using the locator  class name
	    'Steps:
	    '************************************************************************************************************************************************************************************************************************/		
		public static String getTextByClassName(String locatorclassName) {
			String getText = "";
			try {
				getText = FindElementByClassName(locatorclassName).getText();
			}catch (Exception e) {
				strErrorMessage =  e.getMessage();
			} 
			return getText;		
		}	
		/*******************************************************************************************************************************************************************************************************************
	    'Created By			: vkamara3						
	    'Created On			: 2-july-2017				
	    'Last Updated By	: NA
	    'Last Updated On	: NA
	    'Parameters Used	:locatorLinktext -Linktext
	    'Purpose			: Get the text using the locator link text
	    'Steps:
	    '************************************************************************************************************************************************************************************************************************/					
		public static String getTextByLinkText(String locatorLinktext) {
			String getText = "";
			try {
				getText = FindElementByLinkText(locatorLinktext).getText();
			}catch (Exception e) {
				strErrorMessage =  e.getMessage();
			}
			return getText;		
		}
		
		/*******************************************************************************************************************************************************************************************************************
	    'Created By			: vkamara3						
	    'Created On			: 2-july-2017				
	    'Last Updated By	: NA
	    'Last Updated On	: NA
	    'Parameters Used	:locatorPartialLinktext - PartialLinktext
	    'Purpose			:Get the text using the locator partial link text
	    'Steps:
	    '************************************************************************************************************************************************************************************************************************/							
		public static String getTextByPartialLinkText(String locatorPartialLinktext) {
			String getText = "";
			try {
				getText = FindElementByPartialLinkText(locatorPartialLinktext).getText();
			}catch (Exception e) {
				strErrorMessage =  e.getMessage();
			} 
			return getText;		
		}	
	
		/*******************************************************************************************************************************************************************************************************************
	    'Created By			: vkamara3						
	    'Created On			: 2-july-2017				
	    'Last Updated By	: NA
	    'Last Updated On	: NA
	    'Parameters Used	:locatorTagName - name
	    'Purpose			:Get the text using the locator tag name
	    'Steps:
	    '************************************************************************************************************************************************************************************************************************/								
		public static String getTextByTagName(String locatorTagName) {
			String getText = "";
			try {
				getText = FindElementByTagname(locatorTagName).getText();
			}catch (Exception e) {
			     strErrorMessage =  e.getMessage();
			}
			return getText;		
		}
		

		/*******************************************************************************************************************************************************************************************************************
	    'Created By			: vkamara3						
	    'Created On			: 2-july-2017				
	    'Last Updated By	: NA
	    'Last Updated On	: NA
	    'Parameters Used	: locatorCss - CSS
	    'Purpose			:Get the text using the locator css
	    'Steps:
	    '************************************************************************************************************************************************************************************************************************/			
		public static String getTextByCss(String locatorCss) {
			String getText = "";
			try {
				getText = FindElementByCSS(locatorCss).getText();
			}catch (Exception e) {
				strErrorMessage =  e.getMessage();
			} 
			return getText;		
         }
		
		
		/*******************************************************************************************************************************************************************************************************************
	    'Created By			: vkamara3						
	    'Created On			: 2-july-2017				
	    'Last Updated By	: NA
	    'Last Updated On	: NA
	    'Parameters Used	:locatorXpath - xpath
	    'Purpose			:Get the text using the locator xpath
	    'Steps:
	    '************************************************************************************************************************************************************************************************************************/	
		
		public static String getTextByXpath(String locatorXpath) {
			String getText = "";
			try {
				getText = FindElementByXpath(locatorXpath).getText();
			} catch (Exception e) {
				strErrorMessage =  e.getMessage();
			}
			return getText;		
		}	
		
		/*******************************************************************************************************************************************************************************************************************
	    'Created By			: vkamara3						
	    'Created On			: 2-july-2017				
	    'Last Updated By	: NA
	    'Last Updated On	: NA
	    'Parameters Used	:locatorId - ID of the WebElement as String,dropdownVisibleText - Visible Text to be selected in dropdown as String
	    'Purpose			:Select Visible Text in a dropdown by Locator ID
	    'Steps:
	    '************************************************************************************************************************************************************************************************************************/								
		public static void selectVisibleTextById(String locatorId, String dropdownVisibleText){
			try {
				Select selectDropDown = new Select(FindElementByID(locatorId));
				selectDropDown.selectByVisibleText(dropdownVisibleText);
			}catch (Exception e) {
				strErrorMessage =  e.getMessage();
			}
		}	
		/*******************************************************************************************************************************************************************************************************************
	    'Created By			: vkamara3						
	    'Created On			: 2-july-2017				
	    'Last Updated By	: NA
	    'Last Updated On	: NA
	    'Parameters Used	:locatorName - Name of the WebElement as String,dropdownVisibleText - Visible Text to be selected in dropdown as String
	    'Purpose			:Select Visible Text in a dropdown by Locator Name
	    'Steps:
	    '************************************************************************************************************************************************************************************************************************/								
		public static void selectVisibleTextByName(String locatorName, String dropdownVisibleText){
			try {
				Select selectDropDown = new Select(FindElementByName(locatorName));
				selectDropDown.selectByVisibleText(dropdownVisibleText);
			}catch (Exception e) {
				strErrorMessage =  e.getMessage();
			}
		}
		
		
		/*******************************************************************************************************************************************************************************************************************
	    'Created By			: vkamara3						
	    'Created On			: 2-july-2017				
	    'Last Updated By	: NA
	    'Last Updated On	: NA
	    'Parameters Used	:locatorName - XPath of the WebElement as String,dropdownVisibleText - Visible Text to be selected in dropdown as String
	    'Purpose			:Select Visible Text in a dropdown by Locator Xpath
	    'Steps:
	    '************************************************************************************************************************************************************************************************************************/								
		public static void selectVisibleTextByXPath(String locatorXpath, String dropdownVisibleText){
			try {
				Select selectDropDown = new Select(FindElementByXpath(locatorXpath));
				selectDropDown.selectByVisibleText(dropdownVisibleText);
			}catch (Exception e) {
				strErrorMessage =  e.getMessage();
			}
		}
		

		/*******************************************************************************************************************************************************************************************************************
	    'Created By			: vkamara3						
	    'Created On			: 2-july-2017				
	    'Last Updated By	: NA
	    'Last Updated On	: NA
	    'Parameters Used	:locatorId - ID of the WebElement as String,dropDownIndex - Index to be selected in dropdown as String
	    'Purpose			: Select Index in a dropdown by Locator ID
	    'Steps:
	    '************************************************************************************************************************************************************************************************************************/									
		public static void selectIndexById(String locatorId, int dropDownIndex){
			try {
				Select selectDropDown = new Select(FindElementByID(locatorId));
				selectDropDown.selectByIndex(dropDownIndex);
			}catch (Exception e) {
				strErrorMessage =  e.getMessage();
			}
		}
		
		/*******************************************************************************************************************************************************************************************************************
	    'Created By			: vkamara3						
	    'Created On			: 2-july-2017				
	    'Last Updated By	: NA
	    'Last Updated On	: NA
	    'Parameters Used	:locatorName - Name of the WebElement as String,dropDownIndex - Index to be selected in dropdown as String
	    'Purpose			: Select Index in a dropdown by Locator Name
	    'Steps:
	    '************************************************************************************************************************************************************************************************************************/		
		public static void selectIndexByName(String locatorName, int dropDownIndex){
			try {
				Select selectDropDown = new Select(FindElementByName(locatorName));
				selectDropDown.selectByIndex(dropDownIndex);
			}catch (Exception e) {
				strErrorMessage =  e.getMessage();
			}
		}	

		/*******************************************************************************************************************************************************************************************************************
	    'Created By			: vkamara3						
	    'Created On			: 2-july-2017				
	    'Last Updated By	: NA
	    'Last Updated On	: NA
	    'Parameters Used	:locatorXpath - XPath of the WebElement as String,dropDownIndex - Index to be selected in dropdown as String
	    'Purpose			: Select Index in a dropdown by Locator XPath
	    'Steps:
	    '************************************************************************************************************************************************************************************************************************/			
		public static void selectIndexByXpath(String locatorXpath, int dropDownIndex){
			try {
				Select selectDropDown = new Select(FindElementByXpath(locatorXpath));
				selectDropDown.selectByIndex(dropDownIndex);
			} catch (Exception e) {
				strErrorMessage =  e.getMessage();
			}
		}
		
		
		/*******************************************************************************************************************************************************************************************************************
	    'Created By			: vkamara3						
	    'Created On			: 2-july-2017				
	    'Last Updated By	: NA
	    'Last Updated On	: NA
	    'Parameters Used	:locatorId - Id of the WebElement as String,dropDownIndex - Value to be selected in dropdown as String
	    'Purpose			: Select Value in a dropdown by Locator ID
	    'Steps:
	    '************************************************************************************************************************************************************************************************************************/			
		public static void selectValueById(String locatorId, String dropDwonValue){
			try {
				Select selectDropDown = new Select(FindElementByID(locatorId));
				selectDropDown.selectByValue(dropDwonValue);
			} catch (Exception e) {
				strErrorMessage =  e.getMessage();
			}	
		}

		/*******************************************************************************************************************************************************************************************************************
	    'Created By			: vkamara3						
	    'Created On			: 2-july-2017				
	    'Last Updated By	: NA
	    'Last Updated On	: NA
	    'Parameters Used	:locatorName - Name of the WebElement as String,dropDownIndex - Value to be selected in dropdown as String
	    'Purpose			: Select Value in a dropdown by Locator Name
	    'Steps:
	    '************************************************************************************************************************************************************************************************************************/			
		public static void selectValueByName(String locatorName, String dropDwonValue){
			try {
				Select selectDropDown = new Select(FindElementByName(locatorName));
				selectDropDown.selectByValue(dropDwonValue);
			} catch (Exception e) {
				strErrorMessage =  e.getMessage();
			}
		}
		

		/*******************************************************************************************************************************************************************************************************************
	    'Created By			: vkamara3						
	    'Created On			: 2-july-2017				
	    'Last Updated By	: NA
	    'Last Updated On	: NA
	    'Parameters Used	:locatorXpath - XPath of the WebElement as String,dropDownIndex - Value to be selected in dropdown as String
	    'Purpose			: Select Value in a dropdown by Locator XPath
	    'Steps:
	    '************************************************************************************************************************************************************************************************************************/			
		public static void selectValueByXpath(String locatorXpath, String dropDwonValue){
			try {
				Select selectDropDown = new Select(FindElementByXpath(locatorXpath));
	            selectDropDown.selectByValue(dropDwonValue);
			} catch (Exception e) {
				strErrorMessage =  e.getMessage();
			}
		}	
		
		/*******************************************************************************************************************************************************************************************************************
	    'Created By			: vkamara3						
	    'Created On			: 2-july-2017				
	    'Last Updated By	: NA
	    'Last Updated On	: NA
	    'Parameters Used	:
	    'Purpose			:Method to accept Alert
	    'Steps:
	    '************************************************************************************************************************************************************************************************************************/			
		public static void acceptAlert(){
			try {
				driver.switchTo().alert().accept();
			} catch (NoAlertPresentException e) {
				strErrorMessage ="No Alert found";
			}catch (WebDriverException e) {
				strErrorMessage = "The browser is not available for unknown reason.";
			}catch (Exception e) {
				strErrorMessage =  e.getMessage();
			}
		}
	
		
		/*******************************************************************************************************************************************************************************************************************
	    'Created By			: vkamara3						
	    'Created On			: 2-july-2017				
	    'Last Updated By	: NA
	    'Last Updated On	: NA
	    'Parameters Used	:
	    'Purpose			:Method to dismiss Alert
	    '************************************************************************************************************************************************************************************************************************/				
		public static void dismissAlert(){
			try {
				driver.switchTo().alert().dismiss();
			} catch (NoAlertPresentException e) {
				strErrorMessage = "No Alert found";
			}catch (WebDriverException e) {
				strErrorMessage = "The browser is not available for unknown reason.";
			}catch (Exception e) {
				strErrorMessage =  e.getMessage();
			}
		}	
	
		
		/*******************************************************************************************************************************************************************************************************************
	    'Created By			: vkamara3						
	    'Created On			: 2-july-2017				
	    'Last Updated By	: NA
	    'Last Updated On	: NA
	    'Parameters Used	:
	    'Purpose			:Method to get current page url
	    '************************************************************************************************************************************************************************************************************************/				
		public static String getURL() {
			String currentUrl = "";		
			try {
				currentUrl = driver.getCurrentUrl();
			}catch (WebDriverException e) {
				strErrorMessage = "The browser is not available for unknown reason.";
			}catch (Exception e) {
				strErrorMessage =  e.getMessage();
			}
			return currentUrl;		
		}
		
		
		/*******************************************************************************************************************************************************************************************************************
	    'Created By			: vkamara3						
	    'Created On			: 2-july-2017				
	    'Last Updated By	: NA
	    'Last Updated On	: NA
	    'Parameters Used	:
	    'Purpose			:Method to navigate to given page url
	    '************************************************************************************************************************************************************************************************************************/				

		public static void navigatePage(String url) {
			try {
				driver.navigate().to(url);
			} catch (WebDriverException e) {
				strErrorMessage = "The browser is not available for unknown reason.";
			}catch (Exception e) {
				strErrorMessage =  e.getMessage();
			}
		}	

		
		/*******************************************************************************************************************************************************************************************************************
	    'Created By			: vkamara3						
	    'Created On			: 2-july-2017				
	    'Last Updated By	: NA
	    'Last Updated On	: NA
	    'Parameters Used	:locatorId - ID
	    'Purpose			:Method to Verify text containsBy ID
	    '
		************************************************************************************************************************************************************************************************************************/				
		public static boolean verifyTextContainsById(String locatorId, String textValue){
			boolean returnValue=false;
			 try { 
				 String verifyText = getTextById(locatorId);
				 if (verifyText.contains(textValue)) {
					 returnValue= true;
					} else {
						strErrorMessage ="The expected text " +"\""+ textValue + "\"" + " Actual text: " + "\""+ verifyText +"\"" + " are not matched";	
					} 
				}catch (Exception e) {
					strErrorMessage =  e.getMessage();
				}
			return returnValue;
		}
		
		/*******************************************************************************************************************************************************************************************************************
	    'Created By			: vkamara3						
	    'Created On			: 2-july-2017				
	    'Last Updated By	: NA
	    'Last Updated On	: NA
	    'Parameters Used	:
	    'Purpose			:Method to Verify text containsBy Name
	    '
		 ************************************************************************************************************************************************************************************************************************/				
		public static boolean verifyTextContainsByName(String locatorName, String textValue){
			boolean returnValue=false;
			 try { 
				 String verifyText = getTextByName(locatorName);
				 if (verifyText.contains(textValue)) {
					 returnValue= true;
					} else {
						strErrorMessage = "The expected text " +"\""+ textValue + "\"" + " Actual text: " + "\""+ verifyText +"\"" + " are not matched";	
					} 
				}catch (Exception e) {
					strErrorMessage =  e.getMessage();
				}
			return returnValue;
		}

		
		/*******************************************************************************************************************************************************************************************************************
	    'Created By			: vkamara3						
	    'Created On			: 2-july-2017				
	    'Last Updated By	: NA
	    'Last Updated On	: NA
	    'Parameters Used	:locatorClassName - ClassName
	    'Purpose			:Method to Verify text containsBy ClassName
	    '
		************************************************************************************************************************************************************************************************************************/				
		public static boolean verifyTextContainsByClassName(String locatorClassName, String textValue){
			boolean returnValue=false;
			 try { 
				 String verifyText = getTextByClassName(locatorClassName);
				 if (verifyText.contains(textValue)) {
					 returnValue= true;
					} else {
						strErrorMessage = "The expected text " +"\""+ textValue + "\"" + " Actual text: " + "\""+ verifyText +"\"" + " are not matched";	
					} 
				}catch (Exception e) {
					strErrorMessage =  e.getMessage();
				}
			return returnValue;
		}
				
		/*******************************************************************************************************************************************************************************************************************
	    'Created By			: vkamara3						
	    'Created On			: 2-july-2017				
	    'Last Updated By	: NA
	    'Last Updated On	: NA
	    'Parameters Used	:locatorLinktext -Linktext
	    'Purpose			:Method to Verify text containsBy ClassName
	    '
		 ************************************************************************************************************************************************************************************************************************/				
		public static boolean verifyTextContainsByLinkText(String locatorLinktext, String textValue){
			 boolean returnValue=false;
			 try { 
				 String verifyText = getTextByLinkText(locatorLinktext);
				 if (verifyText.contains(textValue)) {
					 returnValue= true;
					} else {
						strErrorMessage = "The expected text " +"\""+ textValue + "\"" + " Actual text: " + "\""+ verifyText +"\"" + " are not matched";	
					} 
				}catch(Exception e) {
					strErrorMessage =  e.getMessage();
				}
			return returnValue;
		}
		
		
		/*******************************************************************************************************************************************************************************************************************
	    'Created By			: vkamara3						
	    'Created On			: 2-july-2017				
	    'Last Updated By	: NA
	    'Last Updated On	: NA
	    'Parameters Used	:locatorPartialLinktext -partial Linktext
	    'Purpose			:Method to Verify text containsBy ClassName
	    '
		************************************************************************************************************************************************************************************************************************/				
		public static boolean verifyTextContainsByPartialLinkText(String locatorPartialLinktext, String textValue){
			 boolean returnValue=false;
			 try { 
				 String verifyText = getTextByPartialLinkText(locatorPartialLinktext);
				 if (verifyText.contains(textValue)) {
					 returnValue= true;
					} else {
						strErrorMessage = "The expected text " +"\""+ textValue + "\"" + " Actual text: " + "\""+ verifyText +"\"" + " are not matched";	
					} 
				}catch (Exception e){
					strErrorMessage =  e.getMessage();
				}
			return returnValue;
		}


		/*******************************************************************************************************************************************************************************************************************
	    'Created By			: vkamara3						
	    'Created On			: 2-july-2017				
	    'Last Updated By	: NA
	    'Last Updated On	: NA
	    'Parameters Used	:locatorCSS - CSS value
	    'Purpose			:Method to Verify text containsBy CSS
	    '
		************************************************************************************************************************************************************************************************************************/				
		public static boolean verifyTextContainsByCSS(String locatorCSS, String textValue){
			 boolean returnValue=false;
			 try { 
				 String verifyText = getTextByCss(locatorCSS);
				 if (verifyText.contains(textValue)) {
					 returnValue= true;
					} else {
						strErrorMessage = "The expected text " +"\""+ textValue + "\"" + " Actual text: " + "\""+ verifyText +"\"" + " are not matched";	
					} 
				} catch (Exception e){
					strErrorMessage =  e.getMessage();
				}
			return returnValue;
		}
		
		/*******************************************************************************************************************************************************************************************************************
	    'Created By			: vkamara3						
	    'Created On			: 2-july-2017				
	    'Last Updated By	: NA
	    'Last Updated On	: NA
	    'Parameters Used	:locator -Xpath
	    'Purpose			:Method to Verify text containsBy Xpath
	    '
		************************************************************************************************************************************************************************************************************************/				
		public static boolean verifyTextContainsByXpath(String locatorXpath, String textValue){
			boolean returnValue=false;
			 try { 
				 String verifyText = getTextByXpath(locatorXpath);
				 if (verifyText.contains(textValue)) {
					 returnValue= true;
					} else {
						strErrorMessage = "The expected text " +"\""+ textValue + "\"" + " Actual text: " + "\""+ verifyText +"\"" + " are not matched";	
					} 
				}catch (Exception e){
					strErrorMessage =  e.getMessage();
				}
			return returnValue;
		}

		/*******************************************************************************************************************************************************************************************************************
	    'Created By			: vkamara3						
	    'Created On			: 2-july-2017				
	    'Last Updated By	: NA
	    'Last Updated On	: NA
	    'Parameters Used	: NA
	    'Purpose			: To get the Parent Window Handle
	    'Steps:
	    '************************************************************************************************************************************************************************************************************************/	
		public static void MovetoChildWindow(){
			// Switch to new window opened
			try{
				for(String winHandle :driver.getWindowHandles()){
					 driver.switchTo().window(winHandle);
				}
			}catch (NoSuchWindowException e) {
				strErrorMessage = "No such window exists.";
			}catch (WebDriverException e) {
				strErrorMessage = "The browser is not available for unknown reason.";
			}catch (Exception e) {
				strErrorMessage =  e.getMessage();
			}
		}
		
		/*******************************************************************************************************************************************************************************************************************
	    'Created By			: vkamara3						
	    'Created On			: 2-july-2017				
	    'Last Updated By	: NA
	    'Last Updated On	: NA
	    'Parameters Used	: NA
	    'Purpose			: To Move to the child window
	    'Steps:
	    '************************************************************************************************************************************************************************************************************************/	
		public static void GetParentWindow(){
			// Store the current window handle
			try{
			  winHandleBefore =  driver.getWindowHandle();
			}catch (NoSuchWindowException e) {
				strErrorMessage = "No such window exists.";
			}catch (WebDriverException e) {
				strErrorMessage = "The browser is not available for unknown reason.";
			}catch (Exception e) {
				strErrorMessage =  e.getMessage();
			}
		}
		
		/*******************************************************************************************************************************************************************************************************************
	    'Created By			: vkamara3						
	    'Created On			: 2-july-2017				
	    'Last Updated By	: NA
	    'Last Updated On	: NA
	    'Parameters Used	: NA
	    'Purpose			: To Move to the particular window
	    'Steps:
	    '************************************************************************************************************************************************************************************************************************/	
		public static void MovetoParentWindow(){
			// Store the current window handle
			try{
				driver.switchTo().window(winHandleBefore);
			}catch (NoSuchWindowException e) {
				strErrorMessage = "No such window exists.";
			}catch (WebDriverException e) {
				strErrorMessage = "The browser is not available for unknown reason.";
			}catch (Exception e) {
				strErrorMessage =  e.getMessage();
			}
		}
		
		/*******************************************************************************************************************************************************************************************************************
	    'Created By			: vkamara3						
	    'Created On			: 2-july-2017				
	    'Last Updated By	: NA
	    'Last Updated On	: NA
	    'Parameters Used	: strDateFormat -formatType date to be get 
	    'Purpose			: To get current date and time
	    'Steps:
	    '************************************************************************************************************************************************************************************************************************/	
		public static String GetCurrentDateTime(String strDateFormat){
			DateFormat dateFormat = null;
			Date date = null;
			
			try{
				dateFormat = new SimpleDateFormat(strDateFormat);
				date = new Date();
				
			}catch (Exception e) {
				strErrorMessage =  e.getMessage();
			}
			return (dateFormat.format(date));	
		}
		
		/*******************************************************************************************************************************************************************************************************************
	    'Created By			: vkamara3						
	    'Created On			: 2-july-2017				
	    'Last Updated By	: NA
	    'Last Updated On	: NA
	    'Parameters Used	: strFileName - File name to be Uploaded
	    'Purpose			: To upload the file
	    'Steps:
	    '************************************************************************************************************************************************************************************************************************/	
		public static void SelectFile(String strFileName) throws IOException {
			String strFinalPath = null ;
			try{
				String strPath = System.getProperty("user.dir");
			    strFinalPath =strPath +"\\"+strFileName;
				Runtime.getRuntime().exec(strFinalPath);
			}catch (FileNotFoundException e){
				strErrorMessage = "File  " + strFileName + " not found  in the path " + strFinalPath;
			}
			
		}
		
		/*******************************************************************************************************************************************************************************************************************
	    'Created By			: vkamara3						
	    'Created On			: 2-july-2017				
	    'Last Updated By	: NA
	    'Last Updated On	: NA
	    'Parameters Used	: 
	    'Purpose			: To Refresh a page
	    'Steps:
	    '************************************************************************************************************************************************************************************************************************/
		public static void RefreshPage(){
			try{
			 driver.navigate().refresh();
			}catch (WebDriverException e) {
				strErrorMessage = "The browser is not available for unknown reason.";
			}catch (Exception e) {
				strErrorMessage =  e.getMessage();
			}
				
		}

		/*******************************************************************************************************************************************************************************************************************
	    'Created By			: vkamara3						
	    'Created On			: 2-july-2017				
	    'Last Updated By	: NA
	    'Last Updated On	: NA
	    'Parameters Used	: 
	    'Purpose			: To verify Alert is present or not
	    'Steps:
	    '************************************************************************************************************************************************************************************************************************/
		public static boolean isAlertPresent(String strCondition){
			try {
				driver.switchTo().alert();
				if(strCondition.equalsIgnoreCase("Accept")){
				   acceptAlert();
				}else if(strCondition.equalsIgnoreCase("Dismiss")){
					dismissAlert();
				}
				switchToDefaultContent();
			  return true;
		    }
		    catch (Exception e) {
		    	strErrorMessage = "No Alerts Present";
			   return false;
	        }
		}
		/*******************************************************************************************************************************************************************************************************************
	    'Created By			: vkamara3						
	    'Created On			: 2-july-2017				
	    'Last Updated By	: NA
	    'Last Updated On	: NA
	    'Parameters Used	: locatorId - ID
	    'Purpose			: To find the element by locator ID
	    'Steps:
	    '************************************************************************************************************************************************************************************************************************/
		public static WebElement FindElementByID(String locatorId){
			WebElement ele = null;
			try{
			   ele = driver.findElement(By.id(locatorId));
			}catch (NoSuchElementException e) {
				strErrorMessage = "Failed to find the Element using  locator id" + locatorId;
			}catch (WebDriverException e) {
				strErrorMessage = "The browser is not available for unknown reason.";
			}
			return ele;	
		}
		
		/*******************************************************************************************************************************************************************************************************************
	    'Created By			: vkamara3						
	    'Created On			: 2-july-2017				
	    'Last Updated By	: NA
	    'Last Updated On	: NA
	    'Parameters Used	: locatorName - Name
	    'Purpose			: To find the element by locator Name
	    'Steps:
	    '************************************************************************************************************************************************************************************************************************/
		public static WebElement FindElementByName(String locatorName){
			WebElement ele = null;
			try{
			   ele = driver.findElement(By.name(locatorName));
			}catch (NoSuchElementException e) {
				strErrorMessage = "Failed to find the Element using  locator name" + locatorName;
			}catch (WebDriverException e) {
				strErrorMessage = "The browser is not available for unknown reason.";
			}
			return ele;	
		}
		
		/*******************************************************************************************************************************************************************************************************************
	    'Created By			: vkamara3						
	    'Created On			: 2-july-2017				
	    'Last Updated By	: NA
	    'Last Updated On	: NA
	    'Parameters Used	: locatorClassName - ClassName
	    'Purpose			: To find the element by locator ClassName
	    'Steps:
	    '************************************************************************************************************************************************************************************************************************/
		public static WebElement FindElementByClassName(String locatorClassName){
			WebElement ele = null;
			try{
			   ele = driver.findElement(By.className(locatorClassName));
			}catch (NoSuchElementException e) {
				strErrorMessage = "Failed to find the Element using  locator class name" + locatorClassName;
			}catch (WebDriverException e) {
				strErrorMessage = "The browser is not available for unknown reason.";
			}
			return ele;	
		}
		
		
		/*******************************************************************************************************************************************************************************************************************
	    'Created By			: vkamara3						
	    'Created On			: 2-july-2017				
	    'Last Updated By	: NA
	    'Last Updated On	: NA
	    'Parameters Used	: locatorLinkText - linkedtext
	    'Purpose			: To find the element by locator linkedText
	    'Steps:
	    '************************************************************************************************************************************************************************************************************************/
		public static WebElement FindElementByLinkText(String locatorLinkText){
			WebElement ele = null;
			try{
			   ele = driver.findElement(By.linkText(locatorLinkText));
			}catch (NoSuchElementException e) {
				strErrorMessage = "Failed to find the Element using  locator linked text" + locatorLinkText;
			}catch (WebDriverException e) {
				strErrorMessage = "The browser is not available for unknown reason.";
			}
			return ele;	
		}
		
		/*******************************************************************************************************************************************************************************************************************
	    'Created By			: vkamara3						
	    'Created On			: 2-july-2017				
	    'Last Updated By	: NA
	    'Last Updated On	: NA
	    'Parameters Used	: locatorPartialLinkText -partial linkedtext
	    'Purpose			: To find the element by locator locatorPartialLinkText
	    'Steps:
	    '************************************************************************************************************************************************************************************************************************/
		public static WebElement FindElementByPartialLinkText(String locatorPartialLinkText){
			WebElement ele = null;
			try{
			   ele = driver.findElement(By.partialLinkText(locatorPartialLinkText));
			}catch (NoSuchElementException e) {
				strErrorMessage = "Failed to find the Element using  locator partial linked text" + locatorPartialLinkText;
			}catch (WebDriverException e) {
				strErrorMessage = "The browser is not available for unknown reason.";
			}
			return ele;	
		}
		
		/*******************************************************************************************************************************************************************************************************************
	    'Created By			: vkamara3						
	    'Created On			: 2-july-2017				
	    'Last Updated By	: NA
	    'Last Updated On	: NA
	    'Parameters Used	: locatorTagName - TagName
	    'Purpose			: To find the element by locator TagName
	    'Steps:
	    '************************************************************************************************************************************************************************************************************************/
		public static WebElement FindElementByTagname(String locatorTagName){
			WebElement ele = null;
			try{
			   ele = driver.findElement(By.tagName(locatorTagName));
			}
			catch (NoSuchElementException e) {
				strErrorMessage = "Failed to find the Element using  locator tag name " + locatorTagName;
			}catch (WebDriverException e) {
				strErrorMessage = "The browser is not available for unknown reason.";
			}
			return ele;	
		}
		
		/*******************************************************************************************************************************************************************************************************************
	    'Created By			: vkamara3						
	    'Created On			: 2-july-2017				
	    'Last Updated By	: NA
	    'Last Updated On	: NA
	    'Parameters Used	: locatorCSS - CSS value
	    'Purpose			: To find the element by locator CSS
	    'Steps:
	    '************************************************************************************************************************************************************************************************************************/
		public static WebElement FindElementByCSS(String locatorCSS){
			WebElement ele = null;
			try{
			   ele = driver.findElement(By.cssSelector(locatorCSS));
			}catch (NoSuchElementException e) {
				strErrorMessage = "Failed to find the Element using  locator css" + locatorCSS;
			}catch (WebDriverException e) {
				strErrorMessage = "The browser is not available for unknown reason.";
			}
			return ele;	
		}
		
		/*******************************************************************************************************************************************************************************************************************
	    'Created By			: vkamara3						
	    'Created On			: 2-july-2017				
	    'Last Updated By	: NA
	    'Last Updated On	: NA
	    'Parameters Used	: locatorXpath - Xpath
	    'Purpose			: To find the element by locator Xpath
	    'Steps:
	    '************************************************************************************************************************************************************************************************************************/
		public static WebElement FindElementByXpath(String locatorXpath){
			WebElement ele = null;
			try{
			   ele = driver.findElement(By.xpath(locatorXpath));
			}catch (NoSuchElementException e) {
				strErrorMessage = "Failed to find the Element using  locator xpath " + locatorXpath;
			}catch (WebDriverException e) {
				strErrorMessage = "The browser is not available for unknown reason.";
			}
			return ele;	
		}
		
		
		/*******************************************************************************************************************************************************************************************************************
	    'Created By			: vkamara3						
	    'Created On			: 2-july-2017				
	    'Last Updated By	: NA
	    'Last Updated On	: NA
	    'Parameters Used	: strLocatorID - ID
	    'Purpose			: To verify the element is displayed by locator ID
	    'Steps:
	    '************************************************************************************************************************************************************************************************************************/
		public static boolean isDisplayedByID(String strLocatorID){
			boolean blnDisplayStatus = false;
			try{
				if(FindElementByID(strLocatorID).isDisplayed()){
					blnDisplayStatus = true;
				}
			}catch (Exception e) {
				strErrorMessage =  e.getMessage();
			}
			return blnDisplayStatus;			
		}
		
		/*******************************************************************************************************************************************************************************************************************
	    'Created By			: vkamara3						
	    'Created On			: 2-july-2017				
	    'Last Updated By	: NA
	    'Last Updated On	: NA
	    'Parameters Used	: strLocatorName - Name
	    'Purpose			: To verify the element is displayed by locator Name
	    'Steps:
	    '************************************************************************************************************************************************************************************************************************/
		public static boolean isDisplayedByName(String strLocatorName){
			boolean blnDisplayStatus = false;
			try{
				if(FindElementByName(strLocatorName).isDisplayed()){
					blnDisplayStatus = true;
				}
			} catch (Exception e) {
				strErrorMessage =  e.getMessage();
			}
			return blnDisplayStatus;			
		}
		
		

		/*******************************************************************************************************************************************************************************************************************
	    'Created By			: vkamara3						
	    'Created On			: 2-july-2017				
	    'Last Updated By	: NA
	    'Last Updated On	: NA
	    'Parameters Used	: locatorClassName - Class Name
	    'Purpose			: To verify the element is displayed by locator Class Name
	    'Steps:
	    '************************************************************************************************************************************************************************************************************************/
		public static boolean isDisplayedByClassName(String locatorClassName){
			boolean blnDisplayStatus = false;
			try{
				if(FindElementByClassName(locatorClassName).isDisplayed()){
					blnDisplayStatus = true;
				}
			} catch (Exception e) {
				strErrorMessage =  e.getMessage();
			}
			return blnDisplayStatus;			
		}
		
		/*******************************************************************************************************************************************************************************************************************
	    'Created By			: vkamara3						
	    'Created On			: 2-july-2017				
	    'Last Updated By	: NA
	    'Last Updated On	: NA
	    'Parameters Used	: strLocatorLnkText - link text
	    'Purpose			: To verify the element is displayed by locator linktext
	    'Steps:
	    '************************************************************************************************************************************************************************************************************************/
		public static boolean isDisplayedByLinkText(String strLocatorLnkText){
			boolean blnDisplayStatus = false;
			try{
				if(FindElementByLinkText(strLocatorLnkText).isDisplayed()){
					blnDisplayStatus = true;
				}
			}catch (Exception e) {
				strErrorMessage =  e.getMessage();
			}
			return blnDisplayStatus;			
		}
		
		/*******************************************************************************************************************************************************************************************************************
	    'Created By			: vkamara3						
	    'Created On			: 2-july-2017				
	    'Last Updated By	: NA
	    'Last Updated On	: NA
	    'Parameters Used	: locatorCSS - CSS
	    'Purpose			: To verify the element is displayed by locator CSS
	    'Steps:
	    '************************************************************************************************************************************************************************************************************************/
		public static boolean isDisplayedByCSS(String locatorCSS){
			boolean blnDisplayStatus = false;
			try{
				if(FindElementByCSS(locatorCSS).isDisplayed()){
					blnDisplayStatus = true;
				}
			}catch (Exception e) {
				strErrorMessage =  e.getMessage();
			}
			return blnDisplayStatus;			
		}
		
		/*******************************************************************************************************************************************************************************************************************
	    'Created By			: vkamara3						
	    'Created On			: 2-july-2017				
	    'Last Updated By	: NA
	    'Last Updated On	: NA
	    'Parameters Used	: locatorPartialLinkText - partial link text
	    'Purpose			: To verify the element is displayed by locator partial linktext
	    'Steps:
	    '************************************************************************************************************************************************************************************************************************/
		public static boolean isDisplayedByPartialLinkText(String locatorPartialLinkText){
			boolean blnDisplayStatus = false;
			try{
				if(FindElementByPartialLinkText(locatorPartialLinkText).isDisplayed()){
					blnDisplayStatus = true;
				}
			}catch (Exception e) {
				strErrorMessage =  e.getMessage();
			}
			return blnDisplayStatus;			
		}
		
		/*******************************************************************************************************************************************************************************************************************
	    'Created By			: vkamara3						
	    'Created On			: 2-july-2017				
	    'Last Updated By	: NA
	    'Last Updated On	: NA
	    'Parameters Used	: locatorXpath - Xpath
	    'Purpose			: To verify the element is displayed by locator Xpath
	    'Steps:
	    '************************************************************************************************************************************************************************************************************************/
		public static boolean isDisplayedByXPath(String locatorXpath){
			boolean blnDisplayStatus = false;
			try{
				if(FindElementByXpath(locatorXpath).isDisplayed()){
					blnDisplayStatus = true;
				}
			} catch (Exception e) {
				strErrorMessage =  e.getMessage();
			}
			return blnDisplayStatus;			
		}	
		
		
		
		/*******************************************************************************************************************************************************************************************************************
	    'Created By			: vkamara3						
	    'Created On			: 2-july-2017				
	    'Last Updated By	: NA
	    'Last Updated On	: NA
	    'Parameters Used	: locatorId - id
	    'Purpose			: Method to click using the locator id using Action class
	    'Steps:
	    '************************************************************************************************************************************************************************************************************************/	
		public static void clickByIdUsingActions(String locatorId){		
			try {
			  act.moveToElement(FindElementByID(locatorId)).click().build().perform();
			}catch (Exception e) {
				strErrorMessage =  e.getMessage();
			}
		}
		
		/*******************************************************************************************************************************************************************************************************************
	    'Created By			: vkamara3						
	    'Created On			: 2-july-2017				
	    'Last Updated By	: NA
	    'Last Updated On	: NA
	    'Parameters Used	: locatorName - Name
	    'Purpose			: Method to click using the locator name using Action class
	    'Steps:
	    '************************************************************************************************************************************************************************************************************************/	
		public static void clickByNameUsingActions(String locatorName){
			try {
				act.moveToElement(FindElementByName(locatorName)).click().build().perform();
			} catch (Exception e) {
				strErrorMessage =  e.getMessage();
			}	
		}	
	
		/*******************************************************************************************************************************************************************************************************************
	    'Created By			: vkamara3						
	    'Created On			: 2-july-2017				
	    'Last Updated By	: NA
	    'Last Updated On	: NA
	    'Parameters Used	: locatorClassName - ClassName
	    'Purpose			: Method to click using the locator class name using Action class
	    'Steps:
	    '************************************************************************************************************************************************************************************************************************/	
		
		public static void clickByClassNameUsingActions(String locatorClassName){
			try {
				act.moveToElement(FindElementByClassName(locatorClassName)).click().build().perform();
			}catch (Exception e) {
				strErrorMessage =  e.getMessage();
			} 	
		}
	
		/*******************************************************************************************************************************************************************************************************************
	    'Created By			: vkamara3						
	    'Created On			: 2-july-2017				
	    'Last Updated By	: NA
	    'Last Updated On	: NA
	    'Parameters Used	: locatorLinkText - LinkText
	    'Purpose			:Method to click using the locator linktext Using Actions class
	    'Steps:
	    '************************************************************************************************************************************************************************************************************************/		
		
		public static void clickByLinkTextUsingActions(String locatorLinkText){
			try {
				act.moveToElement(FindElementByLinkText(locatorLinkText)).click().build().perform();
			}catch (WebDriverException e) {
				strErrorMessage = e.getMessage();
			} 
		}
		
		/*******************************************************************************************************************************************************************************************************************
	    'Created By			: vkamara3						
	    'Created On			: 2-july-2017				
	    'Last Updated By	: NA
	    'Last Updated On	: NA
	    'Parameters Used	: locatorPartialLinkText - PartialLinkText
	    'Purpose			:Method to click using the locator Partial linktext Using Actions class
	    'Steps:
	    '************************************************************************************************************************************************************************************************************************/		
		public static void clickByPartialLinkTextUsingActions(String locatorPartialLinkText){
			try {
				act.moveToElement(FindElementByPartialLinkText(locatorPartialLinkText)).click().build().perform();
			}catch (Exception e) {
				strErrorMessage =  e.getMessage();
			} 
	
		}
		
		/*******************************************************************************************************************************************************************************************************************
	    'Created By			: vkamara3						
	    'Created On			: 2-july-2017				
	    'Last Updated By	: NA
	    'Last Updated On	: NA
	    'Parameters Used	: 	locatorTagName - locator
	    'Purpose			: Method to click using the locator tagname Using Actions class
	    'Steps:
	    '************************************************************************************************************************************************************************************************************************/		
		public static void clickByTagNameUsingActions(String locatorTagName){
			try {
				act.moveToElement(FindElementByTagname(locatorTagName)).click().build().perform();
			}catch (Exception e) {
				strErrorMessage =  e.getMessage();
			} 
		}

		/*******************************************************************************************************************************************************************************************************************
	    'Created By			: vkamara3						
	    'Created On			: 2-july-2017				
	    'Last Updated By	: NA
	    'Last Updated On	: NA
	    'Parameters Used	: locatorCss - Css
	    'Purpose			: Method to click using the locator css clickByXpath Using Actions class
	    'Steps:
	    '************************************************************************************************************************************************************************************************************************/		
		public static void clickByCssUsingActions(String locatorCss){
			try {
				act.moveToElement(FindElementByCSS(locatorCss)).click().build().perform();
			} catch (Exception e) {
				strErrorMessage =  e.getMessage();
			} 
		}	
		
		/*******************************************************************************************************************************************************************************************************************
	    'Created By			: vkamara3						
	    'Created On			: 2-july-2017				
	    'Last Updated By	: NA
	    'Last Updated On	: NA
	    'Parameters Used	: locatorXpath - Xpath
	    'Purpose			:  Method to click using the locator xpath clickByXpath Using Actions class
	    'Steps:
	    '************************************************************************************************************************************************************************************************************************/		
		public static void clickByXpathUsingActions(String locatorXpath){
			try {
				act.moveToElement(FindElementByXpath(locatorXpath)).build().perform();
			}catch (Exception e) {
				strErrorMessage = e.getMessage();
			} 		
		}
		
		/*******************************************************************************************************************************************************************************************************************
	    'Created By			: vkamara3						
	    'Created On			: 2-july-2017				
	    'Last Updated By	: NA
	    'Last Updated On	: NA
	    'Parameters Used	: 
	    'Purpose			: Wait until the page getsloaded
	    'Steps:
	    '************************************************************************************************************************************************************************************************************************/		
		    public static void waitForPageLoaded() {
		        ExpectedCondition<Boolean> expectation = new
		                ExpectedCondition<Boolean>() {
		                    public Boolean apply(WebDriver driver) {
		                        return ((JavascriptExecutor) driver).executeScript("return document.readyState").toString().equals("complete");
		                    }
		                };
		        try {
		            Thread.sleep(1000);
		            WebDriverWait wait = new WebDriverWait(driver, 30);
		            wait.until(expectation);
		        } catch (Exception e) {
					strErrorMessage =  e.getMessage();
				}
		    }
		    /*******************************************************************************************************************************************************************************************************************
		    'Created By			: vkamara3						
		    'Created On			: 2-july-2017				
		    'Last Updated By	: NA
		    'Last Updated On	: NA
		    'Parameters Used	: 
		    'Purpose			: to move back to the previous page
		    'Steps:
		    '************************************************************************************************************************************************************************************************************************/		
		    public static void NavigateBack(){
		    	try{
		    	 driver.navigate().back();
		    	}catch (WebDriverException e) {
					strErrorMessage = "The browser is not available for unknown reason.";
				}catch (Exception e) {
					strErrorMessage =  e.getMessage();
				} 
		    }
		    /*******************************************************************************************************************************************************************************************************************
		    'Created By			: vkamara3						
		    'Created On			: 2-july-2017				
		    'Last Updated By	: NA
		    'Last Updated On	: NA
		    'Parameters Used	: 
		    'Purpose			: to get Windows count opened by the browser
		    'Steps:
		    '************************************************************************************************************************************************************************************************************************/		
		    public static int getWindowsCount(){
		    	int windowsSize = 0;
		    	try{
				  windowsSize =  driver.getWindowHandles().size();
		    	}catch (WebDriverException e) {
					strErrorMessage = "The browser is not available for unknown reason.";
		        }catch (Exception e) {
					strErrorMessage =  e.getMessage();
				}
				return windowsSize;		    	
		    }	
		    
		    /*******************************************************************************************************************************************************************************************************************
		    'Created By			: vkamara3						
		    'Created On			: 2-july-2017				
		    'Last Updated By	: NA
		    'Last Updated On	: NA
		    'Parameters Used	: locatorId - id,AttributeName - AttributeName
		    'Purpose			: to get the Attributevalue by locator ID
		    'Steps:
		    '************************************************************************************************************************************************************************************************************************/		
		    public static String getAttributeValueById(String locatorId,String AttributeName){
		    	String strAttributeValue ="";	
		    	try{
		    		strAttributeValue = FindElementByID(locatorId).getAttribute(AttributeName);
		    	}catch (Exception e) {
					strErrorMessage =  e.getMessage();
				}
				return strAttributeValue; 
		    }	
		    
		    /*******************************************************************************************************************************************************************************************************************
		    'Created By			: vkamara3						
		    'Created On			: 2-july-2017				
		    'Last Updated By	: NA
		    'Last Updated On	: NA
		    'Parameters Used	: locatorName - Name,AttributeName - AttributeName
		    'Purpose			: to get the Attributevalue by locator Name
		    'Steps:
		    '************************************************************************************************************************************************************************************************************************/		
		    public static String getAttributeValueByName(String locatorName,String AttributeName){
		    	String strAttributeValue ="";	
		    	try{
		    		strAttributeValue = FindElementByName(locatorName).getAttribute(AttributeName);
		    	}catch (Exception e) {
					strErrorMessage =  e.getMessage();
				}
				return strAttributeValue; 
		    }	
		    
		    /*******************************************************************************************************************************************************************************************************************
		    'Created By			: vkamara3						
		    'Created On			: 2-july-2017				
		    'Last Updated By	: NA
		    'Last Updated On	: NA
		    'Parameters Used	: locatorClassName - Class name,AttributeName - AttributeName
		    'Purpose			: to get the Attributevalue by locator Class Name
		    'Steps:
		    '************************************************************************************************************************************************************************************************************************/		
		    public static String getAttributeValueByClassName(String locatorClassName,String AttributeName){
		    	String strAttributeValue ="";	
		    	try{
		    		strAttributeValue = FindElementByClassName(locatorClassName).getAttribute(AttributeName);
		    	}catch (Exception e) {
					strErrorMessage =  e.getMessage();
				}
				return strAttributeValue; 
		    }	
		    
		    /*******************************************************************************************************************************************************************************************************************
		    'Created By			: vkamara3						
		    'Created On			: 2-july-2017				
		    'Last Updated By	: NA
		    'Last Updated On	: NA
		    'Parameters Used	: locatorCSS - CSS,AttributeName - AttributeName
		    'Purpose			: to get the Attributevalue by locator CSS
		    'Steps:
		    '************************************************************************************************************************************************************************************************************************/		
		    public static String getAttributeValueByCSS(String locatorCSS,String AttributeName){
		    	String strAttributeValue ="";	
		    	try{
		    		strAttributeValue = FindElementByCSS(locatorCSS).getAttribute(AttributeName);
		    	}catch (Exception e) {
					strErrorMessage =  e.getMessage();
				}
				return strAttributeValue; 
		    }	
		    

		    /*******************************************************************************************************************************************************************************************************************
		    'Created By			: vkamara3						
		    'Created On			: 2-july-2017				
		    'Last Updated By	: NA
		    'Last Updated On	: NA
		    'Parameters Used	: locatorXpath - Xpath,AttributeName - AttributeName
		    'Purpose			: to get the Attributevalue by locator Xpath
		    'Steps:
		    '************************************************************************************************************************************************************************************************************************/		
		    public static String getAttributeValueByXpath(String locatorXpath,String AttributeName){
		    	String strAttributeValue ="";	
		    	try{
		    		strAttributeValue = FindElementByXpath(locatorXpath).getAttribute(AttributeName);
		    	}catch (Exception e) {
					strErrorMessage =  e.getMessage();
				}
				return strAttributeValue; 
		    }	
		    		    

		    /*******************************************************************************************************************************************************************************************************************
		    'Created By			: vkamara3						
		    'Created On			: 2-july-2017				
		    'Last Updated By	: NA
		    'Last Updated On	: NA
		    'Parameters Used	: locatorXpath - Xpath
		    'Purpose			: To find the group of elements by locator Xpath
		    'Steps:
		    '************************************************************************************************************************************************************************************************************************/
			public static List<WebElement> FindElementsByXpath(String locatorXpath){
                 List<WebElement> list = null;
				try{
					list = driver.findElements(By.xpath(locatorXpath));
				}catch (NoSuchElementException e) {
					strErrorMessage = "Failed to find the Element using  locator locatorXpath" + locatorXpath;
				}catch (WebDriverException e) {
					strErrorMessage = "The browser is not available for unknown reason.";
				}catch (Exception e) {
					strErrorMessage =  e.getMessage();
				}
				return list;
			}
			
		    /*******************************************************************************************************************************************************************************************************************
		    'Created By			: vkamara3						
		    'Created On			: 2-july-2017				
		    'Last Updated By	: NA
		    'Last Updated On	: NA
		    'Parameters Used	: locatorXpath - Xpath
		    'Purpose			: To find the group of elements by locator TagName
		    'Steps:
		    '************************************************************************************************************************************************************************************************************************/
			public static List<WebElement> FindElementsByTagname(String TagName){
                 List<WebElement> list = null;
				try{
					list = driver.findElements(By.tagName(TagName));
				}catch (NoSuchElementException e) {
					strErrorMessage = "Failed to find the Element using  locator TagName" + TagName;
				}catch (WebDriverException e) {
					strErrorMessage = "The browser is not available for unknown reason.";
				}catch (Exception e) {
					strErrorMessage =  e.getMessage();
				}
				return list;
			}
			
			/*******************************************************************************************************************************************************************************************************************
		    'Created By			: vkamara3						
		    'Created On			: 2-july-2017				
		    'Last Updated By	: NA
		    'Last Updated On	: NA
		    'Parameters Used	: strLocatorID - ID
		    'Purpose			: To verify the element is enabled by locator ID
		    'Steps:
		    '************************************************************************************************************************************************************************************************************************/
			public static boolean isEnabledByID(String strLocatorID){
				boolean blnDisplayStatus = false;
				try{
					if(FindElementByID(strLocatorID).isEnabled()){
						blnDisplayStatus = true;
					}
				} catch (Exception e) {
					strErrorMessage =  e.getMessage();
				}
				return blnDisplayStatus;			
			}
			
			/*******************************************************************************************************************************************************************************************************************
		    'Created By			: vkamara3						
		    'Created On			: 2-july-2017				
		    'Last Updated By	: NA
		    'Last Updated On	: NA
		    'Parameters Used	: strLocatorName - Name
		    'Purpose			: To verify the element is enabled by locator Name
		    'Steps:
		    '************************************************************************************************************************************************************************************************************************/
			public static boolean isEnabledByName(String strLocatorName){
				boolean blnDisplayStatus = false;
				try{
					if(FindElementByName(strLocatorName).isEnabled()){
						blnDisplayStatus = true;
					}
				}catch (Exception e) {
					strErrorMessage =  e.getMessage();
				}
				return blnDisplayStatus;			
			}
			
			

			/*******************************************************************************************************************************************************************************************************************
		    'Created By			: vkamara3						
		    'Created On			: 2-july-2017				
		    'Last Updated By	: NA
		    'Last Updated On	: NA
		    'Parameters Used	: locatorClassName - Class Name
		    'Purpose			: To verify the element is enabled by locator Class Name
		    'Steps:
		    '************************************************************************************************************************************************************************************************************************/
			public static boolean isEnabledByClassName(String locatorClassName){
				boolean blnDisplayStatus = false;
				try{
					if(FindElementByClassName(locatorClassName).isEnabled()){
						blnDisplayStatus = true;
					}
				}catch (Exception e) {
					strErrorMessage =  e.getMessage();
				}
				return blnDisplayStatus;			
			}
			
			/*******************************************************************************************************************************************************************************************************************
		    'Created By			: vkamara3						
		    'Created On			: 2-july-2017				
		    'Last Updated By	: NA
		    'Last Updated On	: NA
		    'Parameters Used	: strLocatorLnkText - link text
		    'Purpose			: To verify the element is enabled by locator linktext
		    'Steps:
		    '************************************************************************************************************************************************************************************************************************/
			public static boolean isEnabledByLinkText(String strLocatorLnkText){
				boolean blnDisplayStatus = false;
				try{
					if(FindElementByLinkText(strLocatorLnkText).isEnabled()){
						blnDisplayStatus = true;
					}
				}catch (Exception e) {
					strErrorMessage =  e.getMessage();
				}
				return blnDisplayStatus;			
			}
			
			/*******************************************************************************************************************************************************************************************************************
		    'Created By			: vkamara3						
		    'Created On			: 2-july-2017				
		    'Last Updated By	: NA
		    'Last Updated On	: NA
		    'Parameters Used	: locatorPartialLinkText -partial link text
		    'Purpose			: To verify the element is enabled by locator partial linktext
		    'Steps:
		    '************************************************************************************************************************************************************************************************************************/
			public static boolean isEnabledByPartialLinkText(String locatorPartialLinkText){
				boolean blnDisplayStatus = false;
				try{
					if(FindElementByPartialLinkText(locatorPartialLinkText).isEnabled()){
						blnDisplayStatus = true;
					}
				}catch (Exception e) {
					strErrorMessage =  e.getMessage();
				}
				return blnDisplayStatus;			
			}
			
			/*******************************************************************************************************************************************************************************************************************
		    'Created By			: vkamara3						
		    'Created On			: 2-july-2017				
		    'Last Updated By	: NA
		    'Last Updated On	: NA
		    'Parameters Used	: locatorCSS - CSS
		    'Purpose			: To verify the element is enabled by locator CSS
		    'Steps:
		    '************************************************************************************************************************************************************************************************************************/
			public static boolean isEnabledByCSS(String locatorCSS){
				boolean blnDisplayStatus = false;
				try{
					if(FindElementByCSS(locatorCSS).isEnabled()){
						blnDisplayStatus = true;
					}
				}catch (Exception e) {
					strErrorMessage =  e.getMessage();
				}
				return blnDisplayStatus;			
			}
			

			/*******************************************************************************************************************************************************************************************************************
		    'Created By			: vkamara3						
		    'Created On			: 2-july-2017				
		    'Last Updated By	: NA
		    'Last Updated On	: NA
		    'Parameters Used	: locatorXpath - Xpath
		    'Purpose			: To verify the element is enabled by locator Xpath
		    'Steps:
		    '************************************************************************************************************************************************************************************************************************/
			public static boolean isEnabledByXPath(String locatorXpath){
				boolean blnDisplayStatus = false;
				try{
					if(FindElementByXpath(locatorXpath).isEnabled()){
						blnDisplayStatus = true;
					}
				}catch (Exception e) {
					strErrorMessage =  e.getMessage();
				}
				return blnDisplayStatus;			
			}	
			
			/*******************************************************************************************************************************************************************************************************************
		    'Created By			: vkamara3						
		    'Created On			: 2-july-2017				
		    'Last Updated By	: NA
		    'Last Updated On	: NA
		    'Parameters Used	: 
		    'Purpose			: To move the scroll bar to the end of the page
		    'Steps:
		    '************************************************************************************************************************************************************************************************************************/
			public  static boolean ViewtoScrollBar() throws InterruptedException{
				boolean blnScrollStatus = true;
				
				JavascriptExecutor scrollBarPresent = (JavascriptExecutor) driver;
					try{
					  scrollBarPresent.executeScript("window.scrollTo(0, document.body.scrollHeight)");
					}
					catch(Exception e){
						blnScrollStatus = false;
					}
		         return blnScrollStatus;	
			}
			
			public static boolean verifyAttributeContainsByXpath(String locatorXpath, String strAttributeName,String textValue){
                boolean returnValue=false;
                try { 
                       String verifyText = getAttributeValueByXpath(locatorXpath,strAttributeName);
                      if (verifyText.contains(textValue)) {
                            returnValue= true;
                            } else {
                                  strErrorMessage ="The expected text " +"\""+ textValue + "\"" + " Actual text: " + "\""+ verifyText +"\"" + " are not matched";  
                            } 
                      }catch (Exception e) {
                            strErrorMessage =  e.getMessage();
                      }
                return returnValue;
          }
			
			public static void enterWaitByXpath(WebElement element, String textValue){
				try {
					try{
						element.clear();
					}catch(Exception e){
						strErrorMessage = "Not able to clear the value";	
					}
					element.sendKeys(textValue);
				}catch (Exception e) {
					strErrorMessage =  e.getMessage();
				}		
			}
			
			public static void clickWaitByXpath(WebElement element){
				try {
					//element.sendKeys("");
					element.click();
				}catch (Exception e) {
					strErrorMessage =  e.getMessage();
				} 		
			}
			
			public static void clickWaitByCss(WebElement element){
				try {
					element.click();
				}catch (Exception e) {
					strErrorMessage =  e.getMessage();
				} 
			}
			
			public static void moveToElementByActions(String locatorId){		
				try {
				  act.moveToElement(FindElementByCSS(locatorId)).build().perform();
				}catch (Exception e) {
					strErrorMessage =  e.getMessage();
				}
			}

}


