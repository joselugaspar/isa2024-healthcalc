# Práctica 6
## Introducción
Se nos pide realizar un patrón de diseño diferente que cubra las necesidades de cada uno de los apartados estipulados

## Primer apartado
En este apartado se nos dice explícitamente de usar el patrón singleton.

![singleton](https://github.com/joselugaspar/isa2024-healthcalc/assets/131762623/7f9cec13-9ab9-452f-a59e-8820013fdb19)

## Apartado A
Aquí se nos habla sobre una interfaz creada por un Hospital, para que la funcionalidad de nuestra calculadora pueda emplearse con esta interfaz usamos el patrón adapter.

![adapter](https://github.com/joselugaspar/isa2024-healthcalc/assets/131762623/1dd025a6-2eda-4771-a216-5b71a44caaa0)

## Apartado B
Ahora se quieren recoger las estadísticas medias, entre otros datos, de los pacientes que usan la calculadora, para ello implementamos una interfaz llamada HealthStats que llama a todos los métodos que devuelven estos valores; logramos su funcionamiento con el patrón proxy de registro.

![proxyregistro](https://github.com/joselugaspar/isa2024-healthcalc/assets/131762623/c30a57db-3f47-4c37-bd2f-c2826b657343)

## Apartado C
Se nos solicita implementar versiones de la calculadora, una americana y otra europea, de manera que los pacientes americanos puedan insertar sus datos en pies y libras y la calculadora funcione igual, para ello realizamos un patrón decorator.

![decorator](https://github.com/joselugaspar/isa2024-healthcalc/assets/131762623/f625e265-f299-4659-9225-5891acf54335)
