/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.ups.edu.test;

import ec.ups.edu.controlador.ControladorTelefono;
import ec.ups.edu.controlador.ControladorUsuario;
import ec.ups.edu.dao.TelefonoDAOImpl;
import ec.ups.edu.dao.UsuarioDAOImpl;
import ec.ups.edu.modelo.Telefono;
import ec.ups.edu.modelo.Usuario;
import ec.ups.edu.vista.VistaTelefono;
import ec.ups.edu.vista.VistaUsuario;
import java.util.Scanner;

/**
 * clase principal Test.
 *
 * esta clase es la encargado de correr el programa. cuenta con la instancia de
 * un objeto de tipo VistaUsuario y de un objeto ControladorUsuario. Cuenta con
 * un menu el cual depende de lo que el usuario decida. Este menu se encuantra
 * en la clase VistaUsuario. El ControladorUsuario es el encargado de llamar a
 * los distintos metodos.
 *
 * @see VistaUsuario
 * @see ControladorUsuario
 * @author Adolfo
 */
public class Test {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here

        Scanner leer = new Scanner(System.in);

        //se instancian los objetos
        VistaUsuario vistaU = new VistaUsuario();
        VistaTelefono vistaT = new VistaTelefono();
        
        TelefonoDAOImpl telefonoDao = new TelefonoDAOImpl();
        UsuarioDAOImpl usuarioDao = new UsuarioDAOImpl();
        
                
        ControladorTelefono controladorT = new ControladorTelefono(vistaT, 
                telefonoDao);
                
                
        ControladorUsuario controladorU = new ControladorUsuario(vistaU, vistaT,
                usuarioDao, telefonoDao);
        
        
        //un int que sirve para correr el menu
        int opcionMenu;

        System.out.println("\n*******Bienvenido al Menú*******\n");

        //bucle do-while encarrgado de correr el menu varias veces
        do {
            //se obtiene int para controlar el menu y las opciones de menu se encuentran aqui
            opcionMenu = controladorU.menu();

            //menu
            switch (opcionMenu) {
                case 1:

                    //para registrar un usuario nuevo
                    controladorU.registrar();
                    break;

                case 2:

                    //para iniciar sesion
                    Usuario usuario = controladorU.iniciarSesion();
                    /*
                    if (usuario!=null){
                        int opcion = 0;
                        while(opcion!=4){
                            opcion = controladorT.menu();
                            
                            switch(opcion){
                                case 1: 
                                    
                                    controladorT.registrar(usuario);
                                  //  controladorU.agregarTelefono();
                                    break;
                                    
                                case 2:
                                    
                                    controladorT.actualizarTelefono();
                                    break;
                                    
                                case 3:
                                    
                                    controladorT.eliminarTelefono();
                                    break;
                                    
                                case 4:
                                    
                                    controladorT.salir();
                                    break;
                                    
                                default:
                                    
                                    controladorU.numeroErroneo();
                                    break;                                     
                            }  
                        }
                    } else {
                        controladorU.usuarioNoEncontrado();
                    }*/
                    break;

                case 3:

                    //para imprimir los telefonos de un usuario
                    controladorU.imprimirTelefonos();
                    break;

                case 4:

                    //para buscr un usuario
                    controladorU.buscarUsuario();
                    break;

                case 5:

                    //para imprimir todos los usuarios
                    controladorU.imprimirUsuarios();
                    break;

                case 6:

                    //para imprimir todos los telefonos del sistema
                    controladorT.verTelefonos();
                    break;

                case 7:
                    
                    //para imprimir una frase para salir
                    controladorU.salir();
                    break;
                    
                default:

                    //en caso de que digite un numero que no se encuentre en el menu
                    controladorU.numeroErroneo();
                    break;

            }
        } while (opcionMenu != 7);

    }

}
