package com.ibm.mobilebrowser;

import java.net.MalformedURLException;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.ibm.common.BaseTest;
import com.ibm.common.Configuration;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;

public class GoogleChromeActivities extends BaseTest {

	String[] toDoList = { "Add tasks to list", "Get number of tasks", "Clear the list" };
	String UserName = "admin";
	String PassWord = "password";
	String UserName1 = "admin1";
	String PassWord1 = "password1";

	@Test
	public void Task4_GoogleChrome_toDoList() {

		getDriver().findElement(MobileBy.AndroidUIAutomator(
				"UiScrollable(UiSelector().scrollable(true).instance(0)).scrollIntoView(textStartsWith(\"To-Do List\"))"));
		getDriver().findElement(MobileBy.xpath("//android.widget.TextView[@text='To-Do List']")).click();
		Reporter.log("clicked on To - DO List");
		getDriver()
				.findElement(By
						.xpath("//android.webkit.WebView/android.view.View/android.view.View[3]/android.view.View[3]"))
				.click();
		Reporter.log("clicked on View");
		for (String toDo : toDoList) {
			getDriver().findElement(MobileBy.AndroidUIAutomator("resourceId(\"taskInput\")")).sendKeys(toDo);
			Reporter.log("'" + toDo + "' entered in task input");
			getDriver().findElement(MobileBy.AndroidUIAutomator("text(\"Add Task\")")).click();
			Reporter.log("Add Task clicked");
		}

		List<MobileElement> createdTasks = getDriver()
				.findElements(MobileBy.AndroidUIAutomator("resourceId(\"tasksList\")"));
		for (MobileElement tasks : createdTasks) {
			tasks.click();
			Reporter.log("Task clicked");
		}

		getDriver()
				.findElement(By
						.xpath("//android.webkit.WebView/android.view.View/android.view.View[3]/android.view.View[3]"))
				.click();
		Reporter.log("clicked on View");
		List<MobileElement> clearedTasks = getDriver()
				.findElements(MobileBy.AndroidUIAutomator("resourceId(\"tasksList\")"));
		Assert.assertEquals(clearedTasks.size(), 0);
		Reporter.log("Tasks Count matched with expected tasks count 0");

	}

	@Test
	public void Task5_GoogleChrome_ValidLogin() {

		getDriver().findElement(MobileBy.AndroidUIAutomator(
				"UiScrollable(UiSelector().scrollable(true).instance(0)).scrollIntoView(textStartsWith(\"Login Form\"))"));
		getDriver().findElement(MobileBy.xpath("//android.widget.TextView[@text='Login Form']")).click();
		String loginMessage = login(UserName, PassWord);
		Reporter.log("Valid Login message: " + loginMessage);
		Assert.assertEquals(loginMessage, "Welcome Back, admin");
		String invalidloginMessage = login(UserName1, PassWord1);
		Reporter.log("Invalid Login message:" + invalidloginMessage);
		Assert.assertEquals(invalidloginMessage, "Invalid Credentials");
	}

	@Test
	public void Task6_GoogleChrome_LoginSimpleForm() {

		getDriver().findElement(MobileBy.AndroidUIAutomator(
				"UiScrollable(UiSelector().scrollable(true).instance(0)).scrollIntoView(textStartsWith(\"Popups\"))"));
		getDriver().findElement(MobileBy.xpath("//android.widget.TextView[@text='Popups']")).click();
		getDriver().findElement(MobileBy.AndroidUIAutomator("text(\"Sign In\")")).click();
		String loginMessage = login(UserName, PassWord);
		Reporter.log("Valid Login message: " + loginMessage);
		Assert.assertEquals(loginMessage, "Welcome Back, admin");
		getDriver().findElement(MobileBy.AndroidUIAutomator("text(\"Sign In\")")).click();
		String invalidloginMessage = login(UserName1, PassWord1);
		Reporter.log("Invalid Login message:" + invalidloginMessage);
		Assert.assertEquals(invalidloginMessage, "Invalid Credentials");

	}

	@BeforeMethod
	public void beforeMethod() throws MalformedURLException {
		Reporter.log("********************************");
		Reporter.log("!!!!!Test Execution Started!!!!");
		setDriver(Configuration.createMobileDrvier(Configuration.CHROME_TASK_PACKAGE,
				Configuration.CHROME_TASK_ACTIVITY, Configuration.APPIUMSERVER_URL));

		getDriver().get(Configuration.URL);
		getDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	public String login(String Username, String Password) {
		Reporter.log("Sign In Clicked");
		WebElement userName = getDriver().findElement(MobileBy.AndroidUIAutomator("resourceId(\"username\")"));
		userName.clear();
		userName.sendKeys(Username);
		Reporter.log(Username + " entered in user name");
		try {
			Thread.sleep(3000);
		  } catch (InterruptedException e) {
			
		  }
		WebElement password = getDriver().findElement(MobileBy.AndroidUIAutomator("resourceId(\"password\")"));
		password.clear();
		password.sendKeys(Password);
		Reporter.log(Password + " entered in Password");
		getDriver().findElement(MobileBy.AndroidUIAutomator("text(\"Log in\")")).click();
		Reporter.log("Log In Clicked");
		return getDriver().findElement(MobileBy.AndroidUIAutomator("resourceId(\"action-confirmation\")")).getText();
	}

}
