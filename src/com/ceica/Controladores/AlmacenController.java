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
        proveedorList = new ArrayList<>();
        pedidoList = new ArrayList<>();
        piezaList = new ArrayList<>();
    }


    //creamos obj tipo proveedor -> para añadir nuevos proveedores
    public boolean nuevoProveedor(String cif, String nombre, String direccion, String localidad, String provincia) {
        Proveedor proveedor = new Proveedor(cif, nombre);
        proveedor.setDireccion(direccion);
        proveedor.setLocalidad(localidad);
        proveedor.setProvincia(provincia);
        //para que devuelva un booleano

        //proveedorList.remove(proveedor);
        return proveedorList.add(proveedor);

    }

    //prueba borrar proveedor
    public boolean borrarProveedor(String cif) {
        //recorres lista para buscar proveedor
        for (Proveedor proveedor : proveedorList) {
            if (proveedor.getCif().equals(cif)) {
                proveedorList.remove(proveedor);
                return true;
            }
        }
        //si no se encuentra al proveedor
        return false;
    }
   //otra versión de borrarProveedor
//    public boolean borrarProveedor(String cif){
//        //recorres lista para buscar proveedor
//        for (int i = 0; i < proveedorList.size(); i++) {
//            if(cif.equals(proveedorList.get(i).getCif())){
//                proveedorList.remove(i);
//                //proveedorList.remove(proveedorList.get(i));
//                return true;
//            }
//        }
//        return false;
//    }

    //otra versión con función landa -> funciones flecha // si "eso" es igual es true sino false
//    public boolean borrarProveedor(String cif){
//        return proveedorList.removeIf(proveedor -> cif.equals(proveedor.getCif()));
//    }

    //actualizar - modificar el proveedor
    public boolean actualizarProveedor(String cif, String nombre, String direccion, String localidad, String provincia){
        //busca el proveedor en la lista (for each) clase variable:lista proveedor
        for (Proveedor proveedor : proveedorList) {
            if (proveedor.getCif().equals(cif)){
                //proveedor.setCif(cif);
                proveedor.setNombre(nombre);
                proveedor.setDireccion(direccion);
                proveedor.setLocalidad(localidad);
                proveedor.setProvincia(provincia);
                return true;
            }
        }
        //si no se encontró
          return false;
    }
//otro modo de ActualizarProveedor (pero en este caso solo modifica el nombre)
//    public boolean editarNombreProveedor(String cif, String nombre){
//        for (int i = 0; i < proveedorList.size(); i++) {
//            if(cif.equals(proveedorList.get(i).getCif())){
//                proveedorList.get(i).setNombre(nombre);
//                return true;

//            }
//        }
//        return false;
//    }

//    Otra manera
//
//    public boolean editarNombreProveedor(String cif, String nombre){
//
//        for(Proveedor proveedor : proveedorList){
//            if(cif.equals(proveedor.getCif())){
//                proveedor.setNombre(nombre);
//                return true;
//            }
//        }
//        return false;
//    }
    //para pintar en main - n salto de línea
    @Override
    public String toString() {
        return "AlmacenController{" + "\n" +
                "proveedorList=" + proveedorList + "\n" +
                ", piezaList=" + piezaList + "\n" +
                ", pedidoList=" + pedidoList + "\n" +
                '}';
    }

}


