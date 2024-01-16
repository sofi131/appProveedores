package com.ceica;

import com.ceica.Controladores.AlmacenController;

public class Main {
    public static void main(String[] args) {

        AlmacenController almacen = new AlmacenController();
        almacen.nuevoProveedor("a", "nombre", "dir", "loc", "pro");
        almacen.nuevoProveedor("b", "nombreb", "dir", "loc", "pro");
        //para borrar
//        System.out.println(almacen.borrarProveedor("a"));
//        almacen.borrarProveedor("b");
//        almacen.borrarProveedor("c");
        //para editar los datos
        System.out.println(almacen.actualizarProveedor("a","nombreotro", "dire","locali","prov"));

        System.out.println(almacen.toString());

    }
}