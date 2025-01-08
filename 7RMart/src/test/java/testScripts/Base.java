package testScripts;

import org.testng.annotations.Test;

import utility.ScreenshotUtility;

import org.testng.annotations.BeforeMethod;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;

public class Base {

	public WebDriver driver;

	@BeforeMethod
	public void beforeMethod() {
		driver = new ChromeDriver();
		driver.get("https://groceryapp.uniqassosiates.com/admin/login");
		driver.manage().window().maximize();

	}

	@AfterMethod
	
	public void afterMethod(ITestResult itResult) throws IOException {
		
		//Before the driver quit, it takes the screenshot, if TC failed. No screenshot will be taken even if there is a failure in between, only the final one is considered.
		//i.e. current situation of the driver.
		if (itResult.getStatus() == ITestResult.FAILURE) {
			ScreenshotUtility sc = new ScreenshotUtility();
			sc.captureFailureScreenShot(driver, itResult.getName());
		}
		if (driver != null) {
		//	driver.quit();
		}
	}

}
