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
![6d10753eda994cb828d6d182304d2c9929ae85c1 (1)](https://github.com/joselugaspar/isa2024-healthcalc/assets/131762623/d32147c6-0300-4121-8701-61941517ab3d)

## Adición de dos casos de uso nuevos
En nuestro diagrama se nos solicita por un lado, añadir el caso de uso de calculo del índice de masa corporal del usuario (IMC), y otro caso de uso de nuestra elección, optaremos por una nueva funcionalidad de nuestra calculadora de salud, se mostrará el porcentaje de grasa corporal del usuario en cuestión.


![CasosDeUsoHEALTHCALC](https://github.com/joselugaspar/isa2024-healthcalc/assets/131762623/48452787-5312-47a8-ba59-9251b97b4f1e)

## Especificación de un caso de uso
Vamos a especificar el caso de uso de cálculo de IMC, cabe recalcar que este contenido se halla en el txt del directorio doc [CasosDeUsoHEALTHCALC.txt](https://github.com/joselugaspar/isa2024-healthcalc/files/14633588/CasosDeUsoHEALTHCALC.txt):

**Nombre:** Calcular IMC (Índice de Masa Corporal)

**Actor principal:** Usuario

**Ámbito:** Calculadora de salud

**Nivel:** Bajo

**Stakeholders e intereses:**

  ·Usuario: Interesado en conocer su índice de masa corporal para evaluar su estado de salud.
  
  ·Desarrolladores del sistema: Interesados en implementar y mantener la funcionalidad de cálculo del IMC.
  
  ·Precondiciones: El usuario debe proporcionar su peso en kilogramos (kg) y su altura en metros (m).
  
  ·Garantías mínimas: El sistema debe calcular el IMC correctamente según la fórmula estándar: IMC = peso (kg) / (altura (m))^2.
  
  ·Garantía de éxito: El sistema debe proporcionar al usuario el resultado del cálculo del IMC de manera precisa y comprensible.
  
**Escenario principal:**

  1.El usuario accede a la calculadora de salud y elige la opción de "Calcular IMC".
  
  2.El sistema solicita al usuario que ingrese su peso en kilogramos y su altura en metros.
  
  3.El usuario ingresa su peso y altura.
  
  4.El sistema calcula el IMC utilizando la fórmula estándar.
  
  5.El sistema muestra al usuario el resultado del cálculo del IMC.
  
  6.Fin del caso de uso.
  
**Escenarios alternativos:**

  ·En el paso 3, si el usuario ingresa un valor no válido para el peso o la altura (por ejemplo, un valor negativo o no numérico), el sistema muestra un mensaje de error y vuelve al paso 2.
  
  ·En el paso 5, si el cálculo del IMC resulta en un valor que está fuera del rango normal (por ejemplo, IMC menor que 10 o mayor que 50), el sistema muestra una advertencia al usuario indicando que el resultado puede ser incorrecto debido a valores extremos y sugiere verificar los datos ingresados.
  
**Extensiones:**

  ·El sistema podría permitir al usuario guardar el resultado del cálculo del IMC para su referencia futura.
  
  ·El sistema podría proporcionar información adicional sobre lo que significa un cierto valor de IMC en términos de categorías de peso (bajo peso, peso normal, sobrepeso, obesidad, etc.).


