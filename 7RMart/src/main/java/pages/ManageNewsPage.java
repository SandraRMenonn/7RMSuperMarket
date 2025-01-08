package pages;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import utility.FileUploadUtility;

public class ManageNewsPage {

	public WebDriver driver;

	public ManageNewsPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//textarea[@name='news']")
	WebElement enterNewsArea;
	@FindBy(xpath = "//button[@type='submit']")
	WebElement clickSaveButtonforNews;

	public ManageNewsPage enterNewsInfo(String message) {
		enterNewsArea.click();
		enterNewsArea.sendKeys(message);
		clickSaveButtonforNews.click();
		return this;
	}

}
