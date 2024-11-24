package com;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.PreparedStatement;  // Importación para usar PreparedStatement

import java.util.Scanner;  // Importación para obtener la entrada del usuario

public class TestConnection {
    public static void main(String[] args) {
        String url = "jdbc:postgresql://localhost:5432/TiendaEcológica";
        String usuario = "postgres";
        String clave = "postgres";

        String query = "SELECT * FROM productos";
        Scanner scanner = new Scanner(System.in);

        // Bloque para establecer conexión y realizar operaciones
        try (Connection conexion = DriverManager.getConnection(url, usuario, clave);
             Statement stmt = conexion.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {

            if (conexion != null) {
                System.out.println("Conexión exitosa a la base de datos.");
            }

            // Mostrar productos existentes
            while (rs.next()) {
                System.out.println("Producto ID: " + rs.getString("id"));
                System.out.println("Peso: " + rs.getDouble("peso"));
                System.out.println("Precio: " + rs.getDouble("precio"));
                System.out.println("-----");
            }

            // Funcionalidad para agregar un nuevo producto
            System.out.println("\nAgregar un nuevo producto:");
            System.out.print("ID del producto: ");
            String id = scanner.nextLine();
            System.out.print("Peso del producto: ");
            double peso = scanner.nextDouble();
            System.out.print("Precio del producto: ");
            double precio = scanner.nextDouble();
            
            // Comando SQL para insertar un nuevo producto
            String insertQuery = "INSERT INTO productos (id, peso, precio) VALUES (?, ?, ?)";
            
            try (PreparedStatement pstmt = conexion.prepareStatement(insertQuery)) {
                pstmt.setString(1, id);  // Asignar el valor del ID
                pstmt.setDouble(2, peso); // Asignar el valor del peso
                pstmt.setDouble(3, precio); // Asignar el valor del precio
                
                int filasInsertadas = pstmt.executeUpdate();
                
                if (filasInsertadas > 0) {
                    System.out.println("Producto agregado exitosamente.");
                } else {
                    System.out.println("No se pudo agregar el producto.");
                }
            } catch (SQLException e) {
                System.out.println("Error al agregar el producto: " + e.getMessage());
            }

        } catch (SQLException e) {
            System.out.println("Error al ejecutar la consulta: " + e.getMessage());
        } finally {
            scanner.close();  // Cerrar el scanner al final
        }
    }
}
