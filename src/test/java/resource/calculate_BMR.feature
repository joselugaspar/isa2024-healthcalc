Feature: Calculate Basal Metabolic Rate (BMR)
  As a user,
  I want to calculate the basal metabolic rate (BMR) of a person,
  So that I can understand how many calories my body needs at rest.

  Scenario: Calculate BMR for a person
    Given the user has accessed the health calculator
    When the user submits gender, age, weight and height
    Then the system calculates the BMR using the appropriate formula based on the entered data

  Scenario: Enter gender, age, weight, and height
    Given the user has entered their gender, age, weight, and height
    When the user submits negative information
    Then the system throws an error

  Scenario: Display calculated BMR
    Given the system has calculated the BMR
    When the result is displayed
    Then if the result is zero the system should raise an error
