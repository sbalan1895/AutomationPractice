package com.screenshot;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class ScreenshotUtil {
	
	WebDriver driver;
	
	public String takeScreenshot(String result) throws IOException {
		
		TakesScreenshot ts= (TakesScreenshot) driver;
		
		File source = ts.getScreenshotAs(OutputType.FILE);
		
		String path= "F:\\\\Sbalan018\\\\Automation\\\\eclipse-workspace-master\\\\eclipse-workspace-master\\\\SeleniumBasic\\\\TestOUTPUT\\\\" +
						result+ ".png";
		File dstn= new File(path);
		
		FileUtils.copyFile(source, dstn);
		
		return path;

	}
	

}
