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
public class Cancion {

    private String clave;
    private String titulo;
    private String interprete;
    private String autor;
    private String album;
    private int duracion;
    Fecha fecha;

    public Cancion() {
    }

    public Cancion(String clave, String titulo, String interprete, String autor, String album, int duracion, Fecha fecha) {
        this.clave = clave;
        this.titulo = titulo;
        this.interprete = interprete;
        this.autor = autor;
        this.album = album;
        this.duracion = duracion;
        this.fecha = fecha;
    }

    public Cancion(String clave) {
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

    public String getInterprete() {
        return interprete;
    }

    public void setInterprete(String interprete) {
        this.interprete = interprete;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getAlbum() {
        return album;
    }

    public void setAlbum(String album) {
        this.album = album;
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
