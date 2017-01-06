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
public class Backups {
    public static void hacerBackupAuto(Empresa e){
      try {
         FileOutputStream fileOut =
         new FileOutputStream("Backup/backup.ser");
         ObjectOutputStream out = new ObjectOutputStream(fileOut);
         out.writeObject(e);
         out.close();
         fileOut.close();
      }catch(IOException i) {
         i.printStackTrace();
      }
    }
    
      public static void hacerBackupManual(Empresa e, String path){
      try {
         FileOutputStream fileOut =
         new FileOutputStream("Backup/"+ path + ".ser");
         ObjectOutputStream out = new ObjectOutputStream(fileOut);
         out.writeObject(e);
         out.close();
         fileOut.close();
         System.out.println("Serialized data is saved in Backup/"+ path +".ser");
      }catch(IOException i) {
         i.printStackTrace();
      }
   }
      
      public static Empresa recuperarBackupAuto(){
          Empresa e = null;
      try {
         FileInputStream fileIn = new FileInputStream("Backup/backup.ser");
         ObjectInputStream in = new ObjectInputStream(fileIn);
         e = (Empresa) in.readObject();
         in.close();
         fileIn.close();
      }catch(IOException i) {
         i.printStackTrace();
         
      }catch(ClassNotFoundException c) {
         System.out.println("Empresa class not found");
         c.printStackTrace();
         
      }
      return e;
      }
      
      public static Empresa recuperarBackupManual(String path){
          Empresa e = null;
      try {
         FileInputStream fileIn = new FileInputStream("Backup/"+path);
         ObjectInputStream in = new ObjectInputStream(fileIn);
         e = (Empresa) in.readObject();
         in.close();
         fileIn.close();
      }catch(IOException i) {
         i.printStackTrace();
         
      }catch(ClassNotFoundException c) {
         System.out.println("Empresa class not found");
         c.printStackTrace();
         
      }
      return e;
      }
}

