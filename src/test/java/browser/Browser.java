package browser;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.SessionId;

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
    
 /*******************************************************************************************************************************************************************************************************************
    'Created By			: rrajara9						
    'Created On			: 2-july-2017				
    'Last Updated By	: NA
    'Last Updated On	: NA
    'Parameters Used	: NA
    'Purpose			: To Launch the browser
    'Steps:
    '************************************************************************************************************************************************************************************************************************/
    public Browser() throws Exception{
    	
    	if(!(driver == null)){
    		 if(!(driver.toString() == null)){
    			 strDriverValue = driver.toString();
    		 }
    		 else{
    			 strDriverValue = ""; 
    		 }
    	}
    	
    	if(driver == null || strDriverValue.contains("null")){	
    		 Browser.LoadConfigFile(); //Load the Config file
    		 Browser.SetSystemProperty(); //Launch the browser
	   		 try{
	   			 timeout = Integer.parseInt(prop.getProperty("TimeOut"));
	   			 driver.get(prop.getProperty("URL"));
	   			 driver.manage().timeouts().implicitlyWait(timeout,TimeUnit.SECONDS) ;	
	   			 driver.manage().window().maximize();
	   		 }
	   		 catch(Exception e){
	   			 System.out.println(e.getLocalizedMessage());
	    	}
    	}
    }
  	  
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
     	   File file = new File(System.getProperty("user.dir")+"\\src\\test\\java\\resources\\config.properties"); 		  
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
	public static void SetSystemProperty() throws Exception 
	{		
		  String browserName = prop.getProperty("BrowserName");	
	
		 switch(browserName){
				case "Chrome":
					System.setProperty("webdriver.chrome.driver","C:\\Projects\\SeleniumCucumber\\Selenium\\chromedriver.exe");
				    driver = new ChromeDriver();
                    session = ((ChromeDriver)driver).getSessionId();
				    System.out.println(session);
				    break;				    
				case "Firefox":
					System.setProperty("webdriver.firefox.driver","C:\\Projects\\SeleniumCucumber\\Selenium\\geckodriver.exe");
				    driver = new FirefoxDriver();
                    session = ((FirefoxDriver)driver).getSessionId();
				    System.out.println(session);
				    break;
		 }	
    }	
	
}


