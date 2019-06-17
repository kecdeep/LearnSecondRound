package com.sapient.qurate.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BookFlight {
	WebDriver driver;
	public BookFlight(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(name="passFirst0")
	public WebElement Input_FirstName;
	
	@FindBy(name="passLast0")
	public WebElement Input_LastName;
	
	@FindBy(name="creditnumber")
	public WebElement Input_CreditCardNumber;
	
	@FindBy(name="buyFlights")
	public WebElement Btn_Secure_Purchase;
	
	public void enterDetailsAndBook() {
		Input_FirstName.sendKeys("Qurate");
		Input_LastName.sendKeys("QoE");
		Input_CreditCardNumber.sendKeys("123456789");
		Btn_Secure_Purchase.click();
	}
}
