package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DepositPage {
	
	@FindBy(name="accountno")
	WebElement accountNo;
	
	@FindBy(name="ammount")
	WebElement amount;
	
	@FindBy(name="desc")
	WebElement desc;
	
	@FindBy(name="AccSubmit")
	WebElement submit;
	
	
	
	WebDriver driver;
	WebDriverWait wait;
	
	public DepositPage(WebDriver driver){
		this.driver=driver;
		PageFactory.initElements(driver, this);
		wait=new WebDriverWait(driver,20);
		
	}

	public void enterAccountNo(String acc){
		wait.until(ExpectedConditions.visibilityOf(accountNo));
		accountNo.sendKeys(acc);
	}
	
	public void enterAmount(String am){
		wait.until(ExpectedConditions.visibilityOf(amount));
		amount.sendKeys(am);
	}
	
	public void enterDesc(String des){
		wait.until(ExpectedConditions.visibilityOf(desc));
		desc.sendKeys(des);
	}
	
	public void clickSubmit(){
		wait.until(ExpectedConditions.visibilityOf(submit));
		submit.click();
	}
	
}
