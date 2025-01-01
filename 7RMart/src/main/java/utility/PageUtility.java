package utility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class PageUtility {
	
	public WebDriver driver;
	
	public void selectByVisibleText(WebElement dropdown,String visibleText) {
		
		Select selectAdminUserType=new Select(dropdown);
		selectAdminUserType.selectByVisibleText(visibleText);
	}

}
