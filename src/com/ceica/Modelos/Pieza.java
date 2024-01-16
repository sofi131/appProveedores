package com.ceica.Modelos;

public class Pieza {
    private int id;
    private String nombre;
    private String color;
    private Double precio;
    private Categoria categoria; //no existe clase categoría aún - tipo de dato nuestro

    public Pieza(String nombre, String color, Double precio) {
        this.nombre = nombre;
        this.color = color;
        this.precio = precio;
    }
}
