package Tests;

import org.testng.annotations.Test;
import static org.testng.Assert.assertTrue;

import org.openqa.selenium.Alert;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import DriverInstance.BaseClass;
import Pages.DepositPage;
import Pages.HomePage;
import Pages.LoginPage;
import Utility.Util;
@Listeners(ListenersClass.TestListner.class)
public class DepositTest extends BaseClass{

	WebDriver driver;
	WebDriverWait wait;
	
	HomePage hp;
	LoginPage lp;
	DepositPage dp;
	

	
	
	@Test(enabled=false)
	public void successfulDeposit(){
	
	
		lp=new LoginPage(BaseClass.driver);
		lp.enterUsername(Util.USER_NAME);
		lp.enterPassword(Util.PASSWD);
		lp.clickSubmit();
		
		hp=new HomePage(BaseClass.driver);
		hp.deposit();
		
		dp=new DepositPage(BaseClass.driver);
		this.driver=BaseClass.driver;
		dp.enterAccountNo("84340");
		dp.enterAmount("1000");
		dp.enterDesc("abc");
		dp.clickSubmit();
		
		
		boolean s=isAlertPresent();
		
		
		if(isAlertPresent()==true)
		driver.switchTo().alert().accept();
		
		hp.logout();
		if(isAlertPresent()==true){
		driver.switchTo().alert().accept();
		}
		Assert.assertEquals(s,false);
		
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
