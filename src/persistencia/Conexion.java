/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;

import java.sql.*;
import excepciones.PersistenciaException;

/**
 * Esta clase establece una conexion con una base de datos mySQL
 *
 * @author Francisco
 */
public class Conexion {

// Conector a la base de datos.
    private Connection conexion;

    /**
     * Establece una conexión con la base de datos.
     *
     */
    public Conexion() throws PersistenciaException {
        try {
            String url = "jdbc:mysql://localhost:3306/asignacionbd";
            String usuario = "root";
            String password = "root";
            // Se crea una instancia de la clase manejadora de mySQL
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            // Se conecta con la base de datos
            conexion = DriverManager.getConnection(url, usuario, password);
        } catch (Exception e) {
            throw new PersistenciaException("Error al conectarse a la base de datos", e);
        }
    }

    /**
     * Establece una conexion con la base de datos
     *
     * @param url URL de la base de datos
     * @param usuario Cuenta de usuario
     * @param password Contrase;a del usuario
     * @throws PersistenciaException Si no puede establecer la conexion con la
     * base de datos
     */
    public Conexion(String url, String usuario, String password) throws PersistenciaException {
        try {
            // Se crea una instancia de la clase manejadora de mySQL
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            // Se conecta con la base de datos
            conexion = DriverManager.getConnection(url, usuario, password);
        } catch (Exception e) {
            throw new PersistenciaException("Error al conectarse a la base de datos", e);
        }
    }

    /**
     * Obtiene la conexión con la base de datos.
     *
     * @return La conexión con la base de datos
     */
    public Connection getConexion() {
        return conexion;
    }

    public void close() throws PersistenciaException {
        try {
            conexion.close();
        } catch (Exception e) {
            throw new PersistenciaException("Error al cerrar la conexión con la base de datos", e);
        }
    }
}
