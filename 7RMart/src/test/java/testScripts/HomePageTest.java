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

	public HomePage homePage; 

	@Test
	@Parameters({ "ValidUsername", "ValidPassword" }) // Parameterization. these are variable name. values can be passed only through xml file
	public void verifyUserisAbleToLogout(String username, String password) { // tag's variable names. Value from 21st to here.
		LoginPage loginPage = new LoginPage(driver);
		loginPage.signIn(username, password); // Value from 22nd
		homePage = loginPage.clickSignIn();
		assertEquals(driver.getTitle(), "Dashboard | 7rmart supermarket", Constant.ERRORMESSAGE); // getting title and comparing with given value 
		homePage.logoutAction("Logout");
		assertEquals(driver.getTitle(), "Login | 7rmart supermarket", Constant.NOTLOGGEDOUTERRORMESSAGE);

	}
}
