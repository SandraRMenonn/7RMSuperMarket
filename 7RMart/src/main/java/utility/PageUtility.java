package utility;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class PageUtility {
	
	public WebDriver driver;
	
	public void selectByVisibleText(WebElement dropdown,String visibleText) {
		
		Select selectAdminUserType=new Select(dropdown);
		selectAdminUserType.selectByVisibleText(visibleText);
	}

	//add fw more methods
	
	public void javaScriptExecutorToScrollDown()
	{
		JavascriptExecutor exe = (JavascriptExecutor) driver;   
		exe.executeScript("window.scrollBy(0,3000)"); // scroll down
		try {
			Thread.sleep(2000);
		} // 2-second pause }
		catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
