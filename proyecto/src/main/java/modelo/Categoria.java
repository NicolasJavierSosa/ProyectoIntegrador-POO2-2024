package modelo;

import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
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
/**
 * Representa una Categoría de los productos de la tienda.
 *
 * La clase {@code Categoria} es una entidad JPA que se mapea a la tabla "categorias" 
 * en la base de datos y permite categorizar los productos. Cada categoría 
 * tiene un ID único, un nombre y una descripción.
 *
 * Utiliza anotaciones de Lombok para generar automáticamente los métodos
 * getter, setter y un constructor sin argumentos.
 *
 * 
 */
public class Categoria {

    /** 
     * Identificador único de la categor
     * Este campo se genera automáticamente con un valor UUID para garantizar su unicidad
     * en la base de datos. Este identificador no es modificable una vez creado.
     *
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Setter(AccessLevel.NONE)
    @Column(updatable = false)
    private String idCategoria = UUID.randomUUID().toString();
    
    
    /** 
     * Configura el identificador único de la categoría.
     * @param idCategoria identificador único de la categoria
     */
    public void setIdCategoria(String idCategoria) {
        this.idCategoria = idCategoria;
    }

    /**
     * Nombre de la categor
     * Representa el nombre de la categoría. Este campo no puede
     * estar en blanco y debe tener entre 10 y 20 caracteres para garantizar una 
     * descripción breve y clara. En futuras iteraciones, se podrían agregar validaciones
     * adicionales.
     *
     * 
     */
    @NotBlank
    @Size(min = 10, max = 20)
    @Column(nullable = false, length = 20)
    private String nombre;

    /**
     * Descripción detallada de la categor
     * Proporciona una descripción detallada de la categoría. Este
     * campo es obligatorio, no puede estar en blanco y debe tener entre 25 y 225 caracteres.
     * Esta descripción ayuda a los usuarios a entender mejor el tipo de productos en la 
     * categoría.
     *
     */
    @NotBlank
    @Size(min = 25, max = 225)
    @Column(nullable = false, length = 225)
    private String descripcion;

}
