package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginHrmsPage {
	
private WebDriver driver;
	
	private By usernameLocator = By.name("username");
	private By passwordLocator = By.name("password");
	private By loginButtonLocator=By.xpath("//div[@class='oxd-form-actions orangehrm-login-action']/button");
	private By forgotPwdLinkLocator=By.xpath("//div[@class='orangehrm-login-forgot']/p");
	private By accountNameLocator = By.xpath("//p[@class='oxd-userdropdown-name']");
	private By dashBoardLocator = By.xpath("//span[@class='oxd-topbar-header-breadcrumb']");
	private By userNameReqEMLocator = By.xpath("//input[@name='username']/parent::div/following-sibling::span");
	private By passwordReqEMLocator = By.xpath("//input[@name='password']/parent::div/following-sibling::span");
	
	public LoginHrmsPage(WebDriver driver) {
		this.driver =driver;
	}
	
	
	public void enterUsername(String username) {
		WebElement usernameField = driver.findElement(usernameLocator);
		usernameField.sendKeys(username);
	}
	
	
	public void enterPassword(String password) {
		WebElement passwordField = driver.findElement(passwordLocator);
		passwordField.sendKeys(password);
	}
	
	public void clickLoginButton() {
		WebElement loginButton = driver.findElement(loginButtonLocator);
		loginButton.click();
	}
	
	public void clickOnForgotLink() {
		WebElement forgotPwdLink = driver.findElement(forgotPwdLinkLocator);
		forgotPwdLink.click();
	}
	
	public boolean verifyForgotPwdLinkDisplayed() {
		return driver.findElement(forgotPwdLinkLocator).isDisplayed();
	}
	
	public boolean verifyLoginButtonEnabled() {
		return driver.findElement(loginButtonLocator).isEnabled();
	}
	
	public void login(String username,String password) {
		enterUsername(username);
		enterPassword(password);
		clickLoginButton();
	}
	
	public String getforgotPwdPageUrl() {
		String forgetPwdPageUrl = driver.getCurrentUrl();
		return forgetPwdPageUrl;
	}
	
	public String getAccountName() {
		WebElement accountName= driver.findElement(accountNameLocator);
		return accountName.getText();
	}

	public boolean isDashBoardDisplayed() {
		WebElement dashBoardDisplayed = driver.findElement(dashBoardLocator);
		return dashBoardDisplayed.isDisplayed();
		
	}
	
	public String getUserNameReqEMLocator() {
		WebElement userNameReqErrorMessage = driver.findElement(userNameReqEMLocator);
		return userNameReqErrorMessage.getText();
	}
	
	
	public String getPasswordReqEMLocator() {
		WebElement passwordReqErrorMessage = driver.findElement(passwordReqEMLocator);
		return passwordReqErrorMessage.getText();
	}


}
