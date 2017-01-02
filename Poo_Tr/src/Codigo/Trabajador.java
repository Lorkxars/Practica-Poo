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
public class Trabajador extends Persona{
    private double sueldo;
    
    public Trabajador(String nombre, String apellidos, String usuario,String password, double sueldo){
        super(nombre, apellidos, usuario, password);
        this.sueldo = sueldo;
    }

    public double getSueldo() {
        return sueldo;
    }
    
    public void modificar(String nombre, String apellidos, String usuario,String password, double sueldo){
        this.modificar(nombre, apellidos, usuario, password);
        this.sueldo = sueldo;
    }
    
}
