package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Utility.Util;

public class CustomerRegMsg {

	@FindBy(xpath="//*[@id=\"customer\"]/tbody/tr[4]/td[2]")
	WebElement custID;

	@FindBy(linkText="Continue")
	WebElement continueLink;

	
	
	WebDriver driver;
	WebDriverWait wait;
	
	public CustomerRegMsg(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
		wait=new WebDriverWait(this.driver,20);
	}
	
	public void saveCustId(){
		wait.until(ExpectedConditions.visibilityOf(custID));
		Util.setCustomerId(custID.getText());
		
	}
	
	public void clickContinue(){
		wait.until(ExpectedConditions.visibilityOf(continueLink));
		continueLink.click();
	}
	
	
	
}
