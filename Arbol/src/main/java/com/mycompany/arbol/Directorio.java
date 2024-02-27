/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.arbol;

/**
 *
 * @author David Noguera
 */
import java.io.Serializable;
import java.util.ArrayList;

public class Directorio implements Serializable {

    private Contacto contactoRaiz;

    private int numContactos;

    public Directorio() {
        contactoRaiz = null;
        numContactos = 0;
    }

    public ArrayList<Contacto> obtenerTodosLosContactos() {
        ArrayList<Contacto> listaContactos = new ArrayList<>();
        agregarContactosALista(contactoRaiz, listaContactos);
        return listaContactos;
    }

    private void agregarContactosALista(Contacto contacto, ArrayList<Contacto> listaContactos) {
        if (contacto != null) {
            agregarContactosALista(contacto.getIzq(), listaContactos);
            listaContactos.add(contacto);
            agregarContactosALista(contacto.getDer(), listaContactos);
        }
    }

    private boolean existeContactoConNombre(Contacto contacto, String nombre) {
        if (contacto == null) {
            return false;
        }

        int comparacion = nombre.compareTo(contacto.getNombre());

        if (comparacion == 0) {
            // El nombre coincide, el contacto ya existe
            return true;
        } else if (comparacion < 0) {
            // Buscar en la subárbol izquierda
            return existeContactoConNombre(contacto.getIzq(), nombre);
        } else {
            // Buscar en la subárbol derecha
            return existeContactoConNombre(contacto.getDer(), nombre);
        }
    }

    public void agregarContacto(int idContacto, String nombre, String apellido, String celular, String direccion, String eMail)
            throws ContactoRepetidoException {
        Contacto nuevoContacto = new Contacto(idContacto, nombre, apellido, celular, direccion, eMail, null, null);

        // Verificar si ya existe un contacto con el mismo nombre
        if (existeContactoConNombre(contactoRaiz, nombre)) {
            throw new ContactoRepetidoException(nombre);
        }

        // Continuar con la lógica para agregar el nuevo contacto
        if (contactoRaiz == null) {
            contactoRaiz = nuevoContacto;
        } else {
            contactoRaiz.insertar(nuevoContacto);
        }

        numContactos++;
    }

    public void eliminarContacto(String nombre) {
        contactoRaiz = contactoRaiz.eliminar(nombre);
        numContactos--;

    }

    public boolean editarContacto(int idContacto, String nombre, String apellido, String celular, String direccion, String eMail) {
        Contacto contacto = buscarContacto(nombre);

        if (contacto != null) {
            // Actualizar los atributos del contacto
            contacto.setIdContacto(idContacto);
            contacto.setApellido(apellido);
            contacto.setCelular(celular);
            contacto.setDireccion(direccion);
            contacto.seteMail(eMail);

            return true; // La edición fue exitosa
        }

        return false; // Si no se encontró el contacto por nombre, la edición no se realiza
    }

    public Contacto buscarContacto(String nombre) {
        return contactoRaiz == null ? null : contactoRaiz.buscar(nombre);
    }

    /**
     * Retorna el n�mero de contactos que est�n en el directorio
     *
     * @return n�mero de contactos presentes en el �rbol
     */
    public int darPeso() {
        return contactoRaiz == null ? 0 : contactoRaiz.darPeso();
    }

}
