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


    /**
     * Listas dentro del AlmacénController
     */
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

    /**
     * @param cif cif
     * @param nombre nombre
     * @param direccion dirección
     * @param localidad localidad
     * @param provincia provincia
     * @return Un nuevo proveedor
     */
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

    /**
     * @param cif cif
     * @return Borra el proveedor
     */
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

    /**
     * @param cif cif
     * @param nombre nombre
     * @return Datos del proveedor editados
     */
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

    /**
     * @param nombre nombre pieza
     * @param color color pieza
     * @param precio precio pieza
     * @param idcategoria categoría pieza
     * @return Una nueva pieza
     */
    //alta, editar, eliminar
//---------------------------nueva pieza y categorías--------------------------------
    public boolean nuevaPieza(String nombre, Color color, Double precio, int idcategoria) {
        Pieza pieza = new Pieza(nombre, color.toString(), precio);
        pieza.setCategoria(getCategoriaById(idcategoria));
        piezaList.add(pieza);
//
        return true;
    }

    /**
     * @param id id de la categoría de la pieza
     * @return categoría de la pìeza
     */
    private Categoria getCategoriaById(int id) {
        return categorias.stream()
                .filter(categoria -> categoria.getId() == id)
                .findFirst().get();
    }

    /**
     * @param id id del precio de la pieza
     * @param precio precio de la pieza
     * @return precio editado
     */
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

    /**
     * @param cif cif
     * @param idPieza id de la pieza
     * @param cantidad nº de piezas
     * @return Que el pedido haya sido creado o que haya sido un error
     */
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

    /**
     * @param id id pieza
     * @return pieza
     */
    //otra manera de hacer el for (la de antes)
    private Pieza getPiezaByID(int id) {
        for (int i = 0; i < piezaList.size(); i++) {
            if (piezaList.get(i).getId() == id) {
                return piezaList.get(i);
            }
        }
        return null;
    }

    /**
     * @param cif cif proveedor
     * @return proveedor o no
     */
    private Proveedor getProveedorByCIF(String cif) {
        for (Proveedor p : proveedorList) {
            if (cif.equals(p.getCif())) {
                return p;
            }
            //no hay ningún proveedor con esas características
        }
        return null;
    }

    /**
     * @param idPieza id de la pieza
     * @return ver si hay los pedidos correspondientes de la pieza o no
     */
    public String getPedidosByPieza(int idPieza){
        List<Pedido> pedidosByPieza=new ArrayList<>();
        for (Pedido pedido : pedidoList){
            if(pedido.getPieza().getId()==idPieza){
                pedidosByPieza.add(pedido);
            }
        }
        if(pedidosByPieza.size()>0){
            return pedidosByPieza.toString();
        }else{
            return "No hay pedidos de esta pieza";
        }
    }

    /**
     * @param cif cif del proveedor
     * @return ver si hay pedidos de un proveedor o no
     */
    public String getPedidosByProveedor(String cif){
        List<Pedido> pedidosByProveedor = new ArrayList<>();
        for (Pedido pedido : pedidoList){
            if(pedido.getProveedor().getCif().equals(cif)){
                pedidosByProveedor.add(pedido);
            }
        }
        if(pedidosByProveedor.size()>0){
            return pedidosByProveedor.toString();
        }else{
            return "No hay pedidos de esta proveedor";
        }
    }

    /**
     * @return proveedores, piezas y pedidos
     */
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

