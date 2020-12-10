package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SelniumPageObjects {
	
	WebDriver driver;
	public SelniumPageObjects(WebDriver driver) {
		
			this.driver = driver;
	}
	
	private By email = By.id("email");
	private By pass = By.name("pass");
	private By forgetPassword = By.linkText("Forgotten password?");
	private By userName = By.id("username");
	private By password = By.name("pw");
	private By submit = By.cssSelector("input[type='submit']");
	private By forgot = By.cssSelector("a[id*='forgot']");
	private By paxInfo = By.id("divpaxinfo");
	private By orgnStation = By.xpath("(//input[contains(@id, 'originStation1')])[1]");
	private By banglore = By.xpath("(//a[@text='Bengaluru (BLR)'])[1]");
	private By chennai = By.xpath("(//a[@text='Chennai (MAA)'])[2]");
	private By defaultHighlight = By.cssSelector("a.ui-state-default.ui-state-highlight.ui-state-active");
	private By seniorCitizen = By.cssSelector("input[id*='SeniorCitizenDiscount']");
	private By autoSuggest = By.id("autosuggest");
	private By contentView = By.name("ctl00$mainContent$view_date2");
	private By name = By.id("name");
	private By alertButton = By.cssSelector("input#alertbtn");
	
	public WebElement getEmail() {
		return driver.findElement(email);
	}
	
	public WebElement getPass() {
		return driver.findElement(pass);
	}
	
	public WebElement getForgetPassword() {
		return driver.findElement(forgetPassword);
	}
	
	public WebElement getUserName() {
		return driver.findElement(userName);
	}
	
	public WebElement getPassword() {
		return driver.findElement(password);
	}
	
	public WebElement getsubmit() {
		return driver.findElement(submit);
	}
	
	public WebElement getforgot() {
		return driver.findElement(forgot);
	}
	
	public WebElement getPaxInfo() {
		return driver.findElement(paxInfo);
	}
	
	public WebElement getOrgnStation() {
		return driver.findElement(orgnStation);
	}
	
	public WebElement getBanglore() {
		return driver.findElement(banglore);
	}
	
	public WebElement getChennai() {
		return driver.findElement(chennai);
	}
	
	public WebElement getDefaultHighlight() {
		return driver.findElement(defaultHighlight);
	}
	
	public WebElement getSeniorCitizen() {
		return driver.findElement(seniorCitizen);
	}
	
	public WebElement getAutoSuggest() {
		return driver.findElement(autoSuggest);
	}
	
	public WebElement getName() {
		return driver.findElement(name);
	}
	
	public WebElement getAlertButton() {
		return driver.findElement(alertButton);
	}
	
	

}
