package com.redbus;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import io.github.bonigarcia.wdm.WebDriverManager;

public class RB_BaseClass {

	WebDriver driver;

	@BeforeClass
	public void logIn_RB() {

		WebDriverManager.chromedriver().setup();

		driver= new ChromeDriver();

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		driver.get("https://www.redbus.in/");

	}

	@AfterClass
	public void closeRB() {

		if(driver != null) {

			driver.quit();
		}

	}

}

	

