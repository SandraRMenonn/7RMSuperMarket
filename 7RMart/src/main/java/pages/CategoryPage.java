package pages;

import static org.testng.Assert.assertEquals;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import utility.PageUtility;
import utility.WaitUtility;

public class CategoryPage {

	public WebDriver driver;

	public CategoryPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//input[@id='category']")
	WebElement enterCategoryField;
	@FindBy(xpath = "//input[@type='file']")
	WebElement chooseFileButton;
	@FindBy(xpath = "(//span[text()='discount'])[1]")
	WebElement selectGroups;
	@FindBy(xpath = "//button[@type='submit']")
	WebElement saveAfterCategoryimageupload;
	@FindBy(xpath = "//input[@class='form-control']")
	WebElement categorySearchField;
	@FindBy(xpath = "//button[@name='Search']")
	WebElement categorySearchButton;
	@FindBy(xpath = "//a[@class='page-link']")
	WebElement categorySearchResultPagination;
	@FindBy(xpath = "//i[@class='fas fa-trash-alt']")
	WebElement deleteCategoryFromSearchResult;

	public CategoryPage addNewCategory(String categoryName, String filePath) {
		enterCategoryField.sendKeys(categoryName);
		selectGroups.click();
		chooseFileButton.sendKeys(filePath);
		WaitUtility waitUtilityPage=new WaitUtility();
		waitUtilityPage.waitForElementToBeClickable(driver, saveAfterCategoryimageupload);
		PageUtility pageUtility=new PageUtility();
		pageUtility.javaScriptExecutorToScrollDown();
		saveAfterCategoryimageupload.click();
		return this;
	}

	public boolean categorySearch(String categoryName) {
		categorySearchField.sendKeys(categoryName);
		categorySearchButton.click();
		boolean isPaginationDisplayed = categorySearchResultPagination.isDisplayed();
		System.out.println("Search result pagination displayed: " + isPaginationDisplayed);
		return isPaginationDisplayed;
	}

	public String searchResultGetText(String categoryName) {
		String searchresultGetCategoryNamexPath = "//td[text()='" + categoryName + "']";
		String searchresultGetCategoryName = driver.findElement(By.xpath(searchresultGetCategoryNamexPath)).getText();
		return searchresultGetCategoryName;
	}

	public CategoryPage deleteFromCategorySearchResult() {
		deleteCategoryFromSearchResult.click();
		driver.switchTo().alert().accept();
		return this;
	}
}
