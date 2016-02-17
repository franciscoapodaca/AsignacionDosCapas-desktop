/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package objetoNegocio;

import objetosServicio.Fecha;

/**
 *
 * @author Francisco
 */
public class Pelicula {

    private String clave;
    private String titulo;
    private String actor1;
    private String actor2;
    private String director;
    private int duracion;
    private Fecha fecha;

    public Pelicula() {
    }

    public Pelicula(String clave, String titulo, String actor1, String actor2, String director, int duracion, Fecha fecha) {
        this.clave = clave;
        this.titulo = titulo;
        this.actor1 = actor1;
        this.actor2 = actor2;
        this.director = director;
        this.duracion = duracion;
        this.fecha = fecha;
    }

    public Pelicula(String clave) {
        this.clave = clave;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getActor1() {
        return actor1;
    }

    public void setActor1(String actor1) {
        this.actor1 = actor1;
    }

    public String getActor2() {
        return actor2;
    }

    public void setActor2(String actor2) {
        this.actor2 = actor2;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public int getDuracion() {
        return duracion;
    }

    public void setDuracion(int duracion) {
        this.duracion = duracion;
    }

    public Fecha getFecha() {
        return fecha;
    }

    public void setFecha(Fecha fecha) {
        this.fecha = fecha;
    }

    
    
}
