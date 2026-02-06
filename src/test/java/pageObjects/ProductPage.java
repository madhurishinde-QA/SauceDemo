package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import net.bytebuddy.asm.MemberSubstitution.FieldValue;

public class ProductPage extends BasePage
{

	public ProductPage(WebDriver driver) 
	{
		super(driver);
	}
	
	@FindBy (xpath="//span[text()='Products']")
	WebElement productTitle;
	
	@FindBy (css="#react-burger-menu-btn")
	WebElement hamburger;
	
	@FindBy (id="logout_sidebar_link")
	WebElement logoutBtn;
	
	@FindBy (xpath="//button[text()=\"Add to cart\" and@name=\"add-to-cart-sauce-labs-backpack\"]")
	WebElement addToCartBtn;
	
	@FindBy (className="shopping_cart_link")
	WebElement cartLink;
	
	public boolean isProductTitlePresent()
	{
		Boolean status=productTitle.isDisplayed();
		return status;
				
	}
	
	public void clickHamburgerBtn()
	{
		hamburger.click();
	}
	
	public void clickLogoutBtn()
	{
		logoutBtn.click();
	}
	
	public void clickAddToCartBtn()
	{
		addToCartBtn.click();
	}
	
	public void goToCartPage()
	{
		cartLink.click();
	}
	
	
	
	

	
}
