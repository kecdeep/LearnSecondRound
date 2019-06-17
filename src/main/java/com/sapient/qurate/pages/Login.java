package com.sapient.qurate.pages;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.sapient.qurate.utility.Utility;

public class Login {
WebDriver driver;
public Login(WebDriver driver) {
	this.driver=driver;
	PageFactory.initElements(driver, this);
}

@FindBy(xpath="//form//b")
public WebElement Welement_Date;

@FindBy(xpath="//img[@alt='Featured Destination: Aruba']")
public WebElement IMG_Aruba;

@FindBy(name="userName")
public WebElement Input_UserName;

@FindBy(name="password")
public WebElement Input_Password;

@FindBy(name="login")
public WebElement Btn_Sign_in;

@FindBy(xpath="//b[contains(text(),'Welcome back to')]")
public WebElement Welement_WelcomeBack;

public void openApp() throws IOException {
	driver.get(Utility.getProperty("Url")+"");
	driver.manage().window().maximize();
	driver.manage().timeouts().pageLoadTimeout(240, TimeUnit.SECONDS);
}
public boolean verifyDate() {
	boolean isCurentDate=false;
	String sAppDate=Welement_Date.getText().trim()+"";
	SimpleDateFormat sdf=new SimpleDateFormat("MMM dd, yyyy");
	Date dTodayDate=new Date();
	String sDateNow= sdf.format(dTodayDate);
	System.out.println("Date on Application="+sAppDate);
	System.out.println("Date Today="+sDateNow);
	if(sDateNow.equals(sAppDate)) {
		isCurentDate=true;
	}	
	return isCurentDate;
}

public boolean verifyArubaImagePresent() {
	return IMG_Aruba.isDisplayed();
}

public boolean verifyInvalidLogin(String userName,String password) {
	Input_UserName.sendKeys(userName);
	Input_Password.sendKeys(password);
	Btn_Sign_in.click();
	return Welement_WelcomeBack.isDisplayed();
}

public void enterValidLogin(String userName,String password) {
	Input_UserName.sendKeys(userName);
	Input_Password.sendKeys(password);
	Btn_Sign_in.click();
	driver.manage().timeouts().pageLoadTimeout(240, TimeUnit.SECONDS);
}

}
