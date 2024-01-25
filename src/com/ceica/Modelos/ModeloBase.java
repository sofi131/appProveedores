package com.ceica.Modelos;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.Properties;
import java.util.List;

public abstract class ModeloBase {
    private static final String CONFIG_FILE = "config.properties";
    protected static String URL;
    protected static String USUARIO;
    protected static String PASSWORD;

    static {
        cargarConfiguracion();
    }

    private static void cargarConfiguracion() {
        Properties propiedades = new Properties();
        try (FileInputStream entrada = new FileInputStream(CONFIG_FILE)) {
            propiedades.load(entrada);
            URL = propiedades.getProperty("db.url");
            USUARIO = propiedades.getProperty("db.usuario");
            PASSWORD = propiedades.getProperty("db.password");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Método abstracto para obtener el nombre de la tabla
    protected abstract String getNombreTabla();

    // Métodos para CRUD---- INSERT, UPDATE, DELETE, READ

    protected void insertar(String sql, Object... parametros) {
        sql="insert into " +getNombreTabla()+" "+sql;
        ejecutarQuery(sql, parametros);
    }

    protected void actualizar(String sql, Object... parametros) {
        sql="update "+getNombreTabla()+" "+sql;
        ejecutarQuery(sql, parametros);
    }

    protected void borrar(String sql, Object... parametros) {
        sql="delete from "+getNombreTabla()+" where "+sql;
        ejecutarQuery(sql, parametros);
    }

    // Método para leer datos de la base de datos -- devolver lista de obj
    protected List<Object> leer(String sql, Object... parametros) {
        List<Object> objectList = new ArrayList<>();
        try {
            Connection conexion = DriverManager.getConnection(URL, USUARIO, PASSWORD);
            PreparedStatement preparedStatement = conexion.prepareStatement(sql);
            // Establecer los valores de los parámetros
            for (int i = 0; i < parametros.length; i++) {
                preparedStatement.setObject(i + 1, parametros[i]);
            }
            ResultSet resultSet = preparedStatement.executeQuery();
            ResultSetMetaData md = resultSet.getMetaData();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        // Implementa la lógica para leer datos
    }

    // Método genérico para ejecutar consultas SQL
    private void ejecutarQuery(String sql, Object... parametros) {
        try (Connection conexion = DriverManager.getConnection(URL, USUARIO, PASSWORD);
             PreparedStatement preparedStatement = conexion.prepareStatement(sql)) {

            // Establecer los valores de los parámetros
            for (int i = 0; i < parametros.length; i++) {
                preparedStatement.setObject(i + 1, parametros[i]);
            }

            // Ejecutar la consulta
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

