package com.selenium1;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import net.bytebuddy.asm.Advice.OffsetMapping.ForExitValue;

public class HYRWindows {

	WebDriver driver;

	WebDriverWait waits;

	@Test
	public void loginHYR() {

		WebDriverManager.chromedriver().setup();

		ChromeOptions options= new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");

		options.addArguments("--start-maximized");

		driver= new ChromeDriver(options);

		//		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		waits= new WebDriverWait(driver, Duration.ofSeconds(10));

		driver.get("https://www.hyrtutorials.com/p/window-handles-practice.html");


//	}

//	public void newWindown() {

		String parentHandle = driver.getWindowHandle();
		System.out.println("Parent WindowHandle "+parentHandle);

		try {
			WebElement adClick = waits.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div[5]/span[2]/svg")));
			adClick.click();
		}
		
		catch(Exception e){
			System.out.println("No Ad-Present");
		}
		
			WebElement newWindow = waits.until(ExpectedConditions.elementToBeClickable(By.id("newWindowBtn")));
			newWindow.click();


			Set<String> windowHandles = driver.getWindowHandles();
			System.out.println("Child WindowHandle `8"+windowHandles);

			for (String handle : windowHandles) {
				https://www.hyrtutorials.com/p/window-handles-practice.html
					if(!handle.equals(parentHandle)) {

						driver.switchTo().window(handle);

						driver.findElement(By.id("firstName")).sendKeys("sbalan018");
						driver.findElement(By.id("lastName")).sendKeys("Venba");
						driver.findElement(By.xpath("//input[@id='malerb']")).click();
						driver.findElement(By.xpath("//input[@id='latinchbx']")).click();

						driver.findElement(By.xpath("//input[@id='email']")).click();
						driver.findElement(By.xpath("//input[@id='password']")).click();

						driver.findElement(By.xpath("//button[@id='registerbtn']")).click();
						driver.close();

				}

			}
			
			driver.switchTo().window(parentHandle);
			driver.findElement(By.id("name")).sendKeys("Automation Testing");
		}		

}
