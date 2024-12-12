# Proyecto-Integrador-POO2---2024
El presente proyecto tiene como objetivo desarrollar un sistema integral que optimice la gestión de productos y ventas en una plataforma orientada al comercio electrónico. A través de la implementación de herramientas tecnológicas avanzadas, buscamos brindar una solución que sea funcional, escalable y eficiente, respondiendo a las necesidades actuales del mercado.

**Requisitos previos**
Antes de ejecutar el proyecto, asegúrate de tener los siguientes elementos configurados en tu sistema:

**Entorno de desarrollo:**

- JDK (Java Development Kit) versión 11 o superior.

- IDE recomendado: IntelliJ IDEA, Eclipse o Visual Studio Code con soporte para Java.

**Base de datos:**

- Motor de base de datos (PostgreSQL).

- Usuario y contraseña configurados, y esquema de base de datos creado previamente.

- Para poder visualizar un catalogo, buscar productos y la función de filtrado es necesario la creación de una base de datos de nombre "TiendaEcologica", en el motor PostgreSQL.
Al momento de crear, dirigirse a Query TooL e insertar las siguientes categorias:

INSERT INTO categorias (id_categoria, nombre_categoria, descripcion_categoria, img_categoria) VALUES
(1, 'moda', 'Moda ecológica y sostenible. Ropa, accesorios y complementos.', '/imagenes/ModaEcologica.jpg'),
(2, 'decoracion', 'Decoraciones para el hogar, artículos decorativos y ornamentales.', '/imagenes/Decoraciones.jpg'),
(3, 'muebles', 'Muebles para el hogar, oficina y jardín. Variedad de estilos y materiales.', '/imagenes/Muebleria.jpg'),
(4, 'empaques', 'Soluciones de empaquetado y embalaje para envíos y almacenamiento.', '/imagenes/Empaques.jpg'),
(5, 'higiene', 'Productos de higiene personal, cuidado corporal y limpieza.', '/imagenes/HigienePersonal.jpg'),
(6, 'juguetes', 'Juguetes para niños de todas las edades, educativos y de entretenimiento.', '/imagenes/Juguetes.jpg');

Luego inserte los productos:

INSERT INTO productos (cant_disp, id, id_categoria, peso, precio, nombre, descripcion, img_producto) 
VALUES (50, 1, 5, 0.14, 1550.50, 'Cepillos de diente de bambu', 'Cepillos de diente biodegradables hechos a base de bambu', '/imagenes/producto/CepillosBambu.jpg'),
       (35, 2, 5, 0.45, 3500.70, 'Pasta dental', 'Pasta dental hecha con productos veganos y naturales', '/imagenes/producto/PastaDental.jpg'),
       (80, 3, 5, 0.37, 4000.50, 'Peine de bambu', 'Peine biodegradable hecho a base de bambu', '/imagenes/producto/peine.jpg'),
       (12, 4, 5, 0.52, 1800.99, 'Jabon Artesanal', 'Jabon artesanal hecha a base de productos veganos y naturales', '/imagenes/producto/JabónArtesanal.jpg'),
       (74, 5, 5, 0.39, 6400.84, 'Hisopos de Bambu', 'Hisopos biodegradables hechos a base de bambu', '/imagenes/producto/HisoposBambu.jpg'),
       (58, 6, 6, 1.78, 5780.10, 'Figuras de madera', 'Animales de madera que ruedan', '/imagenes/producto/juguete1.jpg'),
       (40, 7, 6, 2.45, 7000.00, 'Tabla de cuerpo humano', 'Tabla del cuerpo humanos plasmada en madera', '/imagenes/producto/juguete2.jpg'),
       (5, 8, 6, 2.12, 8400.50, 'Ta-Te-Ti', 'Ta-Te-Ti con piezas de madera', '/imagenes/producto/juguete3.jpg'),
       (36, 9, 6, 2.95, 9000.00, 'Ajedrez', 'Juego de Ajedrez con tablero y piezas de madera', '/imagenes/producto/juguete4.jpg'),
       (20, 10, 6, 2.93, 9200.40, 'Ludo', 'Juego de Ludo con tablero y piezas de madera', '/imagenes/producto/juguete5.jpg'),
       (68, 11, 4, 0.87, 1500.60, 'Empaque biodegradable para golosinas', 'Pequeños empaques biodegradables para golosinas', '/imagenes/producto/empaque1.jpg'),
       (14, 12, 4, 0.64, 950.60, 'Empaque biodegradable para alfajores', 'Pequeños empaques biodegradables para alfajores', '/imagenes/producto/empaque2.jpg'),
       (23, 13, 4, 0.46, 1400.00, 'Bolsita biodegradable', 'Bolsitas biodegradables artesanales', '/imagenes/producto/empaque3.jpg'),
       (45, 14, 4, 0.48, 2050.32, 'Bolsas reutilizables', 'Bolsas reutilizables para regalo', '/imagenes/producto/empaque4.jpg'),
       (10, 15, 4, 0.75, 3000.40, 'Empaques cilindricos biodegradables', 'Empaques cilindricos decorados artesanales biodegradables', '/imagenes/producto/empaque5.jpg'),
       (64, 16, 3, 4.01, 10050.20, 'Sillón cajón', 'Sillón destapable dentro del cual se puede guardar objetos', '/imagenes/producto/muebleria1.jpg'),
       (45, 17, 3, 5.12, 12500.20, 'Sillón', 'Sillón de madera', '/imagenes/producto/muebleria2.jpg'),
       (37, 18, 3, 6.45, 15000.00, 'Mesa decorativa', 'Mesa decorativa hecha de bambu', '/imagenes/producto/muebleria3.jpg'),
       (11, 19, 3, 2.76, 7050.00, 'Silla de playa', 'Silla biodegradable para playa', '/imagenes/producto/muebleria4.jpg'),
       (51, 20, 3, 3.78, 7500.00, 'Mesa', 'Mesa decorativa para sala', '/imagenes/producto/muebleria5.jpg'),
       (27, 21, 2, 0.75, 2000.00, 'Bowl decorativo', 'Bowl decorativo biodegradable', '/imagenes/producto/decoraciones1.jpg'),
       (5, 22, 2, 1.26, 3500.00, 'Tabla decorativa', 'Tabla decorativa con un dibujo de mariposa', '/imagenes/producto/decoraciones2.jpg'),
       (21, 23, 2, 0.23, 1000.00, 'Adornos navideños', 'Adornos navideños biodegradables', '/imagenes/producto/decoraciones4.jpg'),
       (45, 24, 2, 2.78, 7500.00, 'Espejo adornado', 'Espejo decorativo con adornos biodegradables', '/imagenes/producto/decoraciones5.jpg'),
       (10, 25, 1, 0.20, 1500.00, 'Bolsa de mano', 'Bolsas de mano', '/imagenes/producto/moda.jpg'),
       (3, 26, 1, 0.23, 700.00, 'Aritos', 'Aritos con forma de estrella', '/imagenes/producto/moda2.jpg'),
       (8, 27, 1, 0.48, 2000.00, 'Lentes de bambu', 'Lentes biodegradables hechos de bambu', '/imagenes/producto/Lentes.jpg');

**Dependencias:**
Maven

- Spring Boot.
- Hibernate.
- PostgreSQL
- Thymeleaf
  
**Herramientas adicionales:**

- Git para clonar el repositorio.

Navegador web para probar la interfaz (Google Chrome o Firefox).

Para la conexion a la base de datos usamos el puerto 8050, que es el predeterminado. 

- Se escribe en el navegador: http://localhost:8050

A partir de este punto puede utilizar las funcionalidades de la tienda. 
