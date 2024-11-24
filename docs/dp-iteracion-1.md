# Trabajo en equipo
Como equipo, comenzamos organizándonos en tres grupos de trabajo, con el objetivo de dividir las responsabilidades de forma efectiva. Nos agrupamos de a dos personas en cada equipo, asignando a cada grupo una de las siguientes áreas:
1. ***Base de Datos:*** Un grupo se encargó de la estructura y diseño de la base de datos, asegurando que cumpliera con los requisitos y que pudiera manejar la información de manera eficiente.
2. ***Diseño de Pantallas y Framework:*** Otro equipo se ocupó del diseño de la interfaz de usuario y de la selección del framework adecuado. Este grupo trabajó en la planificación de las pantallas de la página web, asegurándose de que el diseño fuera intuitivo y funcional.
3. ***Backend:*** El último equipo se centró en el desarrollo del backend, creando la lógica del negocio y la estructura del servidor. Este equipo se encargó de implementar la funcionalidad necesaria para que el sistema opere correctamente.

Para mantener la cohesión, todos los grupos trabajamos en constante comunicación, asegurando la integración fluida de cada componente.
En cuanto a las tareas específicas:
- **Diseño del Diagrama de Clases:** Gustavo Melgarejo y Máximo Gigena fueron los responsables de elaborar el diagrama de clases inicial. Tras una reunión conjunta con todos los miembros, se discutieron los patrones de diseño y las clases clave para el proyecto, logrando un diseño base que fue ajustado con los aportes de todo el equipo.
- **Diseño de Pantallas y Selección de Framework:** Nicolás Sosa y Lautaro Fernández se encargaron de elegir el diseño visual de las pantallas y proponer los frameworks que mejor se adaptaban a los requerimientos del sistema.
- **Backend y documentación:** Hernán Lovera y Bianca Eitner trabajaron en el modelo del proyecto y en la creación de archivos de documentación. Mientras el equipo de diseño definía las bases visuales y el equipo de Base de datos avanzaba en el diagrama, este grupo aseguraba que toda la información estuviera organizada y bien documentada para facilitar futuras actualizaciones y el mantenimiento del sistema.


# Diseño OO
Para esta iteración el diagrama de clases es:
[Diagrama de clases](https://github.com/NicolasJavierSosa/ProyectoIntegrador-POO2-2024/blob/main/Imagenes/Tienda%20Ecologica%20-%20DCC.jpeg)
Para el diseño de este diagrama de clases utilizamos como base 3 patrones de diseños los cuales se pueden observar enmarcados en la imagen, el patrón COMPOSITE enmarcado en verde, DECORATOR enmarcado en anaranjado y STRATEGY en celeste.
1. Composite:
    En este patrón utilizamos como clase principal a la interfaz *ComponenteProducto* que define el comportamiento común para los objetos que pueden ser tratados de manera uniforme en una jerarquía de productos y paquetes. La clase *Producto* representa un artículo individual en la tienda, implementa la interfaz *ComponenteProducto* y proporciona una implementación específica de los métodos definidos, como el cálculo del precio y del peso de un producto individual. Por otro lado, la clase *Paquete* también implementa *ComponenteProducto*, permitiendo agrupar varios productos (o incluso otros paquetes) en una sola unidad.
2. Decorator:
    Tiene como interfaz principal *Descuento* que define el método *aplicarDescuento()* para aplicar diferentes tipos de descuentos a un producto o paquete. La clase *DescuentoDecorator* actúa como una clase base decoradora que sirve de intermediaria para aplicar descuentos específicos de manera flexible, Ademas hereda a las clases *DescuentoBasico*, *DescuentoTemporada* y *DescuentoVolumen* 
3. Strategy:
    La interfaces claves de este patrón son: *Pago* y *Envio*, al tener este enfoque aseguramos que el sistema sea flexible, ya que permite cambiar o agregar fácilmente métodos de pago y opciones de envío sin afectar otras partes del sistema, promoviendo la extensibilidad y manteniendo un diseño limpio.


# Wireframe y caso de uso
un boceto simple (o algunos) de cómo se verá la interfaz de usuario, acompañado de casos de uso para describir cómo interactúa el usuario con la aplicación. Similar al UML, pueden usar un software para generar el wireframe.

# Descripción del Diagrama de Casos de Uso

El [Diagrama de Casos de Uso](https://github.com/NicolasJavierSosa/ProyectoIntegrador-POO2-2024/blob/main/Imagenes/Tienda%20Ecol%C3%B3gica%20-%20DCU%20.jpg) representa un **Sistema** que interactúa con dos tipos de actores principales: **Cliente** y **Administrador**. Cada actor tiene acceso a diferentes funcionalidades, organizadas en casos de uso. Además, se emplean relaciones de <*include*> y <*extend*> para detallar dependencias o extensiones entre los casos de uso.

**Actores:**

1. **Cliente**:
   - Usuario que accede al sistema para realizar compras, buscar productos, organizar pedidos y realizar pagos.

2. **Administrador**:
   - Encargado de gestionar el catálogo de productos, crear paquetes, asignar descuentos y monitorear el stock.

**Casos de Uso del Cliente:**

1. **Visualizar Catálogo**:
   - Permite al cliente navegar por la lista completa de productos disponibles en el sistema.

2. **Buscar Producto**:
   - Proporciona una herramienta para realizar la busqueda de productos específicos.

4. **Filtrar Búsqueda**:
   - Extiende "Buscar Producto". Ofrece funcionalidades avanzadas para refinar resultados de búsqueda.

    - **Filtros específicos (<*Extends*>)**:
        - **Filtrar por Categoría**: Permite clasificar los productos según categorías específicas.
        - **Filtrar por Criterios**: Ofrece opciones adicionales como rango de precio, marca u otros atributos 
    relevantes.
    
5. **Pagar Producto**:
   - Representa el proceso de completar el pago de un producto seleccionado.

   - **Pagos específicos (<*Extends*>)**:
     - **Pagar con Transferencia**: Permite realizar el pago mediante transferencia bancaria.
     - **Pagar con MercadoPago**: Opción para usar la plataforma de Mercado Pago como un medio de pago.
     - **Pagar con Tarjeta**: Habilita el uso de tarjetas de crédito/débito.

6. **Organizar Compras**:
   - Ayuda al cliente a planificar y gestionar sus compras.

7. **Consultar Pedido**:
   - Permite al cliente verificar el estado de sus pedidos previos.

**Casos de Uso del Administrador:**

1. **Agregar Productos**:
   - Permite introducir nuevos productos en el catálogo del sistema.

2. **Agregar Paquetes**:
   - Habilita la creación de paquetes de productos (por ejemplo, combos o promociones).

3. **Automatizar Descuentos**:
   - Relacionado con la automatización de descuentos promocionales, incluyendo criterios predefinidos.

   - **Descuentos Especificos (<*Extend*>)**:
       - **Designar por Intervalos de Tiempo**: Permite establecer vigencia de los descuentos en 
     función del tiempo.
       - **Designar por Cantidad**: Los descuentos pueden configurarse según límites de cantidad.

4. **Designar Productos**:
   - Permite seleccionar o asociar productos específicos a la creacion de descuentos especificos.
     
5. **Designar Paquetes**:
   - Permite seleccionar o asociar paquetes específicos a la creacion de descuentos especificos.

6. **Modificar Productos**:
   - Habilita la edición de las propiedades de productos existentes.

7. **Modificar Paquetes**:
   - Permite realizar ajustes en los paquetes existentes.

8. **Alertar Stock**:
   - Función que notifica al administrador cuando el inventario de productos alcanza niveles bajos.
     
# Casos de Uso Extendidos  

**Caso 1:** Pagar Producto

**Actor Primario:** Cliente

**Propósito:** Permitir al cliente completar el proceso de compra de un producto.

**Flujo Principal**
1. El cliente selecciona un producto en el carrito de compras.
2. El sistema solicita que el cliente elija un método de pago.
3. El cliente selecciona un método (Transferencia, MercadoPago o Tarjeta).
4. El sistema procesa el pago utilizando el método seleccionado.
5. Se confirma la transacción y se registra el pedido en el sistema.

**Flujos Alternativos** (<*Extend*>)
1. **Pagar con Transferencia**
   
    1- El cliente selecciona "Transferencia Bancaria" como método de pago.
   
    2- El sistema muestra los datos bancarios necesarios para realizar la operación.
   
    3- El cliente confirma haber realizado la transferencia y adjunta comprobantes si es requerido.

    4- Si la transferencia falla se termina el caso de uso 

3. **Pagar con MercadoPago**
   
    1- El cliente selecciona "MercadoPago".
   
    2- El sistema redirige al cliente al sitio de MercadoPago para completar el pago.
   
    3- Una vez confirmado el pago, el sistema regresa al flujo principal.
   
5. **Pagar con Tarjeta**
   
    1- El cliente selecciona "Tarjeta de Crédito/Débito".
   
    2- El sistema solicita los datos de la tarjeta.

    3- El sistema valida la transacción 
   
    4- Si los datos no coinciden se informa al usuario cual es el error y se vuelve al paso 2

    5- El sistema confirma el pago 
  
   
**Caso 2:** Filtrar Busqueda

**Actor Primario:** Cliente

**Propósito:** Ayudar al cliente a encontrar productos específicos mediante filtros avanzados.

**Flujo Principal**
1. El cliente accede a la funcionalidad de búsqueda.
2. Introduce un término (por ejemplo, "teclado").
3. El sistema devuelve resultados relacionados.
4. El usuario selecciona los filtros sobre esa busqueda
   
**Flujos Alternativos** 

**Filtrar por Categoría**

1- El cliente selecciona una categoría específica (por ejemplo, "Periféricos").

2- El sistema actualiza la búsqueda mostrando únicamente productos de la categoría seleccionada.

**Filtrar por Criterios**

1- El cliente selecciona filtros avanzados como rango de precio, marca o stock.

2- El sistema actualiza los resultados con base en los criterios definidos.

**Caso 3:** Agregar Productos

**Actor Primario**: Administrador

**Propósito:** Permitir al administrador introducir nuevos productos al catálogo del sistema.

**Flujo Principal**

1. El administrador accede a la funcionalidad de agregar productos.
2. Ingresa los detalles del producto como nombre, precio, descripción y categoría.
4. El sistema valida la información.
5. El producto se registra y se agrega al catálogo.

**Flujo Alternativo** 

1- El administrador comete un fallo en la carga de datos del producto 

2- El sistema notifica este fallo al administrador.

3- Se retorna al paso 2 del flujo principal.

**Caso 4:** Automatizar Descuentos

**Actor Primario:** Administrador

**Propósito:** Implementar descuentos automáticos según criterios predefinidos.

**Flujo Principal**

1. El administrador accede a la funcionalidad de descuentos.
2. Configura los criterios para el descuento.
3. El sistema valida los parámetros ingresados.
4. Los descuentos se activan automáticamente en el sistema.

**Flujos Alternativos** (<*Extend*>)

**Designar por Intervalos de Tiempo**

1- El administrador configura un rango de fechas para la vigencia del descuento.

2- El sistema activa y desactiva los descuentos según las fechas definidas.

**Designar por Cantidad**

1- El administrador especifica que el descuento se aplicará solo si el cliente compra una cantidad mínima de productos.

2- El sistema valida la cantidad durante el proceso de compra y aplica el descuento si se cumple la condición.

# Backlog de iteraciones

### Historia de usuario que completaremos en esta primer iteración:

1. **COMO** usuario **QUIERO** que se vea un catálogo de los productos disponibles en la página/aplicación **PARA** tener una vista general de lo disponible.
    - ***Tipo:*** Funcional
    - ***Prioridad:*** Alta
    - ***Criterios de aceptación:*** 
        - [] El catálogo debe mostrar imágenes, precios, y descripciones de los productos.
    - ***Impacto:*** Mejora la experiencia de los usuarios al facilitar la navegación y la selección de productos.

2. **COMO** usuario **QUIERO** un buscador de productos por nombre **PARA** hacer búsquedas específicas mucho más rápido.
    - ***Tipo:*** Funcional
    - ***Prioridad:*** Media
    - ***Criterios de aceptación:*** 
        - [] El buscador debe sugerir productos a medida que el usuario escribe en el campo de búsqueda.
        - [] El buscador debe permitir búsqueda por nombre de producto y mostrar resultados instantáneamente.
    - ***Impacto:*** Aumenta la eficiencia en la localización de productos específicos.

3. **COMO** gerente **QUIERO** posibilitar la venta de productos por paquetes **PARA** facilitar la adquisición de mayor cantidad de productos para quien desee hacerlo.
    - ***Tipo:*** Funcional
    - ***Prioridad:*** Alta
    - ***Criterios de aceptación:*** 
        - [] El sistema debe ofrecer opciones de paquetes preconfigurados con precios especiales.
        - [] El sistema debe permitir configurar distintos tipos de paquetes con diferentes combinaciones de productos.
        - [] El sistema debe permitir seleccionar la cantidad de paquetes a comprar.
        - [] Los paquetes deben poder añadirse al carrito y ser gestionados como una única unidad.
    - ***Impacto:*** Facilita compras al por mayor y fomenta ventas más grandes.

4. **COMO** cliente **QUIERO** disponer de un carrito de compras **PARA** la organización de mis compras.
    - ***Tipo:*** Funcional
    - ***Prioridad:*** Alta
    - ***Criterios de aceptación:*** 
        - [] El carrito debe permitir agregar, eliminar y modificar la cantidad de productos.
        - [] El carrito debe calcular automáticamente el total de la compra en base a la cantidad y precio de los productos.
    - ***Impacto:*** Mejora la conveniencia de los clientes durante el proceso de compra.

5. **COMO** gerente **QUIERO** posibilitar la venta de productos por paquetes **PARA** facilitar la adquisición de mayor cantidad de productos para quien desee hacerlo.
    - ***Tipo:*** Funcional
    - ***Prioridad:*** Alta
    - ***Criterios de aceptación:*** 
    - [] El sistema debe ofrecer opciones de paquetes preconfigurados con precios especiales.
    - [] El sistema debe permitir configurar distintos tipos de paquetes con diferentes combinaciones de productos.
    - [] El sistema debe permitir seleccionar la cantidad de paquetes a comprar.
    - [] Los paquetes deben poder añadirse al carrito y ser gestionados como una única unidad.
    - ***Impacto:*** Facilita compras al por mayor y fomenta ventas más grandes.

5. **COMO** usuario **QUIERO** una interfaz intuitiva y fácil de usar **PARA** un mejor uso del sistema.
    - ***Tipo:*** Usabilidad
    - ***Prioridad:*** Alta
    - ***Criterios de aceptación:*** 
        - [] La interfaz debe seguir principios de diseño intuitivos, con menús claros y accesibles.
        - [] La interfaz debe estar optimizada para dispositivos móviles y de escritorio.
    - ***Impacto:*** Aumenta la satisfacción del usuario y reduce la curva de aprendizaje.

# Tareas

1. Realizar los diagramas necesarios (Diagrama de clases, diagramas de casos de uso).
2. Hacer los diseños de pantalla.
3. Seleccionar frameworks.
4. Crear el modelo.
5. Implementar la base de datos.
6. Implementar funciones básicas(Cátalogo de productos, compra de un producto, pago del producto).
7. Implementación de un método pago para el producto.
