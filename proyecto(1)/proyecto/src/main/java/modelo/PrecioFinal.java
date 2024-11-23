package modelo;

/**
 * Interfaz que define los métodos necesarios para obtener el precio final
 * y la cantidad de productos en un pedido. Esta interfaz es parte de la primera iteración
 * en el desarrollo de la aplicación web para la tienda,
 * y su implementación puede evolucionar en iteraciones futuras conforme se abance con el sistema.
 * 
 * <p>El objetivo de esta interfaz es garantizar que todas las clases que representen productos
 * o elementos dentro de un pedido puedan calcular su precio y cantidad de forma coherente.
 * </p>
 * 
 */
public interface PrecioFinal {

    /**
     * Obtiene el precio total del producto o del pedido.
     * 
     * <p>
     * Este método deberá ser implementado por las clases que representen productos o 
     * componentes de un pedido para devolver el precio total correspondiente. En la primera
     * iteración, la lógica del precio será simple y puede ser ampliada en versiones posteriores.
     * </p>
     * 
     * @return el precio total del producto o del pedido.
     */
    double getPrecio();
    /**
     * Obtiene la cantidad de productos o unidades en el pedido.
     * 
     * <p>
     * Este método deberá ser implementado por las clases que representen productos o 
     * componentes de un pedido para devolver la cantidad total correspondiente. La implementación
     * inicial es básica y puede modificarse conforme evolucionen los requisitos.
     * </p>
     * 
     * @return la cantidad de productos o unidades en el pedido.
     */
    int getCantidad();

}
