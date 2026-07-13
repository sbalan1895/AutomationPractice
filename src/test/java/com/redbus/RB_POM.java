package com.redbus;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class RB_POM {

	WebDriver driver;
	WebDriverWait wait;

	public RB_POM(WebDriver driver) {

		this.driver = driver;

		wait= new WebDriverWait(driver, Duration.ofSeconds(10));

	}

	By redBusLogo= By.xpath("//img[@alt='redBus logo']");

	public void validateLogo() {

		String actualTitle = driver.getTitle();
		System.out.println("Title: " +actualTitle);

		boolean displayed = driver.findElement(redBusLogo).isDisplayed();

		System.out.println("Logo Displayed "+ displayed);
	}

}
