package modelo;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter @NoArgsConstructor
public class EnvioProvincial implements Envio{

    @Override
    public String tiempoEntrega(){
        return "Se entregará dentro de 7 a 10 días habiles";
    }

    @Override
    public double setCosto(double pesoTotal){
        return pesoTotal * 2500;
    }

}
