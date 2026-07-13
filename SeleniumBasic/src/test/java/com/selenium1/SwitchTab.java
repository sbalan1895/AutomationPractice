package com.selenium1;

import java.util.ArrayList;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.baseselenium.Base_DemoQA;
import com.pomclass.POM_TAB;

public class SwitchTab extends Base_DemoQA {

//	WebDriver driver;


	@Test
	public void switchTabs() {

		POM_TAB pom_tab= new POM_TAB(driver);

		String parentTab = driver.getWindowHandle();
		System.out.println("parent tab title: " +driver.getTitle());
		
		pom_tab.switchToTab();
		pom_tab.switchNextTab(parentTab);
		
		
		System.out.println("child tab title: " +driver.getTitle());
		
		pom_tab.switchParentT(parentTab);
		System.out.println("parent tab title: " +driver.getTitle());


	}

}
