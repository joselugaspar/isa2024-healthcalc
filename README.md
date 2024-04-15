# Práctica 3
## Introducción
En esta práctica se nos introduce el empleo de cucumber para realización de features en nuestro proyecto, se nos encomienda realizar dos user stories relacionadas con este repositorio.


![cucumber](https://github.com/joselugaspar/isa2024-healthcalc/assets/131762623/4d4849e3-9945-4ae6-bb36-fbb96cd936d6)

## Adición de dos user stories
Una vez más, este contenido podemos encontrarlo en un txt dentro de la carpeta doc.

**Calculate_ideal_weight.feature:**

"As a user,

I want to calculate the ideal weight for a person,

So that I can have a target weight to achieve for better health."

Acceptance criteria:

·Scenario 1: Calculate ideal weight for a person with valid inputs

	Given the user has accessed the health calculator
   	When the user puts his gender and height 
    	Then the system calculates the ideal weight based on the entered data
 
·Scenario 2: Displayed wrong inputs

	Given the user has accessed the health calculator
    	When the inputs are negative
    	Then the system throws an error
 
·Scenario 3: Display calculated ideal weight

	Given the user has accessed the health calculator
    	When the user puts his gender and height 
    	Then the ideal weight is zero and the system should rise an error
 
**Calculate_BMR.feature:**

"As a user,

I want to calculate the basal metabolic rate (BMR) of a person,
  
So that I can understand how many calories my body needs at rest."

Acceptance criteria:

·Scenario 1: Calculate BMR for a person

	Given the user has accessed the health calculator
    	When the user submits gender, age, weight and height
    	Then the system calculates the BMR using the appropriate formula based on the entered data
     
·Scenario 2: Enter gender, age, weight, and height

	Given the user has entered their gender, age, weight, and height
    	When the user submits negative information
    	Then the system throws an error
     
·Scenario 3: Display calculated BMR

	Given the system has calculated the BMR
    	When the result is displayed
    	Then if the result is zero the system should raise an error
