package testScripts;

import static org.testng.Assert.assertEquals;

import java.io.IOException;

import org.testng.annotations.Test;

import constants.Constant;
import pages.AdminUsersPage;
import pages.HomePage;
import pages.LoginPage;
import utility.ExcelUtility;
import testScripts.Base;

public class AdminUsersPageTest extends Base {
	
	public HomePage homePage;
//	public LoginPage loginPage;
	
  @Test
  public void newAdminUserCreation() throws IOException {
	  LoginPage loginPage=new LoginPage(driver);
	  String adminUsername=ExcelUtility.readStringData(1, 0, "AdminUserPage");
	  String adminpassword=ExcelUtility.readStringData(1, 1, "AdminUserPage");
	  String validusername=ExcelUtility.readStringData(3, 0, "LoginPage");
	  String validpassword=ExcelUtility.readStringData(3, 1, "LoginPage");
	  AdminUsersPage adminUserPage=new AdminUsersPage(driver);
	  loginPage.signIn(validusername, validpassword);
	  homePage=loginPage.clickSignIn();
	  assertEquals(driver.getTitle(),"Dashboard | 7rmart supermarket", Constant.ERRORMESSAGE);
	  homePage.clickAdminUserMoreInfo();
	  assertEquals(driver.getTitle(),"Admin Users | 7rmart supermarket", "Admin Users Page is not displayed");
	  adminUserPage.newButtonClick();
	  adminUserPage.inputAdminUsernameandPassword(adminUsername, adminpassword);
	  adminUserPage.selectAdminUserType("Admin");
	  adminUserPage.clickSaveAdminUserInfo();
	  System.out.println(adminUserPage.isAdminUserInfoSaveandDeleteSuccess());
	    
  }
  
  @Test
  public void adminUserSearch() throws IOException {
	  LoginPage loginPage=new LoginPage(driver);
	  String adminUsername=ExcelUtility.readStringData(1, 0, "AdminUserPage");
	  String adminUserPassword=ExcelUtility.readStringData(1, 1, "AdminUserPage");
	  loginPage.signIn(adminUsername, adminUsername);
	  homePage=loginPage.clickSignIn();
	  assertEquals(driver.getTitle(),"Dashboard | 7rmart supermarket", Constant.ERRORMESSAGE);
	  homePage.clickAdminUserMoreInfo();
	  assertEquals(driver.getTitle(),"Admin Users | 7rmart supermarket", Constant.ADMINUSERPAGENOTDISPLAYEDMESSAGE);
	  AdminUsersPage adminUserPage=new AdminUsersPage(driver);
	  adminUserPage.searchAdminUser();
	  adminUserPage.inputAdminSearchUserName_UserType("Sandra","Admin");
  }
  
  
  @Test
  public void deleteAdminUser() {
		AdminUsersPage adminUserPage=new AdminUsersPage(driver);
		adminUserPage.deleteAdminUser();
		System.out.println(adminUserPage.isAdminUserInfoSaveandDeleteSuccess());
	  }
}
