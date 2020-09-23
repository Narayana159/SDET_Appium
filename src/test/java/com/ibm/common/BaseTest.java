package com.ibm.common;


import java.net.MalformedURLException;

import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public class BaseTest {
	private AndroidDriver<MobileElement> driver=null;
		
		
		
		public void beforeMethod() throws MalformedURLException
		{
			Reporter.log("********************************");
			Reporter.log("!!!!!Test Execution Started!!!!");
			setDriver(Configuration.createMobileDrvier(Configuration.GOOGLE_KEEP_PACKAGE, 
					Configuration.GOOGLE_KEEP_ACTIVITY, Configuration.APPIUMSERVER_URL));
		}
		
		@AfterMethod
		public void afterMethod()
		{
			driver.quit();
			Reporter.log("!!!!!Test Execution Ended!!!!");
			Reporter.log("********************************");
		}
		
		
		protected AndroidDriver<MobileElement> getDriver()
		{
			return driver;
		}
		
		protected void setDriver(AndroidDriver<MobileElement> driver)
		{
			this.driver=driver;
		}

}
