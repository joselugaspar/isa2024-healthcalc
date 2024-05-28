package healthcalc;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("Tests para la calculadora de salud.")
public class HealthCalcTest {

    private HealthCalcImpl healthCalc = HealthCalcImpl.getInstance(); //Implementación de singleton

    @Test
	public void testIdealWeightForMale() {
		try {
			double idealWeight = healthCalc.getIdealBodyWeight(new PersonClass(180, Gender.MALE));
			assertEquals(72.5f, idealWeight, 0.1f); 
		} catch (Exception e) {
			
		}
	}


    @Test
    public void testIdealWeightForFemale() {
        try {
            double idealWeight = healthCalc.getIdealBodyWeight(new PersonClass(160, Gender.FEMALE));
            assertEquals(56.0f, idealWeight, 0.1f);
        } catch (Exception e) {
            
        }
    }

	@Test
    public void testIdealWeightForTallMale() throws Exception {
        int height = 200;
        double result = healthCalc.getIdealBodyWeight(new PersonClass(height, Gender.MALE));
        assertTrue(result > 0);
    }

    @Test
    public void testIdealWeightForTallFemale() throws Exception {
        int height = 185;
        double result = healthCalc.getIdealBodyWeight(new PersonClass(height, Gender.FEMALE));
        assertTrue(result > 0);
    }
	
	@Test
    public void testIdealWeightForNegativeHeight() {
        int height = -150;
        assertThrows(IllegalArgumentException.class, () -> healthCalc.getIdealBodyWeight(new PersonClass(height, Gender.MALE)));
    }

    @Test
    public void testIdealWeightForVeryLowHeight() throws Exception {
        int height = 50;
        double result = healthCalc.getIdealBodyWeight(new PersonClass(height, Gender.FEMALE));
        assertTrue(result >= 0);
    }

    @Test
    @DisplayName("Prueba del cálculo de la tasa metabólica basal para hombre")
    public void testBasalMetabolicRateForMale() {
        try {
            double bmr = healthCalc.basalMetabolicRate(new PersonClass(80, 175, 30, Gender.MALE));
            assertEquals(1748.75f, bmr, 0.1f);
        } catch (Exception e) {
            // Manejo de excepciones
        }
    }

    @Test
    @DisplayName("Prueba del cálculo de la tasa metabólica basal para mujer")
    public void testBasalMetabolicRateForFemale() {
        try {
            double bmr = healthCalc.basalMetabolicRate(new PersonClass(60, 160, 25, Gender.FEMALE));
            assertEquals(1314.0f, bmr, 0.1f);
        } catch (Exception e) {
            // Manejo de excepciones
        }
    }


	@Test
    public void testBasalMetabolicRateForInvalidAge() {
        assertThrows(IllegalArgumentException.class, () -> {
            healthCalc.basalMetabolicRate(new PersonClass(70, 175, -10, Gender.MALE));
        });
    }

	@Test
    public void testBasalMetabolicRateForInvalidHeight() {
        assertThrows(IllegalArgumentException.class, () -> {
            healthCalc.basalMetabolicRate(new PersonClass(70, -175, 30, Gender.MALE));
        });
    }
}
