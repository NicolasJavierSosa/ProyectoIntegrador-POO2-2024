package modelo;

/**
 * Interfaz que define el contrato para los métodos de pago de la aplicación.
 * 
 * Las clases que implementen esta interfaz deben proporcionar una implementación 
 * específica del método de pago para procesar una transacción dada. Esto permite que 
 * la aplicación soporte múltiples métodos de pago, como Mercado Pago, transferencia bancaria, 
 * entre otros.
 * 
 * En futuras iteraciones, esta interfaz podría ampliarse para incluir métodos adicionales, 
 * como la verificación del estado del pago o la cancelación de una transacción.
 * 
 */
public interface Pago {

    /**
     * Procesa el pago para una transacción específica.
     *
     * @param monto el monto a ser procesado en el pago. Debe ser un valor positivo.
     * @return un mensaje indicando el resultado del procesamiento del pago.
     * @throws IllegalArgumentException si el monto es menor o igual a cero (debe ser positivo).
     * 
     */
    String procesarPago(double monto);

}
