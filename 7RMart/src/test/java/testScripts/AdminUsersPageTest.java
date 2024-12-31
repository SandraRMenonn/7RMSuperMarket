package testScripts;

import static org.testng.Assert.assertEquals;

import java.io.IOException;

import org.testng.annotations.Test;

import constants.Constant;
import pages.AdminUsersPage;
import pages.HomePage;
import pages.LoginPage;
import utility.ExcelUtility;

public class AdminUsersPageTest extends Base {
	
	public HomePage homePage;
//	public LoginPage loginPage;
	
  @Test
  public void newAdminUserCreation() throws IOException {
	  LoginPage loginPage=new LoginPage(driver);
	  String adminUsername=ExcelUtility.readStringData(1, 0, "AdminUserPage");
	  String adminpassword=ExcelUtility.readStringData(1, 1, "AdminUserPage");
	  AdminUsersPage adminUserPage=new AdminUsersPage(driver);
	  loginPage.signIn("admin", "admin");
	  homePage=loginPage.clickSignIn();
	  assertEquals(driver.getTitle(),"Dashboard | 7rmart supermarket", Constant.ERRORMESSAGE);
	  homePage.clickAdminUserMoreInfo();
	  assertEquals(driver.getTitle(),"Admin Users | 7rmart supermarket", "Admin Users Page is not displayed");
	  adminUserPage.newButtonClick();
	  adminUserPage.inputAdminUsernameandPassword(adminUsername, adminpassword);
	  adminUserPage.selectAdminUserType("Admin");
	  adminUserPage.clickSaveAdminUserInfo();
	  System.out.println(adminUserPage.isAdminUserInfoSaveandDeleteSuccess());
	  adminUserPage.deleteAdminUser();
	  System.out.println(adminUserPage.isAdminUserInfoSaveandDeleteSuccess());
	  
	  
	  
  }
}
