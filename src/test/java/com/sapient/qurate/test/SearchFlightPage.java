package com.sapient.qurate.test;

import static org.testng.Assert.assertTrue;

import org.testng.annotations.Test;

import com.sapient.qurate.pages.SearchFlight;
import com.sapient.qurate.pages.SelectFlight;
import com.sapient.qurate.utility.Driver;
import com.sapient.qurate.utility.Utility;

public class SearchFlightPage extends Driver{

	SearchFlight oSearchFlight;
	SelectFlight oSelectFlight;
	@Test(priority=4)
	public void verifySearchFunctionality() {
		try {
			oSearchFlight=new SearchFlight(driver);
			oSearchFlight.enterSearchFlight(Utility.getProperty("FromAirPort"),Utility.getProperty("ToAirPort"));
			oSelectFlight =new SelectFlight(driver);
    		assertTrue(oSelectFlight.verifySearchFlight(Utility.getProperty("FromAirPort"),Utility.getProperty("ToAirPort")), "Search Flight Page should come up with Valid Login");
		}catch(Exception e) {
    		assertTrue(false, "Search Flight Page should come up with Valid Login");
    	}	
	}
}
