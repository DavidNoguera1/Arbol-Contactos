/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.contactos;

/**
 *
 * @author juand
 */
public class ContactoRepetidoException extends Exception{
    public ContactoRepetidoException( String nombreContacto )
    {
        super( "Ya existe un contacto con ese nombre: " + nombreContacto );
    }
}
