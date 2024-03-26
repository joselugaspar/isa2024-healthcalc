package healthcalc.Steps;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Assertions;

import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import healthcalc.HealthCalcImpl;

public class ideal_weight_steps {
    private int height;
    private char gender;
    private float calculatedIdealWeight;
    private HealthCalcImpl healthcalc; 
    private boolean error;
    private String exceptionMessage;

    @Before
    public void initialization() {
        this.height = 0;
        this.gender = ' ';
        this.calculatedIdealWeight = 0;
        this.healthcalc = null;
        this.error = false;
        this.exceptionMessage = "";
    }

    @Given("the user has accessed the health calculator")
    public void the_user_has_accessed_the_health_calculator() {
        // Health calculator accessed in @Before method
    }

    @When("the user puts his gender and height")
    public void the_user_puts_his_gender_and_height(String gender, int height) {
        try {
            this.calculatedIdealWeight = healthcalc.idealWeight(height, gender.charAt(0));
        } catch (Exception e) {
            this.exceptionMessage = e.getMessage().toLowerCase();
        }
    }

    @Then("the system calculates the ideal weight based on the entered data")
    public void the_system_calculates_the_ideal_weight_based_on_the_entered_data() {
        // Assuming ideal weight is calculated correctly
        assertTrue(this.calculatedIdealWeight > 0);
    }

    @When("the inputs are negative")
    public void the_inputs_are_negative() {
        try {
            // Assuming negative inputs for gender and height will cause an error
            this.calculatedIdealWeight = healthcalc.idealWeight(-170, 'm' );
        } catch (Exception e) {
            this.exceptionMessage = e.getMessage().toLowerCase();
        }
    }

    @Then("the system throws an error")
    public void the_system_throws_an_error() {
        // Assuming negative inputs will raise an error
        assertTrue(this.exceptionMessage.contains("debe ser un valor positivo"));
    }

    @Then("the ideal weight is zero and the system should rise an error")
    public void the_ideal_weight_is_zero_and_the_system_should_rise_an_error() {
        // Assuming ideal weight calculated as zero will raise an error
        assertTrue(this.exceptionMessage.contains("es cero o menor que cero"));
    }
}


