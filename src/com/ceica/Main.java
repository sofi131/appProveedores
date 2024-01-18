package com.ceica;

import com.ceica.Controladores.AlmacenController;
import com.ceica.Modelos.Color;

public class Main {
    public static void main(String[] args) {

        AlmacenController almacen = new AlmacenController();
        almacen.nuevoProveedor("a", "nombre", "dir", "loc", "pro");
        // almacen.nuevoProveedor("b", "nombreb", "dir", "loc", "pro");
        almacen.nuevaPieza("PiezaA", Color.AZUL, 45.5, 1);
        almacen.nuevaPieza("PiezaB", Color.AZUL, 5.5, 2);
        //para borrar
        //System.out.println(almacen.borrarProveedor("a"));
        //almacen.borrarProveedor("b");
        //almacen.borrarProveedor("c");
        //para editar los datos
        //System.out.println(almacen.editarNombreProveedor("a","nombreotro"));
        //almacen.editarPrecioPieza(1, 65.4);
        System.out.println(almacen.nuevoPedido("a",1,50));
        System.out.println(almacen.nuevoPedido("a",1,10));
        System.out.println(almacen.nuevoPedido("j",0,30));
        System.out.println(almacen.getPedidosByPieza(8));
        System.out.println(almacen.toString());
    }
}