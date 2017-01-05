/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Codigo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

/**
 *
 * @author david
 */
public class Test {public static void main(String[] args) {
    
    boolean admin = false;
    Empleado empleado = null; //me hace falta para saltar la variable de un if a otro
    Dueno dueno = null;
    Franquicia faux = null; //Si no la inicializas te da un fallo que no llegaria a producirse pero netbeans es asi
    Scanner sk= new Scanner (System.in);  
    int aux = 0;
    int estado = 0;
    //Vamos a preparar algo de contenido para hacer la prueba
    Empresa lrk = new Empresa("LRK",new Persona("Jefe","Super Jefe","admin","admin"));
    lrk.anadirFranquicia(new Franquicia("Franquicia 2","09:00","21:00","C/Piruleta",new Dueno("yo","yo mismo","yo","contrasena")));
    lrk.anadirFranquicia(new Franquicia("Franquicia 1","09:30","21:30","C/Caramelo",new Dueno("yo","yo mismo","yo","contrasena")));
    lrk.anadirFranquicia(new Franquicia("Franquicia 3","08:00","20:00","C/Chocolate",new Dueno("el","el mismo","el","654321")));
    lrk.getFranquicias().get(0).anadirProducto(new Rejas("Reja_1","Es una reja",100,150,true,250,100,7,false));
    lrk.getFranquicias().get(0).anadirProducto(new Ventanas("Ventana_1","Es una ventana",400,500,true,200,250,10,false));
    lrk.getFranquicias().get(0).anadirProducto(new Pieza_Aluminio("Pieza_aluminio_1","Es una pieza de aluminio",75,100,false,40,70));
    lrk.getFranquicias().get(1).anadirProducto(new Ventanas("Ventana_2","Es una ventana",600,700,true,400,350,17,true));
    lrk.getFranquicias().get(2).anadirProducto(new Pieza_Aluminio("Pieza_aluminio_2","Es una pieza de aluminio",50,75,false,30,50));
    
    //Hasta aqui van empresa, franquicias y productos. Ahora vamos a meter algun empleado 
    lrk.getFranquicias().get(0).anadirEmpleado("Empleado","1","usuario1","contrasena1",1000);
    lrk.getFranquicias().get(0).anadirEmpleado("Empleado","2","usuario2","contrasena2",1500);
    lrk.getFranquicias().get(1).anadirEmpleado("Empleado","3","usuario3","contrasena3",2000);
    lrk.getFranquicias().get(2).anadirEmpleado("Empleado","4","usuario4","contrasena4",900);
    
    do{
    
    if (estado == 0){//Este codigo le pregunta al usuario que tipo de usuario es
    System.out.println("Si es usted usuario pulse 1, si es empleado pulse 2");
    do {
        aux = sk.nextInt();
        if (aux == 1){
            System.out.println("Bienvenido cliente");
            estado = 1;
        }
        if (aux == 2){
            System.out.println("Identifiquese por favor");
            estado = 2;
        }
    }while (aux != 1 && aux != 2);
    }
    
    if(estado == 1){//Es un cliente
        System.out.println("Para consultar el catalogo pulse 3, para consultar una lista de nuestras franquicias pulse 4");
        do{
            aux = sk.nextInt();
            if (aux == 3){
                System.out.println("Accediendo a la lista de productos");
                estado = 3;
            }
            if (aux == 4){
                System.out.println("Accediendo a la lista de franquicias");
                estado = 4;
            }            
        }while(aux != 3 && aux != 4);
    }
    
    if(estado == 3){//El cliente quiere ver el catalogo general
        for(int i=0; i<lrk.superCatalogo().size();i++){
            System.out.println(lrk.superCatalogo().getProducto(i));
        }
        System.out.println("Pulse 0 si desea que se ordene por precio, 1 si desea que se ordene por el nombre de la franquicia a la que pertenece o 2 si quiere buscar un producto");
        int temp = sk.nextInt();
        if (temp == 0){
            for(int i=0; i<lrk.superCatalogoP().size();i++){
                System.out.println(lrk.superCatalogoP().getProducto(i));
            }
        }
        if (temp == 1){
            for(int i=0; i<lrk.superCatalogoN().size();i++){
                System.out.println(lrk.superCatalogoN().getProducto(i));
            }
        }
        if (temp == 2){
            System.out.print("Introduzca el nombre del producto que busca: ");
            String prod = sk.next();
            try{
                System.out.println(lrk.superCatalogo().buscarNombre(prod));
            }catch (NoEncontradoExcp e){
                System.out.println("Ese producto no se encuentra en el catalogo");
            }
        }
        aux = -7;
    }
    
    if(estado == 4){//El usuario quiere ver el listado de franquicias
        int decision = -1;
        for(int j=0; j<lrk.getFranquicias().size();j++){
            System.out.println(j +"     " + lrk.getFranquicias().get(j).getNombre());
        }
        if (admin){
            System.out.println("Pulse 0 para consultar una franquicia, 1 para modificarla, 2 para eliminarla o 3 para crearla");
            decision = sk.nextInt();
            if (decision==1){
                System.out.println("Introduzca el numero de la franquicia a modificar:");
                int index = sk.nextInt();
                if(index>=0 && index< lrk.getFranquicias().size()){
                System.out.println("Modificando: " + lrk.getFranquicias().get(index));
                System.out.print("Introduzca nombre: ");
                String nombre = sk.next();
                System.out.print("Introduzca direccion: ");
                String direccion = sk.next();
                System.out.print("Introduzca hora apertura: ");
                String horaApertura = sk.next();
                System.out.print("Introduzca hora cierre: ");
                String horaCierre = sk.next(); 
                System.out.println("Modificar franquicia a: " + nombre +"   "+direccion+"   "+horaApertura+"   "+horaCierre+ " continuar y/n?");
                     String prod = sk.next();
                     if(prod.equalsIgnoreCase("y")){
                         lrk.getFranquicias().get(index).modificar(nombre, direccion, horaApertura, horaCierre);
                         System.out.println("La franquicia ha sido modificada con exito");
                     }
                     else{
                         System.out.println("Se ha cancelado la operacion");
                     }
                
            }}
            if (decision == 2){
                System.out.println("Introduzca el numero de la franquicia a eliminar:");
                int index = sk.nextInt();
                if(index>=0 && index< lrk.getFranquicias().size()){
                    System.out.println("Eliminar: " + lrk.getFranquicias().get(index)+ " y/n?");
                     String prod = sk.next();
                     if(prod.equalsIgnoreCase("y")){
                         lrk.eliminaFranquiciar(lrk.getFranquicias().get(index));
                         System.out.println("La franquicia ha sido eliminada con exito");
                     }
                     else{
                         System.out.println("Se ha cancelado la operacion");
                     }
                }
            }
            if (decision == 3){
                System.out.print("Introduzca nombre: ");
                String nombre = sk.next();
                System.out.print("Introduzca direccion: ");
                String direccion = sk.next();
                System.out.print("Introduzca hora apertura: ");
                String horaApertura = sk.next();
                System.out.print("Introduzca hora cierre: ");
                String horaCierre = sk.next();
                System.out.print("Nombre dueno: ");
                String nombred = sk.next();
                System.out.print("Apellidos dueno: ");
                String apellidos = sk.next();
                System.out.print("Usuario dueno: ");
                String usuario = sk.next();
                System.out.print("Contrasena dueno: ");
                String password = sk.next();
                System.out.println("Crear franquicia: " + nombre +" "+ direccion+" "+horaApertura+" "+horaCierre+" "+ nombred+" " + " continuar y/n?");
                     String prod = sk.next();
                     if(prod.equalsIgnoreCase("y")){
                         Dueno duenoaux = new Dueno(nombred,apellidos,usuario,password);
                         lrk.anadirFranquicia(new Franquicia(nombre,horaApertura,horaCierre,direccion,duenoaux));
                         System.out.println("La franquicia ha sido creada con exito");
                     }
                     else{
                         System.out.println("Se ha cancelado la operacion");
                     }
            }
        }
        if(!admin || decision == 0){
        System.out.println("Si desea consultar alguna franquicia selecione su numero");
        int temp = sk.nextInt();
        if(temp>=0 && temp< lrk.getFranquicias().size()){
            faux = lrk.getFranquicias().get(temp);
            System.out.println("Accediendo a la franquicia: "+ faux.getNombre());            
            estado = 5;
        }
        else{
            aux = -7;
        }
        }
    }
    
    if(estado == 5){//Queremos consultar una franquicia (almacenada en faux)
        System.out.println(faux);
        if (!admin){
        if (dueno == null || !faux.getDueno().equals(dueno)){
            System.out.println("Si desea consultar el catalogo pulse 1");
        }
        else{
            System.out.println("Si desea consultar el catalogo pulse 1, si desea consultar los empleados de la franquicia pulse 2");
        }}
        else{
            System.out.println("Pulse 1 para consultar el catalogo, 2 para consultar los empleados de la franquicia o 3 para administrar el dueno de la misma");
        }
        int tem = sk.nextInt();
        if(tem == 1){
            estado = 6;
            System.out.println("Accediendo al catalogo de la franquicia");
        }
        if((dueno != null && faux.getDueno().equals(dueno)) || admin ){
            if (tem == 2){
                estado = 11;
                System.out.println("Accediendo a lista de empleados");
            }
        }
        if (admin){
            if(tem==3){
                System.out.println(faux.getDueno());
                System.out.println("Pulse 0 para modificar el actual dueno o 1 para remplazarlo");
                int decision = sk.nextInt();
                if(decision == 0){
                    System.out.print("Nombre dueno: ");
                    String nombre = sk.next();
                    System.out.print("Apellidos dueno: ");
                    String apellidos = sk.next();
                    System.out.print("Usuario dueno: ");
                    String usuario = sk.next();
                    System.out.print("Contrasena dueno: ");
                    String password = sk.next();
                    System.out.println("El dueno quedara como: " +nombre +"    "+ apellidos +"    "+usuario+"    "+password + " continuar y/n?");
                     String prod = sk.next();
                     if(prod.equalsIgnoreCase("y")){
                         faux.getDueno().modificar(nombre, apellidos, usuario, password);
                         System.out.println("La el dueno ha sido modificado con exito");
                     }
                     else{
                         System.out.println("Se ha cancelado la operacion");
                     }
                }
                if(decision == 1){
                    System.out.print("Nombre dueno: ");
                    String nombre = sk.next();
                    System.out.print("Apellidos dueno: ");
                    String apellidos = sk.next();
                    System.out.print("Usuario dueno: ");
                    String usuario = sk.next();
                    System.out.print("Contrasena dueno: ");
                    String password = sk.next();
                    System.out.println("El nuevo dueno sera: " +nombre +"    "+ apellidos +"    "+usuario+"    "+password + " continuar y/n?");
                     String prod = sk.next();
                     if(prod.equalsIgnoreCase("y")){
                         
                         faux.remplazarDueno(nombre, apellidos, usuario, password);
                         System.out.println("La el dueno ha sido reemplazado con exito");
                     }
                     else{
                         System.out.println("Se ha cancelado la operacion");
                     }
                }
                
            }
        }
        if(estado == 5 && (tem !=3 || !admin)){
            estado = -7;
        }
        
    }
    
    if (estado == 6){//Estamos acediendo al catalogo de la franquicia almacenada en faux
        for(int z =0; z < faux.getCatalogo().size(); z++){
            System.out.println(z + "    " + faux.getCatalogo().getProducto(z));
        }
        if ((empleado == null ||faux.esEmpleado(empleado.getUsuario(), empleado.getPassword()) == -1) && (dueno == null || !faux.getDueno().equals(dueno))){
            System.out.println("Si quiere que se ordene por precio pulse 0, si quiere buscar un producto pulse 1");
        }
        else{
            System.out.println("Si quiere que se ordene por precio pulse 0, si quiere buscar un producto pulse 1, si quiere vender un producto pulse 2 y si quiere crear un producto pulse 3");
        
        }
        int temp = sk.nextInt();
        if (temp == 0){
            Collections.sort(faux.getCatalogo().getCatalogo());
            for(int z =0; z < faux.getCatalogo().size(); z++){
                System.out.println(z + "    " + faux.getCatalogo().getProducto(z));
            }   
        }
        if (temp == 1){
            System.out.print("Introduzca el nombre del producto que busca: ");
            String prod = sk.next();
            try{
                System.out.println(faux.getCatalogo().buscarNombre(prod));
            }catch (NoEncontradoExcp e){
                System.out.println("Ese producto no se encuentra en el catalogo");
            }
        }
        aux = -7; //Los bloques de despues no acabarian con la ejecucion del programa, por eso esto esta aqui
        if ((empleado != null && faux.esEmpleado(empleado.getUsuario(), empleado.getPassword()) != -1) || (dueno != null && faux.getDueno().equals(dueno))){
             if (temp == 2){
                 System.out.print("Introduzca el numero del producto a vender: ");
                 int index = sk.nextInt();
                 if(index>=0 && index < faux.getCatalogo().size()){
                     System.out.println("Va a vender el producto: " + faux.getCatalogo().getProducto(index));
                     System.out.print("Continuar y/n ?");
                     String prod = sk.next();
                     if(prod.equalsIgnoreCase("y")){
                         faux.ventaProducto(faux.getCatalogo().getProducto(index));
                         System.out.println("El producto se ha vendido con exito");
                     }
                     else{
                         System.out.println("Se ha cancelado la venta del producto");
                     }
                 }
                 aux = 6;
             }
             if (temp == 3){//Si no se controlan las excepciones petara por todas partes
                 System.out.println("Pulse 0 para Pieza Aluminio, 1 para Ventana o 2 para Reja");
                 int opcion = sk.nextInt();
                 if (opcion == 0){
                     System.out.println("Creando Pieza Aluminio");
                     System.out.print("Nombre: ");
                     String nombre = sk.next();
                     System.out.print("Descripcion: ");
                     String descripcion = sk.next();
                     System.out.print("Precio de compra: ");
                     double pCompra = sk.nextDouble();
                     System.out.print("Precio de venta: ");
                     double pVenta = sk.nextDouble();
                     System.out.print("Instalacion: ");
                     boolean instalacion = sk.nextBoolean();
                     System.out.print("Altura: ");
                     int altura = sk.nextInt();
                     System.out.print("Anchura: ");
                     int anchura = sk.nextInt();
                     System.out.println("Crear Pieza Aluminio: " +  nombre + " " + descripcion + " " + pCompra + " " +  pVenta + " " +instalacion + " " + altura + " " + anchura + " y/n?");
                     String prod = sk.next();
                     if(prod.equalsIgnoreCase("y")){
                         faux.anadirProducto(new Pieza_Aluminio(nombre, descripcion, pCompra, pVenta, instalacion, altura, anchura));
                         System.out.println("El producto se ha creado con exito");
                     }
                     else{
                         System.out.println("Se ha cancelado la creacion del producto");
                     }                     
                 }
                 if (opcion == 1){
                     System.out.println("Creando Ventana");
                     System.out.print("Nombre: ");
                     String nombre = sk.next();
                     System.out.print("Descripcion: ");
                     String descripcion = sk.next();
                     System.out.print("Precio de compra: ");
                     double pCompra = sk.nextDouble();
                     System.out.print("Precio de venta: ");
                     double pVenta = sk.nextDouble();
                     System.out.print("Instalacion: ");
                     boolean instalacion = sk.nextBoolean();
                     System.out.print("Altura: ");
                     int altura = sk.nextInt();
                     System.out.print("Anchura: ");
                     int anchura = sk.nextInt();
                     System.out.print("Numero de hojas: ");
                     int nHojas = sk.nextInt();
                     System.out.print("Personalizado: ");
                     boolean personalizado = sk.nextBoolean();
                     
                     System.out.println("Crear Ventana: " +  nombre + " " + descripcion + " " + pCompra + " " +  pVenta + " " +instalacion + " " + altura + " " + anchura + " " + nHojas + " " + personalizado + " y/n?");
                     String prod = sk.next();
                     if(prod.equalsIgnoreCase("y")){
                         faux.anadirProducto(new Ventanas(nombre, descripcion, pCompra, pVenta, instalacion, altura, anchura, nHojas, personalizado));
                         System.out.println("El producto se ha creado con exito");
                     }
                     else{
                         System.out.println("Se ha cancelado la creacion del producto");
                     }                     
                 }
                 if (opcion == 2){
                     System.out.println("Creando Reja");
                     System.out.print("Nombre: ");
                     String nombre = sk.next();
                     System.out.print("Descripcion: ");
                     String descripcion = sk.next();
                     System.out.print("Precio de compra: ");
                     double pCompra = sk.nextDouble();
                     System.out.print("Precio de venta: ");
                     double pVenta = sk.nextDouble();
                     System.out.print("Instalacion: ");
                     boolean instalacion = sk.nextBoolean();
                     System.out.print("Altura: ");
                     int altura = sk.nextInt();
                     System.out.print("Anchura: ");
                     int anchura = sk.nextInt();
                     System.out.print("Numero de Barrotes: ");
                     int nBarrotes = sk.nextInt();
                     System.out.print("Personalizado: ");
                     boolean personalizado = sk.nextBoolean();
                     
                     System.out.println("Crear Reja: " +  nombre + " " + descripcion + " " + pCompra + " " +  pVenta + " " +instalacion + " " + altura + " " + anchura + " " + nBarrotes + " " + personalizado + " y/n?");
                     String prod = sk.next();
                     if(prod.equalsIgnoreCase("y")){
                         faux.anadirProducto(new Rejas(nombre, descripcion, pCompra, pVenta, instalacion, altura, anchura, nBarrotes, personalizado));
                         System.out.println("El producto se ha creado con exito");
                     }
                     else{
                         System.out.println("Se ha cancelado la creacion del producto");
                     }
             }
                 aux = 6;
        }
        } 
        
    }
    
    if(estado == 2){//El usuario esta tratando de aceder como personal registrado
        System.out.print("Introduzca usuario: ");
        String usuario = sk.next();
        System.out.print("Introduzca contrasena: ");
        String contrasena = sk.next();
        
        int fallos = 0;
        //Es el admin?
        if(usuario.equals(lrk.getAdmin().getUsuario()) && (contrasena.hashCode() == lrk.getAdmin().getPassword())){
            System.out.println("Bienvenido admin");
            estado = 7;
            admin = true;
        }
        else{
            fallos ++;
        }
        
        //Es un dueno de franquicia?
        try{
            dueno =lrk.esDueno(usuario, contrasena);
            estado = 8;
            System.out.println("Bienvenido " + dueno.getNombre());
        }catch (NoEncontradoExcp e){
                fallos ++;
                }
        
        //Es un empleado?
        try{
            empleado = lrk.esEmpleado(usuario, contrasena);
            estado = 9;
            System.out.println("Bienvenido " + empleado.getNombre());
        }catch (NoEncontradoExcp e){
            fallos ++;
        }
        if (fallos == 3){
            System.out.println("Usuario o contrasena incorrectos");
            aux = -7;
        }
    }
    
    if(estado== 9){//Es un empleado, le dirigimos a la pantalla de administracion para empleados
        System.out.println("Para consultar el catalogo pulse 3, para consultar la lista de franquicias pulse 4, para consultar su franquicia pulse 5");
        do{
            aux = sk.nextInt();
            if (aux == 3){
                System.out.println("Accediendo a la lista de productos");
                estado = 3;
            }
            if (aux == 4){
                System.out.println("Accediendo a la lista de franquicias");
                estado = 4;
            }            
            if (aux == 5){
                try{
                    faux = lrk.buscarNombre(empleado.getFranquicia());
                }catch (NoEncontradoExcp e){
                    System.out.println("Si estas viendo esto la he cagado en alguna parte");
                }
                System.out.println("Accediendo a la franquicia: "+ faux.getNombre());            
                estado = 5;
            }
        }while(aux != 3 && aux != 4 && aux !=5);
    }
    
    if (estado == 8){
        System.out.println("Para consultar el catalogo pulse 3, para consultar la lista de franquicias pulse 4, para consultar sus franquicias pulse 5");
        do{
            aux = sk.nextInt();
            if (aux == 3){
                System.out.println("Accediendo a la lista de productos");
                estado = 3;
            }
            if (aux == 4){
                System.out.println("Accediendo a la lista de franquicias");
                estado = 4;
            }            
            if (aux == 5){
                System.out.println("Accediendo la lista de sus franquicias");
                estado = 10;
            }
        }while(aux != 3 && aux != 4 && aux !=5);
    }
    
    if (estado == 10){
        ArrayList <Franquicia> fraux;
        fraux = new ArrayList();
        for (int i = 0; i<lrk.getFranquicias().size(); i++){
            if (lrk.getFranquicias().get(i).getDueno().equals(dueno)){
                fraux.add(lrk.getFranquicias().get(i));
            }
        }
        for(int j=0; j<fraux.size();j++){
            System.out.println(j +"     " + fraux.get(j).getNombre());
        }
        System.out.println("Si desea consultar alguna franquicia selecione su numero");
        int temp = sk.nextInt();
        if(temp>=0 && temp< fraux.size()){
            faux = fraux.get(temp);
            System.out.println("Accediendo a la franquicia: "+ faux.getNombre());            
            estado = 5;
        }
    }
    
    if(estado == 11){//Pantalla de administracion de empleados
        for(int i=0; i< faux.getEmpleados().size(); i++){
            System.out.println(i+"    "+faux.getEmpleados().get(i));
        }
        System.out.println("Pulse 0 para agregar empleado, 1 para despedir empleado o 2 para modificarlo o 3 para salir");
        int decision = sk.nextInt();
        if (decision == 0){
            System.out.println("Agregando empleado");
            System.out.print("Nombre: ");
            String nombre = sk.next();
            System.out.print("Apellidos: ");
            String apellidos = sk.next();
            System.out.print("Usuario: ");
            String usuario = sk.next();
            System.out.print("Contrasena: ");
            String password = sk.next();
            System.out.print("Sueldo: ");
            double sueldo = sk.nextDouble();
            System.out.println("Crear Empleado " + nombre +" "+ apellidos+ "    " + usuario + " "+ password + "     "+  sueldo+ "   y/n?");
            String prod = sk.next();
                     if(prod.equalsIgnoreCase("y")){
                         faux.anadirEmpleado(nombre, apellidos, usuario, password, sueldo);
                         System.out.println("El Emplehado ha sido agregado con exito");
                     }
                     else{
                         System.out.println("Se ha cancelado operacion");
                     }
            
        }
        if (decision == 1){
            System.out.print("Introducir el numero de empleado a eliminar: ");
            int index = sk.nextInt();
            System.out.println("Eliminar "+ faux.getEmpleados().get(index).getNombre() + " y/n?");
            String prod = sk.next();
                     if(prod.equalsIgnoreCase("y")){
                         faux.getEmpleados().remove(index);
                         System.out.println("El Empleado ha sido eliminado con exito");
                     }
                     else{
                         System.out.println("Se ha cancelado la operacion");
                     }
        }
        if (decision == 2){
            System.out.println("Modificando empleado");
            System.out.print("Introducir el numero de empleado a modificar: ");
            int index = sk.nextInt();
            System.out.println(faux.getEmpleados().get(index));
            System.out.print("Nombre: ");
            String nombre = sk.next();
            System.out.print("Apellidos: ");
            String apellidos = sk.next();
            System.out.print("Usuario: ");
            String usuario = sk.next();
            System.out.print("Contrasena: ");
            String password = sk.next();
            System.out.print("Sueldo: ");
            double sueldo = sk.nextDouble();
            System.out.println("Modificar Empleado a: " + nombre +" "+ apellidos+ "    " + usuario + " "+ password + "     "+  sueldo+ "   y/n?");
            String prod = sk.next();
                     if(prod.equalsIgnoreCase("y")){
                         faux.getEmpleados().get(index).modificar(nombre, apellidos, usuario, password, sueldo);
                         System.out.println("El Emplehado ha sido modificado con exito");
                     }
                     else{
                         System.out.println("Se ha cancelado operacion");
                     }
        }
        if(decision==3){
            aux = -7;
        }
    }
    if (estado == 7){
        System.out.println("Pulse 0 para ver el catalogo, 1 para ver las franquicias o 2 para hacer un backup");
        int decision = sk.nextInt();
        if(decision == 0){
            System.out.println("Accediendo al catalogo");
            estado = 3;
        }
         if(decision == 1){
            System.out.println("Accediendo a la lista de franquicias");
            estado = 4;
        }
          if(decision == 2){
            System.out.println("Accediendo a la pantalla de administracion de backups");
            estado = -7;//aun por implementar
        }
    } 
        
    }while(aux != -7);//Repetimos todo hasta que algun bloque termine el programa
    }
}
