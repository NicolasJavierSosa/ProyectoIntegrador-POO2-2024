package modelo;

import java.time.LocalDate;
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
import jakarta.persistence.Column;

/**
 * Representa un pedido en el sistema, incluyendo información sobre el estado, 
 * fecha de creación, monto total y peso total del pedido.
 */
@Entity
@Table(name = "pedidos")
@Getter @Setter @NoArgsConstructor
public class Pedido {

    /** Identificador único del pedido, generado automáticamente. */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Setter(AccessLevel.NONE)
    @Column(updatable = false)
    private String idPedido;
    /** Estado actual del pedido. Por defecto es SIN_ENTREGAR. */
    @NotNull
    private EstadoPedido estado = EstadoPedido.SIN_ENTREGAR;
    
    /** Fecha de creación del pedido. */
    @NotNull
    private LocalDate fecha = LocalDate.now();
    
    /** Monto total del pedido. Debe ser mayor a cero. */
    @NotNull
    private Double monto;
    
    /** Peso total del pedido. Debe ser mayor a cero. */
    @NotNull
    private Double pesoTotal;

}
