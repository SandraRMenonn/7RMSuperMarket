package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

	public WebDriver driver;

	public LoginPage(WebDriver driver) { // This constructor is created to create instance of the page
		this.driver = driver;
		PageFactory.initElements(driver, this); // PageFactory enables to use FindBy tags
	}

	@FindBy(xpath = "//input[@name='username']")
	WebElement usernamefield;
	@FindBy(xpath = "//input[@name='password']")
	WebElement passwordfield;
	@FindBy(xpath = "//input[@id='remember']")
	WebElement rememberMe;
	@FindBy(xpath = "//button[text()='Sign In']")
	WebElement signInbutton;
	@FindBy(xpath = "//title[text()='Dashboard | 7rmart supermarket']")
	WebElement dashboard;
	@FindBy(xpath = "//div[@class='alert alert-danger alert-dismissible']")
	WebElement invalidUsernameAlert;

	public LoginPage signIn(String userName, String password) {

		usernamefield.sendKeys(userName);
		passwordfield.sendKeys(password);
		return this; // this since we are returning in this page itself
	}

	public LoginPage rememberMe() {
		rememberMe.click();
		return this;
	}

	public HomePage clickSignIn() {
		/*
		 * This is chaining of pages. We can use chaining for those scenarios where
		 * which we land in a different page after doing an action. To chain we have do
		 * the return in the required landing page
		 */
		signInbutton.click();
		return new HomePage(driver); // new since we are returning in different page
	}

	public LoginPage loginInputfieldsClear() {
		usernamefield.clear();
		passwordfield.clear();
		return this;
	}

	/*
	 * public boolean isDashBoardDisplayed() { //For assertion return
	 * dashboard.isDisplayed(); }
	 */

	public boolean isInvalidUsernameAlertDisplayed() {
		System.out.println(invalidUsernameAlert.isDisplayed());
		return invalidUsernameAlert.isDisplayed();
	}

}
