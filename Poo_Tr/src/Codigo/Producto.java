/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Codigo;
import java.io.Serializable;
/**
 *
 * @author david
 */
abstract public class Producto implements Comparable <Producto>, Serializable{
    
    //que alguien se prepare el javadoc que yo no me acuerdo XD
    private String nombre;
    private String descripcion;
    private double precioVenta;
    private double precioCompra;
    private boolean instalacion;
    private String franquicia;
    
    public Producto(String nombre, String descripcion, double pCompra, double pVenta, boolean instalacion, String franquicia){
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.precioVenta = (pVenta >=0)? pVenta:0;
        this.precioCompra = (pCompra >= 0)? pCompra:0;
        this.instalacion = instalacion;
        this.franquicia = franquicia;
    }
    
    abstract double calculoBeneficio();
    
    abstract double calculoPrecioVenta(); 
    
    //Alta y baja es crear y eliminar una instancia,
    //modificar implementamos una base que hay que sobreescribir
    //y completar en cada caso
    
    public void modificar (String nombre, String descripcion, double pCompra, double pVenta, boolean instalacion){
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.precioVenta = (pVenta >=0)? pVenta:0;
        this.precioCompra = (pCompra >= 0)? pCompra:0;
        this.instalacion = instalacion;
    }
 
    //Metodo auxiliar para implementar los equals de las clases hijas
    protected boolean parecidos (String nombre, String descripcion, double pCompra, double pVenta, boolean instalacion, String franquicia){
        return (this.nombre == nombre && this.descripcion == descripcion && this.precioCompra == pCompra && this.precioVenta == pVenta && this.instalacion == instalacion && this.franquicia.equals(franquicia));
    }
    
    @Override
    public int compareTo(Producto p){
        double alpha = 0.00001; //Para comparar decimales hay que poner un margen de error
        if (this.calculoPrecioVenta() < (p.calculoPrecioVenta () - alpha)){
            return -1;
        }
        else if (this.calculoPrecioVenta() > (p.calculoPrecioVenta() + alpha)){
            return 1;
        }
        else return 0;
    }
    
    @Override
    public String toString(){
        return nombre + "   " + this.calculoPrecioVenta()+ "   " + franquicia;
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

    public String getFranquicia() {
        return franquicia;
    }
    
    
    
}
