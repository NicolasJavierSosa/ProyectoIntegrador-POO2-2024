package modelo;

import java.time.LocalDate;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import jakarta.persistence.Column;

@Entity
@Table(name = "pedidos")
@Getter @Setter @NoArgsConstructor
public class Pedido {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Setter(AccessLevel.NONE)
    @Column(updatable = false)
    private int idPedido;

    @NotNull
    private EstadoPedido estado = EstadoPedido.SIN_ENTREGAR;

    @NotNull
    private LocalDate fechaCreacion = LocalDate.now();

    @NotNull
    @ManyToOne
    private Usuario comprador;

    @Size(min = 10, max = 150)
    @Column(nullable = false, length = 150)
    private String direccionEntrega;

}
