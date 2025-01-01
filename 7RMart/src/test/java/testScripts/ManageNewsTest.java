package testScripts;

import org.testng.annotations.Test;

import pages.HomePage;
import pages.LoginPage;
import pages.ManageNewsPage;

public class ManageNewsTest extends Base {
	
	
	
	public HomePage homePage;
	
	
  @Test
  public void enterNewsInfo() {
	  LoginPage loginPage=new LoginPage(driver);
	  loginPage.signIn("admin", "admin");
	  homePage=loginPage.clickSignIn();
	  ManageNewsPage manageNewsPage = new ManageNewsPage(driver);
	 // manageNewsPage.clickManageNewsLink();
	 // manageNewsPage.enterNewsInfo();
  }
}
