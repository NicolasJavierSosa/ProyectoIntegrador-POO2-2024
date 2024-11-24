package modelo;

import jakarta.persistence.Entity;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Decorador para aplicar descuentos a productos ecológicos.
 * 
 * La clase {@code DescuentoDecorator} implementa el patrón Decorator, permitiendo 
 * añadir funcionalidad adicional para aplicar descuentos al precio final de un producto 
 * sin modificar la estructura de la clase original.
 * 
 * La clase utiliza la interfaz {@code PrecioFinal} para interactuar 
 * con otros componentes de la aplicación.
 * 
 */
@Entity
@Getter @Setter @NoArgsConstructor
public class DescuentoDecorator implements PrecioFinal{

    /**
     * Instancia del objeto {@code PrecioFinal} que será "decorado".
     * 
     * Este campo es obligatorio y representa el onjeto al que se le aplicarán
     * los descuentos. No puede ser {@code null}.
     * 
     */
    @NotNull
    protected PrecioFinal precioFinal;

    /**
     * Constructor que inicializa el decorador con un objeto {@code PrecioFinal} 
     * @param precioFinal devuelve el objeto {@code PrecioFinal} que será decorado con descuentos.
     * @throws IllegalArgumentException si {@code precioFinal} es {@code null}
     * 
     */
    public DescuentoDecorator(PrecioFinal precioFinal){
        if(precioFinal == null){
            throw new IllegalArgumentException("Error");
        }
        else{
            this.precioFinal = precioFinal;
        }
    }

    /**
     * Getter para obtener el precio del producto, incluyenco cualquier descuento aplicado.
     * 
     * Este método delega la llamada al método {@code getPrecio()} del objeto decorado,
     * permitiendo que cualquier modificación en el precio (como un descuento) se refleje
     * en el valor devuelto.
     * 
     * @return devuelve el precio final del Producto después de aplicar el descuento
     */
    @Override
    public double getPrecio(){
        return precioFinal.getPrecio();
    }

    /**
     * Obtiene la cantidad del producto.
     * 
     * Este método delega la llamada al método {@code getCantidad()} del objeto decorado,
     * asegurando que la cantidad especificada en {@code precioFinal} se mantenga sin cambios.
     * 
     * @return devuelve la cantidad de produtos.
     */
    @Override
    public int getCantidad(){
        return precioFinal.getCantidad();
    }

}
