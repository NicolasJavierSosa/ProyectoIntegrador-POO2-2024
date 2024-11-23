package modelo;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Clase que representa un producto en la tienda.
 * 
 * <p>
 * La clase implementa la interfaz {@link ComponenteProducto} para garantizar que todos
 * los productos y componentes puedan obtener sus precios, pesos y aplicar descuentos
 * de manera uniforme dentro del sistema.
 * </p>
 * 
 * <p>
 * Este modelo está diseñado para ser extendido en futuras iteraciones, considerando
 * la posibilidad de agregar más atributos y funcionalidades relacionadas con la gestión
 * de productos.
 * </p>
 * 
 */
@Entity
@Table(name = "productos")
@Getter @Setter @NoArgsConstructor
public class Producto implements ComponenteProducto{

    /**
     * Identificador único del producto.
     * Se genera automáticamente cuando se guarda un nuevo producto en la base de datos.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Setter(AccessLevel.NONE)
    @Column(updatable = false)
    private String idProducto;
    
    /**
     * Nombre del producto. No puede ser nulo ni estar en blanco. Debe tener entre 10 y 20 caracteres.
     */
    @NotBlank
    @Size(min = 10, max = 20)
    @Column(nullable = false, length = 20)
    private String nombre;
    
    /**
     * Descripción del producto. Debe tener entre 10 y 50 caracteres.
     */
    @Size(min = 10, max = 50)
    @Column(nullable = false, length = 50)
    private String descripcion;
    
    /**
     * Precio del producto. No puede ser nulo.
     */
    @NotNull
    private double precio;
    
    /**
     * Peso del producto. No puede ser nulo.
     */
    @NotNull
    private double peso;


    
    /** 
     * Obtiene el precio del producto.
     * 
     * <p>
     * Este método devuelve el precio unitario del producto, que es almacenado en la base de datos.
     * En la primera iteración, el cálculo de precios es directo y no tiene en cuenta descuentos u otras
     * modificaciones. Este método será expandido en futuras iteraciones para incluir descuentos u
     * otras consideraciones.</p>
     * @return double - el precio del producto.
     */
    @Override
    public double getPrecio(){
        double x = precio;
        return x;
    }

    
    /** 
     * Obtiene el peso del producto.
     * 
     * <p>
     * Este método devuelve el peso unitario del producto, que es utilizado para calcular
     * los costos de envío y otros aspectos logísticos dentro de la tienda.
     * </p>
     * 
     * @return double - el peso del producto.
     */
    @Override
    public double getPeso(){
        double x = peso;
        return x;
    }

    
    /** 
     * Aplica un descuento al precio del producto.
     * 
     * <p>
     * Este método es un punto de expansión para futuras iteraciones. Actualmente, el descuento
     * no afecta el precio, pero se ha diseñado para que en el futuro pueda implementar la lógica de 
     * aplicar descuentos según reglas de negocio, como descuentos por volumen, temporada, etc.
     * </p>
     * 
     * @param descuento Es el porcentaje de descuento a aplicar.
     * @return double - el descuento aplicado (actualmente solo devuelve el valor del descuento).
     */
    @Override
    public double aplicarDescuento(double descuento){
        return descuento;
    }

}
