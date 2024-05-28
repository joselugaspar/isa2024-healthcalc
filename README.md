# Práctica 7
## Introducción
Se nos pide realizar un refactoring para sopesar los problemas que se nos presentan con una nueva versión de nuestra calculadora
![image](https://github.com/joselugaspar/isa2024-healthcalc/assets/131762623/57e80489-870b-440c-9008-ea2857afdf23)

1. **Bad Smell: Large Class**
    - **Refactoring:** Extract Interface
    - **Tipo:** Class Refactoring
    - **Desc:** Se han implementado dos interfaces nuevas, MetabolicMetrics y CardiovascularMetrics, para satisfacer estas dos interfaces se ha tenido que cambiar todas las referencias a los métodos que implementan peso ideal y también para que devuelvan double y no float.
    - **Número de cambios:** 
        - 2 crear ambas interfaces
        - 1 implementarlas en HealthCalcImpl
        - 2 veces se ha cambiado float a double en HealthCalcImpl

2. **Bad Smell: Primitive Obsession**
    - **Refactoring:** Introduce Parameter Object
    - **Tipo:** Class Refactoring
    - **Desc:** Se ha creado un objeto tipo enum para el género, quitando así el término char, que es nuestro problema primitivo.
    - **Número de cambios:** 
        - 1 crear Gender
        - 5 cambiar char por Gender
        - 3 reemplazar en los condicionales 'w' por Gender.FEMALE
        - 3 reemplazar en los condicionales 'm' por Gender.MALE
        - 1 crear un método en adapter que seleccione un valor enum dependiendo del caracter que se le proporciona
        - 1 quitar un test que usaba un género no válido

3. **Bad Smell: Long Parameter List**
    - **Tipo:** Class Refactoring
    - **Desc:** Se ha creado una nueva interfaz y una clase que implementa esta, Person y PersonClass, así se usará esta clase para crear objetos que implementan los datos de la interfaz y realizan ambos tipos de cálculo, así no hay que pasarle a la calculadora todos los parámetros de siempre, si no una persona.
    - **Número de cambios:** 
        - 2 crear la interfaz y la clase
        - 2 cambios en el adapter dos métodos para que procesen un objeto Person
        - 2 cambios en el controlador para lo mismo que use un objeto Person
        - 10 cambios en test

