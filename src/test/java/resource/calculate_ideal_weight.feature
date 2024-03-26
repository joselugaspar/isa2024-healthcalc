Feature: Calculate Ideal Weight
  "As a user,
  I want to calculate the ideal weight for a person,
  So that I can have a target weight to achieve for better health."

  Scenario: Calculate ideal weight for a person with valid inputs
    Given the user has accessed the health calculator
    When the user puts his gender and height 
    Then the system calculates the ideal weight based on the entered data

  Scenario: Displayed wrong inputs
    Given the user has accessed the health calculator
    When the inputs are negative
    Then the system throws an error

  Scenario: Display calculated ideal weight
    Given the user has accessed the health calculator
    When the user puts his gender and height 
    Then the ideal weight is zero and the system should rise an error
