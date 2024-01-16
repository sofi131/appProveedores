package com.ceica.Controladores;

import com.ceica.Modelos.Pedido;
import com.ceica.Modelos.Pieza;
import com.ceica.Modelos.Proveedor;

import java.util.ArrayList;
import java.util.List;

public class AlmacenController {
    private List<Proveedor> proveedorList;
    private List<Pieza> piezaList;
    private List<Pedido> pedidoList;

//vacío -> constructor almacén
    public AlmacenController() {
        proveedorList=new ArrayList<>();
        pedidoList=new ArrayList<>();
        piezaList=new ArrayList<>();
    }


    //creamos obj tipo proveedor
    public boolean nuevoProveedor(String cif, String nombre, String direccion, String localidad, String provincia){
       Proveedor proveedor=new Proveedor(cif, nombre);
       proveedor.setDireccion(direccion);
       proveedor.setLocalidad(localidad);
       proveedor.setProvincia(provincia);
       //para que devuelva un booleano
       return proveedorList.add(proveedor);
        //return true;

    }
    //para pintar en main - n salto de línea
    @Override
    public String toString() {
        return "AlmacenController{" + "\n"+
                "proveedorList=" + proveedorList + "\n"+
                ", piezaList=" + piezaList + "\n"+
                ", pedidoList=" + pedidoList + "\n"+
                '}';
    }

}
