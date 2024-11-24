package modelo;

import java.util.ArrayList;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
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
    //@ManyToMany(mappedBy = "productos")
    private ArrayList<ComponenteProducto> elementos;

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

}
