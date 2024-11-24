package modelo;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Decorador que aplica un descuento temporal a un producto.
 * 
 * La clase {@code DescuentoTemporada} extiende {@code DescuentoDecorator} para
 * aplicar un descuento porcentual durante un periodo de tiempo específico.
 * Este descuento solo es aplicable cuando la fecha actual se encuentra dentro 
 * del rango definido por {@code fechaInicio} y {@code fechaFin}.
 * 
 */
@Entity
@Getter @Setter @NoArgsConstructor
public class DescuentoTemporada extends DescuentoDecorator{

    /**
     * Fecha de inicio del descuento de temporada.
     * 
     * Este valor es obligatorio y define el inicio del periodo en el que 
     * el descuento será válido. 
     * 
     */
    @NotNull
    LocalDateTime fechaInicio;

    /**
     * Fecha de finalización del descuento de temporada.
     * 
     * Este valor es obligatorio y define el fin del periodo en el que 
     * el descuento será válido.
     * 
     */
    @NotNull
    LocalDateTime fechaFin;
    
    /**
     * Porcentaje de descuento a aplicar durante la temporada.
     * 
     * El valor por defecto asignada para esta primer iteración es del 20% 
     * y representa la reducción en el precio del producto durante el periodo de descuento.
     * 
     */
    @NotNull
    double descuento = 20;

    /**
     * Constructor que inicializa el descuento de temporada con el precio base.
     * 
     * @param precioFinal el objeto {@code PrecioFinal} al que se le aplicará el
     * descuento de temporada
     */
    public DescuentoTemporada(PrecioFinal precioFinal){
        super(precioFinal);
    }

    /** 
     * Calcula el precio del producto con el descuento de temporada aplicado.
     * 
     * Este método verifica si la fecha actual está dentro del rango de validez
     * del descuento (entre {@code fechaInicio} y {@code fechaFin}). Si es así,
     * aplica el descuento porcentual al precio del producto. Si la fecha no está
     * dentro del rango válido, lanza una excepción.
     * 
     * @return double devuelve el precio del producto después de aplicar el descuento de temporada
     * @throws IllegalArgumentException si la fecha actual no está dentro del 
     * periodo de validez del descuento
     * 
     */
    @Override
    public double getPrecio(){
        if(LocalDateTime.now().isBefore(fechaInicio) && LocalDateTime.now().isAfter(fechaFin)){
            throw new IllegalArgumentException("No nos encontramos en la fecha de la promocion");
        }
        else{
            return precioFinal.getPrecio() - ((precioFinal.getPrecio() * descuento) / 100);
        }
    }

}
