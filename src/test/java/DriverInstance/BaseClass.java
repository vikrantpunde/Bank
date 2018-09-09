package DriverInstance;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import Utility.Util;

public class BaseClass {
	 public static WebDriver driver;

	 @BeforeSuite
	  public void setupChromeDriver() {
		 System.setProperty("webdriver.chrome.driver",Util.CHROME_PATH);
	  }
	 
	 
     @BeforeClass
     public void runDriver()
     {
    	
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(Util.BASE_URL);
        this.driver=driver;
     }

  
     

    
     
     @AfterClass
     public void close()        
     {
         driver.close();
     }
}
