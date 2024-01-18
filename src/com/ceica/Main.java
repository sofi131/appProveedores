package com.ceica;

import com.ceica.Controladores.AlmacenController;

public class Main {
    public static void main(String[] args) {

        AlmacenController almacen = new AlmacenController();
        almacen.nuevoProveedor("a", "nombre", "dir", "loc", "pro");
       // almacen.nuevoProveedor("b", "nombreb", "dir", "loc", "pro");
        almacen.nuevaPieza("PiezaA","verde",45.5,1);
        //para borrar
//        System.out.println(almacen.borrarProveedor("a"));
//        almacen.borrarProveedor("b");
//        almacen.borrarProveedor("c");
        //para editar los datos
        //System.out.println(almacen.editarNombreProveedor("a","nombreotro"));

        System.out.println(almacen.toString());


    }
}