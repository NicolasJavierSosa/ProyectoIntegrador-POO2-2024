package modelo;

import java.util.ArrayList;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Representa un paquete de productos, que puede estar compuesto por múltiples elementos que 
 * implementan la interfaz {@link ComponenteProducto}. Esta clase permite obtener el precio y 
 * peso total de los productos contenidos y aplicar descuentos.
 * 
 * Esta clase es parte de la aplicación de tienda de productos ecológicos y está diseñada para 
 * ser extensible en futuras iteraciones.
 * 
 */

@Entity
@Table(name = "paquetes")
@Getter @Setter @NoArgsConstructor
public class Paquete implements ComponenteProducto{

    /** Identificador único del paquete, generado automáticamente. */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Setter(AccessLevel.NONE)
    @Column(updatable = false)
    private String idPaquete;
    
    /** Lista de elementos que conforman el paquete */
    @NotNull
    @OneToMany(mappedBy = "productos")
    private ArrayList<ComponenteProducto> elementos;

    
    /** 
     *  Calcula el precio total del paquete sumando los precios de cada elemento en el paquete.
     * 
     * @return double - El precio total del paquete.
     */
    @Override
    public double getPrecio(){
        double precio = 0;
        for(int i = 0; i <= elementos.size(); i++){
            precio += elementos.get(i).getPrecio();
        }
        return precio;
    }

    
    /** 
     * Calcula el peso total del paquete sumando el peso de cada elemento en el paquete.
     * 
     * @return double - El peso total del paquete
     */
    @Override
    public double getPeso(){
        double peso = 0;
        for(int i = 0; i <= elementos.size(); i++){
            peso += elementos.get(i).getPeso();
        }
        return peso;
    }

    /**
     * Aplica un descuento al precio total del paquete.
     * 
     * @param descuento el porcentaje de descuento a aplicar. Debe estar entre 0 y 100.
     * @return el precio total del paquete después de aplicar el descuento.
     * 
     */
    @Override
    public double aplicarDescuento(double descuento){
        return descuento;
    }

}
