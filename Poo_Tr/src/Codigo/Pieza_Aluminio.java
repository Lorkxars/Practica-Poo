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
public class Pieza_Aluminio extends Producto{
    private double altura;
    private double anchura;
    
    public Pieza_Aluminio(String nombre, String descripcion, double pCompra, double pVenta, boolean instalacion, double altura, double anchura){
        super(nombre, descripcion, pCompra, pVenta, instalacion);
        this.altura = altura;
        this.anchura = anchura;
    }
    
    @Override
    public double calculoPrecioVenta(){
        return this.getPrecioVenta();
    }
    
    public void modificar (String nombre, String descripcion, double pCompra, double pVenta, boolean instalacion, double altura, double anchura){
        this.modificar(nombre, descripcion, pCompra, pVenta, instalacion);
        this.altura = altura;
        this.anchura = anchura;
    }

    public double getAltura() {
        return altura;
    }

    public double getAnchura() {
        return anchura;
    }
     
}
    
    

