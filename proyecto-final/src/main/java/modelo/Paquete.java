package modelo;

import java.util.ArrayList;
import java.util.List;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "paquetes")
@Getter @Setter @NoArgsConstructor
public class Paquete implements ComponenteProducto{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Setter(AccessLevel.NONE)
    @Column(updatable = false)
    private int idPaquete;

    @Column(nullable = false)
    @OneToMany(mappedBy = "paquete", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<PaqueteProducto> elementosPaquete = new ArrayList<>();

    @Override
    public double getPrecio(){
        double precio = 0;
        for(int i = 0; i <= elementosPaquete.size(); i++){
            precio += elementosPaquete.get(i).getProducto().getPrecio();
        }
        return precio;
    }

    @Override
    public double getPeso(){
        double peso = 0;
        for(int i = 0; i <= elementosPaquete.size(); i++){
            peso += elementosPaquete.get(i).getProducto().getPeso();
        }
        return peso;
    }

}
