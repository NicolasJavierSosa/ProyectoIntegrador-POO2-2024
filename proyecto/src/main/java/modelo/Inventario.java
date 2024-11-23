package modelo;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Representa el inventario de productos en la tienda de productos ecológicos.
 * 
 * La clase {@code Inventario} gestiona la cantidad disponible de un producto y define
 * un umbral mínimo para el reabastecimiento. Esta clase es fundamental para el control
 * de stock y asegurar que los productos se mantengan en niveles óptimos, evitando así
 * faltantes en la tienda. 
 * 
 * En la primera iteración de desarrollo, esta clase incluye atributos para almacenar
 * la cantidad de productos disponibles y un umbral mínimo(que será implementado en la segunda iteración), que permite generar alertas
 * cuando el inventario cae por debajo de este nivel. En futuras iteraciones, se podrán
 * añadir más funcionalidades, como gestión de proveedores o integración con pedidos.
 * 
 */
@Entity
@Table(name = "inventario")
@Getter @Setter @NoArgsConstructor
public class Inventario {

    /**
     * Identificador único del registro de inventario, generado automáticamente.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Setter(AccessLevel.NONE)
    @Column(updatable = false)
    private String idInventario;
    
    /**
     * Cantidad disponible del producto en el inventario. 
     * 
     * Este valor representa la cantidad de unidades de un producto que están
     * disponibles actualmente en stock. Es un valor que se valida como no nulo.
     * 
     */
    @NotNull
    private int cantidadDisponible;
    
    /**
     * Umbral mínimo de cantidad en inventario.
     * 
     * Define el número mínimo de unidades que se deben mantener en el inventario
     * antes de que se considere necesario un reabastecimiento. Este atributo permite
     * gestionar la alerta de stock bajo en una futura iteración.
     * 
     */
    @NotNull
    private int umbralMinimo;

}
