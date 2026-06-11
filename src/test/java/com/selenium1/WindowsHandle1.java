package com.selenium1;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.baseselenium.BaseSelenium;

public class WindowsHandle1 extends BaseSelenium {
	
	String windowHandle1;
	
	@Test(priority=1)
	public void parentWindow() {
		
//		bs.loginSelenium();
		
		windowHandle1 = driver.getWindowHandle();
		
		System.out.println("Window ID " + windowHandle1);
		
		//button[contains(text(), 'New Window')][1]
		
		WebElement parentWindow = driver.findElement(By.xpath("//button[contains(text(), 'New Window')][1]"));
		parentWindow.click();
		
	}
	
	@Test(priority=2)
	public void childWindow() {

		Set<String> windowHandles = driver.getWindowHandles();
		System.out.println("WindowHandle ID "+ windowHandles);
		
		for (String string : windowHandles) {
			
			if(!string.equals(windowHandle1)) {
				
				driver.switchTo().window(string);
				
				String sampleT = driver.findElement(By.xpath("//div[contains(@class,'logindiv')]")).getText();
				
				Assert.assertTrue(sampleT.contains("Sample Text"));
				
			}
		}
		
	}
	
	
	

}
