package modelo;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Clase que implementa la interfaz {@link Pago} para procesar pagos mediante transferencia bancaria.
 * 
 * Esta clase es parte del sistema de pagos de la tienda y representa
 * un método de pago en el cual el monto se transfiere desde la cuenta bancaria del cliente
 * a la cuenta de la tienda. El proceso de pago con transferencia bancaria es confirmado
 * con un mensaje de éxito.
 * 
 *  En futuras iteraciones, se pueden agregar más detalles sobre la validación de la transferencia,
 * la integración con APIs bancarias o la gestión de posibles errores en el proceso de pago.
 * 
 * @see Pago
 */
@Entity
@Getter @Setter @NoArgsConstructor
public class TransferenciaBancaria implements Pago{

    /** 
     * Procesa el pago de una compra mediante transferencia bancaria.
     * 
     * @param monto El monto total de la compra a ser pagado mediante transferencia bancaria.
     * @return String - Un mensaje que indica que el pago fue procesado con éxito.
     * 
     */
    @Override
    public String procesarPago(double monto){
        return "El pago fue procesado con exito por transferencia bancaria";
    }

}
