package modelo;

import jakarta.persistence.Entity;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Decorador que aplica un descuento por volumen a un producto.
 * 
 * La clase {@code DescuentoVolumen} extiende {@code DescuentoDecorator} para aplicar 
 * un descuento porcentual cuando la cantidad de productos adquiridos supera un umbral 
 * mínimo definido. Este descuento solo se aplica si la cantidad comprada es mayor o 
 * igual a la cantidad mínima especificada.
 *
 * 
*/
@Entity
@Getter @Setter @NoArgsConstructor
public class DescuentoVolumen extends DescuentoDecorator{

    /**
     * Cantidad mínima de productos a comprar para que el descuento se aplique.
     * 
     * Este valor es obligatorio y define la cantidad mínima de productos 
     * que el cliente debe adquirir para obtener el descuento por volumen.
     *
    */
    @NotNull
    private int cantidadMinima = 5;

    /**
     * Porcentaje de descuento a aplicar si se cumple con la cantidad mínima de productos.
     * 
     * El valor por defecto añadido para la primer iteración es del 15% y se aplica sobre el precio total si 
     * la cantidad de productos supera o iguala la cantidad mínima.
     *
    */
    @NotNull
    private double descuento = 15;


    /**
     * Constructor que inicializa el descuento por volumen con el precio base.
     * @param precioFinal el objeto {@code PrecioFinal} al que se le 
     * aplicará el descuento por volumen
    */
    public DescuentoVolumen(PrecioFinal precioFinal){
        super(precioFinal);
    }

    /**
     * Calcula el precio del producto con el descuento por volumen aplicado.
     * 
     * Este método verifica si la cantidad de productos adquiridos es mayor o 
     * igual a la cantidad mínima definida. Si es así, aplica el descuento 
     * porcentual sobre el precio del producto. Si no, lanza una excepción.
     * 
     * @return devuelve el precio del producto después de aplicar el descuento por volumen
     * @throws IllegalArgumentException si la cantidad comprada es menor que la 
     * cantidad mínima definida para aplicar el descuento.
     *
    */
    @Override
    public double getPrecio(){
        if(precioFinal.getCantidad() < cantidadMinima){
            throw new IllegalArgumentException("La cantidad comprada no es la minima para aplicar dicho descuento");
        }
        else{
            return precioFinal.getPrecio() - ((precioFinal.getPrecio() * descuento) / 100);
        }
    }

}
