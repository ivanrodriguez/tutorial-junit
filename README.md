Intro a JUnit
==============

Tutorial simple de JUnit por medio de una aplicación para calcular créditos preaprobados a clientes de un banco. En el tutorial se muestran las siguientes funcionalidades:

- AssertEquals
- Fixtures (Setup)
- Objetos auxiliares (Stubs, Mocks)
- Prueba de Excepciones
- Pruebas con parámetros

## Descripción de la aplicación


Nos piden hacer una aplicación para la oferta de créditos preaprobados a clientes de un banco. La idea es que los empleados del banco puedan ir a esta aplicación a través de la intranet de la sucursal y con base en los ingresos mensuales de un cliente, calcular las características de un crédito preaprobado que se puede ofrecer. Como política del banco, estos créditos preaprobados son por un monto equivalente a 5 veces el ingreso mensual del cliente. Por lo tanto la aplicación debe calcular una tabla de amortización de pagos con base en la información de los ingresos de un cliente.

La aplicación recibe como parámetros:

- Cliente que solicita el préstamo (para saber sus ingresos mensuales)
- Monto del crédito
- Tasa de interés anual
- Plazo en meses

La aplicación calcula:

- El pago fijo que debe hacer el cliente
- El total de intereses que deberá pagar el cliente
- El saldo remanente al final de un cierto mes del crédito

## Fórmula de pago fijo

Fórmula de Pago Fijo

![alt text](http://www.financeformulas.net/Formula%20Images/Loan%20Payment%20Formula%201.gif "Formula pago fijo")

En los archivos del tutorial también hay un Excel llamado "ejemplo-12meses-20mil.xls" (también funciona en LibreOffice) que tiene el ejemplo para un empleado que tiene ingresos mensuales de $20,000 y cotiza un crédito a 12 meses (que es el caso que se usa para los tests en el tutorial).

## Etapa 1

Con base en el Excel y las especificaciones de la aplicación, se diseña una clase "Calculadora" y se hace en JUnit una primera prueba de cómo sería la interacción con esta clase.

![alt text](http://yuml.me/diagram/scruffy/class/[Calculadora] "Clase Calculadora")

- Definición de todos los tests/pruebas que debe pasar
- Margen de error
- @test y assertEquals
- Float para cosas de dinero

## Etapa 2

- Implementación de getPagoFijo()
- Refactor con fixture @before y setUp()

## Etapa 3

- Implementación de cálculo de monto preabrobado 
- Mock classes para quitar dependencias con base de datos de clientes

## Etapa 4

- Implementación de cálculo saldos finales
- Pruebas con parámetros

## Etapa 5

- Manejos de error y validación de input de usuario
