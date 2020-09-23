package com.ibm.common;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public class Configuration {
	
	
	public static String APPIUMSERVER_URL="http://0.0.0.0:4723/wd/hub";
	public static String DEVICE_NAME="motorola moto x4";
	public static String PLATFORM_NAME="android";
	public static String AUTOMATION_NAME="UiAutomator2";
	public static String GOOGLE_KEEP_PACKAGE="com.google.android.keep";
	public static String GOOGLE_KEEP_ACTIVITY=".activities.BrowseActivity";
	public static String GOOGLE_TASK_PACKAGE="com.google.android.apps.tasks";
	public static String GOOGLE_TASK_ACTIVITY=".ui.TaskListsActivity";
	public static String CHROME_TASK_PACKAGE="com.android.chrome";
	public static String CHROME_TASK_ACTIVITY="com.google.android.apps.chrome.Main";
	public static String URL="https://www.training-support.net/selenium";
	
	public static AndroidDriver<MobileElement> createMobileDrvier(String appPackage, String appActivity, String URL) throws MalformedURLException
	{
		DesiredCapabilities caps = new DesiredCapabilities();
		caps.setCapability("deviceName", DEVICE_NAME);
		caps.setCapability("platformName", PLATFORM_NAME);
		caps.setCapability("automationName", AUTOMATION_NAME);
		caps.setCapability("appPackage", appPackage);
		caps.setCapability("appActivity", appActivity);
		caps.setCapability("noReset", true);

		URL appServer = new URL(URL);
		return new AndroidDriver<MobileElement>(appServer, caps);
	}
	
	
}
