package modelo;
/** 
 * Interfaz que representa un paquete de productos o unproducto en la tienda
 * 
 * <p>
 * La interfaz {@code ComponenteProducto} define el comportamiento básico para
 *los objetos que pueden ser tratados de manera uniforme en una jerarquía de productos y paquetes, 
 especificando métodos para obtener el precio y peso del componente, así como para aplicar un descuento.
 * </p>
 * 
 * <p>
 * Esta interfaz permite una estructura flexible que facilita la implementación
 * de diferentes tipos de productos en futuras iteraciones. Las clases que implementen 
 * esta interfaz deberán definir cómo calcular el precio, el peso y aplicar 
 * descuentos específicos a cada componente.
 * </p>
 */
public interface ComponenteProducto {

    /**
     * Obtiene el precio del componente ya sea un producto o un paquete.
     * @return devuelve el precio del componente.
     */
    double getPrecio();
    
    /**
     * Obtiene el peso de un componente
     * @return devuelve el peso del componente
     */
    double getPeso();

    /**
     * Aplica un descuento al precio del componente.
     * 
     * <p>
     * Este método permite aplicar un descuento específico al precio del componente.
     * En la segunda iteración se definiremos cómo se aplicará el descuento y nos aseguraremos que 
     * el precio resultante sea razonable (por ejemplo, no negativo).
     * </p>
     * 
     * @param descuento Es el procentaje a aplicar, representado en un valor decimal (por ejemplo, para aplicar un descuento del 10% sería 0.10)
     * @return devuelve el nuev precio del componente después de aplicar el decuento.
     */
    double aplicarDescuento(double descuento);

}
