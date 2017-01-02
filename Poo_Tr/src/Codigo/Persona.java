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
public class Persona {
    private String nombre;
    private String apellidos;
    private String usuario;
//Para darle emoción no vamos a guardar la contraseña si no un hash de la misma
    private int password;
    
    public Persona (String nombre, String apellidos, String usuario,String password){
      this.nombre = nombre;
      this.apellidos = apellidos;
      this.usuario = usuario;
      this.password = password.hashCode();
    }
    
    public void modificar(String nombre, String apellidos, String usuario,String password){
      this.nombre = nombre;
      this.apellidos = apellidos;
      this.usuario = usuario;
      this.password = password.hashCode();
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public String getUsuario() {
        return usuario;
    }

    public int getPassword() {
        return password;
    }
}
