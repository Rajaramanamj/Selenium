package testRunner;

import java.io.IOException;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

/*import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;*/

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
		monochrome = true,
		plugin = {"pretty","html:target/cucumber","json:target/cucumber.json","junit:target/cukes.xml"},
		features = {"src/test/java/resources"},
		glue = {"stepDefinition"},
		tags = {"@First,@Second"}
		)
public class RunCukesTest {
	
	//ExtentSparkReporter and ExtentReport class
	/*@Before
	public void setUp() {
		String path = System.getProperty("user.dir")+"\\reports\\index.html";
		ExtentSparkReporter reporter = new ExtentSparkReporter(path);
		reporter.config().setReportName("Web Automation Results");
		reporter.config().setDocumentTitle("Test Results");
		
		ExtentReports report = new ExtentReports();
		report.attachReporter(reporter);
		report.setSystemInfo("Tester", "Rajaraman Ramanathan");
		
	}*/

}
