package com.baseselenium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseSelenium {

	public static WebDriver driver;

		public static Actions actions;

	@BeforeClass
	public void loginSelenium() {

		WebDriverManager.chromedriver().setup();

		driver= new ChromeDriver();

		//		actions= new Actions(driver);

		driver.get("https://www.tutorialspoint.com/selenium/practice/browser-windows.php");
		driver.manage().window().maximize();

	}

	@AfterClass
	public void tearDown() {

		if(driver!=null) {
			driver.quit();
		}

	}


}
