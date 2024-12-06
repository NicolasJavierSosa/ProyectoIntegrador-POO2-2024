package modelo;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter @NoArgsConstructor
public class DescuentoDecorator implements PrecioFinal{

    @NotNull
    protected PrecioFinal precioFinal;


    public DescuentoDecorator(PrecioFinal precioFinal){
        if(precioFinal == null){
            throw new IllegalArgumentException("Error");
        }
        else{
            this.precioFinal = precioFinal;
        }
    }

    @Override
    public double getPrecio(){
        return precioFinal.getPrecio();
    }

    @Override
    public int getCantidad(){
        return precioFinal.getCantidad();
    }

    @Override
    public double getPeso(){
        return precioFinal.getPeso();
    }

}
