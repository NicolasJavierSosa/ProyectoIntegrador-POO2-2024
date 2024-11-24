package modelo;

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
import jakarta.persistence.Column;

@Entity
@Table(name = "usuarios")
@Getter @Setter @NoArgsConstructor
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Setter(AccessLevel.NONE)
    @Column(updatable = false)
    private String idUsuario;
    @NotBlank
    @Size(max = 40)
    @Column(nullable = false, length = 40)
    private String nombreCompleto;
    @NotBlank
    @Size(max = 40)
    @Column(nullable = false, length = 40)
    private String correo;
    @NotBlank
    @Pattern(regexp = "^[0-9]+$", message = "El campo debe contener solo números enteros")
    private String telefono;
    @NotNull
    private TipoUsuario tipoUsuario;
    @NotBlank
    @Size(min = 6, max = 25)
    @Column(nullable = false, length = 25)
    private String clave;

}
