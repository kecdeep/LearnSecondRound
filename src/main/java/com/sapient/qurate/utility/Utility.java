package com.sapient.qurate.utility;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class Utility {
	
	public static String getProperty(String property) throws IOException {
		Properties prop=new Properties();
		FileReader file = new FileReader(System.getProperty("user.dir")+File.separator+"Resources"+File.separator+"config.properties");
		prop.load(file);
		return prop.getProperty(property);
	}
	
	public static void clickSnapShot(String sMethodeName,WebDriver driver) {
		String snapshotPath = System.getProperty("user.dir")+File.separator+"Output"+File.separator+ sMethodeName+"_"+System.currentTimeMillis() + ".jpeg";
		File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(src, new File(snapshotPath));
		} catch (IOException e) {
		}
	}

}
