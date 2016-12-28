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
abstract class Producto{
    
    //que alguien se prepare el javadoc que yo no me acuerdo XD
    private String nombre;
    private String descripcion;
    private double precioVenta;
    private double precioCompra;
    private boolean instalacion;
    
    public Producto(String nombre, String descripcion, double pCompra, double pVenta, boolean instalacion){
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.precioVenta = pVenta;
        this.precioCompra = pCompra;
        this.instalacion = instalacion;
    }
    
    abstract double calculoPrecioVenta(); 
    
    //Alta y baja es crear y eliminar una instancia,
    //modificar implementamos una base que hay que sobreescribir
    //y completar en cada caso
    
    public void modificar (String nombre, String descripcion, double pCompra, double pVenta, boolean instalacion){
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.precioVenta = pVenta;
        this.precioCompra = pCompra;
        this.instalacion = instalacion;
    }
 
    
    

    public String getNombre() {
        return nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public double getPrecioVenta() {
        return precioVenta;
    }

    public double getPrecioCompra() {
        return precioCompra;
    }

    public boolean isInstalacion() {
        return instalacion;
    }
    
    
    
}
