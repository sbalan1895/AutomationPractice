package com.selenium1;

import java.time.Duration;

import org.jspecify.annotations.Nullable;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.openqa.selenium.TimeoutException;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DataProviderTest {

	WebDriver driver;

	@BeforeMethod
	public void loginPractAuto() {

		WebDriverManager.chromedriver().setup();

		driver= new ChromeDriver();

		driver.get("https://adactinhotelapp.com");

		driver.manage().window().maximize();
	}

	@DataProvider (name= "loginData")
	public Object[][] loginData(){

		return new Object[][] {

			{"sbalan018", "895S4A"},
			{"sbala018", "G7VA7C"}	

		};

	}

	@Test(dataProvider= "loginData")
	public void credentialEnter(String username, String password) {

		driver.findElement(By.xpath("//input[@id='username']")).clear();
		driver.findElement(By.xpath("//input[@id='username']")).sendKeys(username);

		driver.findElement(By.xpath("//input[@id='password']")).clear();
		driver.findElement(By.xpath("//input[@id='password']")).sendKeys(password);

		driver.findElement(By.xpath("//input[@id='login']")).click();

		WebDriverWait waits= new WebDriverWait(driver, Duration.ofSeconds(10));

		try {
			WebElement loggedUser = waits.until(ExpectedConditions.elementToBeClickable(By.xpath("//td[@class='welcome_menu']/following-sibling::td/input")));

			System.out.println("Logged-in user is " + loggedUser.getDomAttribute("value"));
		}

		catch(TimeoutException e) {
			System.out.println("Login failed for user " +username);
		}
		
		driver.findElement(By.xpath("//a[contains(text(),'Logout')]")).click();

	}
	//td[@class='welcome_menu']/following-sibling::td/input

	//	@Test (enabled= false)
	//	public void validateLogIn() {
	//
	//		WebDriverWait waits= new WebDriverWait(driver, Duration.ofSeconds(10));
	//		WebElement loggedUser = waits.until(ExpectedConditions.elementToBeClickable(By.xpath("//td[@class='welcome_menu']/following-sibling::td/input")));
	//		@Nullable
	//		String domAttribute = loggedUser.getDomAttribute("value");
	//		System.out.println("Logged-in user is " + domAttribute);
	//	}

	@AfterMethod(enabled= true)
	public void tearDown() {

		if(driver!=null) {
			driver.quit();
		}

	}
}
