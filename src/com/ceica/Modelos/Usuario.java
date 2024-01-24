package com.ceica.Modelos;

import com.ceica.bbdd.Conexion;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
public class Usuario {
    public static boolean getUsuario(String usr, String pass) {
        Connection conn = Conexion.conectar();
        String sql = "select * from usuario where usuario=? and password=?";
        try {
            PreparedStatement pst = conn.prepareStatement(sql);
            pst.setString(1, usr);
            pst.setString(2, pass);
            ResultSet resultSet = pst.getResultSet();
            if (resultSet.next()) {
                return true;
            } else {
                return false;
            }
        } catch (SQLException e) {
            //throw new RuntimeException(e);
            return false;
        }
    }
}



//comprobar que existen en la base de datos
// crear la tabla usuarios --> 3 campos: id usuario - string, password-string -- HECHO
//los modelos --> hace falta un modelo usuario y dentro de
// usuario hay que hacer la conexión a la base de datos igual que hicimos con proveedores -- HECHO
// método static - objeto conection select where (tata) y ejecutar esa consulta -- HECHO
// result set de un registro si hay 0 está mal no devuelve nada (FALSE TRUE)

