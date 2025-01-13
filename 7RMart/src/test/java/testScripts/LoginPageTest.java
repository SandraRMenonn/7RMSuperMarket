package testScripts;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.io.IOException;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import constants.Constant;
import pages.HomePage;
import pages.LoginPage;
import utility.ExcelUtility;

public class LoginPageTest extends Base {

	public HomePage homePage;

	/**** Parameterization ******/
	@DataProvider(name = "Credentials")
	public Object[][] testData() { // object is a class, testdata method name
		Object data[][] = { { "admin", "admin" }, { "@#$", "admin" }, { "admin", "Ob@#$" } }; // data variable name
		return data;
	}

	// DataProvider Parameterization. DataProvider helps to check multiple tests
	// with same TC with different Test data. For invalid test data TC, it will show
	// as failed
	@Test(dataProvider = "Credentials", retryAnalyzer = retry.Retry.class)
	public void verifyLoginWithValidCredentials(String username, String password) throws IOException {
		LoginPage loginPage = new LoginPage(driver);
		loginPage.signIn(username, password);
		// loginPage.rememberMe();
		homePage = loginPage.clickSignIn();
		// loginPage.passwordAlert();
		assertEquals(driver.getTitle(), "Dashboard | 7rmart supermarket", Constant.ERRORMESSAGE);
	}

	@Test(groups = { "Regression" })
	public void verifyLoginWithInvalidUserName() throws IOException {
		LoginPage loginPage = new LoginPage(driver);
		String username = ExcelUtility.readStringData(1, 0, "LoginPage");
		String password = ExcelUtility.readStringData(1, 1, "LoginPage");
		// System.out.println(username + password);
		loginPage.signIn(username, password);
		homePage = loginPage.clickSignIn();
		assertTrue(loginPage.isInvalidUsernameAlertDisplayed(), Constant.INVALIDUSERNAMEMESSAGE);
		loginPage.loginInputfieldsClear();
	}

	@Test(groups = { "Regression" })
	public void verifyLoginWithInvalidPassword() throws IOException {
		LoginPage loginPage = new LoginPage(driver);
		String username = ExcelUtility.readStringData(2, 0, "LoginPage");
		String password = ExcelUtility.readStringData(2, 1, "LoginPage");
		loginPage.signIn(username, password);
		homePage = loginPage.clickSignIn();
		assertTrue(loginPage.isInvalidUsernameAlertDisplayed(), Constant.INVALIDPASSWORDMESSAGE);
		loginPage.loginInputfieldsClear();
	}

}
