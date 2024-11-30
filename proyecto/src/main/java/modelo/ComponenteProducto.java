package modelo;

import jakarta.persistence.DiscriminatorColumn;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;

@Inheritance(strategy = InheritanceType.JOINED) // Usa JOINED para tablas separadas por subclase
@DiscriminatorColumn(name = "tipo_elemento") // Columna para identificar el tipo
public interface ComponenteProducto {

    double getPrecio();
    double getPeso();
    double aplicarDescuento(double descuento);

}
