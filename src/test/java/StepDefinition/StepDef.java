package StepDefinition;

import java.io.IOException;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import PomObject.GoogleSearchPage;
import io.cucumber.core.options.CucumberOptionsAnnotationParser.OptionsProvider;
//import Utility.ScreenshotUtility;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
//import io.opentelemetry.exporter.logging.SystemOutLogRecordExporter;


public class StepDef  {
	public static WebDriver driver;
	public  GoogleSearchPage gsp;
	public static Logger logger;

	@Before 
	public void setup() {
		System.out.println("Before method is implemented");
		
     	driver=new ChromeDriver ();
     	driver.manage().window().maximize();
		
	}
	
	@Given(	"User is on the Google homepage")
	 public void User_is_on_the_Google_homepage() {
		driver.get("https://www.google.com");
	}
	

	
	@When("User searches for {string}")
	public void user_open_the_browser_and_enters_the_url(String Search) throws InterruptedException {
		gsp=new GoogleSearchPage(driver);
		gsp.EnterTheSearch(Search);
	}
	
	@When("Search results are displayed")
	public void Search_results_are_displayed() {
		gsp.validateThesearch();
		
		
	}
	@When("User validates the number of Amazon and Flipkart links")
	public void User_validates_the_number_of_Amazon_and_Flipkart_links () {
		gsp.getthelinks();
	}
	
	
	
	
	 @When ("User clicks on {string} link")
	 public void User_clicks_on_website_link(String website) throws InterruptedException {
		 gsp.clickingonWebsite(website);
		 
	 }
	 
	 @Then( "Title is displayed")
	 public void Title_is_displayed() {
		 System.out.println("title is displayed");
	 }
	 
	 @And ("Number of results is greater than 0")
	 public void Number_of_results_is_greater_than_0() {
		 System.out.println("the greate than 0");
	 }

	@After
	public void TearDown() throws IOException, InterruptedException  {
		
	}


}
