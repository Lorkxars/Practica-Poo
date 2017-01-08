/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor. 
 */
package Codigo;
import java.io.Serializable;
/**
 *
 * @author david
 */
public class NoEncontradoExcp extends Exception implements Serializable{
    public NoEncontradoExcp () {
        super();
    }
    public NoEncontradoExcp (String mensajeDescript){ 
        super(mensajeDescript);
    }
    
}
