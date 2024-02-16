/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package umariana.contactos;

/**
 *
 * @author Sistemas
 */
public class Contacto  {

    // Atributos
    
    /**
     * Nombre del IDcontacto
     */
    private String IDcontacto;
    
    /**
     * Nombre del contacto
     */
    private String nombre;

    /**
     * Tel�fono del contacto
     */
    private String telefono;

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
    
}
