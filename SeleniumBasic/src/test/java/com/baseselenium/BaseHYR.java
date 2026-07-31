package com.baseselenium;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseHYR {

	public static WebDriver driver;


	@BeforeClass
	public void loginHYR() {

		WebDriverManager.chromedriver().setup();

		driver= new ChromeDriver();

		driver.get("https://www.hyrtutorials.com/p/window-handles-practice.html");

		driver.manage().window().maximize();

	}
	
	@Test (enabled = false)
	public void jsExecut(WebElement element) {
		JavascriptExecutor jsEx= (JavascriptExecutor) driver;
		
		jsEx.executeScript("arguments[0].scrollIntoView(true);", element);
	}

	@AfterClass
	public void tearDown() {

		if(driver!=null) {
			driver.quit();
		}

	}

}
