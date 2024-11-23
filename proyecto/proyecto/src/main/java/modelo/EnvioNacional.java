package modelo;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Implementación del envío nacional para los pedidos
 * 
 * <p>
 * La clase {@code EnvioNacional} implementa la interfaz {@code Envio} y proporciona detalles específicos
 * sobre el envío a nivel nacional. El tiempo de entrega estimado es de entre
 * 14 y 20 días hábiles, y el costo de envío se calcula en función del peso total del pedido, aplicando 
 * una tarifa de 4000 pesos por kilogramo.
 * </p>
 * 
 * <p>Esta implementación permite gestionar el proceso de envío para pedidos fuera de la localidad de la tienda.
 * En futuras iteraciones, pueden añadirse variaciones adicionales según la distancia u otros criterios.
 * </p>
 * 
 */
@Entity
@Getter @Setter @NoArgsConstructor
public class EnvioNacional implements Envio{

    /**
     * Calcula el tiempo estimado de entrega para un envío nacional.
     * 
     * <p>
     * Este método devuelve un mensaje indicando que la entrega se realizará entre 14 y 20 días hábiles.
     * Este tiempo de entrega puede ajustarse en futuras versiones para adaptarse a diferentes zonas de envío
     * dentro del país.
     * </p>
     * 
     * @return una cadena de texto que describe el tiempo estimado de entrega (por ejemplo, "Se entregará dentro de 14 a 20 días hábiles").
     */
    @Override
    public String tiempoEntrega(){
        return "Se entregará dentro de 14 a 20 días habiles";
    }

    /**
     * Calcula el costo del envío nacional basado en el peso total del pedido.
     * 
     * <p>
     * El costo de envío se calcula multiplicando el peso total del pedido por una tarifa fija de 4000 pesos
     * por kilogramo. Esta tarifa puede ajustarse en el futuro para incluir factores adicionales,
     * como la ubicación exacta del destino o el tipo de productos enviados.
     * </p>
     * 
     * @param pesoTotal el peso total del pedido, en kilogramos
     * @return devuelve el costo de envío calculado como un valor {@code double}
     * 
     */
    @Override
    public double setCosto(double pesoTotal){
        return pesoTotal * 4000;
    }

}
