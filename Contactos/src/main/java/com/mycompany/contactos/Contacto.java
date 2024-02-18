/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.contactos;

/**
 *
 * @author juand
 */
public class Contacto {
    // Atributos
    
    /**
     * id del contacto
     */
    private String idContacto;
    
    /**
     * Nombre del contacto
     */
    private String nombre;
    
    /**
     * Apellido del contacto
     */
    private String apellido;

    /**
     * Tel�fono del contacto
     */
    private String celular;
    
    /**
     * Direcci�n del contacto
     */
    private String direccion;

    /**
     * Correo electr�nico del contacto
     */
    private String eMail;

    /**
     * Sub�rbol izquierdo de contactos
     */
    private Contacto izq;

    /**
     * Sub�rbol derecho de contactos
     */
    private Contacto der;

    public Contacto() {
    }

    public Contacto(String idContacto, String nombre, String apellido, String celular, String direccion, String eMail, Contacto izq, Contacto der) {
        this.idContacto = idContacto;
        this.nombre = nombre;
        this.apellido = apellido;
        this.celular = celular;
        this.direccion = direccion;
        this.eMail = eMail;
        this.izq = null;
        this.der = null;
    }

    public String getIdContacto() {
        return idContacto;
    }

    public void setIdContacto(String idContacto) {
        this.idContacto = idContacto;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String geteMail() {
        return eMail;
    }

    public void seteMail(String eMail) {
        this.eMail = eMail;
    }
    
    
    
}
