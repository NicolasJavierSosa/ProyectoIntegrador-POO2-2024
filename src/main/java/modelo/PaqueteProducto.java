package modelo;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "paquete_producto")
@Getter @Setter @NoArgsConstructor
public class PaqueteProducto {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Setter(AccessLevel.NONE)
    private int idPaqueteProducto;

    @ManyToOne
    @JoinColumn(name = "id_paquete")
    private Paquete paquete;

    @ManyToOne
    @JoinColumn(name = "id")
    private Producto producto;

    @Column(nullable = false)
    private int cantidadDeProducto;

}
