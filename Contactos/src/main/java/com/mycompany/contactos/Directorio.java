/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.contactos;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;

/**
 *
 * @author PC
 */
public class Directorio {
    // -----------------------------------------------------------------
    // Atributos
    // -----------------------------------------------------------------

    /**
     * Ra�z del �rbol de contactos presentes en el directorio
     */
    private Contacto contactoRaiz;

    /**
     * N�mero de contactos en el directorio
     */
    private int numContactos;

    // -----------------------------------------------------------------
    // Constructores
    // -----------------------------------------------------------------
    /**
     * Crea el directorio sin ning�n contacto
     */
    public Directorio() {
        contactoRaiz = null;
        numContactos = 0;
    }

    // -----------------------------------------------------------------
    // M�todos
    // -----------------------------------------------------------------
    /**
     * Agrega un contacto al directorio <br>
     * <b>post: </b>El contacto ha sido agregado al directorio.
     *
     * @param nom nombre del contacto - nom != null
     * @param tel tel�fono del contacto
     * @param dir direcci�n del contacto
     * @param email direcci�n electr�nica del contacto
     * @throws ContactoRepetidoException cuando ya existe un contacto con ese
     * nombre
     */
    public void agregarContacto(String id, String nombre, String apellido, String celular, String direccion, String email) throws IOException {
        Contacto c = new Contacto(id, nombre, apellido, celular, direccion, email, null, null);

        if (contactoRaiz == null) {
            contactoRaiz = c;
        } else {
            contactoRaiz.insertar(c);
        }

        numContactos++;
    }

    /**
     * Elimina del directorio el contacto con el nombre indicado <br>
     * <b>post: </b>El contacto ha sido eliminado del directorio <br>
     *
     * @param nombre nombre del contacto a eliminar - existe en el directorio un
     * contacto con dicho nombre
     */
    public void eliminarContacto(String nombre) {
        contactoRaiz = contactoRaiz.eliminar(nombre);
        numContactos--;

    }

    /**
     * Busca y retorna el contacto del nombre indicado. Si no lo encuentra
     * retorna null.
     *
     * @param nombre nombre del contacto a buscar - nombre != null
     * @return contacto correspondiente al nombre, si no existe retorna null
     */
    public Contacto buscarContacto(String nombre) {
        return contactoRaiz == null ? null : contactoRaiz.buscar(nombre);
    }

}
