@Smoke  # we can have multiple tag in one feature file
Feature: Major Functionalities for Smoke Test
  @Story_1
  Scenario: Validate home page title
    Then Validate top left corner is "TEKSCHOOL"

    @Story_2
    Scenario: Validate Home Page title and Sign in button
      Then Validate top left corner is "TEKSCHOOL"
      Then Validate Sign In Button is Enabled