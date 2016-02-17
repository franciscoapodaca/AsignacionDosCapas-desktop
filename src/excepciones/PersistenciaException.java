/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package excepciones;

/**
 *
 *
 * @author Francisco
 */
public class PersistenciaException extends RuntimeException {

    /**
     * Construye una excepción con un mensaje de error nulo.
     */
    public PersistenciaException() {
    }

    /**
     * Construye una excepción con el mensaje de error del parámetro.
     *
     * @param msj Mensaje de error.
     */
    public PersistenciaException(String msj) {
        super(msj);
    }

    /**
     * Construye una excepción con el mensaje de error del parámetro y la causa
     * original del error.
     *
     * @param msj Mensaje de error.
     * @param causa Causa original del error.
     */
    public PersistenciaException(String msj, Throwable causa) {
        super(msj, causa);
    }

    /**
     * Construye una excepción la causa original del error.
     *
     * @param causa Causa original del error.
     */
    public PersistenciaException(Throwable causa) {
        super(causa);
    }
}
