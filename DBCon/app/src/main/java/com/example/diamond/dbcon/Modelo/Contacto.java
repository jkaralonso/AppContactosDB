package com.example.diamond.dbcon.Modelo;

/**
 * Created by Diamond on 11/10/2017.
 */

public class Contacto{

    private String Usuario;
    private String Email;
    private String Twitter;
    private String Telefono;
    private String Fecha;

    private long  id;

    public Contacto(){

    }

    public Contacto(long id,String usuario, String email, String twitter, String telefono, String fecha) {
        Usuario = usuario;
        Email = email;
        Twitter = twitter;
        Telefono = telefono;
        Fecha = fecha;
        id=id;
    }

    public Contacto(String usuario, String email, String twitter, String telefono, String fecha) {
        Usuario = usuario;
        Email = email;
        Twitter = twitter;
        Telefono = telefono;
        Fecha = fecha;
    }



    public String getUsuario() {
        return Usuario;
    }

    public void setUsuario(String usuario) {
        Usuario = usuario;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getTwitter() {
        return Twitter;
    }

    public void setTwitter(String twitter) {
        Twitter = twitter;
    }

    public String getTelefono() {
        return Telefono;
    }

    public void setTelefono(String telefono) {
        Telefono = telefono;
    }

    public String getFecha() {
        return Fecha;
    }

    public void setFecha(String fecha) {
        Fecha = fecha;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

}
