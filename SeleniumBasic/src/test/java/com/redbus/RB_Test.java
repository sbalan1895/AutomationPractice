package com.redbus;

import java.awt.AWTException;
import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import com.google.common.io.Files;

public class RB_Test extends RB_BaseClass{

	RB_POM page;

	@Test(priority= 1)
	public void validateRedBus() {

		page= new RB_POM(driver);

		page.validateLogo();

	}
	
	@Test(priority=2)
	public void searchBus() throws AWTException {
		
		WebDriverWait waits = new WebDriverWait(driver, Duration.ofSeconds(10));
		
//		WebElement fromF = waits.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div[1]/main/div/div/div[2]/search/div/div/div[1]/div[1]/div[1]/div[1]")));
//		fromF.click();
		
		WebElement fromInput = waits.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@id='srcinput']")));
		fromInput.sendKeys("Chennai");

		WebElement fromSuggest = waits.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(text(),'Egmore')]")));
		fromSuggest.click();
		
		WebElement toInput = waits.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@id='destinput']")));
		toInput.sendKeys("Salem");

		WebElement toSuggest = waits.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(text(),'Avr')]")));
		toSuggest.click();
		
		//

	}

	@Test(priority=3)
	public void screenShot() throws IOException {

		TakesScreenshot screenshot= (TakesScreenshot)driver;
		File source = screenshot.getScreenshotAs(OutputType.FILE);

		File destination = new File("F:\\Sbalan018\\Automation\\AutomationPractice-main\\AutomationPractice-main\\PracticeProject\\SeleniumBasic\\TestOUTPUT\\redbud.png");

		Files.copy(source, destination);

		System.out.println("screenshot taken successfully");

	}


}
