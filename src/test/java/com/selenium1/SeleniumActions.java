package com.selenium1;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.baseselenium.BaseSelenium;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SeleniumActions extends BaseSelenium {

	WebDriver driver;
//	Actions actions;

	@Test(priority=1)
	public void clickActions() {

		WebElement clickMe = driver.findElement(By.xpath("//button[@class='btn btn-primary']"));

		actions.click(clickMe).build().perform();

		WebElement Text = driver.findElement(By.xpath("//div[contains(text(), 'You have done a dynamic click')]"));
		boolean displayedClickMe = Text.isDisplayed();

		Assert.assertTrue(displayedClickMe);

	}

	@Test(priority=2)
	public void doubleClickActions() {

		WebElement doubleClick = driver.findElement(By.xpath("//button[@ondblclick='myDoubleclick()']"));

		actions.doubleClick(doubleClick).build().perform();

		WebElement Text2 = driver.findElement(By.xpath("//p[@id='doublec']"));
		boolean displayedDouble = Text2.isDisplayed();

		Assert.assertTrue(displayedDouble);

	}

	@Test(priority=3)
	public void contextClk() {
		//button[contains(text(),'Right Click Me')]
		WebElement contextClick = driver.findElement(By.xpath("//button[contains(text(),'Right Click Me')]"));

		actions.moveToElement(contextClick).contextClick().perform();

		WebElement Text3 = driver.findElement(By.xpath("//p[@id='right']"));
		boolean displayedRight = Text3.isDisplayed();

		Assert.assertTrue(displayedRight);
	}


	@Test(priority=4)
	public void screenCapture() throws IOException {

		TakesScreenshot ts= (TakesScreenshot)driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		File destn = new File("F:\\Sbalan018\\Automation\\eclipse-workspace-master\\eclipse-workspace-master\\SeleniumBasic\\TestOUTPUT\\clickMe.png");

		FileUtils.copyFile(source, destn);
	}

}
