Feature: Test Assignment UI and API


@Regression
Scenario: Verify the timer functionality
Given user is on e gg timer site 
When user enters 25 seconds in the timer input box
And user clicks on Go button
Then verify that the countdown begins and timer starts decrementing

@Regression
Scenario: Verify that the SpaceX mission has launched correct Satellite of proper version
Given User fetches spaceX details using API 
Then the satellte name and version should be Starlink-11 (v1.0)

@Regression
Scenario: Verify that the SpaceX mission has landed successfully on expected landing destination
Given User fetches spaceX details using API 
Then the satellite has successfully landed on ASDS

@Regression
Scenario: Verify that the SpaceX mission has had no failures yet
Given User fetches spaceX details using API 
Then the satellite has successfully landed with no failures





