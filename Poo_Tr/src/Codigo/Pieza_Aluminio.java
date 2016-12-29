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
    private int altura;
    private int anchura;
    
    public Pieza_Aluminio(String nombre, String descripcion, double pCompra, double pVenta, boolean instalacion, int altura, int anchura){
        super(nombre, descripcion, pCompra, pVenta, instalacion);
        this.altura = (altura >= 0)? altura: 0;
        this.anchura = (anchura >=0)? anchura:0 ;
    }
    
    @Override
    public double calculoPrecioVenta(){
        if (this.isInstalacion()){
            return this.getPrecioVenta() + 20; //Instalación 20 pavos porque me apetece
        }
        else{
            return this.getPrecioVenta();
        }    
    }
    
    public boolean equals(Pieza_Aluminio p){
        return ((this.altura== p.altura && this.anchura == p.anchura)&& (this.parecidos(p.getNombre(), p.getDescripcion(), p.getPrecioCompra(), p.getPrecioVenta(), p.isInstalacion())));
    }
    
    @Override
    public double calculoBeneficio(){
        return this.calculoPrecioVenta() - this.getPrecioCompra();
    }
    
    public void modificar (String nombre, String descripcion, double pCompra, double pVenta, boolean instalacion, int altura, int anchura){
        this.modificar(nombre, descripcion, pCompra, pVenta, instalacion);
        this.altura = (altura >= 0)? altura: 0;
        this.anchura = (anchura >=0)? anchura:0 ;
    }

    public int getAltura() {
        return altura;
    }

    public int getAnchura() {
        return anchura;
    }
     
}
    
    

