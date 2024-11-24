package modelo;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "productos")
@Getter @Setter @NoArgsConstructor
public class Producto implements ComponenteProducto{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Setter(AccessLevel.NONE)
    @Column(updatable = false)
    private String idProducto;
    @NotBlank
    @Size(min = 10, max = 20)
    @Column(nullable = false, length = 20)
    private String nombre;
    @Size(min = 10, max = 50)
    @Column(nullable = false, length = 50)
    private String descripcion;
    @NotNull
    private double precio;
    @NotNull
    private double peso;



    public Producto(String nombre, String descripcion, double precio, double peso){
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.precio = precio;
        this.peso = peso;
    }

    @Override
    public double getPrecio(){
        double x = precio;
        return x;
    }

    @Override
    public double getPeso(){
        double x = peso;
        return x;
    }

    @Override
    public double aplicarDescuento(double descuento){
        return descuento;
    }

}
