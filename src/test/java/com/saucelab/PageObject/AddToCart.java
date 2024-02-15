package com.saucelab.PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddToCart{
	
	WebDriver driver;
	
	public AddToCart(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="shopping_cart_container")
	WebElement cartIcon;
	
	@FindBy(id="checkout")
	WebElement checkoutBtn;
	
	public void ClickOnCartIcon() {
		cartIcon.click();
	}
	
	public void ClickOncheckoutButton() {
		checkoutBtn.click();
	}

}
