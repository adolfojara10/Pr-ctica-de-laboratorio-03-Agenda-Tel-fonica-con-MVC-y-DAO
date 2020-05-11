/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.ups.edu.controlador;

import ec.ups.edu.dao.UsuarioDAOImpl;
import ec.ups.edu.modelo.Telefono;
import ec.ups.edu.modelo.Usuario;
import ec.ups.edu.vista.VistaUsuario;
import java.util.*;

/**
 *
 * @author Adolfo
 */
public class ControladorUsuario {

    private Usuario usuario2;
    private VistaUsuario vista;
    private UsuarioDAOImpl usuarioDaoImpl;

    public ControladorUsuario(VistaUsuario vista) {
        this.vista = vista;
        this.usuarioDaoImpl = new UsuarioDAOImpl();
    }

    public int menu() {
        int opcionMenu = vista.menu();
        return opcionMenu;
    }

    public void registrar() {
        usuario2 = vista.crearUsuario();
        usuarioDaoImpl.create(usuario2);
    }

    public void iniciarSesion() {

        String correo = vista.iniciarSesionCorreo();
        String contraseña = vista.iniciarSesionContraseña();

        usuario2 = usuarioDaoImpl.iniciarSesion(correo, contraseña);

        if (usuario2 != null) {
            vista.imprimirUsuario(usuario2);
            int opcionSesion = 0;
            while (opcionSesion != 4) {
                opcionSesion = vista.menuEditarTelefonoUsuario();
                switch (opcionSesion) {
                    case 1:
                        Telefono telefono = vista.ingresarTelefono();
                        usuarioDaoImpl.agregarTelefono(usuario2, telefono);
                        vista.imprimirTelefonos(usuario2);
                        break;

                    case 2:
                        int codigo = vista.editarTelefono();
                        Telefono telefono2 = usuarioDaoImpl.readTelefono(usuario2,
                                codigo);
                        if (telefono2 != null) {
                            vista.imprimirTelfono(telefono2);
                            telefono2 = vista.telefonoEditado();
                            usuarioDaoImpl.agregarTelefonoEditado(usuario2, telefono2,
                                    codigo);
                            vista.imprimirTelefonos(usuario2);
                        } else {
                            String frase = "Codigo erroneo";
                            vista.frase(frase);
                        }
                        break;

                    case 3:
                        int codigo2 = vista.editarTelefono();
                        Telefono telefono3 = usuarioDaoImpl.readTelefono(usuario2,
                                codigo2);
                        if (telefono3 != null) {
                            vista.imprimirTelfono(telefono3);
                            usuarioDaoImpl.eliminarTelefono(usuario2, codigo2);
                            vista.imprimirTelefonos(usuario2);
                        } else {
                            String frase = "Codigo erroneo";
                            vista.frase(frase);
                        }
                        break;

                    case 4:
                        String frase = "\nSesion cerrada\n";
                        vista.frase(frase);

                        break;

                    default:
                        String frase2 = "Error al digitar. Vuelva a digitar la "
                                + "accion que desea ejecutar";
                        vista.frase(frase2);

                        break;
                }

            }

        } else {
            String frase = "Datos incorrectos";
            vista.frase(frase);
        }

    }

    public void imprimirTelefonos(){
        String id = vista.pedirIdentificador();
        usuario2 = usuarioDaoImpl.read(id);
        if (usuario2!=null){
            vista.imprimirTelefonos(usuario2);
        } else {
            String frase = "Usuario no encontrado";
            vista.frase(frase);
        }       
        
    }
    
    
    public void buscarUsuario(){
        String id = vista.pedirIdentificador();
        usuario2 = usuarioDaoImpl.read(id);
        if (usuario2!=null){
            vista.imprimirUsuario(usuario2);
        } else {
            String frase = "Usuario no encontrado";
            vista.frase(frase);
        }
    }
    
    public void imprimirUsuarios(){
        Map<String, Usuario> usuarios = new HashMap<>();
        usuarios = usuarioDaoImpl.llamarUsuarios();
        vista.imprimirUsuarios(usuarios);
        
    }
    
    public void salir(){
        String frase = "Usted ha salido del programa";
        vista.frase(frase);
    }
    
    public void numeroErroneo(){
        String frase = "Opcion incorrecta. Digite otra vez la opcion";
        vista.frase(frase);
    }
}
