package browser;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.util.Calendar;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.remote.SessionId;

import testRunner.RunCukesTest;


/*import com.ford.esow.helper.Constants;
import com.ford.esow.pageobjects.Login;*/




public class Browser  {

    public static WebDriver driver;
    public static  int timeout;
    public static Properties prop; 
    public static String UserID;
    public static String Password;
    public static SessionId session;
    public static String strDriverValue;
    
    public static WebDriver getDriver() {
    	
    	DesiredCapabilities cap;
		URL url;
		if(!(driver == null)){
   		 if(!(driver.toString() == null)){
   			 strDriverValue = driver.toString();
   		 }
   		 else{
   			 strDriverValue = ""; 
   		 }
   	}
		try {
			if(driver == null || strDriverValue.contains("null")){
					//Browser.dockerUp();
					Browser.LoadConfigFile();
					String browserName = prop.getProperty("browser");
				  //String browserName = System.getProperty("browser");
			if(browserName.equalsIgnoreCase("Chrome")) {
					/*String chrome = System.getProperty("user.dir")+"\\chromedriver.exe";
					System.setProperty("webdriver.chrome.driver",chrome);
			    	driver = new ChromeDriver();*/
			    	cap = DesiredCapabilities.chrome();
					url = new URL("http://localhost:4444/wd/hub");
				    driver = new RemoteWebDriver(url, cap);
			}else if(browserName.equalsIgnoreCase("Firefox")) {
					/*String firefox = System.getProperty("user.dir")+"\\geckodriver.exe";
					System.setProperty("webdriver.firefox.driver",firefox);
					driver = new FirefoxDriver();*/
					cap = DesiredCapabilities.firefox();
					url = new URL("http://localhost:4444/wd/hub");
				    driver = new RemoteWebDriver(url, cap);
			}
					 timeout = Integer.parseInt(prop.getProperty("TimeOut"));
					 Browser.getDriver().get(prop.getProperty("URL"));
					 Browser.getDriver().manage().timeouts().implicitlyWait(timeout,TimeUnit.SECONDS) ;	
					 Browser.getDriver().manage().window().maximize();
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
    	
    	return driver;
    }
    
 /*******************************************************************************************************************************************************************************************************************
    'Created By			: rrajara9						
    'Created On			: 2-july-2017				
    'Last Updated By	: NA
    'Last Updated On	: NA
    'Parameters Used	: NA
    'Purpose			: To Launch the browser
    'Steps:
    '
 * @return ************************************************************************************************************************************************************************************************************************/
    /*public void browserDriver() throws Exception{
    	
    	if(!(driver == null)){
    		 if(!(driver.toString() == null)){
    			 strDriverValue = driver.toString();
    		 }
    		 else{
    			 strDriverValue = ""; 
    		 }
    	}
    	
    	if(driver == null || strDriverValue.contains("null")){	
    		 //Browser.dockerUp();
    		 Browser.LoadConfigFile(); //Load the Config file
    		 Browser.getDriver(); //Launch the browser
	   		 try{
	   			 timeout = Integer.parseInt(prop.getProperty("TimeOut"));
	   			 Browser.getDriver().get(prop.getProperty("URL"));
	   			 Browser.getDriver().manage().timeouts().implicitlyWait(timeout,TimeUnit.SECONDS) ;	
	   			 Browser.getDriver().manage().window().maximize();
	   		 }
	   		 catch(Exception e){
	   			 System.out.println(e.getLocalizedMessage());
	    	}
    	}
    }*/
  	  
    /*******************************************************************************************************************************************************************************************************************
    'Created By			: rrajara9						
    'Created On			: 2-july-2017				
    'Last Updated By	: NA
    'Last Updated On	: NA
    'Parameters Used	: NA
    'Purpose			: To load the config file
    'Steps:
    '*************************************************************************************************************************************************************************************************************************/
    public static Properties LoadConfigFile(){
    	try{
     	   File file = new File(System.getProperty("user.dir")+"\\src\\test\\java\\helper\\config.properties"); 		  
 		   FileInputStream  fileInput = new FileInputStream(file);
 		    prop = new Properties();
 		    prop.load(fileInput);
 			return prop; 	    	
 		   
    	}
    	catch (IOException e) {
            throw new RuntimeException("Couldn't load Properties", e);
        
	     }
    }
    
    /*******************************************************************************************************************************************************************************************************************
    'Created By			: rrajara9						
    'Created On			: 2-july-2017				
    'Last Updated By	: NA
    'Last Updated On	: NA
    'Parameters Used	: NA
    'Purpose			: To set system property for browser
    'Steps:
    '*************************************************************************************************************************************************************************************************************************/
	/*public static void SetSystemProperty() throws Exception 
	{		
			DesiredCapabilities cap;
			URL url;
		  String browserName = prop.getProperty("browser");
		  //String browserName = System.getProperty("browser");
		  
		  String [] browsers = browserName.split(",");
		  for(int i=0;i<browsers.length;i++) {
			  if(browsers[i].equalsIgnoreCase("Chrome")) {
				  System.setProperty("webdriver.chrome.driver","C:\\Projects\\SeleniumCucumber\\Selenium\\chromedriver.exe");
				  driver = new ChromeDriver();
                  session = ((ChromeDriver)driver).getSessionId();
				  System.out.println(session);
			  }else if(browsers[i].equalsIgnoreCase("Firefox")) {
				  System.setProperty("webdriver.firefox.driver","C:\\Projects\\SeleniumCucumber\\Selenium\\geckodriver.exe");
				  driver = new FirefoxDriver();
                  session = ((FirefoxDriver)driver).getSessionId();
				  System.out.println(session);
			  }
		  }
		  
	
		 switch(browserName){
				case "Chrome":
					String chrome = System.getProperty("user.dir")+"\\chromedriver.exe";
					System.setProperty("webdriver.chrome.driver",chrome);
					cap = DesiredCapabilities.chrome();
					url = new URL("http://localhost:4444/wd/hub");
				    driver = new RemoteWebDriver(url, cap);
					driver = new ChromeDriver();
                    session = ((ChromeDriver)driver).getSessionId();
				    System.out.println(session);
				    break;				    
				case "Firefox":
					String firefox = System.getProperty("user.dir")+"\\geckodriver.exe";
					System.setProperty("webdriver.firefox.driver",firefox);
					cap = DesiredCapabilities.firefox();
					url = new URL("http://localhost:4444/wd/hub");
				    driver = new RemoteWebDriver(url, cap);
					driver = new FirefoxDriver();
                    session = ((FirefoxDriver)driver).getSessionId();
				    System.out.println(session);
				    break;
		 }	
    }*/
	
	/*public static void dockerUp() throws IOException, InterruptedException {
		
		boolean dockerup = false;
		Runtime runtime = Runtime.getRuntime();
		runtime.exec("cmd /c start dockerup.bat");
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.SECOND, 45);
		long stopNow = cal.getTimeInMillis();
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
		Thread.sleep(3000);
		
	}*/
	
}


