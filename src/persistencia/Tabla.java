/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;

import excepciones.PersistenciaException;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Z470
 */
public class Tabla {

    protected String nomTabla;
    protected Connection conexion;
    protected CallableStatement sentencia;
    protected ResultSet respuesta;

    public Tabla() {
    }

    public void setConexion(Connection conexion) {
        this.conexion = conexion;
    }

    public void consulta(String sql) throws PersistenciaException {
        try {
            // Crea una sentencia para hacer la consulta 
            sentencia = (CallableStatement) conexion.prepareCall(sql);
            // Ejecuta la consulta. El método executeQuery() regresa una tabla
            // que genera como resultado de la consulta
            respuesta = sentencia.executeQuery(sql);
        } catch (SQLException se) {
            throw new PersistenciaException("No se puede consultar a la base de datos", se);
        }

    }

    public ResultSet obtenRenglon() throws PersistenciaException {
        try {
            if (respuesta.next()) {
                return respuesta;
            } else {
                respuesta.close();
                sentencia.close();

                return null;
            }
        } catch (SQLException se) {
            throw new PersistenciaException("no se pudo consultar la base de datos", se);
        }
    }

    public void actualiza(String sql) throws PersistenciaException {
        try {
            // Crea una sentencia para hacer la modificación.
            sentencia = (CallableStatement) conexion.prepareCall(sql);
            // Ejecuta la modificación.
            int i = sentencia.executeUpdate(sql);
            // Cierra la sentencia y la tabla.
            sentencia.close();
        } catch (SQLException se) {
            throw new PersistenciaException("No se puede actualizar a la base de datos", se);
        }

    }
}
