package com.sapient.qurate.test;

import static org.testng.Assert.assertTrue;

import java.io.IOException;

import org.testng.annotations.Test;

import com.sapient.qurate.pages.Login;
import com.sapient.qurate.pages.SearchFlight;
import com.sapient.qurate.utility.Driver;
import com.sapient.qurate.utility.Utility;


/**
 * Unit test for simple App.
 */
public class LoginPage extends Driver 
{
	Login oLogin;
	SearchFlight oSearchFlight;
    @Test(priority=0)
	public void verifyDate() throws IOException
    {
    	System.out.println(driver);
    	oLogin=new Login(driver);
    	oLogin.openApp();
    	try {
    		assertTrue(oLogin.verifyDate(), "Date Shown on Login Page should be of Today");
    	}catch(Exception e){
    		assertTrue(false, "Date Shown on Login Page should be of Today");
    	}
    	
    }   
    @Test(priority=1)
    public void verifyArubaImagePresence() {
    	try {
    		oLogin=new Login(driver);
    		assertTrue(oLogin.verifyArubaImagePresent(), "Aruba Image should be present on Login Page");
    	}catch(Exception e) {
    		assertTrue(false, "Aruba Image should be present on Login Page");
    	}
    }
    @Test(priority=2)
    public void InvalidLoginOne(){
    	try {
    		oLogin=new Login(driver);
    		assertTrue(oLogin.verifyInvalidLogin(Utility.getProperty("InvalidUserNameOne"), Utility.getProperty("InvalidPasswordOne")), "Welcome Back text Should come Up for Invalid Login One");
    	}catch(Exception e) {
    		assertTrue(false, "Welcome Back text Should come Up for Invalid Login One");
    	}	
    }
    @Test(priority=2)
    public void InvalidLoginTwo(){
    	try {
    		oLogin=new Login(driver);
    		assertTrue(oLogin.verifyInvalidLogin(Utility.getProperty("InvalidUserNameTwo"), Utility.getProperty("InvalidPasswordTwo")), "Welcome Back text Should come Up for Invalid Login Two");
    	}catch(Exception e) {
    		assertTrue(false, "Welcome Back text Should come Up for Invalid Login Two");
    	}	
    }
    
    @Test(priority=3)
    public void ValidLogin(){
    	try {
    		oLogin=new Login(driver);
    		oLogin.enterValidLogin(Utility.getProperty("UserName"), Utility.getProperty("Password"));
    		oSearchFlight =new SearchFlight(driver);
    		assertTrue(oSearchFlight.verifyValidLogin(), "Search Flight Page should come up with Valid Login");
    	}catch(Exception e) {
    		assertTrue(false, "Search Flight Page should come up with Valid Login");
    	}	
    }
}
