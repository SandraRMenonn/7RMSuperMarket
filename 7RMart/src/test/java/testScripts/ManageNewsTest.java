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
	public ManageNewsPage manageNewsPage;

	@Test
	@Parameters({ "ValidUsername", "ValidPassword" })
	public void VerifyCreatingNewsInfo(String username, String password) throws IOException {
		LoginPage loginPage = new LoginPage(driver);
		loginPage.signIn(username, password);
		homePage = loginPage.clickSignIn();
		manageNewsPage = homePage.clickManageNewsMoreInfo();
		manageNewsPage.newButtonClick();
		String newsInfo = ExcelUtility.readStringData(1, 0, "NewsInfo");
		manageNewsPage.enterNewsInfo(newsInfo);
		assertTrue(manageNewsPage.isSaveandDeleteSuccess(), Constant.MESSAGEFORFAILEDSAVEORDELETE);

	}
}
