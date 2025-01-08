package testScripts;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.io.IOException;
import java.lang.invoke.ConstantBootstraps;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import constants.Constant;
import pages.AdminUsersPage;
import pages.CategoryPage;
import pages.HomePage;
import pages.LoginPage;
import utility.ExcelUtility;

public class CategoryTest extends Base {

	public HomePage homePage;
	public AdminUsersPage adminUsersPage;
	public CategoryPage categoryPage;

	@Test(priority = 1)
	@Parameters({"ValidUsername","ValidPassword"})
	public void verifyCreateNewCategory(String username, String password) throws IOException {
		LoginPage loginPage = new LoginPage(driver);
		loginPage.signIn(username, password);
		loginPage.clickSignIn();
		homePage.clickCategoryMoreInfo();
		adminUsersPage.newButtonClick();
		String categoryName = ExcelUtility.readStringData(1, 0, "CategoryInfo");
		String categoryFilePath = ExcelUtility.readStringData(1, 1, "CategoryInfo");
		categoryPage.addNewCategory(categoryName, categoryFilePath);
		assertTrue(adminUsersPage.isAdminUserInfoSaveandDeleteSuccess(), Constant.MESSAGEFORFAILEDSAVEORDELETE);
	}

	@Test(priority = 2)
	@Parameters({"ValidUsername", "ValidPassword"})
	public void verifyCategorySearch(String username, String password) throws IOException {
		LoginPage loginPage = new LoginPage(driver);
		loginPage.signIn(username, password);
		loginPage.clickSignIn();
		homePage.clickCategoryMoreInfo();
		adminUsersPage.searchAdminUser();
		String categoryName = ExcelUtility.readStringData(1, 0, "CategoryInfo");
		categoryPage.categorySearch(categoryName);
		System.out.println(categoryPage.searchResultGetText(categoryName) + " and " + categoryName);
		assertEquals(categoryPage.searchResultGetText(categoryName), categoryName);
	}

	@Test(priority = 3)
	@Parameters({"ValidUsername", "ValidPassword"})
	public void verifyDeleteCategoryfromSearchResult(String username, String password) throws IOException {
		LoginPage loginPage = new LoginPage(driver);
		loginPage.signIn(username, password);
		loginPage.clickSignIn();
		homePage.clickCategoryMoreInfo();
		adminUsersPage.searchAdminUser();
		String categoryName = ExcelUtility.readStringData(1, 0, "CategoryInfo");
		categoryPage.categorySearch(categoryName);
		categoryPage.deleteFromCategorySearchResult();
		assertTrue(adminUsersPage.isAdminUserInfoSaveandDeleteSuccess(), Constant.MESSAGEFORFAILEDSAVEORDELETE);

	}

}
