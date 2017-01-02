/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Codigo;

/**
 *
 * @author david
 */
public class Franquicia {
    private String nombre;
    private String horaApertura;
    private String horaCierre;
    private String direccion;
    private double beneficio;
    private int nProdVendidos;
    private double ventasTotales;
    private Catalogo catalogo;

    public Franquicia(String nombre, String horaApertura, String horaCierre, String direccion, double beneficio, int nProdVendidos, double ventasTotales, Catalogo catalogo) {
        this.nombre = nombre;
        this.horaApertura = horaApertura;
        this.horaCierre = horaCierre;
        this.direccion = direccion;
        this.beneficio = beneficio;
        this.nProdVendidos = nProdVendidos;
        this.ventasTotales = ventasTotales;
        this.catalogo = catalogo;
    }
    
    public Franquicia(String nombre, String horaApertura, String horaCierre, String direccion) {
        this.nombre = nombre;
        this.horaApertura = horaApertura;
        this.horaCierre = horaCierre;
        this.direccion = direccion;
        this.catalogo = new Catalogo();
    }
    
    public void ventaProducto(Producto p){  
        beneficio += p.calculoBeneficio();
        ventasTotales += p.calculoPrecioVenta();
        catalogo.eliminar(p);
    }
    
    public void modificar(String nombre, String horaApertura, String horaCierre, String direccion){
        this.nombre = nombre;
        this.horaApertura = horaApertura;
        this.horaCierre = horaCierre;
        this.direccion = direccion;
    }

    public String getNombre() {
        return nombre;
    }

    public String getHoraApertura() {
        return horaApertura;
    }

    public String getHoraCierre() {
        return horaCierre;
    }

    public String getDireccion() {
        return direccion;
    }

    public double getBeneficio() {
        return beneficio;
    }

    public int getnProdVendidos() {
        return nProdVendidos;
    }

    public double getVentasTotales() {
        return ventasTotales;
    }

    public Catalogo getCatalogo() {
        return catalogo;
    }
}
