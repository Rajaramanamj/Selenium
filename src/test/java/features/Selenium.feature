Feature: Selenium Learning

@LearnSelenium @Regression
Scenario: Learning selenium from scratch

	Given Open Chrome browser and enter the google link and verify title
	Given Identifying selenium locators
	
@LearnSelenium @Regression
Scenario: section 6 locator techniques and tools

	Given Identifying xpath and css in chrome and firefox browsers
	Given Identify forgot password and verify screen loaded

@SectionEight @Regression
Scenario: section 8 learning dropdowns radio buttons checkboxes and calender

	Given Identify drop dropdowns
	Given Working with auto suggestive dropdowns
	Then Verify the date field enabled or disabled
	Given Working with alerts
	
@SectionNineandten @Regression
Scenario: section 9 and 10 deep dive into selenium automation

	Given Log into ecommerce application and select products into carts
	Then Click on the cart and proceed to checkout then apply the promo code
	
@SectionEleven @Regression @QuickRegression
Scenario: section 11 automate ajax calls, child windows and iFrames

	Given Log into ecommerce application amazon and mouse over the sign in
	Given Navigate to naukri and work on windows
	Given Navigate to jqueryui and work on frames
	
@SectionTwelve @Regression @QuickRegression
Scenario: section 12 real time exercises

	Given Log into rahul shetty academy and get the number of links of the footer section limit the webdriver scope
	
@SectionThirteen @Smoke
Scenario: section 13 practical problems to handle them in selenium

	Given Log into cricbuzz and work with tables
	
@SectionFourteen @Regression @Temp
Scenario: section 14 miscellneous topics in selenium

	Given Work on broken links
	
@SectionFifteen @Regression @Temp
Scenario: section 15 selenium java streams

	Given Perform web table sorting using java streams
	Given Filter the web table using selenium java streams
	
	
	
	