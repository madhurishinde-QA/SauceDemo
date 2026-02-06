package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage
{	
	public LoginPage(WebDriver driver)
	{
		super(driver);
		
	}
	
	@FindBy (xpath="//input[@id=\"user-name\"]")
	WebElement username;
	
	@FindBy (xpath="//input[@id=\"password\"]")
	WebElement password;
	
	@FindBy (xpath="//input[@id=\"login-button\"]")
	WebElement loginBtn;
	
	@FindBy (xpath="//h3[text()='Epic sadface: Username is required']")
	WebElement emptyError;
	
	@FindBy (xpath="//h3[contains(text(),'Epic sadface: Sorry, this user has been locked out')]")
	WebElement lockedError;
	
	
	public void enterUser(String usr)
	{
		username.sendKeys(usr);
	}
	
	public void enterPass(String pass)
	{
		password.sendKeys(pass);
	}
	
	public void clickLoginBtn()
	{
		loginBtn.click();
	}
	
	public String getEmptyErrorMsg()
	{
		return emptyError.getText();
	}
	
	public String getLockedErrorMsg()
	{
		return lockedError.getText();
	}
	
	
}
