@Second
Feature: Selenium Learning Second Part

@SectionFourteen @Regression 
Scenario: section 14 miscellneous topics in selenium

	Given Work on broken links
	
@SectionFifteen @Regression @QuickRegression
Scenario: section 15 selenium java streams

	Given Perform web table sorting using java streams
	Given Filter the web table using selenium java streams
	
@Example @Regression @Temp
Scenario Outline: Data Table Examples

	Given Working with data tables "<Username>" 
	Given Working with data tables and password "<Password>"
	
Examples:
	| Username | Password |
	| Rajaraman | Praveen  |
	| Kalaivani | Nishanth |
	| Ramu      | Usha     |
	
@Example @Regression @Temp
Scenario: Data Table Examples

	When Passing more than one values
	#|FieldName | SearchValue |
	| user      | 123         |
	| pass      | raja        |
	| logs      | Test        |
	
