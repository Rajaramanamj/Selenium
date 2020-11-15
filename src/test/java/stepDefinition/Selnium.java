package stepDefinition;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.KeyDownAction;
/*import org.testng.Assert;
import org.testng.asserts.SoftAssert;*/
import browser.Browser;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import junit.framework.Assert;
import resources.Generic;

public class Selnium extends Browser {

	Generic generic = new Generic();
	Actions action = new Actions(driver);
	JavascriptExecutor je = (JavascriptExecutor)driver;
	//SoftAssert assrt = new SoftAssert();

	public Selnium() throws Exception {
		super();
	}
	

	@Given("Open Chrome browser and enter the google link and verify title")
	public void open_Chrome_browser_and_enter_the_google_link_and_verify_title() throws Exception {
		System.out.println("Title is " + driver.getTitle() + " Current URL is " + driver.getCurrentUrl());
		/*System.out.println("Before Test");
		System.out.println(driver.getPageSource());
		driver.get("https://www.yahoo.co.in");
		Thread.sleep(2000);
		driver.navigate().back();
		driver.close(); //Closes current browser
		driver.quit(); Closes all browsers and session*/
	}

	@Given("Identifying selenium locators")
	public void identifying_selenium_locators() throws Exception {

		Generic.FindElementByID("email").sendKeys("Rajaraman");
		Generic.FindElementByName("pass").sendKeys("123456");
		Generic.FindElementByLinkText("Forgotten password?").click();
		driver.get("https://login.salesforce.com/");
		Generic.FindElementByID("username").sendKeys("Rajaraman");
		Generic.FindElementByName("pw").sendKeys("123456");
	}

	@Given("Identifying xpath and css in chrome and firefox browsers")
	public void Identifying_xpath_and_css_in_chrome_and_firefox_browsers() throws Exception {

		System.out.println("Start of section 6");
		String expectedError = "Please check your username and password. If you still can't log in, contact your Salesforce administrator.";
		Generic.FindElementByCSS("input[type='submit']").click();
		String actualError = Generic.getTextByCss("div#error");
		Assert.assertEquals(expectedError, actualError);
	}

	@Given("Identify forgot password and verify screen loaded")
	public void Identify_forgot_password_and_verify_screen_loaded() throws Exception {

		String expectedMsg = "Forgot Your Password";
		Generic.FindElementByCSS("a[id*='forgot']").click();
		String actualMsg = Generic.getTextByCss("h2[class*='mb']");
		Assert.assertEquals(expectedMsg, actualMsg);
		System.out.println("End of section 6");
	}

	@Given("Identify drop dropdowns")
	public void identify_drop_dropdowns() throws Exception {

		System.out.println("Start of section 8");
		driver.get("https://www.spicejet.com/");
		// static dropdowns having select and option values
		Generic.FindElementByID("divpaxinfo").click();
		Generic.selectValueByXpath("//select[contains(@name, 'Adult')]", "2");
		// Dynamic dropdowns
		Generic.FindElementByXpath("(//input[contains(@id, 'originStation1')])[1]").click();
		Generic.FindElementByXpath("(//a[@text='Bengaluru (BLR)'])[1]").click(); // alternate xpath instead providing
																					// index [1} is
																					// //div[@id='glsctl00_mainContent_ddl_originStation1_CTNR']//a[@text='Bengaluru
																					// (BLR)']
		Generic.FindElementByXpath("(//a[@text='Chennai (MAA)'])[2]").click();
		Generic.FindElementByCSS("a.ui-state-default.ui-state-highlight.ui-state-active").click();
		Generic.FindElementByCSS("input[id*='SeniorCitizenDiscount']").click();
		Assert.assertTrue(Generic.FindElementByCSS("input[id*='SeniorCitizenDiscount']").isSelected());
	}

	@Given("Working with auto suggestive dropdowns")
	public void Working_with_auto_suggestive_dropdowns() throws Exception {

		driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
		Generic.FindElementByID("autosuggest").sendKeys("ind");
		List<WebElement> autoSuggest = driver.findElements(By.cssSelector("li[class='ui-menu-item'] a"));
		for (int i = 0; i < autoSuggest.size(); i++) {
			String optionValue = autoSuggest.get(i).getText();
			if (optionValue.equals("India")) {
				autoSuggest.get(i).click();
				break;
			}
		}

		// Alternate advanced for loop in place of above for loop
		/*
		 * for(WebElement option :options) {
		 * if(option.getText().equalsIgnoreCase("India")) { option.click(); break; } }
		 */

	}

	@Then("Verify the date field enabled or disabled")
	public void Verify_the_date_field_enabled_or_disabled() throws Exception {

		boolean dateEnabled = false;
		Generic.FindElementByName("ctl00$mainContent$view_date2").click();
		if (Generic.FindElementByID("Div1").getAttribute("style").contains("1")) {
			dateEnabled = Generic.FindElementByName("ctl00$mainContent$view_date2").isEnabled();
		}
		Assert.assertTrue(dateEnabled);
	}

	@Given("Working with alerts")
	public void Working_with_alerts() throws Exception {

		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		Generic.FindElementByID("name").sendKeys("Rajaraman");
		Generic.FindElementByCSS("input#alertbtn").click();
		String alertText = driver.switchTo().alert().getText();
		System.out.println("Alert Text is " + alertText);
		driver.switchTo().alert().accept();
		System.out.println("End of section 8");
	}
	
	@Given("Log into ecommerce application and select products into carts")
	public void Log_into_ecommerce_application_and_select_products_into_carts() throws Exception {

		System.out.println("Start of section 9 and 10");
		String numberOfItems = "";
		String splitedName = null;
		int count = 0;
		driver.get("https://rahulshettyacademy.com/seleniumPractise/");
		String [] vegetablesList = {"Cucumber", "Beetroot", "Tomato"};
		List<WebElement> products = Generic.FindElementsByXpath("//h4[@class='product-name']");
		for(int i=0;i<products.size();i++) {
			String [] name = products.get(i).getText().split("-");
			splitedName = name[0].trim();
			List<String> seletedItemList = Arrays.asList(vegetablesList);
			if(seletedItemList.contains(splitedName)) {
				Generic.FindElementsByXpath("//div[@class='product-action']/button").get(i).click();
				count++;
				numberOfItems = numberOfItems + products.get(i).getText();
			}
			if(count == vegetablesList.length) {
				break;
			}
		}
		System.out.println("Number of Items "+numberOfItems);
	}
	
	@Then("Click on the cart and proceed to checkout then apply the promo code")
	public void Click_on_the_cart_and_proceed_to_checkout_then_apply_the_promo_code() throws Exception {
		
		String expectedCode = "Code applied ..!";
		Generic.FindElementByCSS("img[alt='Cart']").click();
		Generic.FindElementByXpath("//button[text()='PROCEED TO CHECKOUT']").click();
		Generic.FindElementByCSS("input.promoCode").sendKeys("rahulshettyacademy");
		Generic.FindElementByCSS("button.promoBtn").click();
		String actualCode = Generic.FindElementByCSS("span.promoInfo").getText();
		Assert.assertEquals(actualCode, expectedCode);
		System.out.println("End of section 9 and 10");
	}
	
	@Given("Log into ecommerce application amazon and mouse over the sign in")
	public void Log_into_ecommerce_application_amazon_and_mouse_over_the_sign_in() throws Exception {
		
		System.out.println("Start of section 11");
		driver.get("https://www.amazon.com/");
		Generic.moveToElementByActions("a[id='nav-link-accountList']");
		action.moveToElement(driver.findElement(By.cssSelector("input[id='twotabsearchtextbox']"))).click().keyDown(Keys.SHIFT).sendKeys("hello").build().perform();
	}
	
	@Given("Navigate to naukri and work on windows")
	public void Navigate_to_naukri_and_work_on_windows() throws Exception {
		
		driver.get("https://www.naukri.com/");
		Generic.FindElementByXpath("//img[contains(@src, 'cognizant')]").click();
		String parent = driver.getWindowHandle();
		Set<String> s = driver.getWindowHandles();
		Iterator<String> it = s.iterator();
		while(it.hasNext()) {
			String childWindows = it.next();
			if(!parent.equals(childWindows)) {
				if(driver.switchTo().window(childWindows).getTitle().contains("Cognizant")) {
					driver.switchTo().window(childWindows);
					System.out.println(driver.switchTo().window(childWindows).getTitle());
					Generic.FindElementByXpath("//input[@name='qp']").sendKeys("Automation Testing");
					break;
				}
			}
		}
		driver.switchTo().window(parent);
		String windowTitle = driver.switchTo().window(parent).getTitle();
		System.out.println(windowTitle);
		
    }
	
	@Given("Navigate to jqueryui and work on frames")
	public void Navigate_to_jqueryui_and_work_on_frames() throws Exception {
		
		driver.get("https://jqueryui.com/droppable/");
		driver.switchTo().frame(Generic.FindElementByCSS("iframe[class='demo-frame']"));
		WebElement source = Generic.FindElementByCSS("div#draggable");
		WebElement target = Generic.FindElementByCSS("div#droppable");
		action.dragAndDrop(source, target).build().perform();
		driver.switchTo().defaultContent();
		System.out.println("End of section 11");
    }
	
	@Given("Log into rahul shetty academy and get the number of links of the footer section limit the webdriver scope")
	public void Log_into_rahul_shetty_academy_and_get_the_number_of_links_of_the_footer_section_limit_the_webdriver_scope() throws Exception {
		
		System.out.println("Start of section 12");
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		System.out.println(driver.findElements(By.tagName("a")).size());
		WebElement limitScope = Generic.FindElementByXpath("//button[@id='openwindow']//ancestor::div[@class='block large-row-spacer']");
		System.out.println(limitScope.findElements(By.tagName("a")).size());
		je.executeScript("arguments[0].scrollIntoView(true);", Generic.FindElementByXpath("//div[contains(@class, 'footer')]//a[text()='Discount Coupons']"));
		String parent = driver.getWindowHandle();
		WebElement footerDriver = Generic.FindElementByXpath("//a[text()='Discount Coupons']//ancestor::ul");
		int footerLinks = footerDriver.findElements(By.tagName("a")).size();
		
		for(int i=1;i<footerLinks;i++) {
			String keyDown = Keys.chord(Keys.CONTROL,Keys.ENTER);
			footerDriver.findElements(By.tagName("a")).get(i).sendKeys(keyDown);
		}
		Set<String> s = driver.getWindowHandles();
		Iterator<String> it = s.iterator();
		while(it.hasNext()) {
			String childWindow = it.next();
			System.out.println(driver.switchTo().window(childWindow).getTitle());
		}
		driver.switchTo().window(parent);
		System.out.println(driver.switchTo().window(parent).getTitle());
		System.out.println("End of section 12");
    }
	
	@Given("Log into cricbuzz and work with tables")
	public void Log_into_cricbuzz_and_work_with_tables() throws Exception {
		
		System.out.println("Start of section 13");
		String batsmanDetails;
		driver.get("https://www.cricbuzz.com/");
		Generic.FindElementByCSS("a[title='Live Cricket Score']").click();
		Generic.FindElementByXpath("//a[text()='PAK vs ZIM - Complete']").click();
		Generic.FindElementByXpath("//a[contains(text(), 'Scorecard')]").click();
		WebElement scoreDriver = driver.findElement(By.xpath("//div[@id='innings_1']//span[text()='Zimbabwe Innings']//ancestor::div[@class='cb-col cb-col-100 cb-ltst-wgt-hdr']"));
		int innings = scoreDriver.findElements(By.xpath("//div[@class='cb-col cb-col-100 cb-scrd-itms']")).size();
		
		for(int i=0;i<innings;i++) {
			 if(scoreDriver.findElements(By.xpath("//div[@class='cb-col cb-col-100 cb-scrd-itms']")).get(i).getText().contains("Raza")) {
				 batsmanDetails = scoreDriver.findElements(By.xpath("div[@class='cb-col cb-col-100 cb-scrd-itms']")).get(i).getText();
					System.out.println(batsmanDetails);
			 }
		}
		System.out.println("End of section 13");
    }
	
	@Given("Work on broken links")
	public void Work_on_broken_links() throws Exception {
		
		System.out.println("Start of section 14");
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		String getLinks = null;
		WebElement footDriver = driver.findElement(By.xpath("//a[text()='Discount Coupons']//ancestor::div[contains(@class, 'footer')]"));
		List<WebElement> links = footDriver.findElements(By.tagName("a"));
		for(int i=0;i<links.size();i++) {
			getLinks = links.get(i).getAttribute("href");
			HttpURLConnection conn = (HttpURLConnection) new URL(getLinks).openConnection();
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
	public void Perform_web_table_sorting_using_java_streams() throws Exception {
		
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
		List<WebElement> vegOffers = Generic.FindElementsByXpath("//tr//td[1]"); //When page changes we must need to grab the elements again otherwise stale element exception occur
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
	public void Filter_the_web_table_using_selenium_java_streams() throws Exception {
		
		Generic.FindElementByCSS("input[type='search']").sendKeys("C");
		List<WebElement> filteredList = Generic.FindElementsByXpath("//tr//td[1]");
		filteredList.stream().filter(s->s.getText().contains("Cheese")).map(s->getPriceValue(s)).forEach(s->System.out.println(s));
	}
	
	
	
	
}
