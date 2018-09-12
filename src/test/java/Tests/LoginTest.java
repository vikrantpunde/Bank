package Tests;

import org.testng.annotations.Test;

import DriverInstance.BaseClass;
import ListenersClass.TestListner;
import Pages.LoginPage;
import Utility.Util;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
@Listeners(ListenersClass.TestListner.class)
public class LoginTest extends BaseClass{
	
	public WebDriver driver;
	WebDriverWait wait;
	LoginPage obj;
  
	
	@BeforeClass
  public void setup() {
	obj=new LoginPage(BaseClass.driver);	
	this.driver=BaseClass.driver;
  }

  
		
	
	

  @Test(enabled=false)
  public void validUsernamePassword() throws Exception{
	  
	  obj.enterUsername(Util.USER_NAME);
	  obj.enterPassword(Util.PASSWD);
	  obj.clickSubmit();
	  String title=obj.getTitle();
	  assertTrue(title.equals(Util.MGE_HP_title));
	  
  }
  
 
  @Test(enabled=false)
  public void validUsernameInvalidPassword() throws Exception{
	  String s=null;
	  obj.enterUsername(Util.USER_NAME);
	  obj.enterPassword("1111");
	  obj.clickSubmit();
	  if(isAlertPresent()==true)
	  {
		   s= driver.switchTo().alert().getText();
			 driver.switchTo().alert().accept();
	 }
	  assertTrue(s.equals(Util.Login_alert_msg));
	  
  }
  
  
  
  @Test(enabled=false)
  public void invalidUsernameValidPassword() throws Exception{
	  String s = null;
	  obj.enterUsername("1111");
	  obj.enterPassword(Util.PASSWD);
	  obj.clickSubmit();
	  if(isAlertPresent()==true)
	  {
		   s= driver.switchTo().alert().getText();
			 driver.switchTo().alert().accept();
	 }
	  assertTrue(s.equals(Util.Login_alert_msg));
  }
   
  
	
  @Test(enabled=false)
  public void invalidUsernamePassword() throws Exception{
	  String s = null;
	  obj.enterUsername("1111");
	  obj.enterPassword("1111");
	  obj.clickSubmit();
	  if(isAlertPresent()==true)
	  {
		   s= driver.switchTo().alert().getText();
			 driver.switchTo().alert().accept();
	 }
	  
		  assertTrue(s.equals(Util.Login_alert_msg));
	  
  }
  
  public boolean isAlertPresent() 
  { 
      try 
      { 
          driver.switchTo().alert(); 
          return true; 
      }   // try 
      catch (NoAlertPresentException Ex) 
      { 
          return false; 
      }   // catch 
  }   
  
  /*
  @AfterClass
  public void afterClass() {
	  driver.close();
  }
*/
  
}
