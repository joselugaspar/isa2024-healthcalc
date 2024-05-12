package healthcalc;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("Tests para la calculadora de salud.")
public class HealthCalcTest {

    private HealthCalc healthCalc = HealthCalcImpl.getInstance(); //Implementación de singleton

    @Test
	public void testIdealWeightForMale() {
		try {
			float idealWeight = healthCalc.idealWeight(180, 'm');
			assertEquals(72.5f, idealWeight, 0.1f); 
		} catch (Exception e) {
			
		}
	}


    @Test
    public void testIdealWeightForFemale() {
        try {
            float idealWeight = healthCalc.idealWeight(160, 'w');
            assertEquals(56.0f, idealWeight, 0.1f);
        } catch (Exception e) {
            
        }
    }

	@Test
    public void testIdealWeightForTallMale() throws Exception {
        int height = 200;
        float result = healthCalc.idealWeight(height, 'm');
        assertTrue(result > 0);
    }

    @Test
    public void testIdealWeightForTallFemale() throws Exception {
        int height = 185;
        float result = healthCalc.idealWeight(height, 'w');
        assertTrue(result > 0);
    }
	
	@Test
    public void testIdealWeightForNegativeHeight() {
        int height = -150;
        assertThrows(IllegalArgumentException.class, () -> healthCalc.idealWeight(height, 'm'));
    }

    @Test
    public void testIdealWeightForVeryLowHeight() throws Exception {
        int height = 50;
        float result = healthCalc.idealWeight(height, 'w');
        assertTrue(result >= 0);
    }

    @Test
    @DisplayName("Prueba del cálculo de la tasa metabólica basal para hombre")
    public void testBasalMetabolicRateForMale() {
        try {
            float bmr = healthCalc.basalMetabolicRate(80, 175, 'm', 30);
            assertEquals(1748.75f, bmr, 0.1f);
        } catch (Exception e) {
            // Manejo de excepciones
        }
    }

    @Test
    @DisplayName("Prueba del cálculo de la tasa metabólica basal para mujer")
    public void testBasalMetabolicRateForFemale() {
        try {
            float bmr = healthCalc.basalMetabolicRate(60, 160, 'w', 25);
            assertEquals(1314.0f, bmr, 0.1f);
        } catch (Exception e) {
            // Manejo de excepciones
        }
    }

	@Test
    public void testBasalMetabolicRateForInvalidGender() {
        assertThrows(IllegalArgumentException.class, () -> {
            healthCalc.basalMetabolicRate(70, 175, 'x', 30);
        });
    }

	@Test
    public void testBasalMetabolicRateForInvalidAge() {
        assertThrows(IllegalArgumentException.class, () -> {
            healthCalc.basalMetabolicRate(70, 175, 'm', -10);
        });
    }

	@Test
    public void testBasalMetabolicRateForInvalidHeight() {
        assertThrows(IllegalArgumentException.class, () -> {
            healthCalc.basalMetabolicRate(70, -175, 'm', 30);
        });
    }
}
