package com.listerners;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.baseselenium.BaseSelenium;

public class TestListerners implements ITestListener {

	//	WebDriver driver;

	@Override
	public void onTestFailure(ITestResult result) {

		TakesScreenshot ts =  (TakesScreenshot) BaseSelenium.driver;

		File source = ts.getScreenshotAs(OutputType.FILE);

		File dstn= new File ("F:\\\\Sbalan018\\\\Automation\\\\eclipse-workspace-master\\\\eclipse-workspace-master\\\\SeleniumBasic\\\\TestOUTPUT\" + testName +\".png");

		try {
			FileUtils.copyFile(source, dstn);
		} 

		catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
