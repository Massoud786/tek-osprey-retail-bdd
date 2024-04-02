@Regression #tagname
Feature: Retail app security test

  # If you have a step at the beginning of the Scenario that is repeating
  #at the beginning based on Cucumber feature, you can put it in the background
  #It will avoid repetition
  #Background will get execute first before each Scenario
  # Hook runs before the background
  Background: Description about the background
    Given User click on Sign In button
    @Security_Positive
  Scenario Outline: Validate user credential
    When User enters "<username>" and "<password>" and click on login
    Then User will see Account button on home page.

    Examples:
    |username| |password|
    |Lolo123@gmail.com| | Lolo_7866@& |
    |Maisam_765@gmail.com | |Gh_7866@&|

# if you have same exact steps, you can use outline.
  @Security_Negative
    Scenario Outline: Validate Sign In with Invalid Credentials
      When User enters "<username>" and "<password>" and click on login
      Then Validate error message "<errorMessage>"

      Examples:
      |username         |   |password     |    |errorMessage              |
      |Wrong@gmail.com  |   |12345678Ab@  |    |wrong username or password|
      |Lolo123@gmail.com |  |1234Abc@n_   |     |wrong username or password|




