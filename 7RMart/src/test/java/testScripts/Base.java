package testScripts;

import org.testng.annotations.Test;

import constants.Constant;
import utility.ScreenshotUtility;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;

public class Base {

	public WebDriver driver;
	Properties properties;
	FileInputStream fis;

	@BeforeMethod
	@Parameters("Browser")
	public void beforeMethod(String browser) throws Exception {
		try {
			properties = new Properties();
			fis = new FileInputStream(Constant.CONFIGFILE);
			properties.load(fis);

		} catch (FileNotFoundException exception) {
			exception.printStackTrace();
		}
		if (browser.equalsIgnoreCase("chrome")) {
			driver = new ChromeDriver();
		} else if (browser.equalsIgnoreCase("edge")) {
			driver = new EdgeDriver();
} else if (browser.equalsIgnoreCase("firefox")) {
			driver = new FirefoxDriver();
		} else {
			throw new Exception("invalid browser");
		}
		
	//	driver = new ChromeDriver();
	//	driver.get("https://groceryapp.uniqassosiates.com/admin/login");
		driver.get(properties.getProperty("URL"));
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
			driver.quit();
		}
	}

}
