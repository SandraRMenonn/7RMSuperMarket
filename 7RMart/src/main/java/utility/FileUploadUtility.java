package utility;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;

import org.openqa.selenium.WebElement;

import constants.Constant;

public class FileUploadUtility {
	
	public void sendKeys(WebElement element, String path) {
		element.sendKeys(path);
	}
	
	public void robotClass(WebElement element, String path) throws AWTException {
		StringSelection choose=new StringSelection(Constant.TESTNEWPATH);
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(choose,null);
		Robot robot=new Robot();
		robot.delay(2500);
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);
		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_V);
		robot.keyRelease(KeyEvent.VK_CONTROL);
		robot.keyRelease(KeyEvent.VK_V);
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);
	}

}
