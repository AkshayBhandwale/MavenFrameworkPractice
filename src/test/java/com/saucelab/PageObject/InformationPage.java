package com.saucelab.PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class InformationPage{
	
	WebDriver driver;
	
	public InformationPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="first-name")
	WebElement FirstName;
	
	@FindBy(id="last-name")
	WebElement LastName;
	
	@FindBy(id="postal-code")
	WebElement PostalCode;
	
	@FindBy(id="continue")
	WebElement continueBtn;
	
	public void enterFirstName() {
		FirstName.sendKeys("Sample First Name");
	}
	
	public void enterLastName() {
		LastName.sendKeys("Sample Last Name");
	}
	
	public void enterPostalCode() {
		PostalCode.sendKeys("123456");
	}
	
	public void clickOnContinueButton() {
		continueBtn.click();
	}

	
}
