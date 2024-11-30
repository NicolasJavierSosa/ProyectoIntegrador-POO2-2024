package modelo;

import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
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
    @Column(name = "id")
    private String idProducto;
    @NotBlank
    @Size(min = 10, max = 50)
    @Column(nullable = false, length = 20)
    private String nombre;
    @Size(min = 10, max = 150)
    @Column(nullable = false, length = 50)
    private String descripcion;
    @NotNull
    @Column(nullable = false)
    private double precio;
    @NotNull
    @Column(nullable = false)
    private double peso;
    @ManyToOne
    @JoinColumn(name = "id_categoria", referencedColumnName = "id_categoria", nullable = false)
    private Categoria categoria;
    @NotBlank
    @Column(nullable = false)
    private String imgProducto;
    @NotNull
    @Column(nullable = false)
    private int cantDisp;


    public Producto(String nombre, String descripcion, double precio, double peso){
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.precio = precio;
        this.peso = peso;
    }

    public String getId() {
        return idProducto;
    }

    public void setId(String idProducto) {
        this.idProducto = idProducto;
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
    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

}
