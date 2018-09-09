package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage {

WebDriver driver;
WebDriverWait wait;
	
@FindBy(linkText="New Customer")
WebElement newCustomer;

@FindBy(linkText="Edit Customer")
WebElement editCustomer;

@FindBy(linkText="Delete Customer")
WebElement deleteCustomer;

@FindBy(linkText="New Account")
WebElement newAccount;

@FindBy(linkText="Edit Account")
WebElement editAccount;

@FindBy(linkText="Delete Account")
WebElement deleteAccount;

@FindBy(linkText="Deposit")
WebElement deposit;

@FindBy(linkText="Withdrawal")
WebElement withdrawal;

@FindBy(linkText="Fund Transfer")
WebElement transfer;

@FindBy(linkText="Change Password")
WebElement chPassword;

@FindBy(linkText="Balance Enquiry")
WebElement balEnquiry;

@FindBy(linkText="Mini Statement")
WebElement miniStatement;

@FindBy(linkText="Customised Statement")
WebElement custStatement;

@FindBy(linkText="Log out")
WebElement logout;







public HomePage(WebDriver driver)
	{
	this.driver=driver;
	PageFactory.initElements(driver, this);
	wait=new WebDriverWait(driver,20);
	}
	
public void clickNewCustomer()
{
wait.until(ExpectedConditions.visibilityOf(newCustomer));
newCustomer.click();	
}

public void deleteCustomer()
{
wait.until(ExpectedConditions.visibilityOf(deleteCustomer));
deleteCustomer.click();	
}

public void newAccount()
{
wait.until(ExpectedConditions.visibilityOf(newAccount));
newAccount.click();	
}

public void deleteAccount()
{
wait.until(ExpectedConditions.visibilityOf(deleteAccount));
deleteAccount.click();	
}

public void deposit()
{
wait.until(ExpectedConditions.visibilityOf(deposit));
deposit.click();	
}

public void withdrawal()
{
wait.until(ExpectedConditions.visibilityOf(withdrawal));
withdrawal.click();	
}

public void fundTransfer()
{
wait.until(ExpectedConditions.visibilityOf(transfer));
transfer.click();	
}

public void logout()
{
wait.until(ExpectedConditions.visibilityOf(logout));
logout.click();	
}



}