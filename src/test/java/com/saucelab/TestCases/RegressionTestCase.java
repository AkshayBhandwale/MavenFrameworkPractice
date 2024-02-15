package com.saucelab.TestCases;

import java.io.IOException;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.saucelab.PageObject.AddToCart;
import com.saucelab.PageObject.CompletePage;
import com.saucelab.PageObject.InformationPage;
import com.saucelab.PageObject.LoginPage;
import com.saucelab.PageObject.LogoutPage;
import com.saucelab.PageObject.OverviewPage;
import com.saucelab.PageObject.ProductPage;

public class RegressionTestCase extends BaseClass {

	@Test
	public void TestCase() throws IOException {

		driver.get(URL);

		// LoginPage
		LoginPage loginPage = new LoginPage(driver);
		loginPage.enterUserName();
		loginPage.enterPassword();
		loginPage.clickOnLoginButton();

		String title = driver.getTitle();
		System.out.println("The Title of page is : " + title);

		// Assert.assertEquals(title, "Swag Labs", "Login test failed: Title mismatch");

		if (title.equals("Swag Labs")) {
			Assert.assertTrue(true);
		} else {
			captureScreenshot(driver, "Verify login title");
			Assert.assertTrue(false);
		}

		// ProductPage = Add item in cart
		ProductPage productPage = new ProductPage(driver);
		productPage.ClickOnBackpack();
		productPage.ClickOnAddToCardButton();

		String productPageURL = driver.getCurrentUrl();
		System.out.println("Cart Page URL is : " + productPageURL);
		if (productPageURL.equals("https://www.saucedemo.com/inventory-item.html?id=4")) {
			Assert.assertTrue(true);
		} else {
			captureScreenshot(driver, "productPageURL");
			Assert.assertTrue(false);
		}

		// Add to Cart
		AddToCart addToCart = new AddToCart(driver);
		addToCart.ClickOnCartIcon();
		addToCart.ClickOncheckoutButton();

		String cartPageURL = driver.getCurrentUrl();
		System.out.println("Information Page URL is : " + cartPageURL);
		if (cartPageURL.equals("https://www.saucedemo.com/checkout-step-one.html")) {
			Assert.assertTrue(true);
		} else {
			captureScreenshot(driver, "cartPageURL");
			Assert.assertTrue(false);
		}

		// Information Page
		InformationPage informationPage = new InformationPage(driver);
		informationPage.enterFirstName();
		informationPage.enterLastName();
		informationPage.enterPostalCode();
		informationPage.clickOnContinueButton();

		String informationPageURL = driver.getCurrentUrl();
		System.out.println("CHeckout Overview Page URL is : " + informationPageURL);

		if (informationPageURL.equals("https://www.saucedemo.com/checkout-step-two.html")) {
			Assert.assertTrue(true);
		} else {
			captureScreenshot(driver, "informationPage");
			Assert.assertTrue(false);
		}

		OverviewPage overviewPage = new OverviewPage(driver);
		overviewPage.clickOnFinishButton();

		String finalURL = driver.getCurrentUrl();
		System.out.println("The final page URL is : " + finalURL);

		if (finalURL.equals("https://www.saucedemo.com/checkout-complete.html")) {
			Assert.assertTrue(true);
		} else {
			captureScreenshot(driver, "OverviewPage");
			Assert.assertTrue(false);
		}

		// Complete Message
		CompletePage completePage = new CompletePage(driver);
		completePage.successMsg();

		// Logout Button
		LogoutPage logoutPage = new LogoutPage(driver);
		logoutPage.clickOnSliderButton();
		logoutPage.clickOnLogoutButton();

	}

}
