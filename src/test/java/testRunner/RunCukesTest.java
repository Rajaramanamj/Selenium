package testRunner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
		stepNotifications = true,
		features = "src/test/java/features/Selenium.feature",
		glue = {"stepDefinition"}, 
		tags = "@Regression")

public class RunCukesTest {
	
	//ExtentSparkReporter and ExtentReport class
	/*@BeforeTest
	public void setUp() {
		String path = System.getProperty("user.dir")+"\\reprts\\index.html";
		ExtentSparkReporter reporter = new ExtentSparkReporter(path);
		reporter.config().setReportName("Web Automation Results");
		reporter.config().setDocumentTitle("Test Results");
		
		ExtentReports report = new ExtentReports();
		report.attachReporter(reporter);
		report.setSystemInfo("Tester", "Rajaraman Ramanathan");
		
	}*/

}
