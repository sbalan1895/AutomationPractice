package com.pomclass;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class POM_TAB {

	WebDriver driver;

	public POM_TAB(WebDriver driver) {

		this.driver= driver;
	}

	private By newTabButton = By.id("tabButton");


	public void switchToTab() {

		driver.findElement(newTabButton).click();
	}

	public void switchNextTab( String parentTab) {

		Set<String> windowHandles = driver.getWindowHandles();

		for(String nextT : windowHandles) {

			if(!nextT.equals(parentTab)) {
				driver.switchTo().window(nextT);
				break;
			}

		}

	}

	public void switchParentT(String parentTab) {

		driver.switchTo().window(parentTab);
		
	}

}
