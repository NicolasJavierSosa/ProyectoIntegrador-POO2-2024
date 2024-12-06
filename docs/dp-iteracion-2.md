# Trabajo en equipo

Después de haber liberado la primera iteración, nuestra primera tarea consistió en volver a evaluar el modelado de las clases presentes en el sistema, esto con la finalidad de tener una base sólida y homogénea sobre la cual puedan trabajar todos los miembros del equipo. Posteriormente, el enfoque fue el siguiente:

1.	***Base de Datos***: Se priorizó la resolución de los problemas de la base de datos obtenidos en la iteración anterior para asegurar la persistencia de la información para las funciones ya programadas. Una vez que fueron resueltas estas problemáticas, dichas soluciones fueron informadas a todos los miembros del equipo para que sean tenidas en cuenta para el resto de funciones a programar.
2.	***Diseño de Pantallas y Framework***: Abarcó el diseño de pantallas que no fueron abordadas en la primera iteración, el rediseño de ciertos elementos en algunas de las que ya fueron elaboradas y la validación de los campos de aquellas pantallas que lo requirieron.
3.	***Backend***: Consistió en la programación del resto de funciones que habían quedado fuera de la primera iteración, la refactorización de algunas partes del código de las funciones ya implementadas y la creación de pruebas unitarias.
   
Para mantener la cohesión, todos los grupos trabajamos en constante comunicación, asegurando la integración fluida de cada componente. En cuanto a las tareas específicas:

- **Rediseño del Diagrama de Clases y aplicación en el Modelo**: Tras una reunión conjunta con el equipo, Lautaro Fernández se encargó de rediseñar el diagrama de clases mientras que Hernán Lovera se responsabilizó de aplicar los cambios necesarios al modelo de la aplicación.
- **Diseño de Pantallas**: Nicolás Sosa y Lautaro Fernández se encargaron de crear el resto de pantallas faltantes para las funciones a implementar y realizar las validaciones en aquellas pantallas que lo requerían, mientras que los demás miembros del equipo que estaban encargados del Backend realizaron ajustes en algunas de las pantallas ya existentes.
- **Backend**: Hernán Lovera, Bianca Eitner y Nicolas Sosa fueron los encargados de realizar la refactorización de las funciones existentes, así como de crear aquellas que eran faltantes.
- **Documentación**: Lautaro Fernández fue el encargado de realizar este documento mientras que Máximo Gigena fue responsable de realizar la retrospectiva y la documentación del código restante con Javadoc.

# Diseño OO

[Diagrama de clases](https://github.com/NicolasJavierSosa/ProyectoIntegrador-POO2-2024/blob/main/Imagenes/Tienda%20Ecologica%20-%20DDC2.0.jpeg)

Para el diseño de este diagrama de clases utilizamos como base 3 patrones de diseños los cuales se pueden observar enmarcados en la imagen, el patrón COMPOSITE enmarcado en verde, DECORATOR enmarcado en anaranjado y STRATEGY en celeste.
1.	*Composite*: En este patrón utilizamos como clase principal a la interfaz ComponenteProducto que define el comportamiento común para los objetos que pueden ser tratados de manera uniforme en una jerarquía de productos y paquetes. La clase Producto representa un artículo individual en la tienda, implementa la interfaz ComponenteProducto y proporciona una implementación específica de los métodos definidos, como el cálculo del precio y del peso de un producto individual. Por otro lado, la clase Paquete también implementa ComponenteProducto, permitiendo agrupar varios productos (o incluso otros paquetes) en una sola unidad.
2.	*Decorator*: Tiene como interfaz principal Descuento que define el método aplicarDescuento() para aplicar diferentes tipos de descuentos a un producto o paquete. La clase DescuentoDecorator actúa como una clase base decoradora que sirve de intermediaria para aplicar descuentos específicos de manera flexible, Ademas hereda a las clases DescuentoBasico, DescuentoTemporada y DescuentoVolumen
3.	*Strategy*: La interfaces claves de este patrón son: Pago y Envio, al tener este enfoque aseguramos que el sistema sea flexible, ya que permite cambiar o agregar fácilmente métodos de pago y opciones de envío sin afectar otras partes del sistema, promoviendo la extensibilidad y manteniendo un diseño limpio.
   
# Wireframe y caso de uso

Se realizaron una serie de bocetos simples de cómo se vería la interfazpara las funciones restantes, acompañado de casos de uso para describir cómo interactúa el usuario con la aplicación. Las imágenes de los wireframes para esta iteración se encuentran en la carpeta wireframes extendidos. A continuación, se detallan los casos de uso para las pantallas diseñadas.

# Casos de Uso Extendidos

***Caso de Uso: Finalizar Compra***
Actor Primario: Cliente
Objetivo: El cliente desea completar la compra de un producto específico o de productos seleccionados en el carrito.

Flujo Principal:
1.	El cliente accede a la pantalla de "Finalizar Compra" desde el carrito de compras.
2.	El sistema muestra por pantalla los datos no editables del cliente, incluyendo Nombre y Apellido, Email y Teléfono.
3.	El cliente debe seleccionar uno de los métodos de envío disponibles:
      - Envío Local
      - Envío Provincial
      - Envío Nacional
4.	Dependiendo del método de envío seleccionado, los campos de dirección se habilitan o deshabilitan:
      - Envío Local: Solo el campo de "Dirección" se habilita.
      - Envío Provincial: Los campos de "Dirección" y "Ciudad" se habilitan, mientras que el campo de "Provincia" se deshabilita y limpia.
      - Envío Nacional: Todos los campos (Dirección, Ciudad y Provincia) se habilitan.
     
     Cualquier selección del método de envío limpia los campos de dirección.

5.	El cliente debe seleccionar uno de los métodos de pago disponibles:
      - Pago con Mercado Pago
      - Pago con Tarjeta
      - Pago con Transferencia Bancaria
6.	Al hacer clic en "Realizar Pedido", el sistema valida que:
      - Se haya seleccionado un método de envío.
      - Se haya seleccionado un método de pago.
      - Los campos habilitados de dirección (dependiendo del método de envío) estén completos.
      - Los campos de dirección no contengan caracteres especiales, solo letras y números.
7.	Si todas las validaciones son satisfactorias, se muestra un mensaje de éxito y se completa el pedido.

Flujos Alternativos:
- F1: Si el cliente no selecciona un método de envío, el sistema mostrará una alerta indicando que debe seleccionar uno.
- F2: Si el cliente no selecciona un método de pago, el sistema mostrará una alerta indicando que debe seleccionar uno.
- F3: Si el cliente no completa los campos de dirección habilitados, se mostrará una alerta indicando que debe completar dichos campos según el método de envío seleccionado.
- F4: Si los campos de dirección contienen caracteres especiales, se mostrará una alerta indicando que solo se permiten letras y números.

Precondiciones:
- El cliente ha iniciado sesión y ha agregado productos al carrito de compras o ha seleccionado un producto individual para comprarlo.

Postcondiciones:
- El pedido es procesado con éxito y el cliente recibe una confirmación del mismo.


***Caso de Uso: Iniciar Sesión***
Actor: Cliente
Objetivo: El cliente desea acceder a su cuenta en la plataforma.

Flujo Principal:
1.	El cliente accede a la pantalla de inicio de sesión desde la página principal de la tienda, o bien es redireccionado a esta pantalla si desea realizar una compra sin haber iniciado sesión previamente.
2.	El cliente ingresa su dirección de correo electrónico en el campo correspondiente.
      - El sistema valida que el formato del correo electrónico sea correcto.
3.	El cliente ingresa su contraseña en el campo correspondiente.
      - El sistema enmascara la contraseña para garantizar la privacidad del cliente.
4.	El cliente hace clic en el botón "ACCEDER".
5.	El sistema valida las credenciales del cliente.
       - Si las credenciales son correctas, el cliente es redirigido a la pantalla de inicio si ha ingresado desde allí, o a la pantalla de orden de compra si fue redireccionado.
       - Si las credenciales son incorrectas, el sistema muestra un mensaje de error indicando que el correo electrónico o la contraseña son incorrectos.

Flujos Alternativos:
- F1: Si el formato del correo electrónico ingresado es incorrecto, el sistema muestra un mensaje de error indicando que el formato del correo electrónico no es válido.
- F2: Si el cliente ingresa un correo electrónico o contraseña incorrectos, el sistema muestra un mensaje de error indicando que las credenciales son incorrectas. El cliente puede intentar nuevamente ingresando las credenciales correctas.

Precondiciones:
- El cliente tiene una cuenta registrada en la plataforma.

Postcondiciones:
- El cliente accede exitosamente a su cuenta y puede pasar a la orden de compra.


***Caso de Uso: Crear Cuenta*** 
Actor Primario: Cliente
Objetivo: El cliente desea crear una cuenta en la tienda para poder realizar compras.

Flujo Principal:
1.	El cliente accede a la pantalla de creación de cuenta.
2.	El cliente ingresa su nombre en el campo "Nombre" y luego ingresa su apellido en el campo "Apellido".
3.	El cliente ingresa su correo electrónico en el campo "Correo".
      - El sistema valida que el formato del correo electrónico sea correcto.
4.	El cliente ingresa un nombre de usuario en el campo "Username" y luego ingresa una contraseña en el campo "Password".
o	El sistema enmascara la contraseña para garantizar la privacidad del usuario.
5.	El cliente hace clic en el botón "GUARDAR".
6.	El sistema valida que todos los campos estén completos.
7.	Si la validación es exitosa, el sistema guarda la información del cliente en la base de datos. Luego, el sistema muestra un mensaje de confirmación indicando que la cuenta ha sido creada exitosamente.

Flujos Alternativos:
- F1: Si el formato del correo electrónico ingresado es incorrecto, el sistema muestra un mensaje de error indicando que el formato del correo electrónico no es válido.
- F2: Si el usuario deja algún campo vacío, el sistema muestra un mensaje de error indicando que todos los campos son obligatorios.
- F3: Si hay un problema con la conexión a la base de datos, el sistema muestra un mensaje de error indicando que no se pudo crear la cuenta en ese momento y que intente más tarde.

Precondiciones:
- El usuario tiene acceso a la pantalla de creación de cuenta.

Postcondiciones:
- El usuario tendrá una cuenta creada y podrá iniciar sesión en el sistema.


# Backlog de iteraciones

Historias de usuario que completaremos en esta segunda iteración:

1.	**COMO** cliente **QUIERO** disponer de un carrito de compras **PARA** la organización de mis compras.
   
**Tipo**: Funcional

**Prioridad**: Alta

**Criterios de aceptación**:

         - El carrito debe permitir agregar, eliminar y modificar la cantidad de productos.
         - El carrito debe calcular automáticamente el total de la compra en base a la cantidad y precio de los productos.
         
**Impacto**: Mejora la conveniencia de los clientes durante el proceso de compra.



2.	**COMO** cliente **QUIERO** que los productos se separen por categorías **PARA** poder encontrar de manera rápida y sencilla lo que busco en la tienda online.
   
**Tipo**: Funcional

**Prioridad**: Baja

**Criterios de aceptación**: 

      - Los productos deben clasificarse en categorías como alimentos, ropa, productos reutilizables, etc.
      - El sistema debe permitir buscar y filtrar productos dentro de cada categoría.
      - Las categorías deben ser configurables por el gerente, permitiendo añadir o quitar categorías.
      
**Impacto**: Facilita la navegación en la tienda y mejora la experiencia de compra.



3.	**COMO** gerente **QUIERO** que la aplicación de descuentos a productos esté automatizada **PARA** optimizar el proceso de cobro.
   
**Tipo**: Funcional

**Prioridad**: Media

**Criterios de aceptación**: 

      - El sistema debe mostrar el descuento aplicado en el carrito de compras junto al precio original(subtotal) y el precio descontado(total).
      - El sistema debe aplicar automáticamente los descuentos configurados a los productos en el carrito.
      - Los descuentos deben aplicarse de acuerdo con reglas preconfiguradas, como porcentaje o monto fijo.
      - El gerente debe poder programar y administrar descuentos por temporadas.
      
**Impacto**: Optimiza el proceso de ventas y facilita la gestión de promociones.



4.	**COMO** gerente **QUIERO** posibilitar la venta de productos por paquetes **PARA** facilitar la adquisición de mayor cantidad de productos para quien desee hacerlo.
   
**Tipo**: Funcional

**Prioridad**: Alta

**Criterios de aceptación**:

      - El sistema debe ofrecer opciones de paquetes preconfigurados con precios especiales.
      - El sistema debe permitir configurar distintos tipos de paquetes con diferentes combinaciones de productos.
      - El sistema debe permitir seleccionar la cantidad de paquetes a comprar.
      - Los paquetes deben poder añadirse al carrito y ser gestionados como una única unidad.
      
**Impacto**: Facilita compras al por mayor y fomenta ventas más grandes.



5.	**COMO** usuario **QUIERO** disponer de múltiples formas de pago **PARA** la adquisición de productos. (Se concluirá su implementación)
   
**Tipo**: Funcional

**Prioridad**: Media

**Criterios de aceptación**: 

      - El sistema debe aceptar realizar pagos con tarjetas de crédito, débito y transferencias.
      - El sistema debe confirmar la transacción exitosa o fallida en tiempo real.
      
**Impacto**: Incrementa la accesibilidad y conveniencia para clientes de distintos perfiles.



6.	**COMO** usuario **QUIERO** disponer de múltiples opciones de envío **PARA** poder seleccionar la que más me convenga según mi ubicación.
    
**Tipo**: Funcional

**Prioridad**: Alta

**Criterios de aceptación**:

      - El sistema debe permitir seleccionar entre Envío Local, Envío Provincial y Envío Nacional.
      - El sistema debe validar que todos los campos habilitados estén completos antes de finalizar la compra.
      
**Impacto**: Incrementa la flexibilidad y conveniencia para los clientes al proporcionarles opciones de envío que se ajusten a sus necesidades y ubicación geográfica.



# Tareas

1.	Realizar el rediseño de los diagramas necesarios (Diagrama de clases).
2.	Adaptar el modelo.
3.	Re - implementar la base de datos.
4.	Rediseñar las pantallas en base a las necesidades.
5.	Hacer los diseños de las pantallas faltantes.
6.	Implementar las funciones propuestas 
      - Carrito de compras
      - Filtrado por categoría de producto
      - Aplicación automática de descuentos programados
      - Venta de paquetes
7.	Implementación de los métodos de pago restantes y los métodos de envío.


