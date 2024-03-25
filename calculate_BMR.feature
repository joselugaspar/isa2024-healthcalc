Feature: Calculate Basal Metabolic Rate (BMR)
  As a user,
  I want to calculate the basal metabolic rate (BMR) of a person,
  So that I can understand how many calories my body needs at rest.

  Scenario: Calculate BMR for a person
    Given the user has accessed the health calculator
    When the user selects the option to calculate BMR
    Then the system prompts the user to enter their gender, age, weight in kilograms, and height in centimeters

  Scenario: Enter gender, age, weight, and height
    Given the user has entered their gender, age, weight, and height
    When the user submits the information
    Then the system calculates the BMR using the appropriate formula based on the entered data

  Scenario: Display calculated BMR
    Given the system has calculated the BMR
    When the result is displayed
    Then the user can see the calculated BMR value, indicating the number of calories their body needs at rest
