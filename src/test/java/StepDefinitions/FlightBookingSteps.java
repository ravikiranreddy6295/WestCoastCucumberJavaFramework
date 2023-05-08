package StepDefinitions;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import PageClass.FlightsPage;
import PageClass.HomePage;
import PageClass.YourFlightToNewYorkPage;
import PropertiesFile.ReadConfigFile;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;

public class FlightBookingSteps {
	
	WebDriver driver;
	
	@Before
	public void browserSetup() {
		WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}
	
	@After
	public void teardown() {
		driver.quit();
	}

	@Given("User is on the Booking.com home page")
	public void user_is_on_the_booking_com_home_page() {	
		ReadConfigFile configFile=new ReadConfigFile();
		driver.get(configFile.getURl());
        //driver.get("https://flights.booking.com/");	    
	}
	

	@When("User selects round trip from London to Newyork")
	public void user_selects_round_trip_from_london_to_newyork() {
		HomePage home=new HomePage(driver);
        //selecting London as source
    	home.source();
    	//Selecting New york as destination
    	home.destination();   
	}

	@And("User selects start date and return date")
	public void user_selects_start_date_and_return_date() {
		HomePage home=new HomePage(driver);
		//Selecting Start date and end date
    	home.startEndDate();
    	//search
    	home.search();
	}


	@And("User search for flights and select the fastest flight")
	public void user_search_for_flights_and_select_the_fastest_flight() {
		FlightsPage flight=new FlightsPage(driver);
    	//select fastest
    	flight.fastest();
    	//select see flight button
    	flight.seeFlight();
	}
	

	@Then("Check start date, return date, Flight time, Price")
	public void check_start_date_return_date_flight_time_price() {
		YourFlightToNewYorkPage yourFlight=new YourFlightToNewYorkPage(driver);
    	//verify start date
    	yourFlight.verifyStartDate();
    	//verify return date
    	yourFlight.verifyReturnDate();
    	//verify flight time
    	yourFlight.verifyFlightTime();
    	//verify flight price
    	yourFlight.verifyPrice();
	}

	@And("user click on select")
	public void user_click_on_select() {
		YourFlightToNewYorkPage yourFlight=new YourFlightToNewYorkPage(driver);
		//select
	    yourFlight.select();

	}

	@Then("Check that “price” in the “London to New York” page is correct")
	public void check_that_price_in_the_london_to_new_york_page_is_correct() {
		YourFlightToNewYorkPage yourFlight=new YourFlightToNewYorkPage(driver);
		//verify price in London to newyork page
    	yourFlight.verifyPriceLondonToNewyork();
	}

}
