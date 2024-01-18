package com.ceica.Controladores;

import com.ceica.Modelos.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class AlmacenController {
    // public static final Enum={"Verde","Azul","Rojo"};
    private List<Proveedor> proveedorList;
    private List<Pieza> piezaList;
    private List<Pedido> pedidoList;
    private List<Categoria> categorias;


    //vacío -> constructor almacén que vamos llenando
    public AlmacenController() {
        proveedorList = new ArrayList<>();
        pedidoList = new ArrayList<>();
        piezaList = new ArrayList<>();
        categorias = new ArrayList<>();
        categorias.add(new Categoria(1, "pequeño"));
        categorias.add(new Categoria(2, "mediano"));
        categorias.add(new Categoria(3, "grande"));
    }

    //----------------------------------------nuevoProveedor--------------------------------------------
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

    //prueba -------------borrar proveedor----------------- - MI VERSIÓN
//    public boolean borrarProveedor(String cif) {
//        //recorres lista para buscar proveedor
//        for (Proveedor proveedor : proveedorList) {
//            if (proveedor.getCif().equals(cif)) {
//                proveedorList.remove(proveedor);
//                return true;
//            }
//        }
//        //si no se encuentra al proveedor
//        return false;
//    }
    //-------------------------------borrarProveedor--------------------------------------
    public boolean borrarProveedor(String cif) {
        return proveedorList.removeIf(proveedor -> cif.equals(proveedor.getCif()));
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

    //-------------------actualizar--------------- modificar el proveedor MI VERSIÓN - lo edita tó
//    public boolean actualizarProveedor(String cif, String nombre, String direccion, String localidad, String provincia){
//        //busca el proveedor en la lista (for each) clase variable:lista proveedor
//        for (Proveedor proveedor : proveedorList) {
//            if (proveedor.getCif().equals(cif)){
//                //proveedor.setCif(cif);
//                proveedor.setNombre(nombre);
//                proveedor.setDireccion(direccion);
//                proveedor.setLocalidad(localidad);
//                proveedor.setProvincia(provincia);
//                return true;
//            }
//        }
//        //si no se encontró
//          return false;
//    }
    //-------------------------------------editarNombreProveedor----------------------------------
    public boolean editarNombreProveedor(String cif, String nombre) {
        /*
        for (int i = 0; i < proveedorList.size(); i++) {
            if(cif.equals(proveedorList.get(i).getCif())){
                proveedorList.get(i).setNombre(nombre);
                return true;
            }
        }
        return false;
         */
        for (Proveedor proveedor : proveedorList) {
            if (cif.equals(proveedor.getCif())) {
                proveedor.setNombre(nombre);
                return true;
            }
        }
        return false;
    }
    //-------------------------ActualizarProveedor--------------------------------
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
//--------------------editarNombreProveedor--------------------------------------------
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
// ------------------------Prueba con map------------------------------------------
//    public boolean editarNombreProveedor(String cif, String nombre){
//        /*
//        for (int i = 0; i < proveedorList.size(); i++) {
//            if(cif.equals(proveedorList.get(i).getCif())){
//                proveedorList.get(i).setNombre(nombre);
//                return true;
//            }
//        }
//        return false;
//         */
//        /*
//        for(Proveedor proveedor : proveedorList){
//            if(cif.equals(proveedor.getCif())){
//                proveedor.setNombre(nombre);
//                return true;
//            }
//        }
//        return false;
//         */
//        proveedorList.stream()
//                .filter(p->cif.equals(p.getCif()))
//                .findFirst()
//                .map(p -> {
//                    p.setNombre(nombre);
//                    return true;
//                })
//                .orElse(false);
//        return false;
//    }
//----------------------------CRUD de piezas-------------------------------------

    //alta, editar, eliminar
//---------------------------nueva pieza y categorías--------------------------------
    public boolean nuevaPieza(String nombre, Color color, Double precio, int idcategoria) {
        Pieza pieza = new Pieza(nombre, color.toString(), precio);
        pieza.setCategoria(getCategoriaById(idcategoria));
        piezaList.add(pieza);
//
        return true;
    }

    private Categoria getCategoriaById(int id) {
        return categorias.stream()
                .filter(categoria -> categoria.getId() == id)
                .findFirst().get();
    }

    //-------------------------------borrar pieza----------------------------------
//    public boolean borrarPieza(String cif) {
//        return piezaList.removeIf(pieza -> cif.equals(pieza.getCif()));
//    }
//
//    //-------------------------------editar precio pieza-----------------------------------
    public boolean editarPrecioPieza(int id, Double precio) {
        return piezaList.stream()
                .filter(pieza -> pieza.getId() == id)
                .findFirst()
                .map(pieza -> {
                    pieza.setPrecio(precio);

                    return true;
                })
                .orElse(false);
//        }
//        return false;
    }

    //---------------------------------------pedidos------------------------------------------------
    public String nuevoPedido(String cif, int idPieza, int cantidad) {
        //Pedido pedido = new Pedido(); no hace falta
        Proveedor proveedor = getProveedorByCIF(cif);
        if (proveedor != null) {
            Pieza pieza = getPiezaByID(idPieza);
            if (pieza != null) {
                Pedido pedido1 = new Pedido(proveedor, pieza);
                pedido1.setCantidad(cantidad);
                pedido1.setFecha(LocalDate.now());
                pedidoList.add(pedido1);
                return "Pedido creado";
            } else {
                return "Error al crear el pedido, Proveedor no existe";
            }
        } else {
            return "Error al crear el pedido, Proveedor no existe";
        }
    }

    //otra manera de hacer el for (la de antes)
    private Pieza getPiezaByID(int id) {
        for (int i = 0; i < piezaList.size(); i++) {
            if (piezaList.get(i).getId() == id) {
                return piezaList.get(i);
            }
        }
        return null;
    }

    private Proveedor getProveedorByCIF(String cif) {
        for (Proveedor p : proveedorList) {
            if (cif.equals(p.getCif())) {
                return p;
            }
            //no hay ningún proveedor con esas características
        }
        return null;
    }

    //----------------------------------------------toString general---------------------------
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

