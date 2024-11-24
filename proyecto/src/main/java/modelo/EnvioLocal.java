package modelo;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter @Setter @NoArgsConstructor
public class EnvioLocal implements Envio{

    @Override
    public String tiempoEntrega(){
        return "Se entregará dentro de 3 días habiles";
    }

    @Override
    public double setCosto(double pesoTotal){
        return pesoTotal * 1000;
    }

}
