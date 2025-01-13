package utility;

import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PageUtility {

	public WebDriver driver;

	public void selectByVisibleText(WebElement dropdown, String visibleText) {

		Select selectAdminUserType = new Select(dropdown);
		selectAdminUserType.selectByVisibleText(visibleText);
	}

	public void selectByValuet(WebElement dropdown, String value) {

		Select selectAdminUserType = new Select(dropdown);
		selectAdminUserType.selectByValue(value);
		;
	}

	public void javaScriptExecutorToScrollDown(int pixels) {
		JavascriptExecutor exe = (JavascriptExecutor) driver;
		exe.executeScript("window.scrollBy(0," + pixels + ")"); // scroll down
		try {
			Thread.sleep(2000);
		} // 2-second pause }
		catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public boolean isSaveandDeleteSuccess(WebElement SaveandDeleteSuccessAlertElement) {
		boolean isSaveorDeleteSuccess = SaveandDeleteSuccessAlertElement.isDisplayed();
		System.out.println("Is Save or Delete success:" + isSaveorDeleteSuccess);
		return isSaveorDeleteSuccess;
	}

	public void acceptAlert() {
		driver.switchTo().alert().accept();
	}

	public void dismissAlert() {
		driver.switchTo().alert().dismiss();
	}

}
