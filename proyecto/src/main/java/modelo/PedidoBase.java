package modelo;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotNull;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Clase base que representa los pedidos en la aplicación.
 * 
 * PedidoBase implementa la interfaz PrecioFinal, permitiendo calcular el precio 
 * y la cantidad total de un pedido. Su diseño inicial puede adaptarse conforme surjan
 * nuevos requisitos en próximas iteraciones.
 * 
 */
@Entity
@Getter @Setter @NoArgsConstructor
public class PedidoBase implements PrecioFinal{

    /**
     * Identificador único del pedido, generado automáticamente. 
     * Este campo es inmutable y no se puede actualizar una vez asignado.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Setter(AccessLevel.NONE)
    @Column(updatable = false)
    private String idDetalle;
    
    /**
     *  Cantidad de productos incluidos en el pedido. No puede ser nula.
     */
    @NotNull
    private int cantidad;
    
    /**
     * Subtotal del pedido, calculado en función de los precios de los productos seleccionados. 
     * Este valor no debe ser nulo.
     */
    @NotNull
    private Double subtotal;
    
    /**
     * Peso total de los productos en el pedido, en kilogramos 
     * Este valor es obligatorio y se usa para calcular los costos de envío.
     */
    @NotNull
    private Double pesoSubtotal;


    
    /** 
     * Devuelve el precio total del pedido.
     * 
     * Este método implementa el cálculo de precio definido en la interfaz PrecioFinal.
     * En esta primera iteración, el precio es igual al subtotal registrado.
     * 
     * @return double - el subtotal del pedido como precio total.
     */
    @Override
    public double getPrecio(){
        double x = subtotal;
        return x;
    }

    
    /** 
     * Devuelve la cantidad total de productos en el pedido.
     * 
     * Este método implementa la obtención de cantidad definida en la interfaz PrecioFinal.
     * Actualmente, devuelve la cantidad registrada en el campo cantidad.
     * 
     * @return int - la cantidad de productos en el pedido.
     */
    @Override
    public int getCantidad(){
        int x = cantidad;
        return x;
    }

}
