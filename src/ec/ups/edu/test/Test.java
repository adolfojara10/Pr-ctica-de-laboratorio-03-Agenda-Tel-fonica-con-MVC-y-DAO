/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.ups.edu.test;

import ec.ups.edu.controlador.ControladorUsuario;
import ec.ups.edu.vista.VistaUsuario;
import java.util.Scanner;

/**
 *
 * @author Adolfo
 */
public class Test {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        Scanner leer = new Scanner(System.in);
        
        VistaUsuario vista = new VistaUsuario();
        ControladorUsuario controlador = new ControladorUsuario(vista);
        int opcionMenu;
        boolean cuenta=false;
        
        System.out.println("\n*******Bienvenido al Menú*******\n");
        do{
            
            opcionMenu = controlador.menu();
            
            switch ( opcionMenu){
                case 1:
                    controlador.registrar();
                    break;
                    
                case 2:
                    controlador.iniciarSesion();     
                                        
                    break;
                    
                case 3:
                    
                    break;
                    
                case 4:
                    controlador.buscarUsuario();
                    break;
                    
                case 5:
                    controlador.imprimirUsuarios();
                    break;
                    
                case 6:
                    
                    break;
                    
                default:
                    
                    break;
                   
            }
        } while (opcionMenu!=6);
        
        
    }
    
}
