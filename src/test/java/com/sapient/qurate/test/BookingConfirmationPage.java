package com.sapient.qurate.test;

import static org.testng.Assert.assertTrue;

import org.testng.annotations.Test;

import com.sapient.qurate.pages.BookFlight;
import com.sapient.qurate.pages.BookingConfirmation;
import com.sapient.qurate.pages.SelectFlight;
import com.sapient.qurate.utility.Driver;

public class BookingConfirmationPage extends Driver{
	SelectFlight oSelectFlight;
	BookFlight oBookFlight;
	BookingConfirmation oBookingConfirmation;
	@Test(priority=6)
	public void verifyBooking() {
		try {
			oSelectFlight = new SelectFlight(driver);
			oSelectFlight.proceedWithTheBooking();
			oBookFlight=new BookFlight(driver);
			oBookFlight.enterDetailsAndBook();
			oBookingConfirmation=new BookingConfirmation(driver);
    		assertTrue(oBookingConfirmation.verifyTheBookingAndPrintConfirmationNumber(), "Booking should be successfull & with printed Booking ID");
		}catch(Exception e) {
    		assertTrue(false, "Booking should be successfull");
    	}	
	}
}
