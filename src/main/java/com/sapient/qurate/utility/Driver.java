package com.sapient.qurate.utility;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Listeners;

@Listeners(TestNGListener.class)
public class Driver {
	private static String chromeDriverLocation=System.getProperty("user.dir")+File.separator+"Resources"+File.separator+"Drivers"+File.separator+"chromedriver.exe";
	private static String firefoxDriverLocation=System.getProperty("user.dir")+File.separator+"Resources"+File.separator+"Drivers"+File.separator+"geckodriver.exe";
	private static String chromeDriverProperties="webdriver.chrome.driver";
	private static String firefoxDriverProperties="webdriver.gecko.driver";
	public static WebDriver driver;
	
	@BeforeSuite
	public void BaseDriver() throws IOException {
		if(Utility.getProperty("Browser").equalsIgnoreCase("chrome")) {
			System.setProperty(chromeDriverProperties, chromeDriverLocation);
			driver = new ChromeDriver();
		}else {
			System.setProperty(firefoxDriverProperties, firefoxDriverLocation);
			driver=new FirefoxDriver();
		}
	}
	@AfterSuite
	public void cleanUp() {
		driver.close();
	}
}
