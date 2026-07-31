package com.pomclass;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class POM_Windows {
	
	WebDriver driver;

	public POM_Windows(WebDriver driver) {
		
		this.driver= driver;
		
	}
	
	private By newWindow = By.id("newWindowsBtn");
	
	public void clickNewW() {
		
		driver.findElement(newWindow).click();
	}

}
