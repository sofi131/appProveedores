package com.ceica.Modelos;

import com.ceica.bbdd.Conexion;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class Categoria extends ModeloBase {
    private int id;
    private String nombre;

    public Categoria(int id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }
    //------------------------------------constructor categoría NUEVO---------------------------
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

    //--------------------PRUEBA categorías----------------------------------
//    public static List<Categoria> getCategoria()  {
//        List<Categoria> CategoriaList=new ArrayList<>();
//        Connection conn= Conexion.conectar();
//        String sql="SELECT * FROM Categorias";
//        try {
//            Statement stm=conn.createStatement();
//            ResultSet respuesta = stm.executeQuery(sql);
//            while (respuesta.next()){
//                Categoria Categoria=new Categoria();
//                Categoria.setId(respuesta.getInt("idCategorias"));
//                Categoria.setNombre(respuesta.getString("nombre"));
//                CategoriaList.add(Categoria);
//            }
//
//        } catch (SQLException e) {
//            //throw new RuntimeException(e);
//
//            return CategoriaList;
//        }
//        try {
//            conn.close();
//        } catch (SQLException e) {
//            //throw new RuntimeException(e);
//        }
//        return CategoriaList;
//    }
//-----------------------------------------tOstring // se cambia-----------------------------------
    @Override
    public String toString() {
        return  +id + "->" + nombre + "\n";

    }
//método abstracto que devuelve un String
    @Override
    protected String getNombreTabla() {
        return "categorias";
    }
    //para probar que funciona
    public static void main(String[] a) {
        //System.out.println("Hola");
        Categoria categoria = new Categoria();
        //Insertar---------------------------------
//        categoria.setNombre("Portátiles");
//        //código -> bbdd
//        String sql="(categoria) values (?)";
        //categoria.insertar(sql,categoria.getNombre());
        //Actualizar-------------------------------
        //categoria.actualizar("set categoria=? where idcategoria=?", "Mesas", 1);
        //Borrar------------------------------------ no se puede porque es una FK
         //categoria.borrar("idcategoria=?",1);
    }

}
