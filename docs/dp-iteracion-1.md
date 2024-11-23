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
Para esta itración el diagrama de clases es:
![Diagrama de clases](https://github.com/user-attachments/assetsTiendaEcologica(DDC).jpg)

Para el diseño de este diagrama de clases utilizamos como base 3 patrones de diseños los cuales se pueden observar enmarcados en la imagen, el patrón COMPOSITE enmarcado en verde, DECORATOR enmarcado en anaranjado y STRATEGY en celeste.
1. Composite:
    En este patrón utilizamos como clase principal a la interfaz *ComponenteProducto* que define el comportamiento común para los objetos que pueden ser tratados de manera uniforme en una jerarquía de productos y paquetes. La clase *Producto* representa un artículo individual en la tienda, implementa la interfaz *ComponenteProducto* y proporciona una implementación específica de los métodos definidos, como el cálculo del precio y del peso de un producto individual. Por otro lado, la clase *Paquete* también implementa *ComponenteProducto*, permitiendo agrupar varios productos (o incluso otros paquetes) en una sola unidad.
2. Decorator:
    Tiene como interfaz principal *Descuento* que define el método *aplicarDescuento()* para aplicar diferentes tipos de descuentos a un producto o paquete. La clase *DescuentoDecorator* actúa como una clase base decoradora que sirve de intermediaria para aplicar descuentos específicos de manera flexible, Ademas hereda a las clases *DescuentoBasico*, *DescuentoTemporada* y *DescuentoVolumen* 
3. Strategy:
    La interfaces claves de este patrón son: *Pago* y *Envio*, al tener este enfoque aseguramos que el sistema sea flexible, ya que permite cambiar o agregar fácilmente métodos de pago y opciones de envío sin afectar otras partes del sistema, promoviendo la extensibilidad y manteniendo un diseño limpio.


# Wireframe y caso de uso
un boceto simple (o algunos) de cómo se verá la interfaz de usuario, acompañado de casos de uso para describir cómo interactúa el usuario con la aplicación. Similar al UML, pueden usar un software para generar el wireframe.


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
