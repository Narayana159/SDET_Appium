package com.ibm.googleapps;

import java.net.MalformedURLException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.ibm.common.BaseTest;
import com.ibm.common.Configuration;

import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;

public class GoogleTaskAPP extends BaseTest{
	
	String[] activiyt_Tasks = {"Complete Activity with Google Tasks", "Complete Activity with Google Keep", "Complete the second Activity Google Keep"};
	

	@Test
	public void Task1_GoogleTask_addTasks() {
		
		MobileElement newTask = getDriver().findElement(MobileBy.AndroidUIAutomator("resourceId(\"com.google.android.apps.tasks:id/tasks_fab\")"));
		for (String Task : activiyt_Tasks) {
			newTask.click();
			Reporter.log("New Task clicked");
			getDriver().findElement(MobileBy.AndroidUIAutomator("resourceId(\"com.google.android.apps.tasks:id/add_task_title\")")).sendKeys(Task);
			Reporter.log("'"+Task+"' entered in task");
			getDriver().findElement(MobileBy.AndroidUIAutomator("resourceId(\"com.google.android.apps.tasks:id/add_task_done\")")).click();
			Reporter.log("Save clicked");
		}
		
		List<MobileElement> createdTasks = getDriver().findElements(MobileBy.AndroidUIAutomator("resourceId(\"com.google.android.apps.tasks:id/task_name\")"));
		int tasksCount = (createdTasks.size());
		Reporter.log("Tasks Count:"+tasksCount);
		Assert.assertEquals(tasksCount, 3);
		Reporter.log("Tasks Count matched with expected tasks count");
	}

	@BeforeMethod
	public void beforeMethod() throws MalformedURLException {

		Reporter.log("********************************");
		Reporter.log("!!!!!Test Execution Started!!!!");
	  setDriver(Configuration.createMobileDrvier(Configuration.GOOGLE_TASK_PACKAGE, 
				Configuration.GOOGLE_TASK_ACTIVITY, Configuration.APPIUMSERVER_URL));
	  getDriver().manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	}

	
}
