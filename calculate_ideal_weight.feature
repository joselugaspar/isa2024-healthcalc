Feature: Calculate Ideal Weight
  As a user,
  I want to calculate the ideal weight for a person,
  So that I can have a target weight to achieve for better health.

  Scenario: Calculate ideal weight for a person
    Given the user has accessed the health calculator
    When the user selects the option to calculate ideal weight
    Then the system prompts the user to enter their height in meters and their gender

  Scenario: Enter height and gender
    Given the user has entered their height and gender
    When the user submits the information
    Then the system calculates the ideal weight based on the entered data

  Scenario: Display calculated ideal weight
    Given the system has calculated the ideal weight
    When the result is displayed
    Then the user can see the ideal weight value for their specified height and gender
