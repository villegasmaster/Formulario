package com.villegas.formulario;

/**
 * Created by Villegas on 09/12/2017.
 */

public class Contacto {

    private String nombre;

    private String fecha;

    private String telefono;

    private String email;


    public Contacto(String nombre, String fecha, String telefono, String email) {

        this.nombre     = nombre;
        this.fecha      = fecha;
        this.telefono   = telefono;
        this.email      = email;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
