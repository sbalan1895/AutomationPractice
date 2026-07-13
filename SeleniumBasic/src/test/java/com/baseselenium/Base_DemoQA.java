package com.baseselenium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Base_DemoQA {


	public static WebDriver driver;


	@BeforeClass
	public void loginDemoQA() {

		WebDriverManager.chromedriver().setup();

		driver= new ChromeDriver();

		driver.get("https://demoqa.com/browser-windows");

		driver.manage().window().maximize();

	}

	@AfterClass
	public void tearDown() {

		if(driver!=null) {
			driver.quit();
		}

	}

}


