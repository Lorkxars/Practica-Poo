/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Codigo;

import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

/**
 *
 * @author david
 */
public class Test {public static void main(String[] args) {
    
    boolean admin = false;  //Esto nos indica si el usuario logueado es el admin
    Empleado empleado = null; //me hace falta para saltar la variable de un if a otro, si esta distinto de nulo hay un empleado logueado
    Dueno dueno = null;     //si esta distinto de nulo hay un dueno logueado
    Franquicia faux = null; //Si no la inicializas te da un fallo que no llegaria a producirse pero netbeans es asi
    Scanner sk= new Scanner (System.in);  
    int aux = 0; //aux == -7 termina el programa
    int estado = 0; //Cada estado es por lo menos una ventana en la interfaz grafica
    
//    //Vamos a preparar algo de contenido para hacer la prueba
//    Empresa lrk = new Empresa("LRK",new Persona("Jefe","Super Jefe","admin","admin"));
//    lrk.anadirFranquicia(new Franquicia("Franquicia 2","09:00","21:00","C/Piruleta",new Dueno("yo","yo mismo","yo","contrasena")));
//    lrk.anadirFranquicia(new Franquicia("Franquicia 1","09:30","21:30","C/Caramelo",new Dueno("yo","yo mismo","yo","contrasena")));
//    lrk.anadirFranquicia(new Franquicia("Franquicia 3","08:00","20:00","C/Chocolate",new Dueno("el","el mismo","el","654321")));
//    lrk.getFranquicias().get(0).anadirProducto(new Rejas("Reja_1","Es una reja",100,150,true,250,100,7,false, lrk.getFranquicias().get(0).getNombre()));
//    lrk.getFranquicias().get(0).anadirProducto(new Ventanas("Ventana_1","Es una ventana",400,500,true,200,250,10,false, lrk.getFranquicias().get(0).getNombre()));
//    lrk.getFranquicias().get(0).anadirProducto(new Pieza_Aluminio("Pieza_aluminio_1","Es una pieza de aluminio",75,100,false,40,70, lrk.getFranquicias().get(0).getNombre()));
//    lrk.getFranquicias().get(1).anadirProducto(new Ventanas("Ventana_2","Es una ventana",600,700,true,400,350,17,true, lrk.getFranquicias().get(1).getNombre()));
//    lrk.getFranquicias().get(2).anadirProducto(new Pieza_Aluminio("Pieza_aluminio_2","Es una pieza de aluminio",50,75,false,30,50, lrk.getFranquicias().get(2).getNombre()));
//    
//    //Hasta aqui van empresa, franquicias y productos. Ahora vamos a meter algun empleado 
//    lrk.getFranquicias().get(0).anadirEmpleado("Empleado","1","usuario1","contrasena1",1000);
//    lrk.getFranquicias().get(0).anadirEmpleado("Empleado","2","usuario2","contrasena2",1500);
//    lrk.getFranquicias().get(1).anadirEmpleado("Empleado","3","usuario3","contrasena3",2000);
//    lrk.getFranquicias().get(2).anadirEmpleado("Empleado","4","usuario4","contrasena4",900);
    
    Empresa lrk = Backups.recuperarBackupAuto();//Carga los datos que habia la ultima vez que se cerro la aplicacion
    do{
    
    if (estado == 0){//Este codigo le pregunta al usuario que tipo de usuario es
     try{
         System.out.println("Si es usted usuario pulse 1, si es empleado pulse 2");   
        aux = sk.nextInt();
        if (aux == 1){
            System.out.println("Bienvenido cliente");
            estado = 1;
        }
        else if (aux == 2){
            System.out.println("Identifiquese por favor");
            estado = 2;
        }
        else {
            System.out.println("Introduzca una opcion valida");            
            estado = 0;
        }
    }catch (java.util.InputMismatchException e){
        System.out.println("Introduzca una opcion valida");
        sk.next();
        estado = 0;
    }
    }
    
    if(estado == 1){//Es un cliente
       try{ System.out.println("Para consultar el catalogo pulse 0, para consultar una lista de nuestras franquicias pulse 1");
      
            aux = sk.nextInt();
            if (aux == 0){
                System.out.println("Accediendo a la lista de productos");
                estado = 3;
            }
            else if (aux == 1){
                System.out.println("Accediendo a la lista de franquicias");
                estado = 4;
            } 
            else{
                System.out.println("Introduzca una opcion valida");
        estado = 1;
            }
            }catch (java.util.InputMismatchException e){
        System.out.println("Introduzca una opcion valida");
        sk.next();
        estado = 1;
    }
        
    }
    
    if(estado == 3){//El cliente quiere ver el catalogo general
        System.out.println("");
        System.out.println("------------------------------------------------------------");
        for(int i=0; i<lrk.superCatalogo().size();i++){
            System.out.println(lrk.superCatalogo().getProducto(i));
        }
        try{System.out.println("Pulse 0 si desea que se ordene por precio, 1 si desea que se ordene por el nombre de la franquicia a la que pertenece, 2 si quiere buscar un producto o 3 para salir");
        int temp = sk.nextInt();
        if (temp == 0){
            for(int i=0; i<lrk.superCatalogoP().size();i++){
                System.out.println(lrk.superCatalogoP().getProducto(i));
            }
        }
        else if (temp == 1){
            for(int i=0; i<lrk.superCatalogoN().size();i++){
                System.out.println(lrk.superCatalogoN().getProducto(i));
            }
        }
        else if (temp == 2){
            System.out.print("Introduzca el nombre del producto que busca: ");
            String prod = sk.next();
            try{
                System.out.println(lrk.superCatalogo().buscarNombre(prod));
            }catch (NoEncontradoExcp e){
                System.out.println("Ese producto no se encuentra en el catalogo");
            }
        }
        else if(temp == 3){
            aux = -7;
        }
        else{
            System.out.println("Introduzca una opcion valida");
        estado = 3;
        }
        }catch (java.util.InputMismatchException e){
        System.out.println("Introduzca una opcion valida");
        sk.next();
        estado = 3;
    }
    }
    
    if(estado == 4){//El usuario quiere ver el listado de franquicias
        int decision = -1;//Valor no significativo, solo evita error por posible acceso a varaible no inicializada
        for(int j=0; j<lrk.getFranquicias().size();j++){//Escribe la lista de franquicias
            System.out.println(j +"     " + lrk.getFranquicias().get(j).getNombre());
        }
        if (admin){//solo el admin tiene estas opciones
            try{System.out.println("Pulse 0 para consultar una franquicia, 1 para modificarla, 2 para eliminarla o 3 para crearla");
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
            if (decision == 3){//Estamos creando una franquicia
                System.out.print("Introduzca nombre: ");
                String nombre = sk.next();
                System.out.print("Introduzca direccion: ");
                String direccion = sk.next();
                System.out.print("Introduzca hora apertura: ");
                String horaApertura = sk.next();
                System.out.print("Introduzca hora cierre: ");
                String horaCierre = sk.next();
                System.out.print("Nombre dueno: ");//Nos hce falta crear un dueno por lo que tambien pedimos los datos para crearlo
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
        }catch (java.util.InputMismatchException e){
        System.out.println("Introduzca una opcion valida");
        sk.next();
        estado = 4;
    }}
        if(!admin || decision == 0){//Esas son tanto para el admin como para el resto de los mortales
        try{System.out.println("Si desea consultar alguna franquicia selecione su numero, si desea salir pulse -1");
        int temp = sk.nextInt();
        if(temp>=0 && temp< lrk.getFranquicias().size()){
            faux = lrk.getFranquicias().get(temp);
            System.out.println("Accediendo a la franquicia: "+ faux.getNombre());            
            estado = 5;
        }else if(temp == -1){
            aux = -7;
        }}catch (java.util.InputMismatchException e){
        System.out.println("Introduzca una opcion valida");
        sk.next();
        estado = 4;
    }}
        else{
            if(!admin){
            aux = -7;}
            else{
                System.out.println("Introduzca una opcion valida");
        estado = 4;
            }
        }
        }
    
    
    if(estado == 5){//Queremos consultar una franquicia (almacenada en faux)
        if(!admin){System.out.println(faux);
        }else{//El admin de nuevo ve mas informacion
            System.out.println(faux+"   "+"Productos vendidos: "+faux.getnProdVendidos()+"   "+"Beneficios: "+faux.getBeneficio()+"   "+"Facturacion total: "+ faux.getVentasTotales());
        }
        if (!admin){
        if (dueno == null || !faux.getDueno().equals(dueno)){//opcion para usuarios normales, empleados o duenos de otras franquicias
            System.out.println("Si desea consultar el catalogo pulse 1, si desea salir pulse 4");
        }
        else{//opcion para el dueno
            System.out.println("Si desea consultar el catalogo pulse 1, si desea consultar los empleados de la franquicia pulse 2, si desea salir pulse 4");
        }}
        else{//Opcion para el admin
            System.out.println("Pulse 1 para consultar el catalogo, 2 para consultar los empleados de la franquicia o 3 para administrar el dueno de la misma, si desea salir pulse 4");
        }
        try{int tem = sk.nextInt();
        if (tem == 4){
            aux = -7;
        }
        if(tem == 1){
            estado = 6;
            System.out.println("Accediendo al catalogo de la franquicia");
        }
        if((dueno != null && faux.getDueno().equals(dueno)) || admin ){//Solo para el admin y el dueno de la franquicia
            if (tem == 2){
                estado = 11;
                System.out.println("Accediendo a lista de empleados");
            }
        }
        if (admin){//solo para el admin
            if(tem==3){
                System.out.println(faux.getDueno());
                System.out.println("Pulse 0 para modificar el actual dueno o 1 para remplazarlo");
                try{int decision = sk.nextInt();
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
                else if(decision == 1){//Reemplazar dueno
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
                }else{
                    System.out.println("Introduzca una opcion valida");
            sk.next();
         estado = 4;
                }
             }catch (java.util.InputMismatchException e){
        System.out.println("Introduzca una opcion valida");
        sk.next();
        estado = 4;
                     }
   
            }
        }
        if(estado == 5 && (tem !=3 || !admin)){//Si lo que acabamos de hacer ha sido algo relacionado con el dueno no queremos que de error
            System.out.println("Introduzca una opcion valida");           
        }
        }catch (java.util.InputMismatchException e){
        System.out.println("Introduzca una opcion valida");
        sk.next();
        estado = 5;
        }

    }
    
    if (estado == 6){//Estamos acediendo al catalogo de la franquicia almacenada en faux
        System.out.println("");
        System.out.println("-----------------------");
        for(int z =0; z < faux.getCatalogo().size(); z++){
            System.out.println(z + "    " + faux.getCatalogo().getProducto(z));//imprimimos el catalogo
        }
        //Opcion para usuarios normales, admin, y duenos y empleados de otras franqucias
        if ((empleado == null ||faux.esEmpleado(empleado.getUsuario(), empleado.getPassword()) == -1) && (dueno == null || !faux.getDueno().equals(dueno))){
            System.out.println("Si quiere que se ordene por precio pulse 0, si quiere buscar un producto pulse 1 o pulse 4 para finalizar el programa");
        }
        else{//Solo personal de la franquicia
            System.out.println("Si quiere que se ordene por precio pulse 0, si quiere buscar un producto pulse 1, si quiere vender un producto pulse 2, si quiere crear un producto pulse 3 o pulse 4 para finalizar el programa");
        
        }
        int temp = -1;//Si la dejas dentro del try o no la inicializas peta...
        try{ temp = sk.nextInt();
        if (temp == 0){//Busqueda de producto
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
            }}
        
        }catch (java.util.InputMismatchException e){
        System.out.println("Introduzca una opcion valida");
        sk.next();
        estado = 4;
                     }
        if ((empleado != null && faux.esEmpleado(empleado.getUsuario(), empleado.getPassword()) != -1) || (dueno != null && faux.getDueno().equals(dueno))){
             if (temp == 2){
                 System.out.print("Introduzca el numero del producto a vender: ");
                 try{int index = sk.nextInt();
                 if(index>=0 && index < faux.getCatalogo().size()){
                     System.out.println("Va a vender el producto: " + faux.getCatalogo().getProducto(index));
                     System.out.print("Continuar y/n ?");
                     String prod = sk.next();
                     if(prod.equalsIgnoreCase("y")){
                         try{faux.ventaProducto(faux.getCatalogo().getProducto(index));
                         System.out.println("El producto se ha vendido con exito");
                         }catch (NoEncontradoExcp e){
                             System.out.println(e);
                         }
                     }
                     else{
                         System.out.println("Se ha cancelado la venta del producto");
                     }
                 }
                 estado = 6;
             }catch (java.util.InputMismatchException e){
                 sk.next();
                 System.out.println("Eres un inutil de empleado, y si eres el dueno ya ni te cuento");
                 estado = 6;    
             }
             }
             try{if (temp == 3){//Si no se controlan las excepciones petara por todas partes, por suerte no me preocupa aqui. Ya se encargaran en la interfaz grafica, espero
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
                         faux.anadirProducto(new Pieza_Aluminio(nombre, descripcion, pCompra, pVenta, instalacion, altura, anchura,faux.getNombre()));
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
                         faux.anadirProducto(new Ventanas(nombre, descripcion, pCompra, pVenta, instalacion, altura, anchura, nHojas, personalizado, faux.getNombre()));
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
                         faux.anadirProducto(new Rejas(nombre, descripcion, pCompra, pVenta, instalacion, altura, anchura, nBarrotes, personalizado,faux.getNombre()));
                         System.out.println("El producto se ha creado con exito");
                     }
                     else{
                         System.out.println("Se ha cancelado la creacion del producto");
                     }
             }}}catch (java.util.InputMismatchException e){
                     System.out.println("Algo has hecho mal, reflexiona sobre ello antes de volver a intentarlo");
                     sk.next();
                     aux = -1;
                     }}
        if(temp == 4){
            aux = -7;
        }
                 estado = 6;//esto nos devuelve a la lista de productos de la franquicia
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
        System.out.println("Para consultar el catalogo pulse 0, para consultar la lista de franquicias pulse 1, para consultar su franquicia pulse 2");
            try{aux = sk.nextInt();
            if (aux == 0){
                System.out.println("Accediendo a la lista de productos");
                estado = 3;
            }
            else if (aux == 1){
                System.out.println("Accediendo a la lista de franquicias");
                estado = 4;
            }            
            else if (aux == 2){
                try{
                    faux = lrk.buscarNombre(empleado.getFranquicia());
                }catch (NoEncontradoExcp e){
                    System.out.println("Si estas viendo esto la he cagado en alguna parte");//No deberia haber empleados que no pertenezcan a ninguna franquicia
                }
                System.out.println("Accediendo a la franquicia: "+ faux.getNombre());            
                estado = 5;
            }else{
                System.out.println("Animo, que ya te quedan menos numeros por probar");
                estado = 9;
            }
            }catch (java.util.InputMismatchException e){
                System.out.println("Parece que no sabemos distinguir numeros de letras...");
                sk.next();
                estado = 9;
            }
    }
    
    if (estado == 8){//Interfaz de administracion de los duenos de franquicia
        System.out.println("Para consultar el catalogo pulse 0, para consultar la lista de franquicias pulse 1, para consultar sus franquicias pulse 2");
            try{aux = sk.nextInt();
            if (aux == 0){
                System.out.println("Accediendo a la lista de productos");
                estado = 3;
            }
            else if (aux == 1){
                System.out.println("Accediendo a la lista de franquicias");
                estado = 4;
            }            
            else if (aux == 2){
                System.out.println("Accediendo la lista de sus franquicias");
                estado = 10;
            }
            else{
                System.out.println("Animo, que ya te quedan menos numeros por probar");
                estado = 8;
            }
            }catch (java.util.InputMismatchException e){
                System.out.println("Parece que no sabemos distinguir numeros de letras...");
                sk.next();
                estado = 8; 
            }
    }
    
    if (estado == 10){//listado de las franquicias del dueno que esta accediendo
        ArrayList <Franquicia> fraux;
        fraux = new ArrayList();
        for (int i = 0; i<lrk.getFranquicias().size(); i++){
            if (lrk.getFranquicias().get(i).getDueno().equals(dueno)){//almacenas en fraux las franquicias que tienen al dueno que accede de dueno
                fraux.add(lrk.getFranquicias().get(i));
            }
        }
        for(int j=0; j<fraux.size();j++){
            System.out.println(j +"     " + fraux.get(j).getNombre());//Y aqui las pintas
        }
        System.out.println("Si desea consultar alguna franquicia selecione su numero");
        try{int temp = sk.nextInt();
        if(temp>=0 && temp< fraux.size()){
            faux = fraux.get(temp);
            System.out.println("Accediendo a la franquicia: "+ faux.getNombre());            
            estado = 5;
        }
       }catch (java.util.InputMismatchException e){
                System.out.println("Parece que no sabemos distinguir numeros de letras...");
                sk.next();
                estado = 10;
            }
    }
    
    if(estado == 11){//Pantalla de administracion de empleados del admin o el dueno
        for(int i=0; i< faux.getEmpleados().size(); i++){
            System.out.println(i+"    "+faux.getEmpleados().get(i));//los pintas
        }
        System.out.println("Pulse 0 para agregar empleado, 1 para despedir empleado o 2 para modificarlo o 3 para salir");
        try{int decision = sk.nextInt();
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
    }catch (java.util.InputMismatchException e){
                System.out.println("Parece que no sabemos distinguir numeros de letras...");
                sk.next();
                estado = 11;
            }}
    
    if (estado == 7){//pantalla de administracion del admin
        System.out.println("Pulse 0 para ver el catalogo, 1 para ver las franquicias o 2 para administrar backups");
        try{ int decision = sk.nextInt();
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
            estado = 12;
        }
    }catch (java.util.InputMismatchException e){
                System.out.println("Parece que no sabemos distinguir numeros de letras...");
                sk.next();
                estado = 7;
            }} 
    
    if (estado==12){//pantalla de administracion de backups (solo el admin puede entrar aqui)
        System.out.println("Para crear un backup pulse 1, para restaurar un backup anterior pulse 2");
        try{int decision = sk.nextInt();
        if (decision == 1){//crear backup
            System.out.println("Introduzca el nombre con el que quiere crear el Backup:");
            String path = sk.next();
            Backups.hacerBackupManual(lrk,path);
        }
        if (decision == 2){//Recuperar backup
            File folder = new File("Backup");//recupera una lista de todos los archivos de la carpeta backup y los pinta
            File[] listOfFiles = folder.listFiles();
            for (int i = 0; i < listOfFiles.length; i++) {
                if (listOfFiles[i].isFile()) {
                     System.out.println(listOfFiles[i].getName());
                } else if (listOfFiles[i].isDirectory()) {
                    System.out.println("Directory " + listOfFiles[i].getName());
                }
            }
            System.out.println("Introuzca el nombre del backup a restaurar, incluyendo .ser:");//aqui empieza a restaurarlos como tal
            String path = sk.next();
            System.out.println("Restaurar "+ path +" y/n?");
            String prod = sk.next();
                     if(prod.equalsIgnoreCase("y")){
                         lrk = Backups.recuperarBackupManual(path);
                         System.out.println("Se ha restaurado el Backup con exito");
                     }
                     else{
                         System.out.println("Se ha cancelado la operacion");
                     }
        }
        estado = 7;
    }catch (java.util.InputMismatchException e){
                System.out.println("Parece que no sabemos distinguir numeros de letras...");
                sk.next();
                estado = 12;
            }}
        
    }while(aux != -7);//Repetimos todo hasta que algun bloque termine el programa, deberia haber heccho los bloques if con case pero no me da tiempo a cambiarlo
    Backups.hacerBackupAuto(lrk);//Guardamos los cambios para la proxima vez que se abra la aplicacion
    }
}
