package modelo;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Implementación del envío local para pedidos.
 * 
 * La clase {@code EnvioLocal} implementa la interfaz {@code Envio} y proporciona detalles específicos
 * sobre el proceso de envío para pedidos realizados dentro de la misma localidad o área. El tiempo
 * de entrega se define como 3 días hábiles, y el costo de envío se calcula en función del peso total
 * del pedido, aplicando una tarifa de 1000 pesos por cada kilogramo de peso.
 * 
 */
@Entity
@Getter @Setter @NoArgsConstructor
public class EnvioLocal implements Envio{

    /**
     * Calcula el tiempo estimado de entrega para un envío local.
     * 
     * En el caso de los envíos locales, se ha establecido un tiempo fijo de entrega de 3 días hábiles para esta primer itración.
     * Este método debe ser modificado en futuras iteraciones si se desean tiempos de entrega más dinámicos
     * basados en factores como la ubicación del cliente o el volumen dsel pedido.
     * 
     * @return Devuelve una cadena de texto que describe el tiempo estimado de entrega (por ejemplo, "Se entregará dentro de 3 días hábiles").
     */
    @Override
    public String tiempoEntrega(){
        return "Se entregará dentro de 3 días habiles";
    }

    /**
     * Calcula el costo del envío local basado en el peso total del pedido.
     * 
     * El costo de envío se calcula multiplicando el peso total del pedido por una tarifa fija
     * de 1000 pesos por kilogramo(precio fijo establecido para la primer iteración). Este costo puede ajustarse en el futuro para
     * incluir factores adicionales, como la distancia o el tipo de productos solicitados.
     * 
     * @param pesoTotal Es el peso total del pedido, en kilogramos.
     * @return Devuelve el costo de envío calculado como un valor {@code double}
     * 
     */
    @Override
    public double setCosto(double pesoTotal){
        return pesoTotal * 1000;
    }

}
