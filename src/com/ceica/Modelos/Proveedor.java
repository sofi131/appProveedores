package com.ceica.Modelos;

import com.ceica.bbdd.Conexion;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import static java.lang.System.out;

public class Proveedor {
    private int id;
    private String cif;
    private String nombre;
    private String direccion;
    private String localidad;

    //vacío
    public Proveedor() {

    }

    //2 valores
    public Proveedor(java.lang.String cif, java.lang.String nombre) {
        this.cif = cif;
        this.nombre = nombre;
    }

    //getter
    public int getId() {
        return id;
    }

    public String getCif() {
        return cif;
    }

    public String getNombre() {
        return nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public String getLocalidad() {
        return localidad;
    }

    public String getProvincia() {
        return provincia;
    }

    //setter
    public void setId(int id) {
        this.id = id;
    }

    public void setCif(String cif) {
        this.cif = cif;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public void setLocalidad(String localidad) {
        this.localidad = localidad;
    }

    public void setProvincia(String provincia) {
        this.provincia = provincia;
    }

    private String provincia;

    //------------------------------Conexión a proveedores-------------------------------
    public static List<Proveedor> getProveedores() {
        List<Proveedor> proveedorList = new ArrayList<>();
        Connection conn = Conexion.conectar();
        //Consulta
        String sql = "select * from proveedores";
        //createStatement da error, y en más acciones le damos a surroundedexception
        try {
            Statement stm = conn.createStatement();
            ResultSet respuesta = stm.executeQuery(sql);
            //recorre los registros y mira si hay los siguientes
            while (respuesta.next()) {
                Proveedor proveedor = new Proveedor();
                proveedor.setId(respuesta.getInt("idProveedor"));
                proveedor.setNombre(respuesta.getString("nombre"));
                proveedor.setDireccion(respuesta.getString("dirección"));
                proveedor.setLocalidad(respuesta.getString("localidad"));
                proveedor.setProvincia(respuesta.getString("provincia"));
                proveedorList.add(proveedor);
            }

        } catch (SQLException e) {
            // throw new RuntimeException(e);
            return proveedorList;
        }
        return proveedorList;
    }


    //método toString cadena de txt con toda la info
    @Override
    public String toString() {
        return "Proveedor{" +
                "id=" + id +
                ", cif='" + cif + '\'' +
                ", nombre='" + nombre + '\'' +
                ", direccion='" + direccion + '\'' +
                ", localidad='" + localidad + '\'' +
                ", provincia='" + provincia + '\'' + "\n" +
                '}';
    }
}
