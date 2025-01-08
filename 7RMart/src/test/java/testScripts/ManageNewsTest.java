package testScripts;

import static org.testng.Assert.assertTrue;

import java.io.IOException;

import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import constants.Constant;
import pages.AdminUsersPage;
import pages.HomePage;
import pages.LoginPage;
import pages.ManageNewsPage;
import utility.ExcelUtility;

public class ManageNewsTest extends Base {

	public HomePage homePage;
	public AdminUsersPage adminUsersPage;
	public ManageNewsPage manageNewsPage;

	@Test
    @Parameters({"ValidUsername","ValidPassword"})  
	public void enterNewsInfo(String username, String password) throws IOException {
		LoginPage loginPage = new LoginPage(driver);
		loginPage.signIn(username, password);
		homePage = loginPage.clickSignIn();
		homePage.clickManageNewsMoreInfo();
		adminUsersPage.newButtonClick();
		String newsInfo = ExcelUtility.readStringData(1, 0, "NewsInfo");
		manageNewsPage.enterNewsInfo(newsInfo);
		assertTrue(adminUsersPage.isAdminUserInfoSaveandDeleteSuccess(), Constant.MESSAGEFORFAILEDSAVEORDELETE);

	}
}
