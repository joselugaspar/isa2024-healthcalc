package healthcalc.Steps;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Assertions;

import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import healthcalc.HealthCalcImpl;

public class BMR_steps {
    private HealthCalcImpl healthCalc;
    private float calculatedBMR;
    private boolean error;
    private String exceptionMessage;

    @Before
    public void initialization() {
        this.healthCalc = new HealthCalcImpl();
        this.calculatedBMR = .0f;
        this.error = false;
        this.exceptionMessage = "";
    }

    @Given("the user has accessed the health calculator")
    public void the_user_has_accessed_the_health_calculator() {
        // Health calculator accessed in @Before method
    }

    @When("the user submits gender, age, weight and height")
    public void the_user_submits_gender_age_weight_and_height() {
        try {
            this.calculatedBMR = healthCalc.basalMetabolicRate(70, 170, 'm', 30); // Example values
        } catch (Exception e) {
            this.exceptionMessage = e.getMessage().toLowerCase();
        }
    }

    @Then("the system calculates the BMR using the appropriate formula based on the entered data")
    public void the_system_calculates_the_BMR_using_the_appropriate_formula_based_on_the_entered_data() {
        // Assuming BMR calculation is successful
        assertTrue(this.calculatedBMR > 0);
    }

    @Given("the user has entered their gender, age, weight, and height")
    public void the_user_has_entered_their_gender_age_weight_and_height() {
        // Assuming the user has already entered their information
    }

    @When("the user submits negative information")
    public void the_user_submits_negative_information() {
        try {
            // Assuming negative inputs will raise an error
            this.calculatedBMR = healthCalc.basalMetabolicRate(-70, -170, 'm', -30);
        } catch (Exception e) {
            this.exceptionMessage = e.getMessage().toLowerCase();
        }
    }

    @Then("the system throws an error")
    public void the_system_throws_an_error() {
        // Assuming negative inputs will raise an error
        assertTrue(this.exceptionMessage.contains("debe ser un valor positivo"));
    }

    @Given("the system has calculated the BMR")
    public void the_system_has_calculated_the_BMR() {
        // Assuming the system has already calculated the BMR
    }

    @When("the result is displayed")
    public void the_result_is_displayed() {
        // Assuming the result is displayed
    }

    @Then("if the result is zero the system should raise an error")
    public void if_the_result_is_zero_the_system_should_raise_an_error() {
        // Assuming if BMR result is zero, it will raise an error
        assertTrue(this.exceptionMessage.contains("es cero o menor que cero"));
    }
}

