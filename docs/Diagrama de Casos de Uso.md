# Descripción del Diagrama de Casos de Uso

## Introducción
El [Diagrama de Casos de Uso](https://github.com/NicolasJavierSosa/ProyectoIntegrador-POO2-2024/blob/main/Imagenes/Tienda%20Ecol%C3%B3gica%20-%20DCU%20.jpg) representa un **Sistema** que interactúa con dos tipos de actores principales: **Cliente** y **Administrador**. Cada actor tiene acceso a diferentes funcionalidades, organizadas como casos de uso. Además, se emplean relaciones de **<<include>>** y **<<extend>>** para detallar dependencias o extensiones entre los casos de uso.

---

## Actores

1. **Cliente**:
   - Usuario que accede al sistema para realizar compras, buscar productos, organizar pedidos y gestionar pagos.

2. **Administrador**:
   - Encargado de gestionar el catálogo de productos, crear paquetes, asignar descuentos y monitorear el stock.

---

## Casos de Uso del Cliente

1. **Visualizar Catálogo**:
   - Permite al cliente navegar por la lista completa de productos disponibles en el sistema.

2. **Buscar Producto**:
   - Proporciona una herramienta para localizar productos específicos en el catálogo.

3. **Filtrar Búsqueda**:
   - Extiende "Buscar Producto". Ofrece funcionalidades avanzadas para refinar resultados de búsqueda.

4. **Filtrar por Categoría**:
   - Extiende "Filtrar Búsqueda". Permite clasificar los productos según categorías específicas.

5. **Filtrar por Criterios**:
   - Extiende "Filtrar Búsqueda". Ofrece opciones adicionales como rango de precio, marca u otros atributos relevantes.

6. **Pagar Producto**:
   - Representa el proceso de completar el pago de un producto seleccionado.

   - **Pagos específicos (<<include>>)**:
     - **Pagar con Transferencia**: Permite realizar el pago mediante transferencia bancaria.
     - **Pagar con MercadoPago**: Opción para usar esta plataforma de pago.
     - **Pagar con Tarjeta**: Habilita el uso de tarjetas de crédito/débito.

7. **Organizar Compras**:
   - Ayuda al cliente a planificar y gestionar sus compras.

8. **Consultar Pedido**:
   - Permite al cliente verificar el estado de sus pedidos previos.

---

## Casos de Uso del Administrador

1. **Agregar Productos**:
   - Permite introducir nuevos productos en el catálogo del sistema.

2. **Agregar Paquetes**:
   - Habilita la creación de paquetes de productos (por ejemplo, combos o promociones).

3. **Designar por Intervalos de Tiempo**:
   - Extiende "Agregar Paquetes". Permite establecer vigencia de los paquetes en función del tiempo.

4. **Designar por Cantidad**:
   - Extiende "Agregar Paquetes". Los paquetes pueden configurarse según límites de cantidad.

5. **Automatizar Descuentos**:
   - Caso relacionado con la automatización de descuentos promocionales, incluyendo criterios predefinidos.

6. **Designar Productos**:
   - Permite seleccionar o asociar productos específicos a los paquetes o promociones.

7. **Modificar Productos**:
   - Habilita la edición de las propiedades de productos existentes.

8. **Modificar Paquetes**:
   - Permite realizar ajustes en los paquetes previamente configurados.

9. **Alertar Stock**:
   - Función que notifica al administrador cuando el inventario de productos alcanza niveles bajos.

---

## Relaciones entre los Casos de Uso

- **<<include>>**:
   - Representa la obligatoriedad de un caso de uso dentro de otro.
   - Ejemplo: "Pagar Producto" incluye métodos específicos de pago como "Pagar con Tarjeta".

- **<<extend>>**:
   - Representa casos opcionales o variantes de un caso base.
   - Ejemplo: "Filtrar por Categoría" extiende "Filtrar Búsqueda" añadiendo una opción más específica.


