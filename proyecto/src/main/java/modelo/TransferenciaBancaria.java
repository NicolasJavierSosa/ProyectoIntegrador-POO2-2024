package modelo;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter @NoArgsConstructor
public class TransferenciaBancaria implements Pago{

    @Override
    public String procesarPago(double monto){
        return "El pago fue procesado con exito por transferencia bancaria";
    }

}
