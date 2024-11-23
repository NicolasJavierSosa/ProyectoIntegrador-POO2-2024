package modelo;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Representa los detalles de un pedido realizado en la tienda
 * 
 * La clase {@code DetallePedido} contien la información sobre las cantidades de los productos
 * específicos en un pedido, el subtotal del precio de los productos y el peso total de los productos
 * solicitados. Esta clase está asociada a la entidad {@code Pedido}, proporcionando una estructura
 * detallada del contenido de cada pedido realizado por el cliente.
 * 
 * 
 */
@Entity
@Table(name = "detalles_pedido")
@Getter @Setter @NoArgsConstructor
public class DetallePedido {

    /**
     * Identificador único para cada detalle de pedido.
     * 
     * Este campo se genera automáticamente como un identificador único para cada detalle 
     * de pedido y no se puede modificar después de la creación.
     * 
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Setter(AccessLevel.NONE)
    @Column(updatable = false)
    private String idDetalle;
    
    /**
     * Cantidad de productos solicitados en este detalle de pedido.
     * 
     * Este campo es obligatorio y representa la cantidad de productos de un tipo específico
     * que el cliente ha solicitado en el pedido.
     * 
     */
    @NotNull
    private int cantidad;
    
    /**
     * Subtotal del precio de los productos en este detalle de pedido.
     * 
     * Este campo es obligatorio y representa el valor total de los productos solicitados
     * en este detalle, calculado como la cantidad por el precio unitario de cada producto.
     * 
     */
    @NotNull
    private Double subtotal;
    
    /**
     * Subtotal del peso de los productos en este detalle de pedido.
     * 
     * Este campo es obligatorio y representa el peso total de los productos solicitados
     * en este detalle, calculado como la cantidad por el peso unitario de cada producto.
     * 
     */
    @NotNull
    private Double pesoSubtotal;

}
