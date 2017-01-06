/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Codigo;

import java.util.ArrayList;
import java.util.Collections;
import java.io.Serializable;

/**
 *
 * @author david
 */
public class Franquicia implements Comparable <Franquicia>, Serializable{
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

    /**
     * Constructor completo de la clase Franquicia
     * @param nombre nombre de la franquicia
     * @param horaApertura horaApertura
     * @param horaCierre horaCierre
     * @param direccion direccion
     * @param beneficio beneficios totales de la franquicia
     * @param nProdVendidos numero de productos vendidos
     * @param ventasTotales facturacion total de la franquicia
     * @param catalogo lista de productos de la franquicia
     * @param dueno dueno de la franquicia
     * @param empleados lista de empleados de la franquicia
     */
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
    
    /**
     * Constructor de la clase Franquicia desde 0, solo con los datos que la identifican
     * @param nombre nombre de la franquicia
     * @param horaApertura horaApertura
     * @param horaCierre horaCierre
     * @param direccion direccion
     * @param dueno dueno de la franquicia
     */
    public Franquicia(String nombre, String horaApertura, String horaCierre, String direccion, Dueno dueno) {
        this.nombre = nombre;
        this.horaApertura = horaApertura;
        this.horaCierre = horaCierre;
        this.direccion = direccion;
        this.catalogo = new Catalogo();
        this.dueno = dueno;
        this.empleados = new ArrayList();
    }
    
    /**
     * Vende un producto de la franquicia y actualiza los datos monetarios de la misma
     * @param p producto a vender
     * @exception NoEncontradoExcp se lanza si intentas vender un producto del que no dispones
     */
    public void ventaProducto(Producto p)throws NoEncontradoExcp{ 
        if (catalogo.esta(p)){
            beneficio += p.calculoBeneficio();
            ventasTotales += p.calculoPrecioVenta();
            nProdVendidos = nProdVendidos +1;
            catalogo.eliminar(p);
        }else{
            throw new NoEncontradoExcp("Este producto no le pertenece a la franquicia");
        }
    }
    
    /**
     * Modifica los atributos de identificacion de la franquicia
     * @param nombre nombre
     * @param direccion direccion
     * @param horaApertura horaApertura
     * @param horaCierre  horaCierre
     */
    public void modificar(String nombre,String direccion, String horaApertura, String horaCierre){
        this.nombre = nombre;
        this.horaApertura = horaApertura;
        this.horaCierre = horaCierre;
        this.direccion = direccion;
    }
    
    /**
     * Comprueba si tu franquicia y otra son la misma
     * @param f franquicia con la que comparamos
     * @return devuelve si son la misma o no
     */
    public boolean equals(Franquicia f){
        return (beneficio == f.getBeneficio() && nombre == f.getNombre() && horaApertura == f.getHoraApertura() && horaCierre == f.getHoraCierre() && direccion == f.getDireccion() && catalogo == f.getCatalogo() && nProdVendidos == f.getnProdVendidos() && ventasTotales == f.getVentasTotales());
    }
    
    /**
     * Anade un producto a tu lista de productos
     * @param p producto a anadir
     */
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
    
    /**
     * Devuelve el catalogo ordenado por precio de los productos
     * @return catalogo ordenado precio
     */
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
    
    /**
     * Crea y anade un empleado a la lista de empleados
     * @param nombre nombre
     * @param apellidos apellidos
     * @param usuario usuario
     * @param password password
     * @param sueldo sueldo
     */
    public void anadirEmpleado(String nombre, String apellidos, String usuario,String password, double sueldo){
        this.empleados.add(new Empleado(nombre,apellidos,usuario,password,sueldo,this.nombre));
    }
    
    /**
     * Devuelve el numero del empleado si esta y -1 en otro caso
     * @param usuario usuario del empleado a buscar
     * @param contrasena contrasena del empleado a buscar
     * @return numero del empleado si esta y -1 si no
     */
    public int esEmpleado(String usuario, String contrasena){
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
    
    /**
     * Devuelve el numero del empleado si esta y -1 en otro caso
     * @param usuario usuario del empleado a buscar
     * @param contrasena hash de la contrasena del empleado a buscar
     * @return numero del empleado si esta y -1 si no
     */
    public int esEmpleado(String usuario, int contrasena){
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
    
    /**
     * Cambia el dueno actual por otro
     * @param nombre nombre del nuevo dueno
     * @param apellidos apellidos del nuevo dueno
     * @param usuario usuario del nuevo dueno
     * @param password password del nuevo dueno
     */
    public void remplazarDueno(String nombre, String apellidos, String usuario,String password){
        this.dueno = null;
        this.dueno = new Dueno(nombre,apellidos,usuario,password);
    }
}
