package com.sapient.qurate.pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SelectFlight {
	WebDriver driver;
	public SelectFlight(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	

	@FindBy(xpath="//b/font[text()='DEPART']/ancestor::tr/following-sibling::tr//td[1]//b/font")
	public WebElement Text_Flight_DEPART;
	
	@FindBy(xpath="//b/font[text()='RETURN']/ancestor::tr/following-sibling::tr//td[1]//b/font")
	public WebElement Text_Flight_RETURN;
	
	@FindBy(xpath="//b/font[text()='DEPART']/ancestor::tr/following-sibling::tr//td//font/font/b")
	public List<WebElement> List_Price_DEPART;

	@FindBy(xpath="//b/font[text()='RETURN']/ancestor::tr/following-sibling::tr//td//font/font/b")
	public List<WebElement> List_Price_RETURN;
	
	@FindBy(name="reserveFlights")
	public WebElement Btn_Continue;
	
	public boolean verifySearchFlight(String sFromPort, String sToPort) {
		return (Text_Flight_DEPART.getText().trim()+"").equalsIgnoreCase(sFromPort+" to "+sToPort);
	}
	
	public boolean verifyPriceSort() {
		boolean sFlag=false;
		for(int i=0;i<List_Price_DEPART.size()-1;i++) {
		int priceFirst=Integer.parseInt(((List_Price_DEPART.get(i).getText().trim()+"").split("\\$"))[1]);
		int priceSecond=Integer.parseInt(((List_Price_DEPART.get(i+1).getText().trim()+"").split("\\$"))[1]);
		System.out.println(priceSecond+"<"+priceFirst);
		if(priceSecond<priceFirst){
				sFlag=true;
				break;
			}
		}
		return !sFlag;
	}
	
	public void proceedWithTheBooking() {
		Btn_Continue.click();
	}
	
}
