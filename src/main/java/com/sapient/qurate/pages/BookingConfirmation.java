package com.sapient.qurate.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BookingConfirmation {
	WebDriver driver;
	public BookingConfirmation(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//b[contains(.,'itinerary has been booked!')]")
	public WebElement Welement_BookingConfirmation;
	
	@FindBy(xpath="//table//td[1]/b//b")
	public WebElement Welement_BookingConfirmationNumber;
	
	public boolean verifyTheBookingAndPrintConfirmationNumber() {
		System.out.println(Welement_BookingConfirmationNumber.getText().trim()+"");
		return Welement_BookingConfirmation.isDisplayed();
	}
}


