package testScripts;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.io.IOException;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import constants.Constant;
import pages.AdminUsersPage;
import pages.HomePage;
import pages.LoginPage;
import utility.ExcelUtility;
import utility.FakerUtility;
import utility.PageUtility;
import testScripts.Base;

public class AdminUsersPageTest extends Base {

	public HomePage homePage;
	public AdminUsersPage adminUsersPage;
	FakerUtility faker=new FakerUtility();

	@Test
	@Parameters({ "ValidUsername", "ValidPassword" })
	public void verifyAddNewAdminUser(String username, String password) throws IOException {
		LoginPage loginPage = new LoginPage(driver);
		loginPage.signIn(username, password);
		homePage = loginPage.clickSignIn();
		adminUsersPage=homePage.clickAdminUserMoreInfo();
		adminUsersPage.newButtonClick();
		//String adminUsername=faker.getFakeFirstName(); // To Generate Random user names use this instead of excelread
		String adminUsername = ExcelUtility.readStringData(1, 0, "AdminUserPage");
		String adminpassword = ExcelUtility.readStringData(1, 1, "AdminUserPage");
		String adminUserType = ExcelUtility.readStringData(1, 2, "AdminUserPage");
		adminUsersPage.inputAdminUsernameandPassword(adminUsername, adminpassword);
		adminUsersPage.selectAdminUserType(adminUserType);
		adminUsersPage.clickSaveAdminUserInfo();
		assertTrue(adminUsersPage.isSaveandDeleteSuccess(),Constant.MESSAGEFORFAILEDSAVEORDELETE);
		

	}

	@Test
	@Parameters({ "ValidUsername", "ValidPassword" })
	public void verifyAdminUserSearch(String username, String password) throws IOException {
		LoginPage loginPage = new LoginPage(driver);
		loginPage.signIn(username, password);
		homePage = loginPage.clickSignIn();
		adminUsersPage=homePage.clickAdminUserMoreInfo();
		String adminUsername = ExcelUtility.readStringData(1, 0, "AdminUserPage");
		String adminUserType = ExcelUtility.readStringData(1, 2, "AdminUserPage");
		assertTrue(adminUsersPage.searchAdminUser(adminUsername, adminUserType));
	}

	@Test
	@Parameters({ "ValidUsername", "ValidPassword" })
	public void verifyToDeleteAdminUser(String username, String password) {
		LoginPage loginPage = new LoginPage(driver);
		loginPage.signIn(username, password);
		homePage = loginPage.clickSignIn();
		adminUsersPage=homePage.clickAdminUserMoreInfo();
		adminUsersPage.deleteAdminUser();
		assertTrue(adminUsersPage.isSaveandDeleteSuccess(), Constant.MESSAGEFORFAILEDSAVEORDELETE);
	}
}
