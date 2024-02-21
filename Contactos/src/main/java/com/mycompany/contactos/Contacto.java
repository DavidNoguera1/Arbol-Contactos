/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.contactos;
import java.io.IOException;
import java.util.ArrayList;
/**
 *
 * @author juand
 */
public class Contacto implements Comparable {
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
    
    public int compareTo( Object o )
    {
        Contacto otro = ( Contacto )o;
        return nombre.compareToIgnoreCase( otro.nombre );
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
    
    /**
     * Indica si este nodo es una hoja
     * @return true si este nodo es una hoja y false en caso contrario
     */
    public boolean esHoja( )
    {
        return izq == null && der == null;
    }

    /**
     * Retorna el contacto que alfab�ticamente corresponde al menor contacto del �rbol que parte de este nodo
     * @return contacto con menor nombre
     */
    public Contacto darMenor( )
    {
        return ( izq == null ) ? this : izq.darMenor( );
    }

    /**
     * Retorna el contacto que alfab�ticamente corresponde al mayor contacto del �rbol que parte de este nodo
     * @return contacto con mayor nombre
     */
    public Contacto darMayor( )
    {
        return ( der == null ) ? this : der.darMayor( );
    }

    /**
     * Retorna la altura del �rbol de contactos que comienza en este nodo
     * @return altura del �rbol que comienza en este nodo
     */
    public int darAltura( )
    {
        if( esHoja( ) )
            return 1;
        else
        {
            int a1 = ( izq == null ) ? 0 : izq.darAltura( );
            int a2 = ( der == null ) ? 0 : der.darAltura( );
            return 1 + Math.max( a1, a2 );
        }
    }

    /**
     * Retorna el n�mero de contactos que hay en el �rbol que comienza en este nodo utilizando un algoritmo iterativo
     * @return n�mero de contactos en el �rbol que comienza en este nodo
     */
    public int darPesoIterativo( )
    {
        int peso = 0;
        ArrayList pila = new ArrayList( );
        Contacto p = this;
        while( p != null )
        {
            peso++;
            if( p.izq != null )
            {
                // Guarda el sub�rbol derecho en la pila, para recuperarlo m�s tarde
                if( p.der != null )
                    pila.add( p.der );

                // Baja por la izquierda
                p = p.izq;
            }
            else if( p.der != null )
            {
                // Baja por la derecha, puesto que no hay sub�rbol izquierdo
                p = p.der;
            }
            else if( pila.size( ) != 0 )
            {
                // Es una hoja, luego debemos sacar de la pila el �ltimo sub�rbol all� almacenado
                p = ( Contacto )pila.get( 0 );
                pila.remove( 0 );
            }
            else
            {
                p = null;
            }
        }
        return peso;
    }

    /**
     * Retorna el n�mero de contactos que hay en el �rbol que comienza en este nodo
     * @return n�mero de contactos en el �rbol que comienza en este nodo
     */
    public int darPeso( )
    {
        int p1 = ( izq == null ) ? 0 : izq.darPeso( );
        int p2 = ( der == null ) ? 0 : der.darPeso( );
        return 1 + p1 + p2;
    }

    /**
     * Retorna el n�mero de hojas que hay en el �rbol que comienza en este nodo
     * @return n�mero de hojas que hay en el �rbol que comienza en este nodo
     */
    public int contarHojas( )
    {
        if( esHoja( ) )
            return 1;
        else
        {
            int h1 = ( izq == null ) ? 0 : izq.contarHojas( );
            int h2 = ( der == null ) ? 0 : der.contarHojas( );
            return h1 + h2;
        }
    }

    /**
     * Inserta un nuevo contacto al �rbol que comienza en este nodo.
     * @param nuevo el el nuevo contacto que se va a insertar - nuevo != null
     * @throws java.io.IOException
     */
    
    public void insertar( Contacto nuevo ) throws IOException
    {
        if( compareTo( nuevo ) == 0 )
            throw new IOException( nuevo.nombre );

        if( compareTo( nuevo ) > 0 )
        {
            // Debe agregar el nuevo contacto por el sub�rbol izquierdo
            if( izq == null )
                izq = nuevo;
            else
                izq.insertar( nuevo );
        }
        else
        {
            // Debe agregar el nuevo contacto por el sub�rbol derecho
            if( der == null )
                der = nuevo;
            else
                der.insertar( nuevo );
        }
    }
    
    /**
     * Elimina un contacto del �rbol que comienza en este nodo.
     * @param unNombre nombre del contacto que se va a eliminar - hay un contacto en el �rbol que se llama unNombre
     * @return el �rbol de contactos despu�s de eliminar el contacto indicado
     */
    public Contacto eliminar( String unNombre )
    {
        if( esHoja( ) )
            // Tiene que ser el elemento que estamos buscando
            return null;
        if( nombre.compareToIgnoreCase( unNombre ) == 0 )
        {
            if( izq == null )
                return der;
            if( der == null )
                return izq;
            // Localiza el menor contacto del sub�rbol derecho
            Contacto sucesor = der.darMenor( );
            // Elimina del sub�rbol derecho el elemento que acaba de localizar
            der = der.eliminar( sucesor.getNombre( ) );
            // Deja el elemento localizado en la ra�z del �rbol de respuesta
            sucesor.izq = izq;
            sucesor.der = der;
            return sucesor;
        }
        else if( nombre.compareToIgnoreCase( unNombre ) > 0 )
            izq = izq.eliminar( unNombre );
        else
            der = der.eliminar( unNombre );
        return this;
    }
    
/**
     * Implementaci�n iterativa para localizar un contacto en el �rbol que comienza en este nodo
     * @param unNombre nombre que se va a buscar - unNombre != null
     * @return contacto asociado al nombre. Si no lo encuentra retorna null;
     */
    public Contacto buscarIterativo( String unNombre )
    {
        Contacto p = this;
        while( p != null )
        {
            int comp = p.nombre.compareToIgnoreCase( unNombre );
            if( comp == 0 )
                return p;
            else if( comp > 0 )
                p = p.izq;
            else
                p = p.der;
        }
        return null;
    }

    /**
     * Implementaci�n recursiva para localizar un contacto en el �rbol que comienza en este nodo
     * @param unNombre nombre que se va a buscar - unNombre != null
     * @return contacto asociado al nombre. Si no lo encuentra retorna null;
     */
    public Contacto buscar( String unNombre )
    {
        if( nombre.compareToIgnoreCase( unNombre ) == 0 )
            return this;
        else if( nombre.compareToIgnoreCase( unNombre ) > 0 )
            return ( izq == null ) ? null : izq.buscar( unNombre );
        else
            return ( der == null ) ? null : der.buscar( unNombre );
    }    
}
