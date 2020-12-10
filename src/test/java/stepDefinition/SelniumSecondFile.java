package stepDefinition;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;
import java.util.stream.Collectors;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

import browser.Browser;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import helper.Generic;
import pageobjects.SectionFifteen;

public class SelniumSecondFile {
	
	WebDriver driver = Browser.getDriver();
	Generic generic = new Generic();
	WebDriverWait wait=new WebDriverWait(driver,10);
	Actions action = new Actions(driver);
	JavascriptExecutor je = (JavascriptExecutor)driver;
	SectionFifteen sectionFifteen = new SectionFifteen();

	@Given("Work on broken links")
	public void Work_on_broken_links() throws Throwable {
		
		System.out.println("Start of section 14");
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		String getLinks = null;
		WebElement footDriver = driver.findElement(By.xpath("//a[text()='Discount Coupons']//ancestor::div[contains(@class, 'footer')]"));
		List<WebElement> links = footDriver.findElements(By.tagName("a"));
		for(int i=0;i<links.size();i++) {
			getLinks = links.get(i).getAttribute("href");
			HttpURLConnection conn = (HttpURLConnection) new URL(getLinks).openConnection();
			conn.setConnectTimeout(3000);
			conn.setRequestMethod("HEAD");
			conn.connect();
			int responseCode = conn.getResponseCode();
			String responseMessage = conn.getResponseMessage();
			//assrt.assertTrue(responseCode<400, "Test Failed");
			System.out.println(getLinks+" - "+responseCode+" "+responseMessage);
		}
		//assrt.assertAll();
    }
	
	@Given("Perform web table sorting using java streams")
	public void Perform_web_table_sorting_using_java_streams() throws Throwable {
		
		System.out.println("Start of section 15");
		List<String> price;
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");
		Generic.FindElementByXpath("//span[text()='Veg/fruit name']").click();
		List<WebElement> vegFruitOffers = Generic.FindElementsByXpath("//tr//td[1]");
		List<String> originalList = vegFruitOffers.stream().map(s-> s.getText()).collect(Collectors.toList());
		System.out.println(originalList);
		List<String> sortedList = originalList.stream().sorted().collect(Collectors.toList());
		System.out.println(originalList);
		Assert.assertTrue(originalList.equals(sortedList));
		
		do {
		//get the price of Beans
		List<WebElement> vegOffers = Generic.FindElementsByXpath("//tr//td[1]"); //When page changes we must need to grab the elements again otherwise stale element Throwable occur
		price = vegOffers.stream().filter(s-> s.getText().contains("Orange")).map(s-> getPriceValue(s)).collect(Collectors.toList());
		price.stream().forEach(a->System.out.println(a));
		
		if(price.size()<1) {
		Generic.FindElementByCSS("a[aria-label='Next']").click();
		}
	}while(price.size()<1);
}
	
	private static String getPriceValue(WebElement s) {
		
		String itemPrice = s.findElement(By.xpath("following-sibling::td[1]")).getText();
		return itemPrice;
	}
	
	@Given("Filter the web table using selenium java streams")
	public void Filter_the_web_table_using_selenium_java_streams() throws Throwable {
		
		sectionFifteen.searchItems();
	}
	
	@Given("Working with data tables {string}")
	public void working_with_data_tables(String Username) {
	    
		System.out.println(Username);
	}

	@Given("Working with data tables and password {string}")
	public void working_with_data_tables_and_password(String password) {
		System.out.println(password);
	}
	
	@When("Passing more than one values")
	public void passing_more_than_one_values(DataTable dataTable) {
	    
		List<String> list = dataTable.asList();
		list.stream().forEach(s -> System.out.println(s));
	}

}
