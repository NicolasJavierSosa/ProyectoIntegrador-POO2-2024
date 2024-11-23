package modelo;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Clase que representa un usuario en el sistema de la tienda.
 * 
 * Esta clase es utilizada para gestionar la información de los usuarios que interactúan
 * con la tienda, ya sean clientes o administradores. Un usuario tiene un conjunto de
 * atributos que incluyen su nombre completo, correo electrónico, número de teléfono,
 * tipo de usuario y clave de acceso. El tipo de usuario se utiliza para distinguir entre
 * clientes y administradores, y la clave se emplea para garantizar la seguridad del acceso
 * al sistema.
 *  En iteraciones futuras, se podrán agregar funciones adicionales como la recuperación
 * de contraseñas, la actualización de datos personales y la validación más compleja de usuarios.
 *
 * @see  TipoUsuario
 * 
 */
@Entity
@Table(name = "usuarios")
@Getter @Setter @NoArgsConstructor
public class Usuario {

    /**
     * Identificador único del usuario. Este campo se genera automáticamente en la base de datos.
     * 
     * @see #idUsuario
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Setter(AccessLevel.NONE)
    @Column(updatable = false)
    private String idUsuario;
    
    /**
     * Nombre completo del usuario. Este campo no puede estar vacío y debe tener una longitud máxima de 40 caracteres.
     * 
     * @see #nombreCompleto
     */    
    @NotBlank
    @Size(max = 40)
    @Column(nullable = false, length = 40)
    private String nombreCompleto;
    
    /**
     * Correo electrónico del usuario. Este campo no puede estar vacío y debe tener una longitud máxima de 40 caracteres.
     * 
     * @see #correo
     */    
    @NotBlank
    @Size(max = 40)
    @Column(nullable = false, length = 40)
    private String correo;
    
    /**
     * Número de teléfono del usuario. Este campo debe contener solo números enteros.
     * 
     * @see #telefono
     */
    @NotBlank
    @Pattern(regexp = "^[0-9]+$", message = "El campo debe contener solo números enteros")
    private String telefono;
    
    /**
     * Tipo de usuario. Este campo es obligatorio y puede tener dos valores: {@link TipoUsuario#CLIENTE} o {@link TipoUsuario#ADMINISTRADOR}.
     * 
     * @see #tipoUsuario
     * @see TipoUsuario
     */
    @NotNull
    private TipoUsuario tipoUsuario;
    
    /**
     * Clave de acceso del usuario. Este campo no puede estar vacío y debe tener entre 6 y 25 caracteres.
     * 
     * @see #clave
     */
    @NotBlank
    @Size(min = 6, max = 25)
    @Column(nullable = false, length = 25)
    private String clave;

}
