/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Codigo;

import java.util.ArrayList;
import java.util.Collections;

/**
 *
 * @author david
 */
public class Franquicia implements Comparable <Franquicia>{
    private String nombre;
    private String horaApertura;
    private String horaCierre;
    private String direccion;
    private double beneficio;
    private int nProdVendidos;
    private double ventasTotales;
    private Catalogo catalogo;
    private ArrayList <Empleado> empleados;
    private Dueno dueno;

    public Franquicia(String nombre, String horaApertura, String horaCierre, String direccion, double beneficio, int nProdVendidos, double ventasTotales, Catalogo catalogo, Dueno dueno, ArrayList <Empleado> empleados) {
        this.nombre = nombre;
        this.horaApertura = horaApertura;
        this.horaCierre = horaCierre;
        this.direccion = direccion;
        this.beneficio = beneficio;
        this.nProdVendidos = nProdVendidos;
        this.ventasTotales = ventasTotales;
        this.catalogo = catalogo;
        this.dueno = dueno;
        this.empleados = empleados;
    }
    
    public Franquicia(String nombre, String horaApertura, String horaCierre, String direccion, Dueno dueno) {
        this.nombre = nombre;
        this.horaApertura = horaApertura;
        this.horaCierre = horaCierre;
        this.direccion = direccion;
        this.catalogo = new Catalogo();
        this.dueno = dueno;
        this.empleados = new ArrayList();
    }
    
    public void ventaProducto(Producto p){  
        beneficio += p.calculoBeneficio();
        ventasTotales += p.calculoPrecioVenta();
        nProdVendidos = nProdVendidos +1;
        catalogo.eliminar(p);
    }
    
    public void modificar(String nombre,String direccion, String horaApertura, String horaCierre){
        this.nombre = nombre;
        this.horaApertura = horaApertura;
        this.horaCierre = horaCierre;
        this.direccion = direccion;
    }
    
    public boolean equals(Franquicia f){
        return (beneficio == f.getBeneficio() && nombre == f.getNombre() && horaApertura == f.getHoraApertura() && horaCierre == f.getHoraCierre() && direccion == f.getDireccion() && catalogo == f.getCatalogo() && nProdVendidos == f.getnProdVendidos() && ventasTotales == f.getVentasTotales());
    }
    
    public void anadirProducto(Producto p){
        catalogo.anadirProducto(p);
    }
    
    @Override
    public String toString(){
        return nombre + "   " + direccion + "   " + horaApertura + "   " + horaCierre;
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
    
    //Devuelve el catalogo ordenado por precio de los productos
    public Catalogo getCatalogoOrd(){
        Catalogo aux = this.getCatalogo(); //Sacas el catalogo de la franquicia
        Collections.sort(aux.getCatalogo());//Sacas la lista catalogo de la clase catalogo y la ordenas
        return aux;
        
    }
    
    @Override
    public int compareTo(Franquicia f){
        return nombre.compareTo(f.nombre);
    }

    public ArrayList<Empleado> getEmpleados() {
        return empleados;
    }

    public Dueno getDueno() {
        return dueno;
    }
    
    public void anadirEmpleado(String nombre, String apellidos, String usuario,String password, double sueldo){
        this.empleados.add(new Empleado(nombre,apellidos,usuario,password,sueldo,this.nombre));
    }
    
    public int esEmpleado(String usuario, String contrasena){//Devuelve el numero del empleado si esta y -1 en otro caso
        int i = 0;
        boolean encontrado = false;
        do{
            encontrado = (usuario.equals(this.empleados.get(i).getUsuario()) && (contrasena.hashCode() == this.empleados.get(i).getPassword()));
            i++;
        }while(i < this.empleados.size() && !encontrado);
        if(encontrado){
            return i-1;
        }
        else{
            return -1;
        }
        
    }
    public int esEmpleado(String usuario, int contrasena){//Devuelve el numero del empleado si esta y -1 en otro caso
        int i = 0;
        boolean encontrado = false;
        do{
            encontrado = (usuario.equals(this.empleados.get(i).getUsuario()) && (contrasena == this.empleados.get(i).getPassword()));
            i++;
        }while(i < this.empleados.size() && !encontrado);
        if(encontrado){
            return i-1;
        }
        else{
            return -1;
        }
        
    }
    
    public void remplazarDueno(String nombre, String apellidos, String usuario,String password){
        this.dueno = null;
        this.dueno = new Dueno(nombre,apellidos,usuario,password);
    }
}
