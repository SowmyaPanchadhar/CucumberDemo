package stepdef;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class SearchSteps {
	
	
	
	@Given("I have a search box in amazon page")
	public void i_have_a_search_box_in_amazon_page() {
	    // Write code here that turns the phrase above into concrete actions
System.out.println("I am on search box page");	
}

	@When("I search for baby boy clothing")
	public void i_search_for_baby_boy_clothing() {
System.out.println("I am searching for baby boy clothing");	
}

	@Then("dresses for baby boy should be displayed")
	public void dresses_for_baby_boy_should_be_displayed() {

	System.out.println("Dresses for baby boy are displayed");
	}

	

}
