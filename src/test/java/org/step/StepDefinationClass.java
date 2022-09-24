package org.step;

import org.base.BaseClass;
import org.openqa.selenium.Alert;
import org.pojo.Pojo;

//import com.aventstack.extentreports.ExtentReports;
//import com.aventstack.extentreports.ExtentTest;

import cucumber.api.DataTable;
import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class StepDefinationClass extends BaseClass {
	
	
	@Given("^user has to launch the chrome browser and pass the url$")
	public void user_has_to_launch_the_chrome_browser_and_pass_the_url() throws Throwable {
		
		
		launchBrowser();
		maxBrowser();
	passUrl("https://en-gb.facebook.com/");
		
	}

	@When("^user has to enter the values in \"([^\"]*)\" and \"([^\"]*)\" field$")
	public void user_has_to_enter_the_values_in_and_field(String user, String pass) throws Throwable {
		
		Pojo p=new Pojo();
		
		toInput(p.getTxtBox(), user);
		toInput(p.getTxtPass(), pass);
	
	
	}

	@When("^user has to click the login button$")
	public void user_has_to_click_the_login_button() throws Throwable {
		
		Pojo p=new Pojo();
		
		btnClick(p.getPressBtn());
		
		Thread.sleep(3000);


	}

	@Then("^user has to navigate the error page$")
	public void user_has_to_navigate_the_error_page() throws Throwable {
		
		Thread.sleep(3000);
		closebrowser();
		
	}
}
