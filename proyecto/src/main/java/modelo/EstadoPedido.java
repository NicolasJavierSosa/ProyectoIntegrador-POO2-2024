package modelo;

/**
 * Representa el estado de un pedido en el sistema de la tienda de productos ecológicos.
 * 
 * La enumeración {@code EstadoPedido} define los posibles estados por los que puede pasar
 * un pedido desde que se genera hasta que es entregado al cliente. Esto permite realizar un
 * seguimiento del pedido en cada fase del proceso de entrega.
 * 
 */
public enum EstadoPedido {
    /**
     * Estado para un pedido que aún no ha sido entregado ni está en tránsito.
     */
    SIN_ENTREGAR, 
    
    /**
     * Estado para un pedido que está en tránsito hacia su destino.
     */
    EN_CAMINO, 
    
    /**
     * Estado para un pedido que ya ha sido entregado al cliente.
     */
    ENTREGADO

}
