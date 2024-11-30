package modelo;

import java.time.LocalDateTime;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter @NoArgsConstructor
public class DescuentoTemporada extends DescuentoDecorator{

    @NotNull
    LocalDateTime fechaInicio;
    @NotNull
    LocalDateTime fechaFin;
    @NotNull
    double descuento = 20;


    public DescuentoTemporada(PrecioFinal precioFinal){
        super(precioFinal);
    }

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
