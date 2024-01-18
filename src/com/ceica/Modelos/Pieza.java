package com.ceica.Modelos;

public class Pieza {
    //nuevo
    private static int idPieza=0;
    private int id;
    private String nombre;
    private String color;
    private Double precio;
    private Categoria categoria; //no existe clase categoría aún - tipo de dato nuestro

    public Pieza(String nombre, String color, Double precio) {
        //incrementa en 1
        this.id=idPieza++;
        this.nombre = nombre;
        this.color = color;
        this.precio = precio;
    }
//------------------------------------------getter-------------------------------------------
    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getColor() {
        return color;
    }

    public Double getPrecio() {
        return precio;
    }

    public Categoria getCategoria() {
        return categoria;
    }
//------------------------------------setter-----------------------------
    public void setId(int id) {
        this.id = id;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }
    //------------------------------------------método tOstring------------------------

    @Override
    public String toString() {
        return "Pieza{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", color='" + color + '\'' +
                ", precio=" + precio +
                ", categoria=" + categoria +
                '}';
    }
}
