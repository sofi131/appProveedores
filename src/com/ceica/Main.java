package com.ceica;

import com.ceica.Controladores.AlmacenController;
import com.ceica.Controladores.LoginController;
import com.ceica.Modelos.Color;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        String usr, pass;
        AlmacenController almacen = new AlmacenController();
        Scanner leer = new Scanner(System.in);
        System.out.println("Bienvenido a AppAlmacen");
        System.out.println("...Enter para empezar");
        leer.nextLine();
        do {
            System.out.println("Login de AppAlmacen");
            System.out.println("Introduce Usuario: ");
            usr = leer.nextLine();
            System.out.print("Introduce password");
            pass = leer.nextLine();
            if (LoginController.login(usr, pass)) {
                System.out.println("Estoy en la AppAlmacén");
                menuPrincipalAlmacen(leer, almacen); //leer tipo scanner y que guarde los datos en almacén
                leer.nextLine();
            } else {
                System.out.println("Usuario o Contraseña incorrecta");
            }
        } while (true);
    }

    //creado a partir del if donde está menuPrincipalAlmacén - 3 consulta dentro de pedidos
    private static void menuPrincipalAlmacen(Scanner leer, AlmacenController almacen) {
        String op = ""; //operación que el usuario hará (1,2,3,4).
        String menuPrincipal = """
                1. Proveedores
                2. Piezas
                3. Pedidos 
                4. Salir
                """;
        do {
            System.out.println(menuPrincipal);
            op = leer.nextLine();
            switch (op) {
                case "1":
                    //Proveedores
                    subMenuProveedores(leer, almacen);
                    break;
                case "2":
                    //Piezas
                    //subMenuPiezas(leer, almacen);
                    break;
                case "3":
                    //Pedidos
                    //subMenuPedidos(leer, almacen);
                    break;
                case "4":
                    //Salir
                    break;
                default:
                    System.out.println("Opción no válida");
            }
        } while (!"4".equals(op)); //si es distinto de 4 se queda ahí
    }

    //-------------------------------------------subMenúProveedores------------------------------
    private static void subMenuProveedores(Scanner leer, AlmacenController almacen) {
        String op, cif, nombre, direccion, localidad, provincia; // 2 submenu
        String menuProveedores = """
                1. Nuevo proveedor
                2. Editar proveedor
                3. Ver proveedores
                4. Eliminar proveedor
                5. Volver a menú principal
                """;
        do {
            System.out.println(menuProveedores);
            op = leer.nextLine();
            switch (op) {
                case "1":
                    //Nuevo proveedor
                    System.out.println("CIF: ");
                    cif = leer.nextLine();
                    almacen.nuevoProveedor(cif);
                    break;
                case "2":
                    //Editar proveedor
                    System.out.println("CIF del proveedor a editar: ");
                    cif = leer.nextLine();
                    if (almacen.existeProveedor(cif)) {
                        almacen.editarProveedor(cif);
                    } else {
                        System.out.println("El proveedor no existe.");
                    }
                    break;
                case "3":
                    //Ver proveedores
                    System.out.println(almacen.verProveedores());
                    break;
                case "4":
                    //Eliminar proveedor
                    System.out.println("CIF del proveedor a eliminar: ");
                    cif = leer.nextLine();
                    if (almacen.existeProveedor(cif)) {
                        //esto ya ha sido creado anteriormente
                        almacen.borrarProveedor(cif);
                    } else {
                        System.out.println("El proveedor no existe.");
                    }
                    break;
                case "5":
                    //Salida
                    System.out.println("Volviendo al menú principal...");
                    break;
                default:
                    //Si se metiese una opción diferente a las anteriores.
                    System.out.println("Opción no válida");
            }
        } while (!"5".equals(op)); //si es distinto de 5 se queda ahí

    }

    //-------------------------------------nuevoProveedor------------------------------
    public static void nuevoProveedor(Scanner leer, AlmacenController almacen) {
        String cif, nombre, direccion, localidad, provincia;
        System.out.println("Cif: ");
        cif = leer.nextLine();
        System.out.println("Nombre: ");
        nombre = leer.nextLine();
        System.out.println("Dirección: ");
        direccion = leer.nextLine();
        System.out.println("Localidad: ");
        localidad = leer.nextLine();
        System.out.println("Provincia: ");
        provincia = leer.nextLine();
        almacen.nuevoProveedor(cif, nombre, direccion, localidad, provincia);
    }

    //-------------------------------------editarProveedor----------------------------------
    public static boolean editarProveedor(Scanner leer, AlmacenController almacen) {
        String cif;
        //System.out.println("CIF del proveedor a editar: ");
        cif = leer.nextLine();
        if (almacen.existeProveedor(cif)) {
            System.out.println("Introduce el nuevo nombre del proveedor: ");
            String nombre = leer.nextLine();
            System.out.println("Introduce la nueva dirección del proveedor: ");
            String direccion = leer.nextLine();
            System.out.println("Introduce la nueva localidad del proveedor: ");
            String localidad = leer.nextLine();
            System.out.println("Introduce la nueva provincia del proveedor: ");
            String provincia = leer.nextLine();
            almacen.editarProveedor(cif, nombre, direccion, localidad, provincia);
            System.out.println("Proveedor editado correctamente.");
            return true;
        } else {
            System.out.println("El proveedor no existe.");
            return false;
        }
    }
    //----------------------------------verProveedores-------------------------
}


