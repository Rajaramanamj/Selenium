package testRunner;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Calendar;

import org.junit.AfterClass;
import org.junit.Assert;
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
		features = {"src/test/java/features"},
		glue = {"stepDefinition"},
		plugin = {"pretty","html:target/cucumber","json:target/cucumber.json","junit:target/cukes.xml"},
		monochrome = true,
		tags = {"@QuickRegression or @Temp"}
		)
public class RunCukesTest {
	
	@BeforeClass
	public static void dockerUp() throws IOException, InterruptedException {
		
		boolean dockerup = false;
		Runtime runtime = Runtime.getRuntime();
		runtime.exec("cmd /c start dockerup.bat");
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.SECOND, 45);
		long stopNow = cal.getTimeInMillis();
		Thread.sleep(3000);
		while(System.currentTimeMillis()<stopNow) {
			if(dockerup) {
				break;
			}
			BufferedReader reader = new BufferedReader(new FileReader("output.txt"));
			String currentLine = reader.readLine();
		while(currentLine != null && !dockerup) {
			if(currentLine.contains("The node is registered to the hub and ready to use")) {
				System.out.println("Log Found");
				dockerup = true;
				break;
			}
			currentLine = reader.readLine();
		}
		reader.close();
	}
		Assert.assertTrue(dockerup);
		Thread.sleep(20000);
		
}
	
	@AfterClass
	public static void dockerDown() throws IOException, InterruptedException {
		
		boolean dockerdown = false;
		Runtime runtime = Runtime.getRuntime();
		runtime.exec("cmd /c start dockerdown.bat");
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.SECOND, 45);
		long stopNow = cal.getTimeInMillis();
		Thread.sleep(3000);
		while(System.currentTimeMillis()<stopNow) {
			if(dockerdown) {
				break;
			}
			BufferedReader reader = new BufferedReader(new FileReader("output.txt"));
			String currentLine = reader.readLine();
		while(currentLine != null && !dockerdown) {
			if(currentLine.contains("Shutdown complete")) {
				System.out.println("Delete Text Found");
				dockerdown = true;
				break;
			}
			currentLine = reader.readLine();
		}
		reader.close();
	}
		Assert.assertTrue(dockerdown);
		Thread.sleep(5000);
		File file = new File("output.txt");
		boolean fileDeleted = file.delete();
		if(fileDeleted) {
			System.out.println("Output File Deleted Successfully");
		}
		
}
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
