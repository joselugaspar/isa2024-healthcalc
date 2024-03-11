# isa2024-healtcalc
Se desea desarrollar una calculadora que permita estimar varios parámetros de salud de una persona, como su peso ideal o su tasa metabólica basal (TMB).
## Introducción
Se nos solicita realizar un fork de este repositorio para la asignatura "Ingeniería del Software Avanzada", de este modo lo clonaremos en nuestra máquina y comenzaremos a trabajar con él.

## Tests para Ideal Weight
Los tests llevados a cabo para comprobar el correcto funcionamiento de nuestra calculadora con respecto al método Ideal Weight han sido los siguientes:

- **Test Ideal Weight For Male**:
  ```java
  @Test
  public void testIdealWeightForMale() {
      try {
          float idealWeight = healthCalc.idealWeight(180, 'm');
          assertEquals(72.5f, idealWeight, 0.1f); 
      } catch (Exception e) {
          // Manejo de excepciones
      }
  
- **Test Ideal Weight For Female**:
  ```java
  @Test
    public void testIdealWeightForFemale() {
        try {
            float idealWeight = healthCalc.idealWeight(160, 'w');
            assertEquals(56.0f, idealWeight, 0.1f);
        } catch (Exception e) {
            
        }
    }
  
- **Test Ideal Weight For Unexpected High Height (Male)**:
  ```java
  @Test
    public void testIdealWeightForTallMale() throws Exception {
        int height = 200;
        float result = healthCalc.idealWeight(height, 'm');
        assertTrue(result > 0);
    }
  
- **Test Ideal Weight For Unexpected High Height (Female)**:
  ```java
  @Test
    public void testIdealWeightForTallFemale() throws Exception {
        int height = 185;
        float result = healthCalc.idealWeight(height, 'w');
        assertTrue(result > 0);
    }
  
- **Test Ideal Weight For Negative Height**:
  ```java
  @Test
    public void testIdealWeightForNegativeHeight() {
        int height = -150;
        assertThrows(IllegalArgumentException.class, () -> healthCalc.idealWeight(height, 'm'));
    }
  
 - **Test Ideal Weight For Very Low Heightt**:
  ```java
  @Test
    public void testIdealWeightForVeryLowHeight() throws Exception {
        int height = 50;
        float result = healthCalc.idealWeight(height, 'w');
        assertTrue(result >= 0);
    }

