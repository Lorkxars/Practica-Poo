/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Codigo;
import java.io.*;
/**
 *
 * @author david
 */
public class Backups {//p
    /**
     * @param separator Devuelve el separador que utiliza el sistema operativo en el que se esta ejecutando el programa
     */
    static String separator = System.getProperty("file.separator"); //sacamos el separador de carpetas que cambia de un sistema operativo a otro ('/' rules)
    
    /**
     * Este metodo crea una copia de seguridad de la clase empresa que se le suministra
     * y la guarda en Backup/backup.ser
     * @param e es la clase empresa de la que se quiere hacer el backup
     */
    
    //so true = linux
    public static void hacerBackupAuto(Empresa e, boolean so){      
          if(so){
              try {
         FileOutputStream fileOut = new FileOutputStream("/backup.ser");
         ObjectOutputStream out = new ObjectOutputStream(fileOut);
         out.writeObject(e);
         out.close();
         fileOut.close();
      }catch(IOException i) {
         i.printStackTrace();
      }}
      if(!so){
          try {
         FileOutputStream fileOut = new FileOutputStream("C:\\backup.ser");
         ObjectOutputStream out = new ObjectOutputStream(fileOut);
         out.writeObject(e);
         out.close();
         fileOut.close();
      }catch(IOException i) {
         i.printStackTrace();
      }
    }}
    
    /**
     * Crea un backup de la empresa que se le suministra y la guarda en el directorio backup 
     * con el nombre que se le suministra
     * @param e es la clase empresa de la que se quiere hacer el backup
     * @param path es el nombre que se le quiere dar al backup
     */
      public static void hacerBackupManual(Empresa e, String path,boolean so){
      
          if(so){
          try {
         FileOutputStream fileOut =
         new FileOutputStream("/"+path + ".ser");
         ObjectOutputStream out = new ObjectOutputStream(fileOut);
         out.writeObject(e);
         out.close();
         fileOut.close();
         System.out.println("Serialized data is saved in Backup/"+ path +".ser");
      }catch(IOException i) {
         i.printStackTrace();
      }
          }
          else{
          try {
         FileOutputStream fileOut =
         new FileOutputStream("C:" +separator +path + ".ser");
         ObjectOutputStream out = new ObjectOutputStream(fileOut);
         out.writeObject(e);
         out.close();
         fileOut.close();
         System.out.println("Serialized data is saved in Backup/"+ path +".ser");
      }catch(IOException i) {
         i.printStackTrace();
      }
          }
   }
      /**
       * Recupera el backup de la empresa almcenado en Backup/backup.ser
       * @return es la empresa que se habia respaldado
       */
      public static Empresa recuperarBackupAuto(boolean so){
          Empresa e = null;
      if(so){
          try {
         FileInputStream fileIn = new FileInputStream("/backup.ser");
         ObjectInputStream in = new ObjectInputStream(fileIn);
         e = (Empresa) in.readObject();
         in.close();
         fileIn.close();
      }catch(IOException i) {
         i.printStackTrace();
         
      }catch(ClassNotFoundException c) {
         System.out.println("Empresa class not found");
         c.printStackTrace();
         
      }}
      else{
          try {
         FileInputStream fileIn = new FileInputStream("C:\\backup.ser");
         ObjectInputStream in = new ObjectInputStream(fileIn);
         e = (Empresa) in.readObject();
         in.close();
         fileIn.close();
      }catch(IOException i) {
         i.printStackTrace();
         
      }catch(ClassNotFoundException c) {
         System.out.println("Empresa class not found");
         c.printStackTrace();
         
      }}
      return e;
      }
      
      /**
       * 
       * @param path es el nombre del backup a restaurar
       * @return es la empresa que se habia respaldado
       */
      public static Empresa recuperarBackupManual(String path, boolean so){
          Empresa e = null;
          if(so){
      try {
         FileInputStream fileIn = new FileInputStream("/"+path);
         ObjectInputStream in = new ObjectInputStream(fileIn);
         e = (Empresa) in.readObject();
         in.close();
         fileIn.close();
      }catch(IOException i) {
         i.printStackTrace();
         
      }catch(ClassNotFoundException c) {
         System.out.println("Empresa class not found");
         c.printStackTrace();
         
      }}
          else{
      try {
         FileInputStream fileIn = new FileInputStream("C:\\"+path);
         ObjectInputStream in = new ObjectInputStream(fileIn);
         e = (Empresa) in.readObject();
         in.close();
         fileIn.close();
      }catch(IOException i) {
         i.printStackTrace();
         
      }catch(ClassNotFoundException c) {
         System.out.println("Empresa class not found");
         c.printStackTrace();
         
      }}
      return e;
      }
}

