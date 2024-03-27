package com.appuim;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.android.AndroidDriver;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;

public class calulator {
public static void main(String[] args) throws MalformedURLException
{
	DesiredCapabilities d1= new DesiredCapabilities();
	d1.setCapability("devicename", "81c06b36ddee");
	d1.setCapability("automationName", "uiautomator2");
	d1.setCapability("PlatformName", "Android");
	d1.setCapability("Platform Version", "14.0.4");
	d1.setCapability("app package", "com.miui.calculator");
	d1.setCapability("App activity", "com.miui.calculator.cal.CalculatorActivity");
	
	//URL url= URI.create("http://127.0.0.1:4723/").toURL();
	URL url=new URL("http://127.0.0.1:4723/wd/hub");
	AndroidDriver driver=new AndroidDriver(url,d1);
	System.out.println("Application started");
	
    driver.findElement(By.id("com.miui.calculator:id/btn_8_s")).click();
    
    driver.findElement(By.id("com.miui.calculator:id/btn_plus_s")).click();
    
  driver.findElement(By.id("com.miui.calculator:id/btn_2_s")).click();
    
   driver.findElement(By.id("com.miui.calculator:id/btn_equal_s")).click();

    WebElement result= driver.findElement(By.id("com.miui.calculator:id/expression"));
 //  WebElement result= driver.findElement(By.xpath("android.view.View[@content-desc=\"0\"]"));

   String resultString = result.getText();
    
    if(resultString.equals(10))
    {
    	System.out.println("pass");
    }
    else
    {
    	System.out.println("fail");

    }
    
    driver.quit();
}
}
