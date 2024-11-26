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

@Entity
@Table(name = "pedido_base")
@Getter @Setter @NoArgsConstructor
public class PedidoBase implements PrecioFinal{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Setter(AccessLevel.NONE)
    @Column(updatable = false)
    private String idDetalle;
    @NotNull
    private int cantidad;
    @NotNull
    private Double subtotal;
    @NotNull
    private Double pesoSubtotal;


    @Override
    public double getPrecio(){
        double x = subtotal;
        return x;
    }

    @Override
    public int getCantidad(){
        int x = cantidad;
        return x;
    }

}
