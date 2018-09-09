package Pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import Utility.Util;
public class LoginPage {
	
	
	@FindBy(name="uid")
	WebElement userid;
	
	
	@FindBy(name="password")
	WebElement pass;
	
	@FindBy(name="btnLogin")
	WebElement login;
	
	
	WebDriver driver;
	WebDriverWait wait;
	
	
	public LoginPage(WebDriver driver){
		this.driver=driver;
		PageFactory.initElements(driver, this);
		wait=new WebDriverWait(this.driver,20);
	}
	
	public void enterUsername(String user){
		wait.until(ExpectedConditions.visibilityOf(userid));
		userid.clear();
		userid.sendKeys(user);
	}
	
	
	public void enterPassword(String passwrd){
		wait.until(ExpectedConditions.visibilityOf(pass));
		pass.clear();
		pass.sendKeys(passwrd);
	}
	
	public void clickSubmit(){
		wait.until(ExpectedConditions.visibilityOf(login));
		login.click();
	}
	public String getTitle(){
		return driver.getTitle();
	}


}
