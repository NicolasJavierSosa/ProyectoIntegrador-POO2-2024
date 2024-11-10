# Especificación de requisitos de software

## Enunciado del problema

Actualmente los consumidores de productos ecológicos de la tienda enfrentan limitaciones de accesibilidad a los productos. El software es necesario, ya que sin el los clientes deben acudir físicamente a las tiendas para ver el catálogo completo y realizar sus compras.

La falta de automatización en el registro de entrada y salida de productos en el inventario de la empresa implica un disminucion en la eficiencia de la gestión. La implementación de un software agilizará este proceso, reducira errores y permitirá que el personal se enfoque en otras tareas estratégicas.

La falta de una aplicación moderna limita el alcance del mercado que puede llegar a abarcar la empresa. La implementación de un sistema infórmatico puede ayudar a incrementar su prestigio y alcance, así como la percepción del cliente sobre la calidad de la organización.

La falta de la automatización a la hora de aplicar descuentos da lugar a que se generen errores humanos, dando una mala imagen a la empresa. Nuestro software busca resolver dicho problema permitiendo que el sistema automatice el cálculo de descuentos. 

La falta de un control de inventario en tiempo real provoca dificultad a la hora de conocer la cantidad de unidades disponibles de un producto a la hora de realizarse ventas, representando un problema tanto para los clientes como para la organización. La implementación del software es necesaria para proveer precisión en dicha operación.

## Clientes potenciales

Los problemas existentes actualmente que se buscan resolver afectan a:
- La gerencia de la organización
- Los empleados del área de venta y logística de la organización
- Los clientes de la tienda

## Solución propuesta 

El sistema permitirá a los clientes explorar el catálogo de productos ecológicos desde cualquier dispositivo con conexión a internet, eliminando la necesidad de visitas presenciales y brindando una experiencia de compra cómoda y accesible.

Mediante la gestión automatizada de inventario, el software controlará en tiempo real la entrada y salida de productos, minimizando errores y optimizando el abastecimiento. Esto reducirá significativamente el tiempo y esfuerzo requeridos para el control de stock, mejorando la eficiencia operativa.

El software permitirá a los clientes elegir entre varios métodos de pago, como tarjetas o transferencias, brindando flexibilidad y facilitando el cierre de ventas al adaptarse a las preferencias de los clientes.

El sistema calculará automáticamente los precios con descuentos aplicables y gestionará la venta de productos en paquetes, lo que permitirá a la empresa realizar ofertas personalizadas y mejorar su atractivo para clientes que buscan comprar al por mayor, incrementando así las ventas.

Al facilitar el acceso en línea y mejorar la experiencia de compra, la empresa podrá atraer nuevos clientes, promoviendo una expansión en el alcance del negocio.

Con una plataforma de ventas en línea bien estructurada y eficiente, la empresa reforzará su imagen de marca como un proveedor moderno y profesional de productos ecológicos, aumentando su prestigio en el mercado.

## Requisitos

### Requisitos Funcionales
1. **COMO** organización **QUIERO** un sistema de gestión de ventas **PARA** gestionar la venta de productos ecológicos.
    - ***Tipo:*** Funcional
    - ***Prioridad:*** Alta
    - ***Criterios de aceptación:*** El sistema debe permitir el registro de productos, gestionar inventario, y registrar transacciones.
    - ***Impacto:*** Facilita la operación general del negocio y la gestión de inventario.

2. **COMO** usuario **QUIERO** que se vea un catálogo de los productos disponibles en la página/aplicación **PARA** tener una vista general de lo disponible.
    - ***Tipo:*** Funcional
    - ***Prioridad:*** Alta
    - ***Criterios de aceptación:*** El catálogo debe mostrar imágenes, precios, y descripciones de los productos.
    - ***Impacto:*** Mejora la experiencia de los usuarios al facilitar la navegación y la selección de productos.

3. **COMO** cliente **QUIERO** disponer de un carrito de compras **PARA** la organización de mis compras.
    - ***Tipo:*** Funcional
    - ***Prioridad:*** Alta
    - ***Criterios de aceptación:*** El carrito debe permitir agregar, eliminar y modificar la cantidad de productos.
    - ***Impacto:*** Mejora la conveniencia de los clientes durante el proceso de compra.

4. **COMO** usuario **QUIERO** disponer de múltiples formas de pago **PARA** la adquisición de productos.
    - ***Tipo:*** Funcional
    - ***Prioridad:*** Media
    - ***Criterios de aceptación:*** El sistema debe aceptar realizar pagos con tarjetas de crédito, débito y transferencias.
    - ***Impacto:*** Incrementa la accesibilidad y conveniencia para clientes de distintos perfiles.

5. **COMO** gerente **QUIERO** una alerta de stock mínimo **PARA** no quedarme sin stock.
    - ***Tipo:*** Funcional
    - ***Prioridad:*** Baja
    - ***Criterios de aceptación:*** El sistema debe enviar una alerta al gerente cuando el stock de un producto alcance el umbral mínimo.
    - ***Impacto:*** Evita el agotamiento de inventario, asegurando disponibilidad constante de productos.

6. **COMO** cliente **QUIERO** que los productos se separen por categorías **PARA** poder encontrar de manera rápida y sencilla lo que busco en la tienda online.
    - ***Tipo:*** Funcional
    - ***Prioridad:*** Baja
    - ***Criterios de aceptación:*** Los productos deben clasificarse en categorías como alimentos, ropa, productos reutilizables, etc.
    - ***Impacto:*** Facilita la navegación en la tienda y mejora la experiencia de compra.

7. **COMO** usuario **QUIERO** un buscador de productos por nombre **PARA** hacer búsquedas específicas mucho más rápido.
    - ***Tipo:*** Funcional
    - ***Prioridad:*** Media
    - ***Criterios de aceptación:*** El buscador debe permitir búsqueda por nombre de producto y mostrar resultados instantáneamente.
    - ***Impacto:*** Aumenta la eficiencia en la localización de productos específicos.

8. **COMO** usuario **QUIERO** poseer filtros en el buscador **PARA** obtener conjuntos de productos con ciertas características.
    - ***Tipo:*** Funcional
    - ***Prioridad:*** Baja
    - ***Criterios de aceptación:*** El sistema debe permitir filtrar productos por precio, categoría y disponibilidad.
    - ***Impacto:*** Mejora la personalización y precisión de la búsqueda para los usuarios.

9. **COMO** gerente **QUIERO** que la aplicación de descuentos a productos esté automatizada **PARA** optimizar el proceso de cobro.
    - ***Tipo:*** Funcional
    - ***Prioridad:*** Media
    - ***Criterios de aceptación:*** El sistema debe aplicar automáticamente los descuentos configurados a los productos en el carrito.
    - ***Impacto:*** Optimiza el proceso de ventas y facilita la gestión de promociones.

10. **COMO** gerente **QUIERO** posibilitar la venta de productos por paquetes **PARA** facilitar la adquisición de mayor cantidad de productos para quien desee hacerlo.
    - ***Tipo:*** Funcional
    - ***Prioridad:*** Alta
    - ***Criterios de aceptación:*** El sistema debe ofrecer opciones de paquetes preconfigurados con precios especiales.
    - ***Impacto:*** Facilita compras al por mayor y fomenta ventas más grandes.

11. **COMO** gerente **QUIERO** poder designar qué productos aparecerán en el catálogo **PARA** alterar la disposición de los productos.
    - ***Tipo:*** Funcional
    - ***Prioridad:*** Baja
    - ***Criterios de aceptación:*** El sistema debe permitir al gerente marcar ciertos productos para que aparezcan destacados o en una posición específica.
    - ***Impacto:*** Permite un control sobre la visibilidad de productos para estrategias de venta específicas.

### Requisitos No funcionles
12. **COMO** usuario **QUIERO** una interfaz intuitiva y fácil de usar **PARA** un mejor uso del sistema.
    - ***Tipo:*** Usabilidad
    - ***Prioridad:*** Alta
    - ***Criterios de aceptación:*** La interfaz debe seguir principios de diseño intuitivos, con menús claros y accesibles.
    - ***Impacto:*** Aumenta la satisfacción del usuario y reduce la curva de aprendizaje.

13. **COMO** usuario **QUIERO** que el sistema sea seguro al momento de realizar pagos **PARA** tener la tranquilidad de que los datos están protegidos y las compras son confiables
    - ***Tipo:*** No funcional (seguridad y accesibilidad)
    - ***Prioridad:*** Alta
    - ***Críterios de aceptación:*** 
        - El sistema debe integrar métodos de pago que cumpla con estándares de seguricad, como PCI-DSS.
        - La información de pago debe procesarse en un entorno seguro sin almacenar datos sensibles en el sistema.
    - ***Impacto:*** Aumenta la confianza y seguridad del usuario al realizar pagos, al mismo tiempo que mejora la accesibilidad mediante opciones de pago diversificadas y seguras.

## Arquitectura de software
### Tipo de aplicación:
Será una aplicación web, lo que permitirá su acceso desde cualquier dispositivo con navegador, facilitando su uso tanto en entornos de oficina como en movilidad.

### Arquitectura del software:
La aplicación además seguira una arquitectura Cliente-Servidor. En este modelo:
- El cliente estará representado por la interfaz de usuario que se desarrollará con HTML, CSS y JavaScript, posiblemente utilizando un framework de frontend para mejorar la experiencia y la interactividad del usuario.
- El servidor alojará la lógica de negocio y los servicios de backend desarrollados en Java utilizando Spring Boot para gestionar peticiones, transacciones y seguridad, y PostgreSQL como sistema de gestión de bases de datos relacional.

### Lenguaje de programación y frameworks:
#### Backend: 
Se utilizará Java junto con el framework Spring Boot para la creación de la API y la gestión de la lógica de negocio, seguridad y conexión a la base de datos.

#### Frontend:
El cliente se desarrollará usando HTML para la estructura de las páginas, junto con CSS y JavaScript para la presentación y la interactividad.

### Base de Datos:
Se utilizará PostgreSQL como sistema de gestión de bases de datos relacional. PostgreSQL es una opción robusta que soporta transacciones y permite gestionar los datos de manera eficiente.