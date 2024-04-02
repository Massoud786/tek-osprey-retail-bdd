Feature: Create New Account page
@CreateNewAccount
  Scenario: Create New Account with valid credential
    Given User clicks on Sign In button
    Given User clicks on Create Account
    When User fills form "Matty" and "Mathew1234@gmail.com" and "Matt_7866@&"
    When User clicks on Sign Up button
    When user will navigate to Account Profile page
    Then Validate "Matty" and email in account page

  # Create  map data table
  @CreateNewAccount_2
  Scenario: Create New Account with valid credential using Map Data Table
    Given User clicks on Sign In button
    Given User clicks on Create Account
    When User fills up Sign Up form
    |name   |Matty    |
    |email  |Mathew1234@gmail.com|
    |password|Matt_7866@&        |
    When User clicks on Sign Up button
    When user will navigate to Account Profile page
    Then Validate "Matty" and email in account page

    #Create List Data Table
  @CreateNewAccount_3
  Scenario: Create New Account with valid credential using Map Data Table
    Given User clicks on Sign In button
    Given User clicks on Create Account
    When User fills up Sign Up form with List Data Table
       |Matty    |
      |Mathew1234@gmail.com|
      |Matt_7866@&        |
    When User clicks on Sign Up button
    When user will navigate to Account Profile page
    Then Validate "Matty" and email in account page

    #Create List of Maps
  @CreateNewAccount_4
  Scenario: Create New Account with valid credential using List of Maps
    Given User clicks on Sign In button
    Given User clicks on Create Account
    When User fills up Sign Up form with List Map Data Table
      |name |email  |password |
      |John |John@gmail.com   |123456Ab@|
    When User clicks on Sign Up button
    When user will navigate to Account Profile page
    Then Validate "John" and email in account page

    #Create List of List
  # We do not have the keys. We only have the values.
  @CreateNewAccount_5
  Scenario: Create New Account with valid credential using List of List
    Given User clicks on Sign In button
    Given User clicks on Create Account
    When User fills up Sign Up form with List of List Data Table
      |John |John@gmail.com   |123456Ab@|
    When User clicks on Sign Up button
    When user will navigate to Account Profile page
    Then Validate "John" and email in account page
