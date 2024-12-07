package modelo;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter @NoArgsConstructor
public class DescuentoVolumen extends DescuentoDecorator{

    @NotNull
    private int cantidadMinima = 5;
    @NotNull
    private double descuento = 15;


    public DescuentoVolumen(PrecioFinal precioFinal){
        super(precioFinal);
    }

    @Override
    public double getPrecio(){
        if(precioFinal.getCantidad() < cantidadMinima){
            throw new IllegalArgumentException("La cantidad comprada no es la minima para aplicar dicho descuento");
        }
        else{
            return precioFinal.getPrecio() - ((precioFinal.getPrecio() * descuento) / 100);
        }
    }

    public double getDescuento(){
        return ((precioFinal.getPrecio() * descuento) / 100);
    }

}
