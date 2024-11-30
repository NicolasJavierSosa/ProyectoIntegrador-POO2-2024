package modelo;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter @NoArgsConstructor
public class EnvioNacional implements Envio{

    @Override
    public String tiempoEntrega(){
        return "Se entregará dentro de 14 a 20 días habiles";
    }

    @Override
    public double setCosto(double pesoTotal){
        return pesoTotal * 4000;
    }

}
