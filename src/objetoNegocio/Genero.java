/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package objetoNegocio;

/**
 *
 * @author Francisco
 */
public class Genero {

    private String cveGenero;
    private String nombre;
    private String tipoMedio;

    public Genero() {
    }

    public Genero(String cveGenero, String nombre, String tipoMedio) {
        this.cveGenero = cveGenero;
        this.nombre = nombre;
        this.tipoMedio = tipoMedio;
    }

    public Genero(String cveGenero) {
        this.cveGenero = cveGenero;
    }

    public String getCveGenero() {
        return cveGenero;
    }

    public void setCveGenero(String cveGenero) {
        this.cveGenero = cveGenero;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTipoMedio() {
        return tipoMedio;
    }

    public void setTipoMedio(String tipoMedio) {
        this.tipoMedio = tipoMedio;
    }

}
