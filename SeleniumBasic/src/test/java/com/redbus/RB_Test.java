package com.redbus;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

public class RB_Test extends RB_BaseClass{

	RB_POM page;

	@Test
	public void validateRedBus() {

		page= new RB_POM(driver);

		page.validateLogo();

	}


}
