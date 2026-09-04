package com.baseselenium;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseCodekru {

	public static WebDriver driver;
	public static WebDriverWait waits;

	@BeforeClass
	public void loginCodekru() {

		WebDriverManager.chromedriver().setup();

		driver= new ChromeDriver();

		driver.get("https://www.testkru.com/Interactions/Alerts");

		driver.manage().window().maximize();
		
		waits= new WebDriverWait(driver, Duration.ofSeconds(10));
	}

	@AfterClass
	public void tearDown() {

		if(driver!=null) {
			driver.quit();
		}

	}

}




