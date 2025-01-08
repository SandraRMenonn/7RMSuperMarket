package testScripts;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.io.IOException;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import constants.Constant;
import pages.LoginPage;
import utility.ExcelUtility;

public class LoginPageTest extends Base {

	/**** Parameterization ******/
	@DataProvider(name = "Credentials")
	public Object[][] testData() { // object is a class, testdata method name
		Object data[][] = { { "admin", "admin" }, { "admin", "Obsqura" }, { "@#$", "admin" } }; // data variable name
		return data;
	}

	@Test(dataProvider = "Credentials") //DataProvider Parameterization. DataProvider helps to check multiple tests with same TC
										// with different Test data. For invalid test data TC, it will show as failed
	public void verifyValidCredentialsforLogin(String username, String password) throws IOException {
		LoginPage loginPage = new LoginPage(driver);
		loginPage.signIn(username, password);
		// loginPage.rememberMe();
		loginPage.clickSignIn();
		// loginPage.passwordAlert();
		// boolean isInvalidUsernameAlertDisplayed=loginPage.isInvalidUsernameAlertDisplayed();
		assertEquals(driver.getTitle(), "Dashboard | 7rmart supermarket", Constant.ERRORMESSAGE);

	}

	@Test
	public void verifyInvalidUserNameforLogin() throws IOException {
		LoginPage loginPage = new LoginPage(driver);
		String username = ExcelUtility.readStringData(1, 0, "LoginPage");
		String password = ExcelUtility.readStringData(1, 1, "LoginPage");
		// System.out.println(username + password);
		loginPage.signIn(username, password);
		loginPage.clickSignIn();
		assertTrue(loginPage.isInvalidUsernameAlertDisplayed(), Constant.INVALIDUSERNAMEMESSAGE);
		loginPage.loginInputfieldsClear();
	}

	@Test
	public void verifyInvalidPasswordforLogin() throws IOException {
		LoginPage loginPage = new LoginPage(driver);
		String username = ExcelUtility.readStringData(2, 0, "LoginPage");
		String password = ExcelUtility.readStringData(2, 1, "LoginPage");
		loginPage.signIn(username, password);
		loginPage.clickSignIn();
		assertTrue(loginPage.isInvalidUsernameAlertDisplayed(), Constant.INVALIDPASSWORDMESSAGE);
		loginPage.loginInputfieldsClear();
	}

}
