package com.selenium1;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.jspecify.annotations.Nullable;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.baseselenium.BaseHYR;
import com.baseselenium.BaseSelenium;

import net.bytebuddy.implementation.bind.annotation.Argument;

public class SeleniumWindows extends BaseHYR {
	
	String parentWID;
	
	
	@Test(priority=1)
	public void parentWindow() {
		
		WebDriverWait wait= new WebDriverWait(driver, Duration.ofSeconds(10));
		
		parentWID = driver.getWindowHandle();
		
		System.out.println("Parent Window ID is " + parentWID);
		
		WebElement newtWindow = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@id='newWindowsBtn']")));
		
		newtWindow.click();
		
	}
	
	@Test(priority=2)
	public void childWindow() {

		Set<String> windowHandles = driver.getWindowHandles();
		System.out.println("All WindowHandle ID are "+ windowHandles);
		
		for (String handle : windowHandles) {
			
			if(!handle.equals(parentWID)) {
				
				driver.switchTo().window(handle);
				
				System.out.println("ChildWindow URL ---------- " + driver.getCurrentUrl());
				System.out.println("ChildWindow Title ---------- " + driver.getTitle());
								
				driver.close();
			}
		}
		
	}
	
	@Test (priority=3, enabled= false)
	public void multiWindow() {
		
		String windowP = driver.getWindowHandle();
		
		driver.findElement(By.xpath("//button[@id='newWindowsBtn']")).click();
		
		Set<String> windowHandles = driver.getWindowHandles();
		
		List<String> windowList= new ArrayList<>();
		
		System.out.println(windowList);
				
	}
	
}
