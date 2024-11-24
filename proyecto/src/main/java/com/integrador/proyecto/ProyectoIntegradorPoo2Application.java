package com.integrador.proyecto;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

/**
 * Clase principal para la aplicación Spring Boot del Proyecto.
 *
 * Esta clase inicia la aplicación excluyendo la configuración automática de la
 * fuente de datos, lo cual es útil si no se necesita conexión a una base de
 * datos o si se desea configurar manualmente (lo cual nos es útil para el
 * comienzo del proyecto).
 *
 * Para ejecutar la aplicación se utiliza el método {@link #main(String[]) }.
 */
@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})

public class ProyectoIntegradorPoo2Application {

    /**
     * Método principal de la aplicación que lanza la instancia de Spring Boot.
     *
     * Utiliza {@link SpringApplication#run(Class, String...) } para iniciar el
     * contexto de Spring y, como es una aplicación web, también el servidor
     * embebido.
     *
     * @param args Argumentos de línea de comandos para personalizar el arranque
     * de la aplicación
     */
    
    public static void main(String[] args) {
        SpringApplication.run(ProyectoIntegradorPoo2Application.class, args);
    }
}
