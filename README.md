# isa2024-healtcalc
Se desea desarrollar una calculadora que permita estimar varios parámetros de salud de una persona, como su peso ideal o su tasa metabólica basal (TMB).

# Práctica 1
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
  
 - **Test Ideal Weight For Very Low Height**:
    ```java
    @Test
    public void testIdealWeightForVeryLowHeight() throws Exception {
        int height = 50;
        float result = healthCalc.idealWeight(height, 'w');
        assertTrue(result >= 0);
    }

## Tests para Basal Metabolic Rate
Los tests llevados a cabo para comprobar el correcto funcionamiento de nuestra calculadora con respecto al método Basal Metabolic Rate han sido los siguientes:

- **Test Average BMR (Male)**:
  ```java
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

- **Test Average BMR (Female)**:
  ```java
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

- **Test BMR for Invalid Gender**:
  ```java
  @Test
      public void testBasalMetabolicRateForInvalidGender() {
          assertThrows(IllegalArgumentException.class, () -> {
              healthCalc.basalMetabolicRate(70, 175, 'x', 30);
          });
      }
- **Test BMR for Invalid Age**:
   ```java
  @Test
    public void testBasalMetabolicRateForInvalidAge() {
        assertThrows(IllegalArgumentException.class, () -> {
            healthCalc.basalMetabolicRate(70, 175, 'm', -10);
        });
    }

- **Test BMR for Invalid Height**:
   ```java
  @Test
    public void testBasalMetabolicRateForInvalidHeight() {
        assertThrows(IllegalArgumentException.class, () -> {
            healthCalc.basalMetabolicRate(70, -175, 'm', 30);
        });
    }
  }

## Resultado de la ejecución de los Tests con JUnit:

<img width="312" alt="Screenshot 2024-03-11 at 13 52 15" src="https://github.com/joselugaspar/isa2024-healthcalc/assets/131762623/5928aa8e-32e2-47cf-b743-f4ddeb2ce141">

## Captura de las ramas al hacer gitk:

![gitk isa2024](https://github.com/joselugaspar/isa2024-healthcalc/assets/131762623/fc8545f8-8ba3-4517-ab73-ce2f3d83d3da)

# Práctica 2
## Introducción
En esta práctica hemos de realizar un Diagrama de Casos de Uso UML, en nuestro caso haremos uso de Visual Paradigm para ello
![6d10753eda994cb828d6d182304d2c9929ae85c1](https://github.com/joselugaspar/isa2024-healthcalc/assets/131762623/93828896-7ca1-4ac5-8e64-e4e85d81550c)

## Adición de dos casos de uso nuevos
En nuestro diagrama se nos solicita por un lado, añadir el caso de uso de calculo del índice de masa corporal del usuario (IMC), y otro caso de uso de nuestra elección, optaremos por una nueva funcionalidad de nuestra calculadora de salud, se mostrará el porcentaje de grasa corporal del usuario en cuestión.
![CasosDeUsoHEALTHCALC](https://github.com/joselugaspar/isa2024-healthcalc/assets/131762623/48452787-5312-47a8-ba59-9251b97b4f1e)

## Especificación de un caso de uso
Vamos a especificar el caso de uso de cálculo de IMC:
[CasosDeUsoHEALTHCALC.txt](https://github.com/joselugaspar/isa2024-healthcalc/files/14633531/CasosDeUsoHEALTHCALC.txt)
