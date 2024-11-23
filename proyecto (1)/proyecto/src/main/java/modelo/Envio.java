package modelo;

/**
 * Interfaz que define los métodos para el cálculo del envío de los pedidos.
 * 
 * <p>
 * La interfaz {@code Envio} establece los contratos para los métodos que deben ser implementados 
 * por cualquier clase que gestione el proceso de envío de productos. Esto incluye el cálculo del 
 * tiempo estimado de entrega y el cálculo del costo de envío basado en el peso total de los productos 
 * en un pedido.
 * </p>
 * 
 */
public interface Envio {

    /**
     * Método que calcula el tiempo estimado de entrega del pedido.
     * 
     * <p>
     * Este método debe ser implementado para determinar el tiempo de entrega del pedido,
     * considerando diversos factores como la ubicación del cliente, el tipo de envío, etc.
     * </p>
     * 
     * @return devuelve un {@code String} que describe el tiempo estimado de entrega (por ejemplo, "3 días hábiles").
     * 
     */
    String tiempoEntrega();

    /**
     * Método que calcula el costo de envío basado en el peso total del pedido.
     * <p>
     * Este método calcula el costo de envío, tomando en cuenta el peso total de los productos solicitados
     * y aplicando la tarifa correspondiente. El costo podría variar en función del peso del pedido.
     * </p>
     * 
     * @param pesoTotal recibe el peso total de los productos en el pedido
     * @return devuelve el costo de envío como un valor {@code double}
     * 
     */
    double setCosto(double pesoTotal);

}
