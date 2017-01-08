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
public class Empleado extends Persona{
    private double sueldo;
    private String franquicia;
    
    public Empleado(String nombre, String apellidos, String usuario,String password, double sueldo, String franquicia){
        super(nombre, apellidos, usuario, password);
        this.sueldo = sueldo;
        this.franquicia = franquicia;
    }

    public double getSueldo() {
        return sueldo;
    }
    
    public void modificar(String nombre, String apellidos, String usuario,String password, double sueldo){
        this.modificar(nombre, apellidos, usuario, password);
        this.sueldo = sueldo;
    }
    
    @Override
    public String toString(){
        return (this.getNombre() +"    "+ this.getApellidos() +"    "+ this.getSueldo());
    }

    public String getFranquicia() {
        return franquicia;
    }
    
}
