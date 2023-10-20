## Getting Started

Welcome to the VS Code Java world. Here is a guideline to help you get started to write Java code in Visual Studio Code.

## Folder Structure

The workspace contains two folders by default, where:

- `src`: the folder to maintain sources
- `lib`: the folder to maintain dependencies

Meanwhile, the compiled output files will be generated in the `bin` folder by default.

> If you want to customize the folder structure, open `.vscode/settings.json` and update the related settings there.

## Dependency Management

The `JAVA PROJECTS` view allows you to manage your dependencies. More details can be found [here](https://github.com/microsoft/vscode-java-dependency#manage-dependencies).

# Laboratorio evaluado 1. Clases y Objetos

A fines de llevar el inventario de un Laboratorio llamado X-Gen, crearemos una clase
llamada Medicamento con las siguientes características:

Sus atributos son código de medicamento, nombre del medicamento, costo del medicamento,
precio de venta al público (siempre es más alto que el costo en al menos un 20%), unidades
vendidas, unidades en existencia, fecha de caducidad (mes/año), número de lote, vigencia
(0 si no se encuentra disponible en el mercado, 1 si está disponible y 2 si fue retirado del
mercado).

Los constructores que se implementarán serán:
Un constructor por defecto (los valores por defecto los estableces según creas conveniente).

Un constructor con todos los atributos.

Los métodos que se implementarán en la clase Medicamento serán:

Métodos getter y setter de todos los atributos.

Método leerDatos() el cual permite capturar y validar todos los datos del Medicamento.

Deberás incorporar las validaciones que sean necesarias y emplearlas al momento de solicitar
el atributo que requiera validación.

precioAPagar(porcentaje): el precio a pagar se calculará según el costo de elaboración del
medicamento más un porcentaje adicional sobre dicho costo que determina el laboratorio. Este
precio se almacenará en el atributo precio de venta al público una vez calculado.

determinarVencido(): verifica si un medicamento está vencido o no. En caso de estar vencido,
se imprimirá la fecha en que venció, el código y nombre del producto.

retirarLote(número de lote): retira del mercado (vigencia=2) todos los medicamentos que
pertenezcan a un lote determinado.

colocarOferta(): para aquellos medicamentos que vencen en tres meses se ofrecerá un
descuento del 30% sobre su precio de venta al público.

reponerInventario(): envía una notificación si la cantidad de unidades en existencia es menor
que 5.

mostrarInformación(): permite consultar el contenido de todos los atributos almacenados en
la clase, es decir, toda la información sobre el medicamento.

En el main crea al menos tres objetos para probar tu programa, incluye un menú para facilitar el
manejo del mismo. Recuerda incluir todas las validaciones posibles inherentes al manejo de la
información y atributos que se almacenan en la clase Medicamento.