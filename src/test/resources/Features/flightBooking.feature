Feature: Booking the flight ticket from London to Newyork

	@smoketest
  Scenario: Flight Booking
    Given User is on the Booking.com home page
    When User selects round trip from London to Newyork
    And User selects start date and return date
    And User search for flights and select the fastest flight 
    Then Check start date, return date, Flight time, Price
    And user click on select 
    Then Check that “price” in the “London to New York” page is correct



