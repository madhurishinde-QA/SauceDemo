package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.LoginPage;
import pageObjects.ProductPage;
import testBase.TestBase;

public class TestLogin extends TestBase
{
	
	
	@Test (priority=1)
	public void verifyValidLogin()
	{
		LoginPage lp = new LoginPage(driver);
		lp.enterUser(prop.getProperty("stUser"));
		lp.enterPass(prop.getProperty("pwd"));
		lp.clickLoginBtn();

		ProductPage pp = new ProductPage(driver);
		Assert.assertEquals(pp.isProductTitlePresent(), true);	
			
		pp.clickHamburgerBtn();
		pp.clickLogoutBtn();
		
	}
	
	
	@Test (priority=2)
	public void verifyEmptyLogin()
	{
		LoginPage lp = new LoginPage(driver);
		lp.clickLoginBtn();
		
		Assert.assertEquals(lp.getEmptyErrorMsg(), "Epic sadface: Username is required");
	}
	
	@Test (priority=3)
	public void verifyLockedUser()
	{
		LoginPage lp = new LoginPage(driver);

		lp.enterUser(prop.getProperty("lockUser"));
		lp.enterPass(prop.getProperty("pwd"));
		lp.clickLoginBtn();
		
		Assert.assertEquals(lp.getLockedErrorMsg(), "Epic sadface: Sorry, this user has been locked out.");
	
	}
	
	
}
