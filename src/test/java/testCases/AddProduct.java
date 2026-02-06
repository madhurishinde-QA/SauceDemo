package testCases;

import pageObjects.ProductPage;
import testBase.TestBase;

public class AddProduct extends TestBase
{	
	public void addProductToCart()
	{
		ProductPage pp = new ProductPage(driver);
		pp.clickAddToCartBtn();
		pp.goToCartPage();
			
	}

}
