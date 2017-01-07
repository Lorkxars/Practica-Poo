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
public class Rejas extends Producto{
    private int nbarrotes;
    private boolean personalizado;
    private int altura;
    private int anchura;
    
    public Rejas (String nombre, String descripcion, double pCompra, double pVenta, boolean instalacion, int altura, int anchura, int nbarrotes, boolean personalizado, String franquicia){
        super(nombre, descripcion, pCompra, pVenta, instalacion, franquicia);
        this.nbarrotes = nbarrotes;
        this.personalizado = personalizado;
        
        if (personalizado) {
            this.altura = (altura >0)? altura:0;
            this.anchura = (anchura >0)? anchura:0;
        }
        
        else{
            //No personalizadas aplicamos las restricciones, entre 30 y 300 de 5 en 5
            if (altura<30){
                this.altura = 30;
            }
            else if(altura > 300){
                this.altura= 300;
            }
            else{                
                this.altura = 5 *(altura/5); //Si esta división es de enteros deberia redondearlo a 5 por abajo
            }
            
            if (altura<30){
                this.anchura = 30;
            }
            else if(altura > 300){
                this.anchura= 300;
            }
            else{                
                this.anchura = 5 *(altura/5); //Si esta división es de enteros deberia redondearlo a 5 por abajo
            }
        }
    }
    
    @Override
    public double calculoPrecioVenta(){
      double aux;
       if (personalizado){
           aux = (this.getPrecioVenta()*0.1) + this.getPrecioVenta();
      }
       else{
           aux = this.getPrecioVenta();
       }
       if (this.isInstalacion()){
           aux = aux + 20; //De nuevo la instalación son 20 pavos
       }
       return aux;
   }
    
    @Override
    public double calculoBeneficio(){
        return this.calculoPrecioVenta() - this.getPrecioCompra();
    }
    
     public void modificar (String nombre, String descripcion, double pCompra, double pVenta, boolean instalacion, int altura, int anchura, int nbarrotes, boolean personalizado){
        super.modificar(nombre, descripcion, pCompra, pVenta, instalacion);
        this.nbarrotes = nbarrotes;
        this.personalizado = personalizado;
        
        if (personalizado) {
            this.altura = (altura >0)? altura:0;
            this.anchura = (anchura >0)? anchura:0;
        }
        
        else{
            //No personalizadas aplicamos las restricciones, entre 30 y 300 de 5 en 5
            if (altura<30){
                this.altura = 30;
            }
            else if(altura > 300){
                this.altura= 300;
            }
            else{                
                this.altura = 5 *(altura/5); //Si esta división es de enteros deberia redondearlo a 5 por abajo
            }
            
            if (altura<30){
                this.anchura = 30;
            }
            else if(altura > 300){
                this.anchura= 300;
            }
            else{                
                this.anchura = 5 *(altura/5); //Si esta división es de enteros deberia redondearlo a 5 por abajo
            }
        }
    }
     
     public boolean equals(Rejas p){
        return ((this.altura== p.altura && this.anchura == p.anchura && this.nbarrotes == p.nbarrotes && this.personalizado == p.personalizado)&& (this.parecidos(p.getNombre(), p.getDescripcion(), p.getPrecioCompra(), p.getPrecioVenta(), p.isInstalacion(),p.getFranquicia())));
    }

    public int getNbarrotes() {
        return nbarrotes;
    }

    public boolean isPersonalizado() {
        return personalizado;
    }

    public int getAltura() {
        return altura;
    }

    public int getAnchura() {
        return anchura;
    }    
}
