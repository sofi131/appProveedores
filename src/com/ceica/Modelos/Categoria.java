package com.ceica.Modelos;

public class Categoria {
    private int id;
    private String nombre;
//------------------------------------constructor categoría---------------------------
    public Categoria(int id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }
//-----------------------------------------vacío--------------------------------------
    public Categoria() {
    }
//--------------------------------------------get-------------------------------------
    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }
//-------------------------------------------set--------------------------------------
    public void setId(int id) {
        this.id = id;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
//-----------------------------------------tOstring-----------------------------------
    @Override
    public String toString() {
        return "Categoria{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                '}';
    }
}
