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
    
    public Directorio( )
    {
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

    
    public void agregarContacto(int idContacto, String nombre, String apellido, String celular, String direccion, String eMail) throws ContactoRepetidoException
    {
        Contacto c = new Contacto(idContacto, nombre, apellido, celular, direccion, eMail, null, null);
        if( contactoRaiz == null )
            contactoRaiz = c;
        else
            contactoRaiz.insertar( c );
        numContactos++;
        
    }
    
    public  void eliminarContacto(String nombre) {
        contactoRaiz = contactoRaiz.eliminar(nombre);
        numContactos--;

    }
    
    public Contacto buscarContacto( String nombre )
    {
        return contactoRaiz == null ? null : contactoRaiz.buscar( nombre );
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

