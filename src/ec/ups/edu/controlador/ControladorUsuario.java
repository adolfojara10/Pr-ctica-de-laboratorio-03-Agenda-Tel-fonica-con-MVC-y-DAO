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
                        vista.imprimirTelfono(telefono2);
                        telefono2 = vista.telefonoEditado();
                        usuarioDaoImpl.agregarTelefonoEditado(usuario2, telefono2,
                                codigo);
                        vista.imprimirTelefonos(usuario2);
                        break;

                    case 3:

                        break;

                    case 4:

                        break;

                    default:

                        break;
                }

            }

        } else {
            String frase = "Datos incorrectos";
            vista.frase(frase);
        }
        
    }

    public void editarTelefono() {

    }

}
