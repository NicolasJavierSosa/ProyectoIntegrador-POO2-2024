# Plan tentativo
En este plan tentativo describimos las historias de usuario que se desarrollaremos en cada iteración del proyecto, el cual está orientado a construir un sistema funcional de ventas en linea que gestione productos, carritos de compra y métodos de pago. El proyecto está dividido en dos iteraciones clave, cada una con entregables específicos que permitirán alcanzar una versión mínima viable en la Iteración 1 y una funcionalidad completa en la Iteración 2. La planificación de las historias de usuario se ha realizado en función de la prioridad de cada tarea y de su dependencia en el flujo general del sistema.

Enlace a Roadmap de git:
[RoadMap-Git](https://github.com/users/NicolasJavierSosa/projects/1/views/4)

## Iteración 1
### Objetivo: 
Establecer la base de datos, conectar la aplicación con la misma y crear las interfaces básicas necesarias para el registro de usuario y la visualización de productos.

1. ***Base de Datos:***
Diseño de la base de datos: Definir y diseñar la estructura de datos que soportará las operaciones del sistema.
Creación de la base de datos: Implementar la base en el sistema de gestión de bases de datos seleccionado.
Implementación de la base de datos: Verificar que esté operativa y lista para integrarse con el sistema.

2. ***Conexión de Aplicación y Base de Datos:***
Historia: Conectar la aplicación con la base de datos para asegurar que las operaciones CRUD (Crear, Leer, Actualizar, Eliminar) funcionen correctamente en la plataforma.

3. ***Diseño de Interfaces Principales:***
Módulo de registro de usuario: Crear la interfaz para que los usuarios se puedan registrar en el sistema.
Interfaz del carrito: Diseñar una vista preliminar del carrito que muestre los productos añadidos, sus cantidades y el total de la compra.
Interfaz del catálogo: Diseñar una vista inicial del catálogo de productos para facilitar la navegación de los usuarios.
Vista del producto: Diseñar la interfaz para ver los detalles de cada producto.

4. ***Vista de Detalle del Producto:***
Implementación de la vista de detalle del producto: Permitir que el usuario acceda a información específica de cada producto.


## Iteración 2
### Objetivo
Finalizar la funcionalidad del carrito, implementar métodos de pago, y agregar funcionalidades de búsqueda y filtros en el catálogo y añadir las funcinalidades de control de inventario

1. ***Gestión de Inventario:***
Historia: Configurar el almacenamiento y actualización de datos del inventario para asegurar que la información sobre productos esté siempre actualizada.

2. ***Interfaz Completa del Catálogo:***
Desarrollar la interfaz del catálogo: Incluir imágenes, precios, y descripciones completas para cada producto en el catálogo, mejorando la experiencia de navegación.

3. ***Registro de Compras Realizadas:***
Crear vista de historial de compras: Permitir a los usuarios revisar compras pasadas.

4. ***Funcionalidades Avanzadas del Carrito:***
Lógica del carrito: Crear las funciones necesarias para agregar, eliminar y modificar cantidades de productos.
Cálculo automático de totales: Implementar la lógica para calcular el total automáticamente en base a los productos en el carrito.
Aplicación de descuentos: Configurar descuentos automáticos según promociones.
Botón de pago: Añadir un botón para proceder al pago desde el carrito.

5. ***Métodos de Pago:***
Configurar opciones de pago: Permitir pagos mediante transferencia bancaria, tarjetas de débito y crédito.

6. ***Filtros y Búsqueda en el Catálogo:***
Lógica de búsqueda en tiempo real: Permitir búsqueda de productos por nombre.
Filtros para precio, categoría y disponibilidad: Añadir opciones de filtro para mejorar la navegación.
Filtros por categorías: Facilitar la organización de productos en el catálogo mediante categorías.
