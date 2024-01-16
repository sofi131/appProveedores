package com.ceica.Modelos;

public class Proveedor {
    private int id;
    private String cif;
    private String nombre;
    private String direccion;
    private String localidad;

    //vacío
    public Proveedor() {

    }

    //2 valores
    public Proveedor(java.lang.String cif, java.lang.String nombre) {
        this.cif = cif;
        this.nombre = nombre;
    }
    //getter
    public int getId() {
        return id;
    }

    public java.lang.String getCif() {
        return cif;
    }

    public java.lang.String getNombre() {
        return nombre;
    }

    public java.lang.String getDireccion() {
        return direccion;
    }

    public java.lang.String getLocalidad() {
        return localidad;
    }

    public java.lang.String getProvincia() {
        return provincia;
    }

    //setter
    public void setId(int id) {
        this.id = id;
    }

    public void setCif(java.lang.String cif) {
        this.cif = cif;
    }

    public void setNombre(java.lang.String nombre) {
        this.nombre = nombre;
    }

    public void setDireccion(java.lang.String direccion) {
        this.direccion = direccion;
    }

    public void setLocalidad(java.lang.String localidad) {
        this.localidad = localidad;
    }

    public void setProvincia(java.lang.String provincia) {
        this.provincia = provincia;
    }

    private String provincia;


//método toString cadena de txt con toda la info
    @Override
    public String toString() {
        return "Proveedor{" +
                "id=" + id +
                ", cif='" + cif + '\'' +
                ", nombre='" + nombre + '\'' +
                ", direccion='" + direccion + '\'' +
                ", localidad='" + localidad + '\'' +
                ", provincia='" + provincia + '\'' +
                '}';
    }
}
