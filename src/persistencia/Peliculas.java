/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;

import excepciones.PersistenciaException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;
import objetoNegocio.*;
import objetosServicio.Fecha;

/**
 *
 * @author Z470
 */
public class Peliculas extends Tabla {

    /**
     * Constructor del método. Establece el nombre de la tabla en la que se
     * almacenan los datos
     *
     */
    public Peliculas() {
    }

    public Peliculas(String peliculas) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    /**
     * Este método obtiene una película cuya clave es igual a la clave de la
     * película dada por el parámetro.
     *
     * @param pelicula Objeto de tipo Pelicula con la clave de la película a
     * buscar
     * @return La Película si la encuentra, null en caso contrario
     * @throws PersistenciaException Si no puede acceder a la base de datos
     */
    public Pelicula obten(Pelicula pelicula) throws PersistenciaException {
        ResultSet renglon;
// Crea la sentencia SQL para buscar una pelicula en la tabla peliculas.
        String sql = "SELECT * FROM " + "peliculas" + " WHERE clave = '" + pelicula.getClave() + "';";
// Ejecuta la consulta
        consulta(sql);
// Si hay un renglón en la tabla con el titulo deseado
        if ((renglon = obtenRenglon()) != null) {
            try {
// Crea un objeto del tipo Pelicula con los campos del renglón de la
// tabla.
                Pelicula peliculaObten = new Pelicula(
                        renglon.getString("clave"),
                        renglon.getString("titulo"),
                        renglon.getString("actor1"),
                        renglon.getString("actor2"),
                        renglon.getString("director"),
                        renglon.getInt("duracion"),
                        new Fecha(renglon.getDate("fecha")));
                return peliculaObten;
            } catch (SQLException sqle) {
                throw new PersistenciaException("Error al acceder a la base de datos", sqle);
            }
        }
// Si no, regresa null
        return null;
    }

    /**
     * Este método permite insertar un renglón de la tabla con los atributos de
     * los objetos de la clase Pelicula.
     *
     * @param pelicula Pelicula a insertar en la tabla peliculas
     * @throws PersistenciaException Si no puede acceder a la base de datos
     */
    public void agrega(Pelicula pelicula) throws PersistenciaException {
        String sql = "";
// Crea la sentencia para insertar.
// La sentencia debe terminar en un ;
        String clave = "" + pelicula.getClave();
        String titulo = "" + pelicula.getTitulo();
        String actor1 = "" + pelicula.getActor1();
        String actor2 = "" + pelicula.getActor2();
        String director = "" + pelicula.getDirector();
        String duracion = "" + pelicula.getDuracion();
        String fecha = "" + pelicula.getFecha();

        sql += "INSERT INTO " + "peliculas";
        sql += " SET clave = '" + pelicula.getClave() + "'";
        sql += ", titulo = '" + pelicula.getTitulo() + "'";
        sql += ", actor1 = '" + pelicula.getActor1() + "'";
        sql += ", actor2 = '" + pelicula.getActor2() + "'";
        sql += ", director = '" + pelicula.getDirector() + "'";
        sql += ", duracion = '" + pelicula.getDuracion() + "'";
        sql += ", fecha = \"" + pelicula.getFecha().toDateString() + "\";";
        System.out.println(sql);
// Ejecuta la sentencia
        actualiza(sql);
    }

    /**
     * Este método permite modificar un renglón de la tabla con los atributos de
     * los objetos de la clase Pelicula.
     *
     * @param pelicula El usuario a modificar
     * @throws PersistenciaException Si no puede acceder a la base de datos
     */
    public void actualiza(Pelicula pelicula) throws PersistenciaException {
        String sql = "";
// Crea la sentencia con la actualización.
// La sentencia debe terminar en un ;

        String clave = "" + pelicula.getClave();
        String titulo = "" + pelicula.getTitulo();
        String actor1 = "" + pelicula.getActor1();
        String actor2 = "" + pelicula.getActor2();
        String director = "" + pelicula.getDirector();
        String duracion = "" + pelicula.getDuracion();
        String fecha = "" + pelicula.getFecha();

        sql += "UPDATE " + "peliculas";
        sql += " SET clave = '" + pelicula.getClave() + "'";
        sql += ", titulo = '" + pelicula.getTitulo() + "'";
        sql += ", actor1 = '" + pelicula.getActor1() + "'";
        sql += ", actor2 = '" + pelicula.getActor2() + "'";
        sql += ", director = '" + pelicula.getDirector() + "'";
        sql += ", duracion = '" + pelicula.getDuracion() + "'";
        sql += ", fecha = \"" + pelicula.getFecha().toDateString() + "\"";
        sql += " WHERE clave = '" + pelicula.getClave() + "';";
// Ejecuta la sentencia
        actualiza(sql);
    }

    /**
     * Este método permite borrar un renglón de la tabla con los atributos de
     * los objetos de la clase Pelicula.
     *
     * @param pelicula Película a borrar
     * @throws PersistenciaException Si no puede acceder a la base de datos
     */
    public void elimina(Pelicula pelicula) throws PersistenciaException {
        String sql = "";
// Crea la sentencia para borrar.
// La sentencia debe terminar en un ;
        sql += "DELETE FROM " + "peliculas";
        sql += " WHERE clave = '" + pelicula.getClave() + "';";
// Ejecuta la sentencia
        actualiza(sql);
    }

    /**
     * Este método permite consultar la tabla con los atributos de los objetos
     * de la clase Pelicula usando el comando de consulta dado por el parámetro.
     *
     * @param sql Comando de consulta dado por el parámetro.
     * @return Un vector con la lista de los objetos del tipo Pelicula de la
     * tabla
     * @throws PersistenciaException Si no puede acceder a la base de datos
     */
    public Vector lista(String sql) throws PersistenciaException {
        ResultSet renglon;
        Vector lista = new Vector();
// Ejecuta la consulta
        consulta(sql);
// Mientras haya películas en la tabla
        while ((renglon = obtenRenglon()) != null) {
            try {
// Crea un objeto del tipo Pelicula con los campos del renglón de
// la tabla.
                Pelicula pelicula = new Pelicula(
                        renglon.getString("clave"),
                        renglon.getString("titulo"),
                        renglon.getString("actor1"),
                        renglon.getString("actor2"),
                        renglon.getString("director"),
                        renglon.getInt("duracion"),
                        new Fecha(renglon.getDate("fecha")));
// Agrega la película al vector de peliculas
                lista.add(pelicula);
            } catch (SQLException sqle) {
                throw new PersistenciaException("Error al acceder a la base de datos", sqle);
            }
        }
        return lista;
    }

    /**
     * Este método permite consultar la tabla con los atributos de los objetos
     * de la clase Pelicula.
     *
     * @return Un vector con la lista de los objetos del tipo Pelicula de la
     * tabla
     * @throws PersistenciaException Si no puede acceder a la base de datos
     */
    public Vector lista() throws PersistenciaException {
        String sql = "SELECT * FROM " + "peliculas" + ";";
        return lista(sql);
    }

}
