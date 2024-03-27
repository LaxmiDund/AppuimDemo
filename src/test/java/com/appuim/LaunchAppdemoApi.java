package com.appuim;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import com.google.common.collect.ImmutableMap;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.remote.MobilePlatform;

public class LaunchAppdemoApi {
	public static void main (String []args) throws MalformedURLException, InterruptedException 
	{
		DesiredCapabilities cap= new DesiredCapabilities();
		cap.setCapability(MobileCapabilityType.PLATFORM_NAME,MobilePlatform.ANDROID);

        //adb shell dumpsys window | find "mCurrentFocus" for finding apppackage and activity for current ap
		cap.setCapability("appPackage", "io.appium.android.apis");
		cap.setCapability("appActivity", "io.appium.android.apis.ApiDemos");
		AndroidDriver<WebElement> driver= new AndroidDriver<WebElement>(new URL("http://127.0.0.1:4723/wd/hub/"),cap);
        //ID
		//driver.findElement(By.id("android:id/text1")).click();
		//AccessibilityID
        //driver.findElementByAccessibilityId("App").click();
	    List<WebElement> element= driver.findElements(By.className("android.widget.TextView"));
	for(int i=1 ;i<element.size();i++)
	{
		System.out.println("value of element is : "+element.get(i).getText());
		element.get(i).click();
		Thread.sleep(2000);
		driver.navigate().back();
		Thread.sleep(2000);
		if(element.get(i).getText().equals("Preference")) {
			
		break;
		}
	}
	}
}
