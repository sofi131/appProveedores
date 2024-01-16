package com.ceica.Modelos;

import java.time.LocalDate;

public class Pedido {
    private int id;
    private Proveedor proveedor;
    private Pieza pieza;
    private LocalDate fecha;
    private int cantidad;
//vacío
    public Pedido() {
    }
//pedido dos
    public Pedido(Proveedor proveedor, Pieza pieza) {
        this.proveedor = proveedor;
        this.pieza = pieza;
    }

    //getter

    public int getId() {
        return id;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public int getCantidad() {
        return cantidad;
    }

    //setter

    public void setId(int id) {
        this.id = id;
    }

    public void setProveedor(Proveedor proveedor) {
        this.proveedor = proveedor;
    }

    public void setPieza(Pieza pieza) {
        this.pieza = pieza;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }
}
