package testScripts;

import static org.testng.Assert.assertEquals;

import java.time.Duration;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import constants.Constant;
import pages.HomePage;
import pages.LoginPage;

public class HomePageTest extends Base {

	public HomePage homePage; //reference variable //Why this variable public?
	
  @Test
  @Parameters({"username","password"}) //Parameterization. these are variable name. values can be passed only through xml file
  public void Logout(String username, String password) {	//this local variable names can be different from parameter tag's variable names.  
	  
	  LoginPage loginPage=new LoginPage(driver);
	  loginPage.signIn(username, password);
	  homePage=loginPage.clickSignIn();
	 //boolean isDashboardDisplayed=loginPage.isDashBoardDisplayed();
	  assertEquals(driver.getTitle(), "Dashboard | 7rmart supermarket",Constant.ERRORMESSAGE); //getting title and comparing with given value
	  homePage.logoutAction("Logout");
	  assertEquals(driver.getTitle(), "Login | 7rmart supermarket", "User not logged out"); 
	  
	  
  }
}
