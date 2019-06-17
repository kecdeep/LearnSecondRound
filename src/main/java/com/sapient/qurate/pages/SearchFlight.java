package com.sapient.qurate.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class SearchFlight {

	WebDriver driver;
	public SearchFlight(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath="//font[contains(text(),'Use our Flight Finder')]")
	public WebElement Welement_Text_FlightFinder;
	
	@FindBy(xpath="//input[@value='roundtrip']")
	public WebElement Radio_RoundTrip;
	
	@FindBy(name="fromPort")
	public WebElement Select_From;
	
	@FindBy(name="toPort")
	public WebElement Select_To;
	
	@FindBy(xpath="//input[@value='First']")
	public WebElement Radio_FirstClass;
	
	@FindBy(name="findFlights")
	public WebElement Btn_Continue;
	
	public boolean verifyValidLogin() {
		return Welement_Text_FlightFinder.isDisplayed();
	}
	
	public void enterSearchFlight(String sFromPort, String sToPort) {
		Select oSelectFrom=new Select(Select_From);
		oSelectFrom.selectByValue(sFromPort);
		Select oSelectTo=new Select(Select_To);
		oSelectTo.selectByValue(sToPort);
		Radio_FirstClass.click();
		Btn_Continue.click();
	}
}

