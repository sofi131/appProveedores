package com.ceica.Modelos;

import com.ceica.bbdd.Conexion;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class Pieza {
    //nuevo
    private static int idPieza = 0;
    private int id;
    private String nombre;
    private String color;
    private Double precio;
    private Categoria categoria; //no existe clase categoría aún - tipo de dato nuestro

    public Pieza(String nombre, String color, Double precio) {
        //incrementa en 1
        this.id = idPieza++;
        this.nombre = nombre;
        this.color = color;
        this.precio = precio;
    }
//--------------------------------------------------CONSTRUCTOR PIEZA VACÍO-----------------------
    public Pieza() {

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



    //-----------------------------conexión base de datos----------------------PRUEBA PRUEBA PRUEBA
    public static List<Pieza> getPiezas()  {
        List<Pieza> piezaList=new ArrayList<>();
        Connection conn= Conexion.conectar();
        String sql="SELECT * FROM piezas INNER JOIN categorias ON piezas.categoria = idcategorias.categoria";
        try {
            Statement stm=conn.createStatement();
            ResultSet respuesta = stm.executeQuery(sql);
            while (respuesta.next()){
                Pieza pieza=new Pieza();
                pieza.setId(respuesta.getInt("idPieza"));
                pieza.setNombre(respuesta.getString("nombre"));
                pieza.setColor(respuesta.getString("color"));
                pieza.setPrecio(respuesta.getDouble("precio"));
                pieza.setCategoria(respuesta.getString("categorias.categoria"));
                piezaList.add(pieza);
            }

        } catch (SQLException e) {
            //throw new RuntimeException(e);

            return piezaList;
        }
        try {
            conn.close();
        } catch (SQLException e) {
            //throw new RuntimeException(e);
        }
        return piezaList;
    }
//----------------------------------------------------Puede que esto esté mal------- ERROR ERROR ERROR
private void setCategoria(String string) {
//    categoria = new ArrayList<>();
//    categoria.add(new Categoria(1, "pequeño"));
//    categoria.add(new Categoria(2, "mediano"));
//    categoria.add(new Categoria(3, "grande"));
}



    //------------------------------------------método tOstring------------------------
    @Override
    public String toString() {
        return "Pieza\n" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", color='" + color + '\'' +
                ", precio=" + precio +
                ", categoria=" + categoria +
                '}' + "\n";
    }
}


