package Tests;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import PageObjects.CartPage;
import PageObjects.CheckOutPage;
import PageObjects.LandingPage;
import PageObjects.ProductCatalogue;
import TestComponents.BaseTest;

public class StandaloneTest extends BaseTest {
	@Test
	public void launchApp() throws InterruptedException, IOException {
		String productName = "ZARA COAT 3";
		launchApplication();
		LandingPage landingPage = new LandingPage(driver);
		landingPage.goTo();
		landingPage.launchApp("chakrireddy170@gmail.com", "Chakri@1234");

		ProductCatalogue productCatalogue = new ProductCatalogue(driver);
		List<WebElement> products = productCatalogue.getProductList();
		productCatalogue.getProductByName(productName);
		productCatalogue.addProductToCart(productName);
		productCatalogue.goToCartPage();
		
		CartPage cartPage=new CartPage(driver);
		boolean match = cartPage.verifyProductDisplay(productName);
		cartPage.checkOutPage();
		
		CheckOutPage checkOutPage = new CheckOutPage(driver);
		checkOutPage.selectCountry();
		


		
		
		
		
		// driver.findElement(By.cssSelector(".action_submit")).click();

		// String confirmMessage =
		// driver.findElement(By.cssSelector(".hero-primary")).getText();

		// Assert.assertTrue(confirmMessage.equalsIgnoreCase("THANKYOU FOR THE ORDER"));
		driver.close();

	}

}
