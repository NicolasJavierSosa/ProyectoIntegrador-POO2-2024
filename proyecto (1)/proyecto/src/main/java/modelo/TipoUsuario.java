package modelo;

/**
 * Enum que representa los diferentes tipos de usuarios en la tienda de productos ecológicos.
 * Este enum se utiliza para diferenciar entre los distintos roles de usuario en el sistema,
 * permitiendo gestionar permisos y funcionalidades específicas para cada tipo de usuario.
 * 
 * <p>
 * En esta primera iteración del proyecto, se implementan dos tipos de usuarios:
 *  1. {@link TipoUsuario#CLIENTE} - Un usuario que realiza compras en la tienda.
 *  2. {@link TipoUsuario#ADMINISTRADOR} - Un usuario con privilegios para gestionar los productos,
 *    procesar pedidos y administrar la tienda.
 * </p>
 * 
 * <p>
 * Este enum podrá ser ampliado en futuras iteraciones si se requiere la inclusión de otros tipos de usuarios
 * o roles adicionales, como personal de soporte, vendedores, etc.
 * </p>
 * 
 */
public enum TipoUsuario {

    /**
     * Representa a un cliente que realiza compras en la tienda.
     */
    CLIENTE, 
    /**
     * Representa a un administrador con permisos para gestionar productos, pedidos y usuarios.
     */
    ADMINISTRADOR

}
