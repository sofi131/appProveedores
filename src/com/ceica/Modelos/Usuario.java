package com.ceica.Modelos;

import com.ceica.bbdd.Conexion;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
public class Usuario {
    private int id;
    private String usuario;
    private String password;

    //vacío
    public Usuario() {
    }

    //------------------------------------------SETTER---------------------------
    public void setId(int id) {
        this.id = id;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getId() {
        return id;
    }
    //-----------------------------------GETTER----------------------------------
    public String getUsuario() {
        return usuario;
    }

    public String getPassword() {
        return password;
    }
    //------------------------------------ListaUsuarios----------------------------------
    public List getUsuarios()  {
        List usuarioList = new ArrayList<>();
        Connection conn = Conexion.conectar();
        String sql = "select * from usuario";
        try {
            Statement stm = conn.createStatement();
            ResultSet respuesta = stm.executeQuery(sql);
            while (respuesta.next()){
                Usuario usuario = new Usuario();
                usuario.setId(respuesta.getInt("idUsuario"));
                usuario.setUsuario(respuesta.getString("nombreUsuario"));
                usuario.setPassword(respuesta.getString("password"));
                usuarioList.add(usuario);
            }
            conn.close();
        } catch (SQLException e) {
            // Manejo de la excepción
            e.printStackTrace();
        }
        return usuarioList;
    }
}



//comprobar que existen en la base de datos
// crear la tabla usuarios --> 3 campos: id usuario - string, password-string -- HECHO
//los modelos --> hace falta un modelo usuario y dentro de
// usuario hay que hacer la conexión a la base de datos igual que hicimos con proveedores -- HECHO
// método static - objeto conection select where (tata) y ejecutar esa consulta -- HECHO
// result set de un registro si hay 0 está mal no devuelve nada (FALSE TRUE)

