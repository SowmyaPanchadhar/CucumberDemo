package stepdef;

import java.time.Duration;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.BeforeStep;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.LoginHrmsPage;

public class LoginHrmsStepDef {

	private WebDriver driver;
	private LoginHrmsPage loginPage;

	@Before
	public void setup() {
		driver = new ChromeDriver();
	}

	@BeforeStep
	@AfterStep
	public void waitTime() {
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));

	}

	@After
	public void tearDown(Scenario scenario) {

		if (scenario.isFailed()) {
			final byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
			scenario.attach(screenshot, "image/png", scenario.getName());
		}
		if (driver != null) {
			driver.quit();
		}
	}

	@Given("I am on HRMS login page")
	public void i_am_on_hrms_login_page() {
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		loginPage = new LoginHrmsPage(driver);
	}

	@Given("I have entered valid {string} and {string}")
	public void i_have_entered_valid_username_and_password(String username,String password) {
		loginPage.enterUsername(username);
		loginPage.enterPassword(password);
	}

	@When("I click on login")
	public void i_click_on_login() {
		loginPage.clickLoginButton();

	}

	@Then("I should be logged in succesfully")
	public void i_should_be_logged_in_succesfully() {
		String accountName = loginPage.getAccountName();
		Assert.assertNotNull(accountName);
	}

	@Then("I should be redirected to homepage")
	public void i_should_be_redirected_to_homepage() {
		boolean isDashBoardDisplayed = loginPage.isDashBoardDisplayed();
		Assert.assertEquals(isDashBoardDisplayed, true);
	}

	/*
	 * @Given("^I have entered invalid  admin or invalidpassword$") public void
	 * i_have_entered_invalid_admin_or_invalidpassword(DataTable testData) {
	 * Map<String, String> data = testData.asMap(String.class, String.class);
	 * 
	 * loginPage.enterUsername(data.get("username"));
	 * loginPage.enterPassword(data.get("password")); }
	 */
	@When("I click on login button")
	public void i_click_on_login_button() {
		loginPage.clickLoginButton();

	}

	@Then("I should see an error message Invalid credentails")
	public void i_should_see_an_error_message_invalid_credentials() {
		System.out.println("Entered invalid ");
	}

	@Given("I have entered invalid  {string} or {string}")
	public void i_have_entered_invalid_or(String invalidUsername, String invalidPassword) {
		loginPage.enterUsername(invalidUsername);
		loginPage.enterPassword(invalidPassword);
	}

	@Then("I should see an error message {string}")
	public void i_should_see_an_error_message(String error_message) {
		System.out.println("I am printing" + error_message);
	}

	@When("I click on forgot passowrd link")
	public void i_click_on_forgot_passowrd_link() {
		loginPage.clickOnForgotLink();
	}

	@Then("I should be navigated to forgot password page to reset credentails")
	public void i_should_be_navigated_to_forgot_password_page_to_reset_credentails() {
		System.out.println(loginPage.getforgotPwdPageUrl());

	}

	
	@Given("I have entered valid following details")
	public void i_have_entered_valid_following_details(DataTable dataTable) {
	
		List<List<String>> usList= dataTable.asLists(String.class);
		for(List<String> e : usList) {
		System.out.println(e);
			}
	
		List<Map<String,String>> unMap = dataTable.asMaps(String.class,String.class);
			System.out.println(unMap.get(0).get("username"));
			
	}
	
	
}
