package modelo;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Clase que representa un método de pago utilizando tarjeta.
 * Esta clase implementa la interfaz {@link Pago} para garantizar que todos los métodos de pago
 * compartan una estructura común, permitiendo que sean fácilmente integrados en el sistema de pagos
 * de la tienda.
 * 
 * <p>
 * En esta primera iteración del proyecto, se implementa el pago mediante tarjeta con un proceso
 * simple que solo confirma el pago, sin integración con sistemas de pago externos. Se prevé que en
 * futuras iteraciones se agregue más funcionalidad, como la validación de tarjetas y la integración
 * con proveedores de pagos.</p>
 */
@Entity
@Getter @Setter @NoArgsConstructor
public class Tarjeta implements Pago{


    
    /** 
     * Procesa el pago utilizando la tarjeta de crédito o débito del cliente.
     * 
     * <p>
     * Este método simula el procesamiento del pago y devuelve un mensaje indicando que el pago
     * fue procesado con éxito. En futuras iteraciones, este método puede integrarse con un sistema
     * de pagos real para verificar la transacción y procesar el pago.
     * </p>
     * 
     * @param monto El monto a pagar.
     * @return String - Un mensaje indicando que el pago fue procesado con éxito.
     */
    @Override
    public String procesarPago(double monto){
        return "El pago fue procesado con exito con su tarjeta";
    }

}
