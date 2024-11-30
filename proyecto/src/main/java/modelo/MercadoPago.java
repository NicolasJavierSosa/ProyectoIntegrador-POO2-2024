package modelo;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter @NoArgsConstructor
public class MercadoPago implements Pago{

    @Override
    public String procesarPago(double monto){
        return "El pago fue procesado con exito por Mercado Pago";
    }

}
