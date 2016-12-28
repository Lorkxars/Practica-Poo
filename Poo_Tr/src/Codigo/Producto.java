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
    
    abstract double calculoPrecioVenta(); 
    
    abstract void alta();
    
    abstract void baja();
    
    abstract void modificacion ();
    
}
