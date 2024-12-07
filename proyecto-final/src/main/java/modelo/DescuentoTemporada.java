package modelo;

import java.time.LocalDateTime;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter @NoArgsConstructor
public class DescuentoTemporada extends DescuentoDecorator{

    @NotNull
    int añoActual = LocalDateTime.now().getYear();
    @NotNull
    LocalDateTime fechaInicio = LocalDateTime.of(añoActual, 12, 1, 0, 0);
    @NotNull
    LocalDateTime fechaFin = LocalDateTime.of(añoActual + 1, 1, 10, 23, 59);
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

    public double getDescuento(){
        return ((precioFinal.getPrecio() * descuento) / 100);
    }

}
