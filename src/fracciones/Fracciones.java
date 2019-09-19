/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fracciones;

/**
 *
 * @author Lenovo
 */
public class Fracciones {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        
   while(true){     
       try{
        Operador operador=new Operador(Teclado.texto().toLowerCase());
        // TODO code application logic here
       }catch(Exception e){
           System.out.println("Ocurrio un error intentalo de nuevo");
           System.out.println("");
         
       }
   }
        
    
    }
    
    
}
