package testRunner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/java/features/Selenium.feature",glue = {"stepDefinition"}, tags = "@Temp")

public class RunCukesTest {
	

}
