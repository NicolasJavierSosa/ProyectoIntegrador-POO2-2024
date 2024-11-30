package modelo;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
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
    private String idPaquete;

    @NotNull
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "paquete_id")
    private List<Producto> elementos = new ArrayList<>();

    @Override
    public double getPrecio(){
        double precio = 0;
        for(int i = 0; i <= elementos.size(); i++){
            precio += elementos.get(i).getPrecio();
        }
        return precio;
    }

    @Override
    public double getPeso(){
        double peso = 0;
        for(int i = 0; i <= elementos.size(); i++){
            peso += elementos.get(i).getPeso();
        }
        return peso;
    }

    @Override
    public double aplicarDescuento(double descuento){
        return descuento;
    }

    public void añadirItem(Producto x){
        elementos.add(x);
    }

}
