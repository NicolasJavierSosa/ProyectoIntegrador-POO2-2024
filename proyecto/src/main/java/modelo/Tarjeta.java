package modelo;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter @NoArgsConstructor
public class Tarjeta implements Pago{

    @Override
    public String procesarPago(double monto){
        return "El pago fue procesado con exito con su tarjeta";
    }

}
