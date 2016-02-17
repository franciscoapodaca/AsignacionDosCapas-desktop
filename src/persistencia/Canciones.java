/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;

import excepciones.PersistenciaException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;
import objetoNegocio.Cancion;
import objetosServicio.Fecha;

/**
 *
 * @author Z470
 */
public class Canciones extends Tabla {

    /**
     * Constructor del método. Establece el nombre de la tabla en la que se
     * almacenan los datos
     *
     * * @param nomTabla Nombre de la tabla en la que se almacenan los datos
     */
    public Canciones() {
    }

    /**
     * Este método obtiene una canción cuya clave es igual a la clave de la
     * canción dada por el parámetro.
     *
     * @param cancion Objeto de tipo Cancion con la clave de la canción a buscar
     * @return La Cancion si la encuentra. null en caso contrario.
     * @throws PersistenciaException Si no puede acceder a la base de datos
     */
    public Cancion obten(Cancion cancion) throws PersistenciaException {
        ResultSet renglon;
        // Crea la sentencia SQL para buscar la cancion en la tabla canciones.
        String sql = "SELECT * FROM " + "canciones" + " WHERE clave = '" + cancion.getClave() + "';";
        System.out.println(sql);
        // Ejecuta la consulta
        consulta(sql);
        // Si hay un renglón en la tabla con la cancion buscada
//        renglon = obtenRenglon();
        if ((renglon = obtenRenglon()) != null) {
            try {
                // Crea un objeto del tipo Cancion con los campos del renglon de la
                // tabla.
                //Cancion c = new Cancion(sql, sql, null, nomTabla, sql, sql, duracion, c)
                Cancion cancionObtenida = new Cancion();
                cancionObtenida.setClave(renglon.getString(1));
                cancionObtenida.setTitulo(renglon.getString(2));
                cancionObtenida.setInterprete(renglon.getString(3));
                cancionObtenida.setAutor(renglon.getString(4));
                cancionObtenida.setAlbum(renglon.getString(5));
                cancionObtenida.setDuracion(renglon.getInt(6));
                cancionObtenida.setFecha(new Fecha(renglon.getDate(7)));
                return cancionObtenida;
            } catch (SQLException sqle) {
                throw new PersistenciaException("Error al acceder a la base de datos", sqle);
            }
        }
        return null;
    }

    /**
     * Este método permite insertar un renglón de la tabla con los atributos de
     * los objetos de la clase Cancion.
     *
     * @param cancion Cancion a insertar en la tabla cancioness
     * @throws PersistenciaException Si no puede acceder a la base de datos
     */
    public void agrega(Cancion cancion) throws PersistenciaException {
        String sql = "";
// Crea la sentencia para insertar.
// La sentencia debe terminar en un ;
        String id = "" + cancion.getClave();
        String titulo = "" + cancion.getTitulo();
        String interprete = "" + cancion.getInterprete();
        String autor = "" + cancion.getAutor();
        String album = "" + cancion.getAlbum();
        String duracion = "" + cancion.getDuracion();
        String fecha = "" + cancion.getFecha();

        sql += "INSERT INTO " + "canciones";
        sql += " SET clave = '" + cancion.getClave() + "'";
        sql += ", titulo = '" + cancion.getTitulo() + "'";
        sql += ", interprete = '" + cancion.getInterprete() + "'";
        sql += ", autor = '" + cancion.getAutor() + "'";
        sql += ", album = '" + cancion.getAlbum() + "'";
        sql += ", duracion = '" + cancion.getDuracion() + "'";
        sql += ", fecha = \"" + cancion.getFecha().toDateString() + "\";";
        System.out.println(sql);

// Ejecuta la sentencia
        actualiza(sql);
    }

    /**
     * Este método permite modificar un renglón de la tabla con los atributos de
     * los objetos de la clase Cancion.
     *
     * @param cancion El usuario a modificar
     * @throws PersistenciaException Si no puede acceder a la base de datos
     */
    public void actualiza(Cancion cancion) throws PersistenciaException {
        String sql = "";
// Crea la sentencia con la actualización.
// La sentencia debe terminar en un ;
        String id = "" + cancion.getClave();
        String titulo = "" + cancion.getTitulo();
        String interprete = "" + cancion.getInterprete();
        String autor = "" + cancion.getAutor();
        String album = "" + cancion.getAlbum();
        String duracion = "" + cancion.getDuracion();
        String fecha = "" + cancion.getFecha();

        sql += "UPDATE " + "canciones";
        sql += " SET clave = '" + cancion.getClave() + "'";
        sql += ", titulo = '" + cancion.getTitulo() + "'";
        sql += ", interprete = '" + cancion.getInterprete() + "'";
        sql += ", autor  = '" + cancion.getAutor() + "'";
        sql += ", album = '" + cancion.getAlbum() + "'";
        sql += ", duracion = '" + cancion.getDuracion() + "'";
        sql += ", fecha = \"" + cancion.getFecha().toDateString() + "\"";
        sql += " WHERE clave = '" + cancion.getClave() + "';";
        System.out.println(sql);
// Ejecuta la sentencia
        actualiza(sql);
    }

    /**
     * Este método permite borrar un renglón de la tabla con los atributos de
     * los objetos de la clase Cancion.
     *
     * @param cancion Cancion a borrar
     * @throws PersistenciaException Si no puede acceder a la base de datos
     */
    public void elimina(Cancion cancion) throws PersistenciaException {
        String sql = "";
// Crea la sentencia para borrar.
// La sentencia debe terminar en un ;
        sql += "DELETE FROM " + "canciones";
        sql += " WHERE clave = '" + cancion.getClave() + "';";
// Ejecuta la sentencia
        actualiza(sql);
    }

    public Vector lista(String sql) throws PersistenciaException {
        ResultSet renglon;
        Vector lista = new Vector();
// Ejecuta la consulta
        consulta(sql);

// Mientras haya canciones en la tabla
        while ((renglon = obtenRenglon()) != null) {
            try {
// Crea un objeto del tipo Cancion con los campos del renglon de la
// tabla.
                Cancion cancion = new Cancion(
                        renglon.getString("clave"),
                        renglon.getString("titulo"),
                        renglon.getString("interprete"),
                        renglon.getString("autor"),
                        renglon.getString("album"),
                        renglon.getInt("duracion"),
                        new Fecha(renglon.getDate("fecha")));
// Agrega la película al vector de película
                lista.add(cancion);
            } catch (SQLException sqle) {
                throw new PersistenciaException("Error al acceder a la base de datos", sqle);
            }
        }
        return lista;
    }

    public Vector lista() throws PersistenciaException {
        String sql = "SELECT * FROM " + "canciones" + ";";
        return lista(sql);
    }
}
