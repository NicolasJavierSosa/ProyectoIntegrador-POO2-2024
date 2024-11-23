package modelo;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Implementación del método de pago a través de Mercado Pago.
 * 
 * La clase {@code MercadoPago} implementa la interfaz {@code Pago} y permite procesar pagos
 * mediante la plataforma de Mercado Pago. Este es uno de los métodos de pago que la aplicación
 * de la tienda de productos ecológicos ofrece a los clientes.
 * 
 * En esta primera iteración, la clase incluye un método que simula el procesamiento del pago,
 * devolviendo un mensaje de éxito. En futuras iteraciones, esta funcionalidad podría ampliarse
 * para integrarse con la API de Mercado Pago.
 * 
 */
@Entity
@Getter @Setter @NoArgsConstructor
public class MercadoPago implements Pago{


    
    /** 
     * Procesa el pago mediante Mercado Pago.
     * 
     * @param monto El monto a ser procesado en el pago.
     * @return String - Un mensaje indicando que el pago fue prosesado exitosamentes.
     * @throws IllegalArgumentException si el monto es menor o igual a cero.
     */
    @Override
    public String procesarPago(double monto){
        if (monto <= 0) {
            throw new IllegalArgumentException("El monto debe ser mayor a cero para procesar el pago.");
        }
        return "El pago fue procesado con exito por Mercado Pago";
    }

}
