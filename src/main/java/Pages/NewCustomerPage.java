package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class NewCustomerPage {

	@FindBy(name="name")
	WebElement name;
	
	@FindBy(xpath="/html/body/table/tbody/tr/td/table/tbody/tr[5]/td[2]/input[1]")
	WebElement genderM;
	
	@FindBy(xpath="/html/body/table/tbody/tr/td/table/tbody/tr[5]/td[2]/input[2]")
	WebElement genderF;
	
	@FindBy(name="dob")
	WebElement dob;

	@FindBy(name="addr")
	WebElement address;

	@FindBy(name="city")
	WebElement city;

	@FindBy(name="state")
	WebElement state;
	
	@FindBy(name="pinno")
	WebElement pinno;
	
	@FindBy(name="telephoneno")
	WebElement telephone;
	
	@FindBy(name="emailid")
	WebElement email;
	
	@FindBy(name="password")
	WebElement password;
	
	@FindBy(name="sub")
	WebElement submit;
	
	@FindBy(name="res")
	WebElement reset;
	
	WebDriver driver;
	WebDriverWait wait;
public NewCustomerPage(WebDriver driver)
{
	this.driver=driver;
	PageFactory.initElements(driver, this);
	wait=new WebDriverWait(this.driver,20);

}
	

public void enterName(String custName)
{
wait.until(ExpectedConditions.visibilityOf(name));
name.sendKeys(custName);
}


public void selectGenderMale()
{
wait.until(ExpectedConditions.visibilityOf(genderM));
genderM.click();
}

public void selectGenderFemale()
{
wait.until(ExpectedConditions.visibilityOf(genderF));
genderF.click();
}

public void enterDOB(String DOB)
{
wait.until(ExpectedConditions.visibilityOf(dob));
dob.sendKeys(DOB);
}

public void enterAddress(String add)
{
wait.until(ExpectedConditions.visibilityOf(address));
address.sendKeys(add);
}

public void enterCity(String cityName)
{
wait.until(ExpectedConditions.visibilityOf(city));
city.sendKeys(cityName);
}

public void enterState(String stateName)
{
wait.until(ExpectedConditions.visibilityOf(state));
state.sendKeys(stateName);
}

public void enterPIN(String PINCode)
{
wait.until(ExpectedConditions.visibilityOf(pinno));
pinno.sendKeys(PINCode);
}

public void enterTelephoneNo(String telephoneNo)
{
wait.until(ExpectedConditions.visibilityOf(telephone));
telephone.sendKeys(telephoneNo);
}

public void enterEmail(String emailID)
{
wait.until(ExpectedConditions.visibilityOf(email));
email.clear();
email.sendKeys(emailID);
}

public void enterPassword(String pass)
{
wait.until(ExpectedConditions.visibilityOf(password));
password.clear();
password.sendKeys(pass);
}

public void clickSubmit()
{
wait.until(ExpectedConditions.visibilityOf(submit));
submit.click();
}

public void clickReset()
{
wait.until(ExpectedConditions.visibilityOf(reset));
reset.click();
}




}
