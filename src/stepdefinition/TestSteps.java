package stepdefinition;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.api.SpaceX;
import com.dataprovider.ConfigFileReader;
import com.manager.PageObjectManager;
import com.pageobject.HomePage;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class TestSteps {

	WebDriver driver;
	ConfigFileReader configFileReader;
	PageObjectManager pageObjectManager;
	HomePage homePage;
	SpaceX spaceX = new SpaceX();
	
	@Given("^user is on e gg timer site$")
	public void user_is_on_e_gg_timer_site() throws Throwable {
		  configFileReader = new ConfigFileReader();
		  System.setProperty("webdriver.chrome.driver", configFileReader.getDriverPath());
		  driver = new ChromeDriver();
		  driver.get(configFileReader.getApplicationUrl());
		  driver.manage().window().maximize();
		  pageObjectManager = new PageObjectManager(driver);
		  homePage = pageObjectManager.getHomePage();
	}

	@When("^user enters (\\d+) seconds in the timer input box$")
	public void user_enters_seconds_in_the_timer_input_box(int arg1) throws Throwable {
	    homePage.enter_Timer();
	}

	@When("^user clicks on Go button$")
	public void user_clicks_on_Go_button() throws Throwable {
	    homePage.click_Go();
	}

	@Then("^verify that the countdown begins and timer starts decrementing$")
	public void verify_that_the_countdown_begins_and_timer_starts_decrementing() throws Throwable {
	    homePage.verifyTimerText();
	}

	
	@Given("^User fetches spaceX details using API$")
	public void user_fetches_spaceX_details_using_API() throws Throwable {		
		spaceX.launchAPI();
	}
	
	@Then("^the satellte name and version should be Starlink-(\\d+) \\(v(\\d+)\\.(\\d+)\\)$")
	public void the_satellte_name_and_version_should_be_Starlink_v(int arg1, int arg2, int arg3) throws Throwable {
		spaceX.verify_Satellite_Name_Version();
	}
	
	@Then("^the satellite has successfully landed on ASDS$")
	public void the_satellite_has_successfully_landed_on_ASDS() throws Throwable {
		spaceX.verify_Satellite_Destination();
	}
	
	@Then("^the satellite has successfully landed with no failures$")
	public void the_satellite_has_successfully_landed_with_no_failures() throws Throwable {
		spaceX.verify_Satellite_Has_No_Failures();
		
	}
}
