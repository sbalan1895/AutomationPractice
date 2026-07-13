package com.selenium1;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.jspecify.annotations.Nullable;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.baseselenium.BaseHYR;
import com.baseselenium.BaseSelenium;

public class SeleniumWindows extends BaseHYR {
	
	String parentWID;
	
	@Test(priority=1)
	public void parentWindow() {
		
//		bs.loginSelenium();
		
		parentWID = driver.getWindowHandle();
		
		System.out.println("Parent Window ID is " + parentWID);
		
		//button[contains(text(), 'New Window')][1]
		
		WebElement newtWindow = driver.findElement(By.xpath("//button[contains(text(), 'New Window')][1]"));
		newtWindow.click();
		
	}
	
	@Test(priority=2)
	public void childWindow() {

		Set<String> windowHandles = driver.getWindowHandles();
		System.out.println("All WindowHandle ID are "+ windowHandles);
		
		for (String handle : windowHandles) {
			
			if(!handle.equals(parentWID)) {
				
				driver.switchTo().window(handle);
				
				String sampleT = driver.findElement(By.xpath("//div[contains(@class,'logindiv')]")).getText();
				
				Assert.assertTrue(sampleT.contains("Sample Text"));
				
				@Nullable
				String childUrl = driver.getCurrentUrl();
				@Nullable
				String childtitle = driver.getTitle();
				
				System.out.println("ChildWindow URL is " + childUrl);
				System.out.println("ChildWindow Title is " + childtitle);
				
				
			}
		}
		
	}
	
	@Test
	public void multiWindow() {
		
		String windowP = driver.getWindowHandle();
		
		driver.findElement(By.xpath("//button[@id='newWindowsBtn']")).click();
		
		Set<String> windowHandles = driver.getWindowHandles();
		
		List<String> windowList= new ArrayList<>();
		
		System.out.println(windowList);
				
	}
	
}
