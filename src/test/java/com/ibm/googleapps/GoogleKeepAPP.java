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

public class GoogleKeepAPP extends BaseTest {
	
	
	/*Add Note method for adding task in Google Keep app*/
	
  @Test
  public void Task2_GoogleKeep_addNote() {
	 
	  List<MobileElement> createdTasks = getDriver().findElements(MobileBy.AndroidUIAutomator("resourceId(\"com.google.android.keep:id/browse_text_note\")"));
	  int initialNotesCount = (createdTasks.size());
	  Reporter.log("Intial Notes Count in Google Keep app: "+initialNotesCount);
	  getDriver().findElement(MobileBy.AndroidUIAutomator("resourceId(\"com.google.android.keep:id/new_note_button\")")).click();
	  Reporter.log("New Note button clicked");
	  getDriver().findElement(MobileBy.AndroidUIAutomator("resourceId(\"com.google.android.keep:id/editable_title\")")).sendKeys("NotesTitle");
	  Reporter.log("Title of notes added as 'NotesTitle'");
	  getDriver().findElement(MobileBy.AndroidUIAutomator("resourceId(\"com.google.android.keep:id/edit_note_text\")")).sendKeys("This Notes added from Automation");
	  Reporter.log("Notes text added as 'This Notes added from Automation'");
	  getDriver().findElementByAccessibilityId("Open navigation drawer").click();
	  Reporter.log("Notes Added successfully");
	  createdTasks = getDriver().findElements(MobileBy.AndroidUIAutomator("resourceId(\"com.google.android.keep:id/browse_text_note\")"));
	  int newNotesCount = (createdTasks.size());
	  Reporter.log("Notes Count in Google Keep app: "+newNotesCount);
	  Assert.assertEquals((newNotesCount - initialNotesCount), 1);
	  Reporter.log("Notes Count in Google Keep app updated by '"+newNotesCount +"' as expected");
 }
  
  
  /*Add Reminder method for adding reminder in Google Keep app*/
  @Test
  public void Task3_GoogleKeep_addReminder() {
	  
	  getDriver().findElementByAccessibilityId("Open navigation drawer").click();
	  Reporter.log("Navigation clicked");
	  getDriver().findElement(MobileBy.AndroidUIAutomator("resourceId(\"com.google.android.keep:id/drawer_navigation_reminders\")")).click();	  
	  List<MobileElement> createdTasks = getDriver().findElements(MobileBy.AndroidUIAutomator("resourceId(\"com.google.android.keep:id/browse_text_note\")"));
	  int initialRemindersCount = (createdTasks.size());
	  Reporter.log("Intial Reminders Count in Google Keep app: "+initialRemindersCount);
	  getDriver().findElement(MobileBy.AndroidUIAutomator("resourceId(\"com.google.android.keep:id/new_note_button\")")).click();
	  Reporter.log("New Reminder button clicked");
	  getDriver().findElement(MobileBy.AndroidUIAutomator("resourceId(\"com.google.android.keep:id/editable_title\")")).sendKeys("TitleReminder");
	  Reporter.log("Title of Reminder added as 'TitleReminder'");
	  getDriver().findElement(MobileBy.AndroidUIAutomator("resourceId(\"com.google.android.keep:id/edit_note_text\")")).sendKeys("This Reminder added from Automation");
	  Reporter.log("Reminder text added as 'This Reminder added from Automation'");
	  getDriver().findElementByAccessibilityId("Reminder").click();
	  Reporter.log("Reminder clicked");
	  getDriver().findElement(MobileBy.AndroidUIAutomator("resourceId(\"com.google.android.keep:id/time_spinner\")")).click();
	  Reporter.log("Time Spinner selected");
	  getDriver().findElement(MobileBy.AndroidUIAutomator("resourceId(\"com.google.android.keep:id/reminder_time_afternoon\")")).click();
	  Reporter.log("Time selected");
	  getDriver().findElement(MobileBy.AndroidUIAutomator("resourceId(\"com.google.android.keep:id/save\")")).click();
	  Reporter.log("Time Saved");
	  getDriver().findElementByAccessibilityId("Open navigation drawer").click();
	  Reporter.log("Open navigation");
	  getDriver().findElementByAccessibilityId("Open navigation drawer").click();
	  Reporter.log("Open navigation");
	  getDriver().findElement(MobileBy.AndroidUIAutomator("resourceId(\"com.google.android.keep:id/drawer_navigation_reminders\")")).click();	  
	  Reporter.log("Click on Reminders");
	  createdTasks = getDriver().findElements(MobileBy.AndroidUIAutomator("resourceId(\"com.google.android.keep:id/browse_text_note\")"));
	  int newRemindersCount = (createdTasks.size());
	  Reporter.log("Reminder Count in Google Keep app: "+newRemindersCount);
	  Assert.assertEquals((newRemindersCount - initialRemindersCount), 1);
	  Reporter.log("Reminders Count in Google Keep app updated by '"+newRemindersCount +"' as expected");
  }
  
  @BeforeMethod
  public void beforeMethod() throws MalformedURLException {
	  Reporter.log("********************************");
		Reporter.log("!!!!!Test Execution Started!!!!");
	  setDriver(Configuration.createMobileDrvier(Configuration.GOOGLE_KEEP_PACKAGE, 
				Configuration.GOOGLE_KEEP_ACTIVITY, Configuration.APPIUMSERVER_URL));
	  getDriver().manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

	}



}
