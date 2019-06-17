package com.sapient.qurate.test;

import static org.testng.Assert.assertTrue;

import org.testng.annotations.Test;

import com.sapient.qurate.pages.SelectFlight;
import com.sapient.qurate.utility.Driver;

public class SelectFlightPage extends Driver{

	SelectFlight oSelectFlight;
	@Test(priority=5)
	public void verifyPriceSortingFunctionality() {
		try {
			oSelectFlight=new SelectFlight(driver);
    		assertTrue(oSelectFlight.verifyPriceSort(), "Prices on Select Flight SPage should be Sorted from Lower to Higher");
		}catch(Exception e) {
    		assertTrue(false, "Prices on Select Flight SPage should be Sorted from Lower to Higher");
    	}	
	}
}
