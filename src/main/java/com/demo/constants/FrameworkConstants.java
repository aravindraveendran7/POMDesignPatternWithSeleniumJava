package com.demo.constants;

import com.demo.enums.ConfigProperties;
import com.demo.utils.ReadPropertyFile;

//.declaring the class as final here,prohibiting the user from inheriting this class.Only way to invoke this is by calling by classname 

public final class FrameworkConstants {

	//setting the access modifier to private and not exposing the variable
	//can be accessed only via getter setter
	private static final String RESOURCESPATH=System.getProperty("user.dir")+"/src/test/resources";
	private static final String CHROMEDRIVERPATH=RESOURCESPATH+"/executables/chromedriver";
	private static final String CONFIGFILEPATH=RESOURCESPATH+"/config/config.properties";
	private static final int EXPLICITWAIT=10;
	private static final String TESTDATAPATH=RESOURCESPATH+"/testdata/Book1.xlsx";
	private static final String EXTENTREPORTFOLDERPATH=RESOURCESPATH+"/Extent-Report-TestOutput/";
	private static String extentReportFilePath="";

	public static int getExplicitWait() {
		return EXPLICITWAIT;
	}
	private FrameworkConstants() {
		//to avoid calling this class methods by creating object.
	}
	public static String getConfigFilePath() {
		return CONFIGFILEPATH;
	}
	public static String getChromeDriverPath() {
		return CHROMEDRIVERPATH;
	}
	
	public static String getTestDataPath() {
		return TESTDATAPATH;
	}
	public static String createReportPath() throws Exception {
		if (ReadPropertyFile.get(ConfigProperties.OVERRIDEREPORTS).equalsIgnoreCase("no")) {
			return EXTENTREPORTFOLDERPATH+System.currentTimeMillis()+"index.html";
		}
		else {
			return EXTENTREPORTFOLDERPATH+"/index.html";
		}
	}
	
	public static String getExtentReport() throws Exception {
		if (extentReportFilePath.isEmpty()) {
			extentReportFilePath=createReportPath();
		}
		return extentReportFilePath;
	}
	
}
