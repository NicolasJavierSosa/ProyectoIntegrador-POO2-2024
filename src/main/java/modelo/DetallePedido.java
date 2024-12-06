package modelo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import jakarta.persistence.Column;

@Entity
@Table(name = "detalles_pedido")
@Getter @Setter @NoArgsConstructor
public class DetallePedido {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Setter(AccessLevel.NONE)
    @Column(updatable = false)
    private int idDetalle;

    @NotNull
    private int cantidadTotalProductos;

    @NotNull
    private Double montoTotal;
    
    @NotNull
    private Double pesoTotal;

    @NotNull
    @OneToOne
    private Paquete productosComprados;

    @NotNull
    private String metodoPago;

    @NotNull
    private String metodoEnvio;

    public void vaciar(){
        this.cantidadTotalProductos = 0;
        this.montoTotal = 0.0;
        this.pesoTotal = 0.0;
    }

    public DetallePedido(PrecioFinal precioFinal){
        this.cantidadTotalProductos = precioFinal.getCantidad();
        this.montoTotal = precioFinal.getPrecio();
        this.pesoTotal = precioFinal.getPeso();
    }

}
