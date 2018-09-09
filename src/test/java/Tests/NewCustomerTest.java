package Tests;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import org.testng.Assert;
import org.testng.AssertJUnit;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.UnhandledAlertException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.google.common.base.Verify;

import DriverInstance.BaseClass;
import Pages.CustomerRegMsg;
import Pages.HomePage;
import Pages.LoginPage;
import Pages.NewCustomerPage;
import Utility.Util;
@Listeners(ListenersClass.TestListner.class)
public class NewCustomerTest extends BaseClass{

	//WebDriver driver;
	LoginPage lpObj;
	HomePage hpObj;
	NewCustomerPage ncpObj;
	CustomerRegMsg crmObj;
	WebDriverWait wait;
	
	
	@Test
	public void successfulCustomerAdd(){
		
		SoftAssert soft=new SoftAssert();
		
		lpObj=new LoginPage(BaseClass.driver);
		lpObj.enterUsername(Util.USER_NAME);
		lpObj.enterPassword(Util.PASSWD);
		lpObj.clickSubmit();
		
		hpObj=new HomePage(BaseClass.driver);
		hpObj.clickNewCustomer();
		
		ncpObj=new NewCustomerPage(BaseClass.driver);
		ncpObj.enterName("a");
		ncpObj.selectGenderMale();
		ncpObj.enterDOB("12121990");
		ncpObj.enterAddress("a");
		ncpObj.enterCity("a");
		ncpObj.enterState("a");
		ncpObj.enterPIN("111111");
		ncpObj.enterTelephoneNo("8888888888");
		ncpObj.enterEmail("aynnny@gmail.com");
		ncpObj.enterPassword("12345");
		ncpObj.clickSubmit();
		
		boolean s;
		s=isAlertPresent();
		if(isAlertPresent()==true)
					{
		
					driver.switchTo().alert().accept();

					}
		else{
		crmObj=new CustomerRegMsg(BaseClass.driver);
		crmObj.saveCustId();
		crmObj.clickContinue();
		}
		
		hpObj.logout();

		Assert.assertEquals(s, false);
				
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
}
