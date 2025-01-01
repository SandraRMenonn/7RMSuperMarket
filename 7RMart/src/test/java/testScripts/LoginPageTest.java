package testScripts;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.io.IOException;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import constants.Constant;
import pages.LoginPage;
import utility.ExcelUtility;

public class LoginPageTest extends Base{
	
	/****Parameterization******/
	
  @DataProvider(name="Credentials")
  public Object[][] testData() { //object is a class, testdata method name
	  
	  Object data[][]= {{"admin", "admin"},{"admin","Obsqura"},{"@#$","admin"}}; //data variable name
	  return data;
  }
	
  @Test
  public void invalidUserNameforLogin() throws IOException {
	  /*************Invalid user name**/
	  
	  LoginPage loginPage=new LoginPage(driver);
	  String username=ExcelUtility.readStringData(1, 0, "LoginPage");
	  String password=ExcelUtility.readStringData(1, 1, "LoginPage");
	 // System.out.println(username + password);
	  loginPage.signIn(username,password);
	  loginPage.clickSignIn();
	  System.out.println(loginPage.isInvalidUsernameAlertDisplayed());
	  loginPage.loginInputfieldsClear();
  }
  
  @Test
  public void invalidPasswordforLogin() throws IOException {
	  
	  /************Invalid password**/
	  LoginPage loginPage=new LoginPage(driver);
	  String username=ExcelUtility.readStringData(2, 0, "LoginPage");
	  String password=ExcelUtility.readStringData(2, 1, "LoginPage");
	  loginPage.signIn(username, password);
	  loginPage.clickSignIn();
	  System.out.println(loginPage.isInvalidUsernameAlertDisplayed());
	  loginPage.loginInputfieldsClear();
  }
	
  @Test(dataProvider="Credentials") //Parameterization
	  public void validCredentialsforLogin() throws IOException {
	  /*******Valid credentials*******/
	  LoginPage loginPage=new LoginPage(driver);
	  String validusername=ExcelUtility.readStringData(3, 0, "LoginPage");
	  String validpassword=ExcelUtility.readStringData(3, 1, "LoginPage");
	  loginPage.signIn(validusername, validpassword);
	  //loginPage.rememberMe();
	  loginPage.clickSignIn();
	  //loginPage.passwordAlert();
	  //boolean isInvalidUsernameAlertDisplayed=loginPage.isInvalidUsernameAlertDisplayed();  
	  assertEquals(driver.getTitle(),"Dashboard | 7rmart supermarket", Constant.ERRORMESSAGE);
	  
  }
}
