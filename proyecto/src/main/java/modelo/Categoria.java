package modelo;

import java.util.Set;
import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "categorias")
@Getter @Setter @NoArgsConstructor
public class Categoria {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Setter(AccessLevel.NONE)
    @Column(name = "id_categoria")
    private String idCategoria = UUID.randomUUID().toString();
    @NotBlank
    @Size(min = 10, max = 20)
    @Column(nullable = false, length = 20)
    private String nombre;
    @NotBlank
    @Size(min = 25, max = 225)
    @Column(nullable = false, length = 225)
    private String descripcion;
    @Column(nullable = false)
    @OneToMany(mappedBy = "categoria")
    private Set<Producto> productos;
    @NotBlank
    @Column(nullable = false)
    private String imgCategoria;

    public Categoria(Set<Producto> productos) {
        this.productos = productos;
    }

    public String getId() {
        return idCategoria;
    }

    public void setId(String idCategoria) {
        this.idCategoria = idCategoria;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    public Set<Producto> getProductos() {
        return productos;
    }

}
