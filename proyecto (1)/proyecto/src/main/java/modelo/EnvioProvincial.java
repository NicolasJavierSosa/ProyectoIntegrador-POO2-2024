package modelo;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Implementación de envío para entregas dentro de la misma provincia donde se encuantra la sede.
 * 
 * <p>
 * La clase {@code EnvioProvincial} implementa la interfaz {@code Envio} y proporciona detalles específicos
 * sobre los envíos provinciales que tendrá la tienda. El tiempo estimado de entrega es de
 * entre 7 y 10 días hábiles, y el costo de envío se calcula en función del peso total del pedido, aplicando
 * una tarifa de 2500 pesos por kilogramo.
 * </p>
 * 
 */
@Entity
@Getter @Setter @NoArgsConstructor
public class EnvioProvincial implements Envio{

    /**
     * Calcula el tiempo estimado de entrega para un envío provincial.
     * 
     * <p>
     * Este método devuelve un mensaje indicando que la entrega se realizará entre 7 y 10 días hábiles(tiempo estatico puesto para la primer iteración).
     * Este tiempo puede ajustarse según las necesidades o condiciones locales en futuras iteraciones.
     * </p>
     * 
     * @return una cadena de texto que describe el tiempo estimado de entrega (por ejemplo, "Se entregará dentro de 7 a 10 días hábiles").
     */
    @Override
    public String tiempoEntrega(){
        return "Se entregará dentro de 7 a 10 días habiles";
    }

    /**
     * 
     * Calcula el costo del envío provincial basado en el peso total del pedido.
     * <p>
     * El costo de envío se calcula multiplicando el peso total del pedido por una tarifa fija de 2500 unidades
     * monetarias por kilogramo. Este cálculo puede modificarse en el futuro para incluir factores adicionales
     * relacionados con la logística y el destino dentro de la provincia.
     * </p>
     * 
     * @param pesoTotal el peso total del pedido, en kilogramos
     * @return el costo de envío calculado como un valor {@code double}
     */
    @Override
    public double setCosto(double pesoTotal){
        return pesoTotal * 2500;
    }

}
